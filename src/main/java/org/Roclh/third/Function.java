package org.Roclh.third;

public interface Function<A, T, R> {
    R apply(A applier, T target);
}
