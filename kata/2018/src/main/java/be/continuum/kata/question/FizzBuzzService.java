package be.continuum.kata.question;

import java.util.List;

/**
 * FizzBuzzService
 *
 * @author bgerard
 * @version 1.0
 */
public interface FizzBuzzService {

    /**
     * FizzBuzz-transformation for a selected set of consecutive numbers.
     *
     * @param start The first number in the number sequence.
     * @param n     The last number in the number sequence.
     * @return A List containing the FizzBuzz-transformation from the selected numbers in order of appearance.
     * @constraint start < n
     */
    List<String> transform(int start, int n);

    /**
     * FizzBuzz-transformation for a single number.
     *
     * @param i The given number.
     * @return The FizzBuzz-transformation for the given number.
     */
    String transform(int i);

}
