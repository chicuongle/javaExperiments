package org.java.feature.inner

import spock.lang.Specification

class UtilTest extends Specification {
    def "static inner class used as Factory"(){
        given: "a factory instance of Util"
        def fac = new Util.UtilFactory()
        expect: "using factory to get specific instance of Util "
        assert fac.instancePredefinedVal().getValue() == "randomText"
        and: "using factory to get no pre defined value of Util"
        assert fac.getUtilInstance().getValue() == null
    }
}
