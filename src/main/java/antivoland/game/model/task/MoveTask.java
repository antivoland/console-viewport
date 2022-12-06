package antivoland.game.model.task;

import antivoland.game.model.Actor;
import antivoland.console.viewport.tick.Tick;

import static java.lang.Math.min;

public class MoveTask extends Task {
    public final Actor actor;
    public final int xFrom;
    public final int xTo;

    public MoveTask(Actor actor, int x) {
        this.actor = actor;
        this.xFrom = actor.view.x;
        this.xTo = x;
    }

    @Override
    public void tick(Tick tick) {
        long dt = tick.currentTimeMillis - createdTimeMillis;
        int dx = min((int) (actor.velocity * dt / 1000), xTo - xFrom);
        actor.view.x = xFrom + dx;
    }
}