package Task1;

public class Actions {
    private Entity entity;
    private int ticksInStart;
    private int ticksInFinish;
    private int x0;
    private int y0;
    private boolean direction; // true = right, false = left
    private int parabolaX0;

    public Actions(Entity entity, int x, int ticksFromStart) {
        this.entity = entity;
        x = x - entity.getWidth() / 2;

        x0 = entity.getX();
        y0 = entity.getY();

        direction = (x - x0) > 0;
        parabolaX0 = (x - x0) / 2;

        ticksInStart = ticksFromStart;
        ticksInFinish = ticksFromStart + Math.abs(x - x0);
    }

    public void entityJump(int ticksFromStart) {
        int dx = direction ? (ticksFromStart - ticksInStart) : -1 * (ticksFromStart - ticksInStart);
        int dy = (int) (-1.0 / Math.abs(parabolaX0) * Math.pow(dx, 2) + 2 * Math.abs(dx));

        entity.setX(x0 + dx);
        entity.setY(y0 - dy);

        if (ticksFromStart == ticksInFinish) {
            clear();
        }
    }

    public Entity getEntity() {
        return entity;
    }

    private void clear() {
        entity = null;
        ticksInStart = 0;
        ticksInFinish = 0;
        x0 = 0;
        y0 = 0;
        parabolaX0 = 0;
    }

}
