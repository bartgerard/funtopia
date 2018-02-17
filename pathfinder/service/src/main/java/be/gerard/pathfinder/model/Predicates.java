package be.gerard.pathfinder.model;

import java.util.function.Predicate;

/**
 * Predicates
 *
 * @author bartgerard
 * @version v0.0.1
 */
public interface Predicates {

    static <T> Predicate<T> not(
            final Predicate<T> predicate
    ) {
        return predicate.negate();
    }

}
