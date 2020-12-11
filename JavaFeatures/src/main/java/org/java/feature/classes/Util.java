package org.java.feature.classes;

/**
 * an example of inner class
 */
public class Util {
    private String value;
    private final static Util utilInstance = new Util();
    private final static Util utilWithPreDefinedValue = new Util("randomText");

    public Util() {
    }

    public Util(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static class UtilFactory {
        public Util getUtilInstance(){
            return utilInstance;
        }
        public Util instancePredefinedVal(){
            return utilWithPreDefinedValue;
        }
    }
}
