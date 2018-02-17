package be.gerard.pathfinder.service;

import be.gerard.pathfinder.model.Link;
import be.gerard.pathfinder.model.Node;

import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Pathfinder
 *
 * @author bartgerard
 * @version v0.0.1
 */
public class Pathfinder {

    public static List<Node> findShortestPath(
            final Node from,
            final Node to,
            final Collection<Link> links
    ) {
        final Set<Node> tos = links.stream()
                                   .filter(link -> Objects.equals(from, link.getFrom()))
                                   .map(Link::getTo)
                                   .collect(Collectors.toSet());

        return null;
    }

}
