package com.lab.event;

import com.lab.aggregates.AppStatus;

public class BaseEvent<T> {

    public final T id;
    public final AppStatus status;

    public BaseEvent(T id, AppStatus status) {
        this.id = id;
        this.status = status;
    }
}
