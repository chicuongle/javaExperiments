package sort.selection

import groovy.util.logging.Log
import sort.SortFactory
import sort.Sorter
import spock.lang.Shared
import spock.lang.Specification

@Log
class SortSpec extends Specification {
    @Shared
    Sorter[] sorters = [SortFactory.instance.selectionSort(), SortFactory.instance.insertionSort(),
                        SortFactory.instance.bubleSort(),SortFactory.instance.optimizedBubleSort(),
                        SortFactory.instance.mergeSort()]

    def "normal use case"() {
        expect: "list of comparable sorted correctly"
        sorters.each { sorter ->
            log.info("Execute sorting using Sorter ${sorter.getClass().simpleName} for input ${input}")
            assert sorter.sort(input) == output
        }
        where:
        input                                                  || output
        [2, 3, 1, 5, 20] as Integer[]                           | [1, 2, 3, 5, 20] as Integer[]
        [5, 1, 4, 2, 8] as Integer[]                            | [1, 2, 4, 5, 8] as Integer[]
        [57, 48, 79, 65, 15, 33, 52] as Integer[]               | [15, 33, 48, 52, 57, 65, 79] as Integer[]
        [2.0, 3.1, 1.99, 5.938384, 20.0] as Double[]            | [1.99, 2.0, 3.1, 5.938384, 20.0] as Double[]
        ["ich", "bin", "keine", "niemand", "blala"] as String[] | ["bin", "blala", "ich", "keine", "niemand"] as String[]
    }

    def "already sorted list"() {
        expect: "list of comparable sorted correctly"
        sorters.each { sorter ->
            log.info("Execute sorting using Sorter ${sorter.getClass().simpleName} for input ${input}")
            assert sorter.sort(input) == output
        }
        where:
        input                                    || output
        [1, 2, 3, 5, 20] as Integer[]             | [1, 2, 3, 5, 20] as Integer[]
        [15, 33, 48, 52, 57, 65, 79] as Integer[] | [15, 33, 48, 52, 57, 65, 79] as Integer[]
    }

    def "extreme not sorted list"() {
        expect: "list of comparable sorted correctly"
        sorters.each { sorter ->
            log.info("Execute sorting using Sorter ${sorter.getClass().simpleName} for input ${input}")
            assert sorter.sort(input) == output
        }
        where:
        input                                    || output
        [20, 5, 3, 2, 1] as Integer[]             | [1, 2, 3, 5, 20] as Integer[]
        [79, 65, 57, 52, 48, 33, 15] as Integer[] | [15, 33, 48, 52, 57, 65, 79] as Integer[]
        ['x', 'k', 'd', 'b', 'a'] as Character[]  | ['a', 'b', 'd', 'k', 'x',] as Character[]
    }

}
