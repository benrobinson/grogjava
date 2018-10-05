package com.grog.app.api;

import java.util.concurrent.Callable;

public interface Updateable {

    public Updateable update(Callable<Updateable> update);

}
