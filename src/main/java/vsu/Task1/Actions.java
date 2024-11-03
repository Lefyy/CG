package vsu.Task1;

public class Actions {
    private Entity entity;
    private int ticksInStart;
    private int x0;
    private int y0;
    private int x1;
    private boolean direction; // true = right, false = left
    private int parabolaX0;

    public Actions(Entity entity, int x, int ticksFromStart) {
        this.entity = entity;
        x1 = x - (entity.getWidth() / 2);

        x0 = entity.getX();
        y0 = entity.getY();

        direction = (x1 - x0) > 0;
        parabolaX0 = (x1 - x0) / 2;

        ticksInStart = ticksFromStart;
    }

    public void entityJump(int ticksFromStart) {

        int dx = (int) Math.round(1 + Math.abs(x1 - x0) / 75.0) * (direction ? (ticksFromStart - ticksInStart) : -1 * (ticksFromStart - ticksInStart));

        if (direction ? x0 + dx < x1 : x0 + dx > x1) {
            int dy = (int) (-0.5 / Math.abs(parabolaX0) * Math.pow(dx, 2) + Math.abs(dx));

            entity.setX(x0 + dx);
            entity.setY(y0 - dy);
        } else {
            entity.setX(x1);
            entity.setY(y0);
            clear();
        }
    }

    public Entity getEntity() {
        return entity;
    }

    private void clear() {
        entity = null;
        ticksInStart = 0;
        x0 = 0;
        y0 = 0;
        parabolaX0 = 0;
    }

}
