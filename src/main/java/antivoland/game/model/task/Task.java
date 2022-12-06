package antivoland.game.model.task;

import antivoland.console.viewport.tick.Tick;

public abstract class Task {
    public final long createdTimeMillis = System.currentTimeMillis();

    public abstract void tick(Tick tick);
}