package org.java.feature.classes;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class EnclosingClassTest {
    @Test
    public void innerClassConnected_EnclosingInstance() {
        EnclosingClass enclosingClass = new EnclosingClass();
        EnclosingClass.InnerClass innerClass = enclosingClass.new InnerClass();

        enclosingClass.setVal(20);

        assertThat(innerClass.getVal()).isEqualTo("Value of InnerClass 20");
    }

    @Test
    public void changeValueOfEnclosing_UsingInnenInstance() {
        EnclosingClass enclosingClass = new EnclosingClass();
        EnclosingClass.InnerClass innerClass = enclosingClass.new InnerClass();

        innerClass.changeValOfEnclosing(34);

        assertThat(enclosingClass.getFromInnen()).isEqualTo(34);
    }
}