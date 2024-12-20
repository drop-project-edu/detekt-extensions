# Drop Project Detekt Extensions

Custom rules for [Detekt](https://arturbosch.github.io/detekt/) used by [Drop Project](https://github.com/drop-project-edu/drop-project).

Current rules include:
- ForbiddenKeywords, searches students submissions for forbidden keywords such as 'break'
- GlobalVariables, detect the use of global variables - should be avoided in certain projects

## How to use

Include the following dependency on your pom file:

    <dependency>
	    <groupId>org.dropproject</groupId>
	    <artifactId>drop-project-detekt-extensions</artifactId>
	    <version>0.3.0</version>
	</dependency>
	
Add this configuration to detekt.yml:

    drop-project:
      active: true
      ForbiddenKeywords:
        active: true
        forbiddenKeywords: 'for,break,split,indexOf,contains'
        excludes: "**/Test*.kt"
      GlobalVariables:
        active: true