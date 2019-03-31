package be.gerard.kata.bank.ocr;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

/**
 * WhenScanning
 *
 * @author bartgerard
 * @version v0.0.1
 */
public class WhenScanning {

    private static Stream<Arguments> provideCodesForVariousCases() {
        return Stream.of(
                Arguments.arguments(
                        "" +
                                " _     _ \n" +
                                "| |  | _|\n" +
                                "|_|  ||_ ",
                        "012"
                ),
                Arguments.arguments(
                        "" +
                                " _  _  _  _  _  _  _  _  _ \n" +
                                "| || || || || || || || || |\n" +
                                "|_||_||_||_||_||_||_||_||_|",
                        "000000000"
                ),
                Arguments.arguments(
                        "" +
                                "                           \n" +
                                "  |  |  |  |  |  |  |  |  |\n" +
                                "  |  |  |  |  |  |  |  |  |",
                        "111111111"
                ),
                Arguments.arguments(
                        "" +
                                " _  _  _  _  _  _  _  _  _ \n" +
                                " _| _| _| _| _| _| _| _| _|\n" +
                                "|_ |_ |_ |_ |_ |_ |_ |_ |_ ",
                        "222222222"
                )
        );
    }

    @ParameterizedTest(name = "{0} {1}")
    @MethodSource("provideCodesForVariousCases")
    void test(
            final String input,
            final String expected
    ) {
        final String output = OcrParser.parse(input);

        Assertions.assertThat(output).isEqualTo(expected);
    }

}
