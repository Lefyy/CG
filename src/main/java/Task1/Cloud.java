package Task1;

import java.awt.*;

public class Cloud extends Entity {
    private int x;
    private int y;
    private int width;
    private int height;

    public Cloud(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    @Override
    public void draw(Graphics gr) {
        Graphics2D g = (Graphics2D) gr;

        g.setColor(Color.WHITE);
        g.fillRect((int) (this.x + this.width * 0.2), (int) (this.y + this.height * 0.5), (int) (this.width * 0.6), (int) (this.height * 0.5));
        g.fillOval(this.x, (int) (this.y + this.height * 0.5), (int) (this.width * 0.4), (int) (this.height * 0.5));
        g.fillOval((int) (this.x + this.width * 0.6), (int) (this.y + this.height * 0.5), (int) (this.width * 0.4), (int) (this.height * 0.5));
        g.fillOval((int) (this.x + this.width * 0.15), this.y, (int) (this.width * 0.5), (int) (this.height * 0.7));
        g.fillOval((int) (this.x + this.width * 0.5), (int) (this.y + this.height * 0.1), (int) (this.width * 0.4), (int) (this.height * 0.5));
    }

    @Override
    public int getWidth() {
        return width;
    }

    @Override
    public int getHeight() {
        return height;
    }

    @Override
    public int getX() {
        return x;
    }

    @Override
    public int getY() {
        return y;
    }

    @Override
    public void setX(int x) {
        this.x = x;
    }

    @Override
    public void setY(int y) {
        this.y = y;
    }
}
