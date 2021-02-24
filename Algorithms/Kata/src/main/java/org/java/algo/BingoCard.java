package org.java.algo;

import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Stream.concat;

/**
 *
 * A Bingo card contains 24 unique and random numbers according to this scheme:
 * 5 numbers from the B column in the range 1 to 15
 * 5 numbers from the I column in the range 16 to 30
 * 4 numbers from the N column in the range 31 to 45
 * 5 numbers from the G column in the range 46 to 60
 * 5 numbers from the O column in the range 61 to 75
 *
 * https://www.codewars.com/kata/566d5e2e57d8fae53c00000c
 */
public class BingoCard {
    public static String[] getCard() {
        Random random = new Random();
        IntStream bColumn = random.ints(1, 16);
        IntStream iColumn = random.ints(16, 31);
        IntStream nColumn = random.ints(31, 46);
        IntStream gColumn = random.ints(46, 61);
        IntStream oColumn = random.ints(61, 76);
    return Stream.concat(
        bColumn.distinct().limit(5).mapToObj(i -> "B" + i),
        concat(
            iColumn.distinct().limit(5).mapToObj(i -> "I" + i),
            concat(
                nColumn.distinct().limit(4).mapToObj(i -> "N" + i),
                concat(
                    gColumn.distinct().limit(5).mapToObj(i -> "G" + i),
                    oColumn.distinct().limit(5).mapToObj(i -> "O" + i))))).collect(Collectors.toList()).toArray(new String[]{});
    }
}
