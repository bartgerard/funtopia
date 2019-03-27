package be.gerard.kata.bowling;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * ScoreParser
 *
 * @author bartgerard
 * @version v0.0.1
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class ScoreParser {

    public static List<TenPinBowlingGame.Frame> parseFrames(
            final String score
    ) {
        final String[] frames = score.split("\\s+");

        return Stream.of(frames)
                .map(ScoreParser::parseDeliveries)
                .map(TenPinBowlingGame.Frame::of)
                .collect(Collectors.toList());
    }

    private static int[] parseDeliveries(
            final String frame
    ) {
        final int[] deliveries = frame.chars()
                .filter(delivery -> '/' != delivery)
                .map(delivery -> {
                    if ('X' == delivery) {
                        return 10;
                    } else if ('-' == delivery) {
                        return 0;
                    } else if ('F' == delivery) {
                        return -1;
                    } else {
                        return Character.getNumericValue(delivery);
                    }
                })
                .toArray();

        return IntStream.concat(
                IntStream.of(deliveries),
                frame.endsWith("/")
                        ? IntStream.of(10 - IntStream.of(deliveries).sum())
                        : IntStream.empty()
        )
                .toArray();
    }

}
