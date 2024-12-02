package org.dropproject.detekt.extensions.rules

import io.gitlab.arturbosch.detekt.api.*
import org.jetbrains.kotlin.psi.KtProperty

class GlobalVariables(config: Config) : Rule(config) {

    override val issue = Issue(
        id = "GlobalVariables",
        severity = Severity.CodeSmell,
        description = "Avoid using global variables as they can lead to unexpected behaviors.",
        debt = Debt.FIVE_MINS
    )

    override fun visitProperty(property: KtProperty) {
        super.visitProperty(property)

        // Check if the property is declared outside any class, object, or function
        if (property.isVar && property.isTopLevel) {
            report(CodeSmell(issue, Entity.from(property), message = "Global variables should be avoided."))
        }
    }
}