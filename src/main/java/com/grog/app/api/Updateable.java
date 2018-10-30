package com.grog.app.api;

import java.util.function.Function;

public interface Updateable {
    Updateable update(Function<Updateable, Updateable> u);
}
