package be.continuum.kata.question;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * FizzBuzzServiceTest
 *
 * @author bgerard
 * @version 1.0
 */
class FizzBuzzServiceTest {

    private final int start = 1;
    private final int n = 10000;

    private final FizzBuzzService service = new FizzBuzzServiceImpl(FizzBuzzService.DIVIDER_MAP);
    private final FizzBuzzService solution = new FizzBuzzServiceImpl(FizzBuzzService.DIVIDER_MAP);


    @Test
    void testFizzBuzz() {
        service.transform(start, n)
                .forEach(System.out::println);

        Assertions.assertThat(service.transform(start, n))
                .containsExactlyElementsOf(solution.transform(start, n));
    }

}
