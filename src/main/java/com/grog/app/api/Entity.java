package com.grog.app.api;

public abstract class Entity<T extends Output, N extends Number> implements Drawable, Moveable<N>, Positionable<N>, Updateable {
  protected T output;
  protected N x;
  protected N y;
  protected N xSpeed;
  protected N ySpeed;

  public Entity setOutput(T o) {
    output = o;
    return this;
  }
}