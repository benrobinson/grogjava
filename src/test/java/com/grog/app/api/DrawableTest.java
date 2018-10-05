package com.grog.app.api;

import org.junit.Test;

public class DrawableTest {

    private class TestOutput implements Output {
        TestOutput() {}
    }

    private class TestDrawable extends Drawable<Output> {

        TestDrawable() {
            output = null;
        }

        public TestDrawable setOutput(Output o) {
            output = o;
            System.out.println("SET OUTPUT");
            return this;
        }

        public TestDrawable draw() {
            System.out.println("TEST DRAWABLE");
            return this;
        }
    }

    @Test
    public void testSetOutput() {
        Output o = new TestOutput();
        TestDrawable testDrawable = new TestDrawable();
        testDrawable.setOutput(o);
    }

    @Test
    public void testDraw() {
        TestDrawable testDrawable = new TestDrawable();
        testDrawable.draw();
    }
}
