package org.java.feature.classes;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MethodOverloadingTest {
    /**
     * in groovy everything is Object, therefore test with primitive value should be
     * implemented in java using junit
     */
    @Test
    public void overloadingMethod_Autoboxing() {
        assertThat(Overloaded.aMethod(Integer.valueOf(9))).isEqualTo("Integer object");
        assertThat(Overloaded.aMethod(9)).isEqualTo("int");
    }

    static class Overloaded {
        static String aMethod(int val) {
            return "int";
        }

        static String aMethod(Integer val) {
            return "Integer object";
        }
    }
}
