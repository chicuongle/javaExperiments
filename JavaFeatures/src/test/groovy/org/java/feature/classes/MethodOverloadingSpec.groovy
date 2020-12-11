package org.java.feature.classes

import spock.lang.Specification
import static org.assertj.core.api.Assertions.assertThat

class MethodOverloadingSpec extends Specification{
    def "verify diverse overloading resolution"(){
        given: "a byte variable"
        byte aByte = 9
        expect:"overloading resolution: resolve byte -> short, next nearest type"
        assertThat(Overloaded.aMethod(aByte)).isEqualTo("short")
        and: "overloading method for a string object. Even String is an Object, " +
                "but String parameter matches better with overloaded method aMethod(String)"
        assertThat(Overloaded.aMethod("aByte")).isEqualTo("String")
        and: "for any other object"
        assertThat(Overloaded.aMethod(new ArrayList())).isEqualTo("object")
    }

    def "overloading an A implementation"(){
        given:"an Integer object"
        A val = new A()
        expect:"overloading resolution A class is called"
        assertThat(Overloaded.aMethod(val)).isEqualTo("A Class")
    }
    class Overloaded{
        static String aMethod (short val)  { "short"  }
        static String aMethod (Object val) { "object" }
        static String aMethod (String val) { "String" }
        static String aMethod (A val) { "A Class" }
        static String aMethod (B val) { "B Class" }
    }

    interface I{

    }
    class A implements I{

    }
    class B implements I{

    }
}
