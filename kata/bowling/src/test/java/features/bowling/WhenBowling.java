package features.bowling;

import be.gerard.kata.bowling.ScoreParser;
import be.gerard.kata.bowling.TenPinBowlingGame;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * WhenBowling
 * http://codingdojo.org/kata/Bowling/
 * https://www.bowl.com/Source/Source_Home/Bowling_Lingo/
 *
 * @author bartgerard
 * @version v0.0.1
 */
class WhenBowling {

    @Nested
    class AndPlayingAPerfectGame {

        final String aPerfectGame = "X X X X X X X X X X X X";

        @Test
        void i_should_score_300_points() {
            // GIVEN
            final List<TenPinBowlingGame.Frame> frames = ScoreParser.parseFrames(aPerfectGame);

            // WHEN
            final int score = TenPinBowlingGame.scoreGame(frames);

            // THEN
            Assertions.assertThat(score).isEqualTo(300);
        }

    }

    @Nested
    class AndPlayingALessThanPerfectGame {

        @ParameterizedTest(name = "A score card of {0} should score {1}")
        @CsvSource({
                "X X X X X X X X X X X X,         300",
                "5/ 5/ 5/ 5/ 5/ 5/ 5/ 5/ 5/ 5/ 5, 150",
                "1/ 2/ 3/ 4/ 5/ 1/ 2/ 3/ 4/ 5/ 1, 130",
                "9- 9- 9- 9- 9- 9- 9- 9- 9- 9-,    90",
                "11 11 11 11 11 11 11 11 11 11,    20",
                "-- -- -- -- -- -- -- -- -- --,     0",
                "FF FF FF FF FF FF FF FF FF FF,     0",
                "X FF X X X X X X X X X X,        250"
        })
        void i_should_score(
                final String scoreCard,
                final int expectedScore
        ) {
            // GIVEN
            final List<TenPinBowlingGame.Frame> frames = ScoreParser.parseFrames(scoreCard);

            // WHEN
            final int score = TenPinBowlingGame.scoreGame(frames);

            // THEN
            Assertions.assertThat(score).isEqualTo(expectedScore);
        }

    }

    @Nested
    class AndPlayingAnInvalidGame {

        final String anInvalidGame = "X X";

        @Test
        void i_will_be_punished() {
            // GIVEN
            final List<TenPinBowlingGame.Frame> frames = ScoreParser.parseFrames(anInvalidGame);

            // WHEN
            final IllegalArgumentException exception = assertThrows(
                    IllegalArgumentException.class,
                    () -> TenPinBowlingGame.scoreGame(frames)
            );

            // THEN
            Assertions.assertThat(exception.getMessage()).isEqualTo("frames.size is invalid [2 < 10]");
        }

    }

}
