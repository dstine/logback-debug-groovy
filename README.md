logback-debug-groovy
====================

Demonstrates that the system property `logback.debug` is ignored when logback is configured via Groovy.

The subproject `xml-config` is configured via `logback.xml`, and the subproject `groovy-config` is configured via `logback.groovy`.

When `logback.debug` is `false`, the output of both subprojects is the same.
```
$ gradlew clean run
:common:clean
:groovy-config:clean
:xml-config:clean
:common:compileJava
:common:processResources UP-TO-DATE
:common:classes
:common:jar
:groovy-config:compileJava UP-TO-DATE
:groovy-config:processResources
:groovy-config:classes
:groovy-config:run
11:17:30.854 INFO  [main] scrach.logback.config.Runner:9 - hello
:xml-config:compileJava UP-TO-DATE
:xml-config:processResources
:xml-config:classes
:xml-config:run
11:17:31.219 INFO  [main] scrach.logback.config.Runner:9 - hello

BUILD SUCCESSFUL

Total time: 5.248 secs
```

When `logback.debug` is `false`, the debug output is printed for `xml-config` but not for `groovy-config`.
```
$ gradlew clean run -PenableDebug=true
:common:clean
:groovy-config:clean
:xml-config:clean
:common:compileJava
:common:processResources UP-TO-DATE
:common:classes
:common:jar
:groovy-config:compileJava UP-TO-DATE
:groovy-config:processResources
:groovy-config:classes
:groovy-config:run
11:17:54.730 INFO  [main] scrach.logback.config.Runner:9 - hello
:xml-config:compileJava UP-TO-DATE
:xml-config:processResources
:xml-config:classes
:xml-config:run
11:17:54,925 |-INFO in ch.qos.logback.classic.LoggerContext[default] - Could NOT find resource [logback.groovy]
11:17:54,925 |-INFO in ch.qos.logback.classic.LoggerContext[default] - Could NOT find resource [logback-test.xml]
11:17:54,925 |-INFO in ch.qos.logback.classic.LoggerContext[default] - Found resource [logback.xml] at [file:/C:/RUP/workspaces/general/logback-debug-groovy/xml-config/build/resources/main/logback.xml
]
11:17:55,000 |-INFO in ch.qos.logback.core.joran.action.AppenderAction - About to instantiate appender of type [ch.qos.logback.core.ConsoleAppender]
11:17:55,008 |-INFO in ch.qos.logback.core.joran.action.AppenderAction - Naming appender as [STDOUT]
11:17:55,025 |-INFO in ch.qos.logback.core.joran.action.NestedComplexPropertyIA - Assuming default type [ch.qos.logback.classic.encoder.PatternLayoutEncoder] for [encoder] property
11:17:55,058 |-INFO in ch.qos.logback.classic.joran.action.RootLoggerAction - Setting level of ROOT logger to DEBUG
11:17:55,060 |-INFO in ch.qos.logback.core.joran.action.AppenderRefAction - Attaching appender named [STDOUT] to Logger[ROOT]
11:17:55,060 |-INFO in ch.qos.logback.classic.joran.action.ConfigurationAction - End of configuration.
11:17:55,060 |-INFO in ch.qos.logback.classic.joran.JoranConfigurator@4c9692d7 - Registering current configuration as safe fallback point
11:17:55.063 INFO  [main] scrach.logback.config.Runner:9 - hello

BUILD SUCCESSFUL

Total time: 5.165 secs
```
