package be.gerard.pathfinder.model;

import java.util.List;

/**
 * Path
 *
 * @author bartgerard
 * @version v0.0.1
 */
public class Path {

    private final List<Node> nodes;

    public Path(final List<Node> nodes) {
        this.nodes = nodes;
    }

}
