package Task1;

import java.awt.*;

public class Grass extends Entity {
    private int width;
    private int height;
    private int y;

    public Grass(int width, int height, int y) {
        this.width = width;
        this.height = height;
        this.y = y;
    }

    @Override
    public void draw(Graphics gr) {
        Graphics2D g = (Graphics2D) gr;

        g.setColor(new Color(173, 255, 47));

        g.fillRect(0, this.y, this.width, this.height);
    }
}
