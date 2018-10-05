package com.grog.app.api;

public abstract class Moveable<T extends Number> {
    protected T xSpeed;
    protected T ySpeed;

    public abstract Moveable setXSpeed(T xSpeed);

    public abstract Moveable setYSpeed(T ySpeed);

    public abstract Moveable changeXSpeedBy(T amount);

    public abstract Moveable changeYSpeedBy(T amount);
}
