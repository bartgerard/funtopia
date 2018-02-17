package be.gerard.pathfinder.model;

/**
 * TestTag
 *
 * @author bartgerard
 * @version v0.0.1
 */
public enum TestTag implements Tag {
    A,
    B,
    C1,
    C2,
    D,
    E,
    F,
    G,
    X,
    Y,
    Z;

    @Override
    public Tag.Type getType() {
        return TestTagType.TERM;
    }

}
