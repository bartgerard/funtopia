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
                                "    _  _     _  _  _  _  _ \n" +
                                "  | _| _||_||_ |_   ||_||_|\n" +
                                "  ||_  _|  | _||_|  ||_| _|",
                        "123456789"
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
                ),
                Arguments.arguments(
                        "" +
                                " _  _  _  _  _  _  _  _  _ \n" +
                                " _| _| _| _| _| _| _| _| _|\n" +
                                " _| _| _| _| _| _| _| _| _|",
                        "333333333"
                ),
                Arguments.arguments(
                        "" +
                                "                           \n" +
                                "|_||_||_||_||_||_||_||_||_|\n" +
                                "  |  |  |  |  |  |  |  |  |",
                        "444444444"
                ),
                Arguments.arguments(
                        "" +
                                " _  _  _  _  _  _  _  _  _ \n" +
                                "|_ |_ |_ |_ |_ |_ |_ |_ |_ \n" +
                                " _| _| _| _| _| _| _| _| _|",
                        "555555555"
                ),
                Arguments.arguments(
                        "" +
                                " _  _  _  _  _  _  _  _  _ \n" +
                                "|_ |_ |_ |_ |_ |_ |_ |_ |_ \n" +
                                "|_||_||_||_||_||_||_||_||_|",
                        "666666666"
                ),
                Arguments.arguments(
                        "" +
                                " _  _  _  _  _  _  _  _  _ \n" +
                                "  |  |  |  |  |  |  |  |  |\n" +
                                "  |  |  |  |  |  |  |  |  |",
                        "777777777"
                ),
                Arguments.arguments(
                        "" +
                                " _  _  _  _  _  _  _  _  _ \n" +
                                "|_||_||_||_||_||_||_||_||_|\n" +
                                "|_||_||_||_||_||_||_||_||_|",
                        "888888888"
                ),
                Arguments.arguments(
                        "" +
                                " _  _  _  _  _  _  _  _  _ \n" +
                                "|_||_||_||_||_||_||_||_||_|\n" +
                                " _| _| _| _| _| _| _| _| _|",
                        "999999999"
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
