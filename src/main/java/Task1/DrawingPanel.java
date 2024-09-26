package Task1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.LinkedList;

public class DrawingPanel extends JPanel implements ActionListener, MouseListener {

    private final int PANEL_WIDTH;
    private final int PANEL_HEIGHT;
    private final int TIMER_DELAY;
    private Timer timer;
    private int ticksFromStart = 0;
    private boolean busy = false;
    private Bunny bunny;
    private Grass grass;
    private Sky sky;
    private LinkedList<Entity> entityList = new LinkedList<>();
    private Actions action;

    public DrawingPanel(final int width, final int height, final int timerDelay) {
        this.PANEL_WIDTH = width;
        this.PANEL_HEIGHT = height;
        this.TIMER_DELAY = timerDelay;
        timer = new Timer(timerDelay, this);
        timer.start();
        this.addMouseListener(this);

        setEnvironment();
    }

    private void setEnvironment() {
        bunny = new Bunny(500, 500, 100, 200);
        grass = new Grass(1920, 1080 - (bunny.getY() + bunny.getHeight()), (int) (bunny.getY() + bunny.getHeight() * 0.9));
        sky = new Sky(1920, grass.getY());

        entityList.add(new Cloud(10, 10, 500, 400));
        entityList.add(new Cloud(600, 100, 400, 300));
        entityList.add(new Cloud(1300, 50, 500, 400));
        entityList.add(new Bush(100, 800, 300, 200));
        entityList.add(new Bush(700, 750, 400, 200));
        entityList.add(new Bush(1300, 800, 400, 200));
    }

    @Override
    public void paint(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;

        g2d.setColor(Color.WHITE);
        g2d.fillRect(0,0,1920, 1080);

        if (busy) {
            action.entityJump(ticksFromStart);
            if (action.getEntity() == null) {
                busy = false;
            }
        }

        grass.draw(g2d);
        sky.draw(g2d);

        checkEntities(g2d);

        bunny.draw(g2d);
    }

    private void checkEntities(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;

        LinkedList<Entity> toAdd = new LinkedList<>();
        LinkedList<Integer> toDelete = new LinkedList<>();

        if (!entityList.isEmpty()) {
            for (Entity ent : entityList) {
                if (ent.getClass() == Cloud.class) {
                    ent.setX(ent.getX() + 1);
                    if (ent.getX() == 1920) {
                        toDelete.add(entityList.indexOf(ent));
                    } else if (ent.getX() + ent.getWidth() == 1920) {
                        toAdd.add(new Cloud(ent.getX() - 1920, ent.getY(), ent.getWidth(), ent.getHeight()));
                    }
                }
                ent.draw(g2d);
            }
            for (Integer i : toDelete) {
                entityList.remove((int) i);
            }
            entityList.addAll(toAdd);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == timer) {
            repaint();
            ++ticksFromStart;
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getButton() == 1 && !busy && e.getX() != (bunny.getX() + bunny.getWidth() / 2)) {
            busy = true;
            action = new Actions(bunny, e.getX(), ticksFromStart);
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

}
