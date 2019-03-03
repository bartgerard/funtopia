package be.gerard.kata.bowling;

import lombok.RequiredArgsConstructor;

import java.util.List;

/**
 * Game
 *
 * @author bartgerard
 * @version v0.0.1
 */
@RequiredArgsConstructor
public class Game {

    // http://slocums.homestead.com/gamescore.html

    /*
      default 10 frames (plus up to 2 additional frames)
     */

    private final List<Frame> frames;

}
