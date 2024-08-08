package org.dropproject.detekt.extensions.rules

import io.gitlab.arturbosch.detekt.api.*
import org.jetbrains.kotlin.com.intellij.psi.PsiElement
import org.jetbrains.kotlin.com.intellij.psi.impl.source.tree.LeafPsiElement
import org.jetbrains.kotlin.com.intellij.psi.impl.source.tree.PsiCommentImpl

class ForbiddenKeywords(config: Config = Config.empty) : Rule(config) {

    override val issue = Issue(
            javaClass.simpleName,
            Severity.CodeSmell,
            "This rule reports a file with forbidden keywords.",
            Debt.TWENTY_MINS
    )

    private val forbiddenKeywords = valueOrDefault(FORBIDDEN_KEYWORDS, "").split(",")

    override fun visitElement(element: PsiElement) {
        super.visitElement(element)

        if (element is LeafPsiElement &&
                element !is PsiCommentImpl &&
                forbiddenKeywords.contains(element.text)) {

            // println(">>>>>${element.text} - ${element.javaClass.simpleName}")
            report(CodeSmell(issue, Entity.from(element), "${element.text} is forbidden"))

        }
    }

    companion object {
        val FORBIDDEN_KEYWORDS = "forbiddenKeywords"  // comes from detekt.yml
//        val FORBIDDEN_KEYWORDS = arrayOf("for","break","split","indexOf","contains")
    }
}
