import ch.qos.logback.classic.encoder.PatternLayoutEncoder
import ch.qos.logback.core.ConsoleAppender

import static ch.qos.logback.classic.Level.DEBUG

appender("A1", ConsoleAppender) {
	encoder(PatternLayoutEncoder) {
		pattern = "[%d] %-5p: [%t] %c - %m%n"
	}
}
root(DEBUG, ["A1"])