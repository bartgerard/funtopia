package be.gerard.kata.varia;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

/**
 * WhenSpeaking
 *
 * @author bartgerard
 * @version v0.0.1
 */
@DisplayName("When speaking")
class WhenSpeaking {

    @DisplayName("the P-Language")
    @Nested
    class The_P_Language {

        @DisplayName("each group of vowels should be preceded by the letters ep")
        @ParameterizedTest(name = "For example {0} should be spoken as {1}")
        @CsvSource({
                "bart, bepart",
                "how are you doing, hepow eparepe yepou depoing"
        })
        void each_group_of_vowels_should_be_preceded_by_the_letters_ep(
                final String sentence,
                final String spokenSentence
        ) {
            // GIVEN

            // WHEN
            final String theSpokenSentence = Languages.P_LANGUAGE.speak(sentence);

            // THEN
            Assertions.assertThat(theSpokenSentence)
                    .isEqualTo(spokenSentence);
        }

        @DisplayName("the spoken sentence should be transformed back to the original sentence")
        @ParameterizedTest(name = "For example {0} should be spoken and then transformed back to {0}")
        @ValueSource(strings = {
                "bart",
                "how are you doing"
        })
        void the_spoken_sentence_should_be_transformed_back_to_the_original_sentence(
                final String sentence
        ) {
            // GIVEN
            final String theSpokenSentence = Languages.P_LANGUAGE.speak(sentence);

            // WHEN
            final String translatedSentence = Languages.P_LANGUAGE.translate(theSpokenSentence);

            // THEN
            Assertions.assertThat(translatedSentence)
                    .isEqualTo(sentence);
        }

    }

    @DisplayName("the P2-Language")
    @Nested
    class The_P2_Language {

        @DisplayName("each group of vowels should be repeated with a the letter p in between")
        @ParameterizedTest(name = "For example {0} should be spoken as {1}")
        @CsvSource({
                "bart, bapart",
                "how are you doing, hopow aparepe youpou doipoing"
        })
        void each_group_of_vowels_should_be_repeated_with_a_the_letter_p_in_between(
                final String sentence,
                final String spokenSentence
        ) {
            // GIVEN

            // WHEN
            final String theSpokenSentence = Languages.P2_LANGUAGE.speak(sentence);

            // THEN
            Assertions.assertThat(theSpokenSentence)
                    .isEqualTo(spokenSentence);
        }

        @DisplayName("the spoken sentence should be transformed back to the original sentence")
        @ParameterizedTest(name = "For example {0} be spoken and then transformed back to {0}")
        @ValueSource(strings = {
                "bart",
                "how are you doing"
        })
        void the_spoken_sentence_should_be_transformed_back_to_the_original_sentence(
                final String sentence
        ) {
            // GIVEN
            final String theSpokenSentence = Languages.P2_LANGUAGE.speak(sentence);

            // WHEN
            final String translatedSentence = Languages.P2_LANGUAGE.translate(theSpokenSentence);

            // THEN
            Assertions.assertThat(translatedSentence)
                    .isEqualTo(sentence);
        }

    }

}
