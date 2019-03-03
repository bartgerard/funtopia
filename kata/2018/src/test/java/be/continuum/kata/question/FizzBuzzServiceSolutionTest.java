package be.continuum.kata.question;

import org.assertj.core.api.Assertions;
import org.junit.Test;

/**
 * FizzBuzzServiceSolutionTest
 *
 * @author bgerard
 * @version 1.0
 */
public class FizzBuzzServiceSolutionTest {

    private final FizzBuzzService service = new FizzBuzzServiceImpl(FizzBuzzService.DIVIDER_MAP);

    @Test
    public void testFizzBuzz() {
        service.transform(1, 200)
                .forEach(System.out::println);

        Assertions.assertThat(service.transform(1, 15))
                .containsExactly(
                        "1",
                        "2",
                        "Fizz",
                        "4",
                        "Buzz",
                        "Fizz",
                        "7",
                        "8",
                        "Fizz",
                        "Buzz",
                        "11",
                        "Fizz",
                        "13",
                        "14",
                        "FizzBuzz"
                );
    }

}
