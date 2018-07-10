package be.continuum.decryptor;

import org.springframework.util.Assert;

import java.util.stream.Collectors;

/**
 * Decryptor
 *
 * @author bartgerard
 * @version v0.0.1
 */
public class Decryptor {

    private final String in;

    private final String out;

    public Decryptor(
            final String in,
            final String out
    ) {
        Assert.isTrue(
                in.length() == out.length(),
                "in and out have different lengths"
        );

        Assert.isTrue(
                in.chars()
                        .distinct()
                        .count() == in.length(),
                "in requires all different values"
        );

        this.in = in;
        this.out = out;
    }

    public String decrypt(
            final String text,
            final int shift
    ) {
        return text.chars()
                .map(c -> {
                    final int i = in.indexOf(c);

                    if (i < 0) {
                        return c;
                    }

                    return out.charAt((i + shift) % in.length());
                })
                .mapToObj(c -> (char) c)
                .map(String::valueOf)
                .collect(Collectors.joining());
    }

}
