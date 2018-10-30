package com.grog.app.impl;

import com.grog.app.api.Entity;
import com.grog.app.api.Output;
import com.grog.app.api.Position;
import com.grog.app.api.Updateable;

import java.util.function.Function;

public class PlayerEntity<T extends Output> extends Entity<T, Integer> {
  private Position<Integer> position;

  public PlayerEntity draw() {
    // TODO draw to output

    return this;
  }

  public PlayerEntity setXSpeed(Integer xSpeed) {
    xSpeed = xSpeed;
    return this;
  }

  public PlayerEntity setYSpeed(Integer ySpeed) {
    ySpeed = ySpeed;
    return this;
  }

  public PlayerEntity changeXSpeedBy(Integer amount) {
    xSpeed += amount;
    return this;
  }

  public PlayerEntity changeYSpeedBy(Integer amount) {
    ySpeed += amount;
    return this;
  }

  public Position getPosition() {
    return position;
  }

  public PlayerEntity setPosition(Integer x, Integer y) {
    position = new Position<Integer>(x, y);
    return this;
  }

  public Updateable update(Function<Updateable, Updateable> u) {
    return u.apply(this);
  }
}
