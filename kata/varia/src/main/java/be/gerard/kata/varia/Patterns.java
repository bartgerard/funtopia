package be.gerard.kata.varia;

/**
 * Patterns
 *
 * @author bartgerard
 * @version v0.0.1
 */
public enum Patterns {
    ANAGRAM {
        @Override
        boolean matches(
                final String sentence
        ) {
            return false;
        }
    },
    PALINDROME {
        @Override
        boolean matches(
                final String sentence
        ) {
            return false;
        }
    };

    abstract boolean matches(
            String sentence
    );

}
