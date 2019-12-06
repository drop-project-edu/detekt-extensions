package pt.ulusofona.deisi.detekt.extensions.rules

import io.gitlab.arturbosch.detekt.api.*
import org.jetbrains.kotlin.com.intellij.psi.PsiElement

class ForbiddenKeywords(config: Config = Config.empty) : Rule(config) {

    override val issue = Issue(
            javaClass.simpleName,
            Severity.CodeSmell,
            "This rule reports a file with forbidden keywords.",
            Debt.TWENTY_MINS
    )

    private val forbiddenKeywords = SplitPattern(valueOrDefault(FORBIDDEN_KEYWORDS, ""))

    override fun visitElement(element: PsiElement) {
        super.visitElement(element)

        if (forbiddenKeywords.contains(element.text)) {
            report(CodeSmell(issue, Entity.from(element), "${element.text} is forbidden"))
        }
    }

    companion object {
        val FORBIDDEN_KEYWORDS = "forbiddenKeywords"  // comes from detekt.yml
//        val FORBIDDEN_KEYWORDS = arrayOf("for","break","split","indexOf","contains")
    }
}
