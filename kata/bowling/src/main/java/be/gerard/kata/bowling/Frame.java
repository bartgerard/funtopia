package be.gerard.kata.bowling;

import lombok.RequiredArgsConstructor;

import java.util.List;

/**
 * Frame
 *
 * @author bartgerard
 * @version v0.0.1
 */
@RequiredArgsConstructor
public class Frame {

    /*
     * first(pins) == 10 --> 'X'
     * sum(pins) == 10 --> '/'
     * sum(pins) == 0 --> '-'
     * foul --> 'F'
     * else --> hits
     */

    // two choices, either Frame knows about next frames
    // or Game manages scoring

    private final List<Integer> pins;

}
