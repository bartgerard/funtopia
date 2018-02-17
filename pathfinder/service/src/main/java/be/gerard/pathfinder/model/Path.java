package be.gerard.pathfinder.model;

import java.util.Objects;

/**
 * Path
 *
 * @author bartgerard
 * @version v0.0.1
 */
public class Path {

    private final Node from;
    private final Node to;

    public Path(
            final Node from,
            final Node to
    ) {
        this.from = from;
        this.to = to;
    }

    public Node getFrom() {
        return from;
    }

    public Node getTo() {
        return to;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final Path path = (Path) o;
        return Objects.equals(from, path.from) &&
                Objects.equals(to, path.to);
    }

    @Override
    public int hashCode() {

        return Objects.hash(from, to);
    }

}
