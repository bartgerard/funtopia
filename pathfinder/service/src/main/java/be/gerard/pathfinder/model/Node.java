package be.gerard.pathfinder.model;

import java.util.Collection;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Node
 *
 * @author bartgerard
 * @version v0.0.1
 */
public class Node {

    private final Map<Tag.Type, Tag> tags;

    private Node(final Map<Tag.Type, Tag> tags) {
        this.tags = tags;
    }

    public Map<Tag.Type, Tag> getTags() {
        return tags;
    }

    public static Node withTags(
            final Collection<Tag> tags
    ) {
        return new Node(
                tags.stream()
                    .collect(Collectors.toMap(
                            Tag::getType,
                            Function.identity()
                    ))
        );
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final Node node = (Node) o;
        return Objects.equals(tags, node.tags);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tags);
    }

    @Override
    public String toString() {
        return "Node{" +
                "tags=" + tags +
                '}';
    }

}
