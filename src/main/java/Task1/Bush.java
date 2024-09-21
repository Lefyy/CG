package Task1;

import java.awt.*;

public class Bush extends Entity {
    private int x;
    private int y;
    private int width;
    private int height;

    public Bush(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    @Override
    public void draw(Graphics gr) {
        Graphics2D g = (Graphics2D) gr;

        g.setColor(new Color(0, 100, 0));
        g.fillRect((int) (this.x + this.width * 0.2), (int) (this.y + this.height * 0.5), (int) (this.width * 0.6), (int) (this.height * 0.5));
        g.fillOval(this.x, (int) (this.y + this.height * 0.5), (int) (this.width * 0.4), (int) (this.height * 0.5));
        g.fillOval((int) (this.x + this.width * 0.6), (int) (this.y + this.height * 0.5), (int) (this.width * 0.4), (int) (this.height * 0.5));
        g.fillOval((int) (this.x + this.width * 0.15), this.y, (int) (this.width * 0.5), (int) (this.height * 0.7));
        g.fillOval((int) (this.x + this.width * 0.5), (int) (this.y + this.height * 0.1), (int) (this.width * 0.4), (int) (this.height * 0.5));
    }
}
