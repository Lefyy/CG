package Task1;

import java.awt.*;

public class Sky extends Entity {
    private int width;
    private int height;

    public Sky(int width, int height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public void draw(final Graphics gr) {
        Graphics2D g = (Graphics2D) gr;

        GradientPaint gradient = new GradientPaint(0.0F, 0.0F, Color.CYAN, 0.0F, (float) height, new Color(224, 255, 255));
        g.setPaint(gradient);
        g.fillRect(0, 0, width, height);
    }

    @Override
    public int getWidth() {
        return width;
    }

    @Override
    public int getHeight() {
        return height;
    }
}
