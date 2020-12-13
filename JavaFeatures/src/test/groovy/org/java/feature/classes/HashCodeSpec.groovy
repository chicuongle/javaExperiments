package org.java.feature.classes

import spock.lang.Specification

/**
* This specification demonstrates uses cases of correct hashcode implementations
**/
class HashCodeSpec extends Specification {

    def "not unique hashcode for equaled objects "() {
        given: 'two equaled objects'
        Card c1 = new Card('r1', 'suite1')
        Card c2 = new Card('r2', 'suite1')
        and: 'two objects are equal'
        assert c1 == c2
        and: 'but they have different hashcode'
        assert c1.hashCode() != c2.hashCode()
        and: 'a hash map'
        Map<Card, String> m = new HashMap()
        when: 'add two cards in the hash map'
        m.put(c1, 'The card of Alex')
        m.put(c2, 'The card of Beatrix')
        then: 'because of different hashcode all two elements are added neatly in the map'
        assert m.size() == 2
        and: '''they can be fetched using "equal" keys'''
        assert m.get(new Card('r1', 'suite1')) == 'The card of Alex'
        assert m.get(new Card('r2', 'suite1')) == 'The card of Beatrix'
        and: 'correct hashcode but wrong value'
        assert m.get(new Card('r1', 'suite10')) == null
    }

    class Card {

        String rank
        String suite

        Card(String r, String s) {
            if (r == null || s == null) {
                throw new IllegalArgumentException()
            }
            rank = r
            suite = s
        }

        boolean equals(obj) {
            if (!(obj instanceof Card)) {
                return false
            }
            Card c = (Card) obj
            suite == c.suite
        }

        int hashCode() {
            rank.hashCode()
        }

        @Override
        String toString() {
            return 'Card{' +
                    "rank='" + rank + '\'' +
                    ", suite='" + suite + '\'' +
                    '}'
        }

    }

    def "key object without hashcode implementation"() {
        given: 'a hash map of key object without hashcode'
        Address keyAddress = new Address('Backer street', 1)
        and: 'a hash map with value'
        Map<Address, String> m = new HashMap<>()
        m.put(keyAddress, 'Jenny')
        and: ' a key with different hashcode is used to retrieved'
        Address retrievedKey = new Address('Backer street', 1)
        assert retrievedKey == (keyAddress)
        assert retrievedKey.hashCode() != keyAddress.hashCode()
        expect: 'because of different hashcode, no object found for retrieved key'
        m.get(retrievedKey) == null
    }

    final class Address {

        private final String street
        private final Integer number

        Address(String street, Integer number) {
            this.street = street
            this.number = number
        }

        @Override
        boolean equals(Object o) {
            if (o === this) {
                return true
            }
            if (!(o instanceof Address)) {
                return false
            }
            Address pn = (Address) o
            return pn.street == street && pn.number == number
        }

    }

    def "key object with constant hashcode implementation"() {
        given: '''two "equal" keys'''
        ConstantHashCode key1 = new ConstantHashCode('10', '20')
        ConstantHashCode key2 = new ConstantHashCode('10', '22')
        and: 'keys are equal'
        assert key1 == key2
        and: 'but keys are not same'
        assert key1 !== key2
        and: 'a map'
        Map<ConstantHashCode, String> m = new HashMap<>()
        when: '''add two items using "equal" key'''
        m.put(key1, 'value1')
        m.put(key2, 'value2')
        then: 'actually only one item is stored'
        assert m.size() == 1
        and: 'the second item overridden the first item'
        assert m.get(key1) == 'value2'
        and: '''any "different" key with same code will return stored value
        because they all have same combination "equal" + hashcode '''
        assert m.get(new ConstantHashCode('10', '98489393')) == 'value2'
    }

    final class ConstantHashCode {

        private final String code
        private final String number

        ConstantHashCode(String code, String number) {
            this.code = code
            this.number = number
        }

        boolean equals(o) {
            if (this.is(o)) {
                return true
            }
            if (getClass() != o.class) {
                return false
            }

            ConstantHashCode that = (ConstantHashCode) o

            return code == that.code
        }

        int hashCode() {
            return 4883
        }

    }
    def "bad hashcode base on variable value"() {
        given:'a key'
        VariableHashCode key = new VariableHashCode('10', '20')
        and:'a map'
        Map<VariableHashCode,String> m = new HashMap<>()
        when:'add an item to the map'
        m.put(key, 'value')
        and:' after that change value of variable member'
        key.setNumber('30')
        then:'no item found in the map using the same key'
        assert m.get(key) == null
    }
    final class VariableHashCode {

        private final String code
        private String number

        VariableHashCode(String code, String number) {
            this.code = code
            this.number = number
        }

        void setNumber(String number) {
            this.number = number
        }

        boolean equals(o) {
            if (this.is(o)) {
                return true
            }
            if (getClass() != o.class) {
                return false
            }

            VariableHashCode that = (VariableHashCode) o

            if (code != that.code) {
                return false
            }

            return true
        }

        int hashCode() {
            return number.hashCode()
        }

    }

}
