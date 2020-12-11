package org.java.feature.classes;

public class EnclosingClass {
    private int val;
    private int fromInnen;
    /**
     * InnerClass connected with instances of EnclosingClass
     */
    public class InnerClass{
        public String getVal(){
            return "Value of InnerClass "+val;
        }
        public void changeValOfEnclosing(int val){
            fromInnen = val;
        }
    }

    public int getFromInnen() {
        return fromInnen;
    }

    public void setVal(int val) {
        this.val = val;
    }
}
