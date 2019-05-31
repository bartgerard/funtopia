package be.gerard.kata.bowling;

import lombok.NoArgsConstructor;
import lombok.Value;
import org.springframework.util.Assert;

import java.util.List;
import java.util.stream.IntStream;

/**
 * Game
 *
 * @author bartgerard
 * @version v0.0.1
 */
@NoArgsConstructor
public class TenPinBowlingGame {

    public static int scoreGame(
            final List<Frame> frames
    ) {
        Assert.isTrue(
                frames.size() >= 10,
                () -> "frames.size is invalid [" + frames.size() + " < 10]"
        );

        return IntStream.range(0, 10)
                .map(i -> scoreFrame(frames, i))
                .sum();
    }

    private static int scoreFrame(
            final List<Frame> frames,
            final int i
    ) {
        final Frame frame = frames.get(i);

        return IntStream.range(i, frames.size())
                .mapToObj(frames::get)
                .map(Frame::getDeliveries)
                .flatMapToInt(IntStream::of)
                .limit(toNbCountableDeliveries(frame))
                //.filter(delivery -> delivery > 0) // DO NOT COUNT FOULS
                .sum();
    }

    private static int toNbCountableDeliveries(
            final Frame frame
    ) {
        if (frame.isStrike() || frame.isSpare()) {
            return 3;
        } else {
            return 2;
        }
    }

    @Value(staticConstructor = "of")
    public static class Frame {

        /*
         * first(pins) == 10 --> 'X'
         * sum(pins) == 10 --> '/'
         * sum(pins) == 0 --> '-'
         * foul --> 'F'
         * else --> hits
         */

        // two choices, either Frame knows about next frames
        // or Game manages scoring

        private final int[] deliveries;

        private boolean isStrike() {
            return IntStream.of(deliveries).limit(1).sum() == 10;
        }

        private boolean isSpare() {
            return IntStream.of(deliveries).sum() == 10;
        }

    }

}
