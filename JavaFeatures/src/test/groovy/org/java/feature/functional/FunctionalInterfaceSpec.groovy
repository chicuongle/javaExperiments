package org.java.feature.functional

import spock.lang.Specification
import java.util.regex.Pattern

class FunctionalInterfaceSpec extends Specification {
    def "create a functional interface"() {
        setup:
        StringMatchingFunction onlyDigit = (String value) -> {
            Pattern pattern = Pattern.compile("[0-9]*")
            return pattern.matcher(value).matches()
        }
        FunctionCall callUsingFunctionalObject = new FunctionCall(onlyDigit)
        FunctionCall callUsingStaticFunction = new FunctionCall(OnlyDigitMatcher::isMatch)
        expect:
        callUsingFunctionalObject.call(val) == result
        callUsingStaticFunction.call(val) == result
        where:
        val      | result
        "asdf09" | false
        "293844" | true
        "ADFf09" | false
        "?94984" | false
    }

    class FunctionCall {
        private StringMatchingFunction matchingFunction

        FunctionCall(final StringMatchingFunction matchingFunction) {
            this.matchingFunction = matchingFunction
        }

        boolean call(String val) {
            matchingFunction.match(val)
        }
    }
    /**
     * provide static function similar with matching function
     */
    private class OnlyDigitMatcher {
        static boolean isMatch(String val) {
            Pattern pattern = Pattern.compile("[0-9]*")
            return pattern.matcher(val).matches()
        }
    }

    @FunctionalInterface
    interface StringMatchingFunction {
        boolean match(String value)
    }
}
