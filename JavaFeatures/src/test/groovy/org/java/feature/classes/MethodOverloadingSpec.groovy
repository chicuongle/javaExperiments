package org.java.feature.classes

import static org.assertj.core.api.Assertions.assertThat

import spock.lang.Specification

/**
* This specification demonstrates use cases of method overloading technique in java
**/
class MethodOverloadingSpec extends Specification {

    def "verify diverse overloading resolution"() {
        given: 'a byte variable'
        byte aByte = 9
        expect:'overloading resolution: resolve byte -> short, next nearest type'
        assertThat(Overloaded.aMethod(aByte)).isEqualTo('short')
        and: 'overloading method for a string object. Even String is an Object, ' +
                'but String parameter matches better with overloaded method aMethod(String)'
        assertThat(Overloaded.aMethod('aByte')).isEqualTo('String')
        and: 'for any other object. in this case an array'
        assertThat(Overloaded.aMethod([])).isEqualTo('object')
    }

    def "overloading an A implementation"() {
        given:'an Integer object'
        A val = new A()
        expect:'overloading resolution A class is called'
        assertThat(Overloaded.aMethod(val)).isEqualTo('A Class')
    }
    class Overloaded {

        static String aMethod (short val)  { return 'short'  }
        static String aMethod (Object val) { return 'object' }
        static String aMethod (String val) { return 'String' }
        static String aMethod (A val) { return 'A Class' }
        static String aMethod (B val) { return 'B Class' }

    }

    interface I {

    }
    class A implements I {

    }
    class B implements I {

    }

}
