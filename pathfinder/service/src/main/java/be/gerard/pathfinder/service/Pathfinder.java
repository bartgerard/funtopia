package be.gerard.pathfinder.service;

import be.gerard.pathfinder.model.Link;
import be.gerard.pathfinder.model.Node;
import be.gerard.pathfinder.model.Predicates;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Pathfinder
 *
 * @author bartgerard
 * @version v0.0.1
 */
public class Pathfinder {

    public static Optional<List<Node>> findShortestPath(
            final Set<Link> links,
            final Node end,
            final Set<Node> froms,
            final Set<Node> visited
    ) {
        if (froms.contains(end)) {
            return Optional.of(Collections.singletonList(end));
        }

        final Map<Node, Set<Node>> toMap = findToMap(links, froms, visited);

        if (toMap.isEmpty()) {
            return Optional.empty();
        }

        final Set<Node> tos = toMap.values()
                .stream()
                .flatMap(Set::stream)
                .collect(Collectors.toSet());

        final Set<Node> allVisited = new HashSet<>(visited);
        allVisited.addAll(tos);

        return findShortestPath(links, end, tos, allVisited).map(
                path -> toMap.entrySet()
                        .stream()
                        .filter(entry -> entry.getValue()
                                .contains(path.get(0))
                        )
                        .map(Map.Entry::getKey)
                        .findFirst()
                        .map(previous -> {
                            final ArrayList<Node> result = new ArrayList<>(path);
                            result.add(0, previous);
                            return Collections.unmodifiableList(result);
                        })
                        .orElseThrow(IllegalStateException::new)
        );
    }

    private static Map<Node, Set<Node>> findToMap(
            final Set<Link> links,
            final Set<Node> froms,
            final Set<Node> visited
    ) {
        return froms.stream()
                .collect(Collectors.toMap(
                        Function.identity(),
                        from -> Stream.concat(
                                links.stream()
                                        .filter(link -> Objects.equals(from, link.getFrom()))
                                        .map(Link::getTo),
                                links.stream()
                                        .filter(Link::isBidirectional)
                                        .filter(link -> Objects.equals(from, link.getTo()))
                                        .map(Link::getFrom)
                        )
                                .filter(Predicates.not(visited::contains))
                                .collect(Collectors.toSet())
                ));
    }

}
