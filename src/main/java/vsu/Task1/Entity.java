package vsu.Task1;

import java.awt.*;

public abstract class Entity {
    private int x;
    private int y;
    private int width;
    private int height;

    protected int getX() {
        return x;
    }

    protected void setX(int x) {
        this.x = x;
    }

    protected int getY() {
        return y;
    }

    protected void setY(int y) {
        this.y = y;
    }

    protected int getWidth() {
        return width;
    }

    protected int getHeight() {
        return height;
    }

    protected void draw(final Graphics gr) {

    }
}
