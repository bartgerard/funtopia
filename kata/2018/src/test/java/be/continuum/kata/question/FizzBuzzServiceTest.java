package be.continuum.kata.question;

import org.assertj.core.api.Assertions;
import org.junit.Test;

/**
 * FizzBuzzServiceTest
 *
 * @author bgerard
 * @version 1.0
 */
public class FizzBuzzServiceTest {

    private final int start = 1;
    private final int n = 200;

    private final FizzBuzzService service = new FizzBuzzServiceImpl();
    private final FizzBuzzService solution = new FizzBuzzServiceImpl();


    @Test
    public void testFizzBuzz() {
        service.transform(start, n)
                .forEach(System.out::println);

        Assertions.assertThat(service.transform(start, n))
                .containsExactlyElementsOf(solution.transform(start, n));
    }

}
