package pt.ulusofona.deisi.detekt.extensions

import io.gitlab.arturbosch.detekt.api.Config
import io.gitlab.arturbosch.detekt.api.RuleSet
import io.gitlab.arturbosch.detekt.api.RuleSetProvider
import pt.ulusofona.deisi.detekt.extensions.rules.ForbiddenKeywords

class DropProjectProvider : RuleSetProvider {

    override val ruleSetId: String = "drop-project"

    override fun instance(config: Config): RuleSet = RuleSet(
            ruleSetId,
            listOf(
                    ForbiddenKeywords(config)
            )
    )
}