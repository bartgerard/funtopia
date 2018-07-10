package be.gerard.pathfinder.service;

import be.gerard.pathfinder.model.Link;
import be.gerard.pathfinder.model.Node;
import be.gerard.pathfinder.model.TestTag;
import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

/**
 * PathfinderTest
 *
 * @author bartgerard
 * @version v0.0.1
 */
public class PathfinderTest {

    private static final Node A = Node.withTags(List.of(TestTag.A));
    private static final Node B = Node.withTags(List.of(TestTag.B));
    private static final Node C1 = Node.withTags(List.of(TestTag.C1));
    private static final Node C2 = Node.withTags(List.of(TestTag.C2));
    private static final Node D = Node.withTags(List.of(TestTag.D));
    private static final Node E = Node.withTags(List.of(TestTag.E));
    private static final Node F = Node.withTags(List.of(TestTag.F));
    private static final Node G = Node.withTags(List.of(TestTag.G));
    private static final Node X = Node.withTags(List.of(TestTag.X));
    private static final Node Y = Node.withTags(List.of(TestTag.Y));
    private static final Node Z = Node.withTags(List.of(TestTag.Z));

    //  A - B - C1 - D   E - F - G - X - Y - Z
    //        \    /
    //          C2

    private final Set<Link> BASE_LINKS = Set.of(
            new Link(A, B),
            new Link(B, C1),
            new Link(B, C2),
            new Link(C1, D),
            new Link(C2, D),
            new Link(E, F),
            new Link(F, G),
            new Link(G, X),
            new Link(X, Y),
            new Link(Y, Z)
    );

    @Test
    public void findShortestPathVeryBasicTest() {
        final Set<Link> links = Set.of(
                new Link(X, Y),
                new Link(Y, Z)
        );

        Assertions.assertThat(Pathfinder.findShortestPath(links, Z, Collections.singleton(X), Collections.emptySet()))
                .isEqualTo(Optional.of(Arrays.asList(X, Y, Z)));

        Assertions.assertThat(Pathfinder.findShortestPath(links, Z, Collections.singleton(Z), Collections.emptySet()))
                .isEqualTo(Optional.of(Collections.singletonList(Z)));
    }

    @Test
    public void findShortestPathAdvancedBasicTest() {
        final Set<Link> links = new HashSet<>(BASE_LINKS);
        links.add(new Link(A, X));
        links.add(new Link(D, E));
        links.add(new Link(C1, Z));

        //              - - - - - - - - - - - -
        //             /                       \
        //  A - B - C1 - D - E - F - G - X - Y - Z
        //  |     \    /                 |
        //  |       C2                   |
        //  - - - - - - - - - - - - - - -

        Assertions.assertThat(Pathfinder.findShortestPath(links, Z, Collections.singleton(B), Collections.emptySet()))
                .isEqualTo(Optional.of(Arrays.asList(B, C1, Z)));

        Assertions.assertThat(Pathfinder.findShortestPath(links, Z, Collections.singleton(A), Collections.emptySet()))
                .isEqualTo(Optional.of(Arrays.asList(A, B, C1, Z)));

        Assertions.assertThat(Pathfinder.findShortestPath(links, Z, Set.of(Y, G), Collections.emptySet()))
                .isEqualTo(Optional.of(Arrays.asList(Y, Z)));

        Assertions.assertThat(Pathfinder.findShortestPath(links, Z, Set.of(Y, G), Collections.emptySet()))
                .isEqualTo(Optional.of(Arrays.asList(Y, Z)));
    }

    @Test
    public void findDirectedShortestPathAdvancedBasicTest() {
        final Set<Link> links = new HashSet<>(BASE_LINKS);
        links.add(new Link(Z, C1, false));
        links.add(new Link(D, E, false));

        //              < < < < < < < < < < < <
        //             /                       \
        //  A - B - C1 - D > E - F - G - X - Y - Z
        //        \    /
        //          C2

        Assertions.assertThat(Pathfinder.findShortestPath(links, D, Collections.singleton(E), Collections.emptySet()))
                .isEqualTo(Optional.of(Arrays.asList(E, F, G, X, Y, Z, C1, D)));
    }

}
