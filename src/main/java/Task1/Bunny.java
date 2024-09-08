package Task1;

import java.awt.*;

public class Bunny {

    private int x;
    private int y;
    private int width;
    private int height;

    public Bunny(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    void draw(final Graphics gr) {
        Graphics2D g = (Graphics2D) gr;

        //head+ears = 70%
        //head = 35%
        //ears = 35%
        //body+legs = 40%
        //body = 30%
        //back legs = 15%
        //front legs = 30%

        //backlegs
        g.setColor(Color.GRAY);
        g.fillOval(this.x, (int) (this.y + this.height * 0.8), (int) (this.width * 0.2), (int) (this.height * 0.125));
        g.fillOval((int) (this.x + this.width * 0.8), (int) (this.y + this.height * 0.8), (int) (this.width * 0.2), (int) (this.height * 0.125));


        //body
        g.setColor(Color.GRAY);
        g.fillOval((int) (this.x + this.width * 0.1), (int) (this.y + this.height * 0.60), (int) (this.width * 0.8), (int) (this.height * 0.3));

        //frontlegs
        g.setColor(Color.GRAY);
        g.fillOval((int) (this.x + this.width * 0.25), (int) (this.y + this.height * 0.75), (int) (this.width * 0.2), (int) (this.height * 0.25));
        g.fillOval((int) (this.x + this.width * 0.55), (int) (this.y + this.height * 0.75), (int) (this.width * 0.2), (int) (this.height * 0.25));
        g.setColor(Color.BLACK);
        g.drawOval((int) (this.x + this.width * 0.25), (int) (this.y + this.height * 0.75), (int) (this.width * 0.2), (int) (this.height * 0.25));
        g.drawOval((int) (this.x + this.width * 0.55), (int) (this.y + this.height * 0.75), (int) (this.width * 0.2), (int) (this.height * 0.25));

        //ears
        g.setColor(Color.GRAY);
        g.rotate(- Math.PI / 6, this.x + this.width * 0.2, this.y + this.height * 0.25);
        g.fillOval((int) (this.x + this.width * 0.1), this.y, (int) (this.width * 0.2), (int) (this.height * 0.5));
        g.rotate(Math.PI / 6, this.x + this.width * 0.2, this.y + this.height * 0.25);
        g.rotate(Math.PI / 6, this.x + this.width * 0.8, this.y + this.height * 0.25);
        g.fillOval((int) (this.x + this.width * 0.7), this.y, (int) (this.width * 0.2), (int) (this.height * 0.5));
        g.rotate(-Math.PI / 6, this.x + this.width * 0.8, this.y + this.height * 0.25);

        //head
        g.setColor(Color.GRAY);
        g.fillOval((int) (this.x + this.width * 0.15), (int) (this.y + this.height * 0.35), (int) (this.width * 0.7), (int) (this.height * 0.35));
        g.setColor(Color.BLACK);
        g.drawOval((int) (this.x + this.width * 0.15), (int) (this.y + this.height * 0.35), (int) (this.width * 0.7), (int) (this.height * 0.35));
    }

}
