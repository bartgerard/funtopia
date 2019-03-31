package be.gerard.kata.bank.ocr;

import org.springframework.util.Assert;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * OcrParser
 *
 * @author bartgerard
 * @version v0.0.1
 */
public class OcrParser {

    private static final Map<String, Integer> CODE_MAP = Map.ofEntries(
            Map.entry(
                    "" +
                            " _ " +
                            "| |" +
                            "|_|",
                    0
            ),
            Map.entry(
                    "" +
                            "   " +
                            "  |" +
                            "  |",
                    1
            ),
            Map.entry(
                    "" +
                            " _ " +
                            " _|" +
                            "|_ ",
                    2
            ),
            Map.entry(
                    "" +
                            " _ " +
                            " _|" +
                            " _|",
                    3
            ),
            Map.entry(
                    "" +
                            "   " +
                            "|_|" +
                            "  |",
                    4
            ),
            Map.entry(
                    "" +
                            " _ " +
                            "|_ " +
                            " _|",
                    5
            ),
            Map.entry(
                    "" +
                            " _ " +
                            "|_ " +
                            "|_|",
                    6
            ),
            Map.entry(
                    "" +
                            " _ " +
                            "  |" +
                            "  |",
                    7
            ),
            Map.entry(
                    "" +
                            " _ " +
                            "|_|" +
                            "|_|",
                    8
            ),
            Map.entry(
                    "" +
                            " _ " +
                            "|_|" +
                            " _|",
                    9
            )
    );

    public static String parse(
            final String input
    ) {
        Assert.hasText(input, () -> "input is invalid [" + input + "]");
        final int lengthIgnoringNewLines = input.length() - 2;
        final int nbSymbols = lengthIgnoringNewLines / 9; // 3 lines x 3 symbols
        Assert.isTrue(lengthIgnoringNewLines % 9 == 0, () -> "input has invalid length [" + lengthIgnoringNewLines + "]");

        // input.substring(0 + nbSymbols * 0 + i, 0 + nbSymbols * 0 + i + 3)
        //         + input.substring(1 + nbSymbols * 3 + i, 1 + nbSymbols * 3 + i + 3)
        //         + input.substring(2 + nbSymbols * 6 + i, 2 + nbSymbols * 6 + i + 3)

        final List<String> result = IntStream.range(0, nbSymbols)
                .map(i -> i * 3)
                .mapToObj(i -> IntStream.range(0, 3)
                        .map(row -> row + nbSymbols * 3 * row + i)
                        .mapToObj(beginIndex -> input.substring(beginIndex, beginIndex + 3))
                        .collect(Collectors.joining())
                )
                .collect(Collectors.toList());

        return result.stream()
                .map(CODE_MAP::get)
                .map(String::valueOf)
                .collect(Collectors.joining());
    }

}
