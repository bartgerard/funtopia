package be.gerard.kata.varia;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

/**
 * WhenDetecting
 *
 * @author bartgerard
 * @version v0.0.1
 */
@DisplayName("When searching")
class WhenSearching {


    @DisplayName("palindromes")
    @Nested
    class Palindromes {

        @ParameterizedTest(name = "For example {0} should be spoken as {1}")
        @ValueSource(strings = {
                "A man, a plan, a canal, Panama!",
                "Was it a car or a cat I saw?",
                "No 'x' in Nixon"
        })
        void valid(
                final String sentence
        ) {
            // GIVEN

            // WHEN
            final boolean isPalindrome = Patterns.PALINDROME.matches(sentence);

            // THEN
            Assertions.assertThat(isPalindrome).isTrue();
        }

    }

}
