package be.continuum.decryptor;

import org.junit.jupiter.api.Test;
import org.springframework.data.util.Pair;

import java.util.List;
import java.util.stream.Collectors;

/**
 * DecryptorTest
 *
 * @author bartgerard
 * @version v0.0.1
 */
class DecryptorTest {

    private static final String SHERLOCK = "AOEPCTQIHJGFKBRYLVDZNXUWMS";
    private static final String ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    // caesar cypher

    final List<Pair<Integer, String>> CODES = List.of(
            // September 10th
            Pair.of(
                    10,
                    "NVWMVO. KJUYBA. WU EAJVN. VR MAWGNBXO OBB VXLWRR JE GBELNBLBX."
            ),
            // September 19th
            Pair.of(
                    19,
                    "GIBRIV. APXSLP. QIEPBZD FSW AP JKBXK. IC RLBAGPF TB DB VPNPK KPXOBFPK."
            ),
            // September 19th
            Pair.of(
                    19,
                    "QBGFPV"
            )
    );

    @Test
    void test() {
        final Decryptor decryptor = new Decryptor(SHERLOCK, ALPHABET);

        final String sentence = "NVWMVO. KJUYBA. WU EAJVN. VR MAWGNBXO OBB VXLWRR JE GBELNBLBX.";

        System.out.println(decryptor.decrypt(sentence, 26 - 10 + 1));

        //final String sentence = "ABCDEF";

        for (char letter : ALPHABET.toCharArray()) {
            final int shift = ALPHABET.indexOf(letter);

            final String result = sentence.chars()
                    .map(c -> {
                        final int i = SHERLOCK.indexOf(c);

                        if (i < 0) {
                            return c;
                        }

                        return ALPHABET.charAt((i + shift) % ALPHABET.length());
                    })
                    .mapToObj(c -> (char) c)
                    .map(String::valueOf)
                    .collect(Collectors.joining());

            //System.out.println(shift + " " + result);
        }
    }

}
