appender("STDOUT", ConsoleAppender) {
  encoder(PatternLayoutEncoder) {
    pattern = "%date{HH:mm:ss.SSS} %-5level [%thread] %logger:%line - %message%n"
  }
}
root(INFO, ["STDOUT"])
logger("com.acme", DEBUG, ["STDOUT"])
