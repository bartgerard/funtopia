package be.gerard.pathfinder.model;

import java.util.Objects;

/**
 * Link
 *
 * @author bartgerard
 * @version v0.0.1
 */
public class Link {

    private final Node from;
    private final Node to;
    private final boolean bidirectional;

    public Link(
            final Node from,
            final Node to
    ) {
        this(from, to, true);
    }

    public Link(
            final Node from,
            final Node to,
            final boolean bidirectional
    ) {
        this.from = from;
        this.to = to;
        this.bidirectional = bidirectional;
    }

    public Node getFrom() {
        return from;
    }

    public Node getTo() {
        return to;
    }

    public boolean isBidirectional() {
        return bidirectional;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final Link link = (Link) o;
        return Objects.equals(from, link.from) &&
                Objects.equals(to, link.to);
    }

    @Override
    public int hashCode() {
        return Objects.hash(from, to);
    }

}
