package org.Roclh.third;

import lombok.Getter;


@Getter
public class Action<A, T, R> {

    private A applier;
    private T target;
    private String description;
    private R result;
    private Function<A, T, R> action;

    public Action(A applier, T target, String description) {
        this.applier = applier;
        this.target = target;
        this.description = description;
    }

    public Action<A, T, R> setAction(org.Roclh.third.Function<A, T, R> action) {
        this.action = action;
        return this;
    }

    public Action<A, T, R> perform() {
        this.result = this.action.apply(applier, target);
        return this;
    }

    public R orElse(R or) {
        return this.result == null ? or : this.result;
    }
}
