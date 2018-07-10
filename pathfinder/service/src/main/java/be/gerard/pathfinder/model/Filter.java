package be.gerard.pathfinder.model;

import java.util.Set;

/**
 * Filter
 *
 * @author bartgerard
 * @version v0.0.1
 */
public interface Filter<T> {

    static <T> Filter<T> none() {
        return new None<>();
    }

    static <T> Filter<T> wild() {
        return new Wild<>();
    }

    static <T> Filter<T> required() {
        return new Required<>();
    }

    static <T> Filter<T> is(
            final T value
    ) {
        return new Value<>(value);
    }

    static <T> Filter<T> in(
            final Set<T> values
    ) {
        return new Values<>(values);
    }

    enum Type {
        NONE,
        WILD,
        REQUIRED,
        VALUE,
        EXCLUDE
    }

    class None<T> implements Filter<T> {

    }

    class Wild<T> implements Filter<T> {

    }

    class Required<T> implements Filter<T> {

    }

    class Value<T> implements Filter<T> {

        private final T value;

        private Value(final T value) {
            this.value = value;
        }

    }

    class Values<T> implements Filter<T> {

        private final Set<T> values;

        private Values(final Set<T> values) {
            this.values = values;
        }

    }

}
