package be.gerard.kata.varia;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/**
 * Languages
 *
 * @author bartgerard
 * @version v0.0.1
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public enum Languages implements Language {
    P_LANGUAGE {

        @Override
        public String speak(
                final String sentence
        ) {
            return sentence.replaceAll(
                    "([aeiouéè]+)",
                    "ep$1"
            );
        }

        @Override
        public String translate(
                final String sentence
        ) {
            return sentence.replaceAll(
                    "ep([aeiouéè]+)",
                    "$1"
            );
        }

    },
    P2_LANGUAGE {
        @Override
        public String speak(
                final String sentence
        ) {
            return sentence.replaceAll(
                    "([aeiouéè]+)",
                    "$1p$1"
            );
        }

        @Override
        public String translate(
                final String sentence
        ) {
            return sentence.replaceAll(
                    "([aeiouéè]+)p\\1",
                    "$1"
            );
        }

    }
}
