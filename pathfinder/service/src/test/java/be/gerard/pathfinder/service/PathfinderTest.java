package be.gerard.pathfinder.service;

import be.gerard.pathfinder.model.Link;
import be.gerard.pathfinder.model.Node;
import be.gerard.pathfinder.model.TestTag;
import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.util.List;
import java.util.Set;

/**
 * PathfinderTest
 *
 * @author bartgerard
 * @version v0.0.1
 */
public class PathfinderTest {

    private static final Node X = Node.withTags(List.of(TestTag.X));
    private static final Node Y = Node.withTags(List.of(TestTag.Y));
    private static final Node Z = Node.withTags(List.of(TestTag.Z));

    @Test
    public void findPath() {
        final Set<Link> links = Set.of(
                new Link(X, Y),
                new Link(Y, Z)
        );

        Assertions.assertThat(Pathfinder.findShortestPath(X, Z, links))
                  .containsExactly(X, Y, Z);
    }

}
