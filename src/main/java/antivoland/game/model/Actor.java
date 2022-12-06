package antivoland.game.model;


import antivoland.console.viewport.view.component.Component;
import antivoland.game.model.task.MoveTask;
import antivoland.game.model.task.Task;

public class Actor {

    public final int health = 60;
    public final int maxHealth = 100;
    public volatile double velocity = 1.0;

    // todo: inventory

    public final Component view;

    public volatile Task task;

    public Actor(Component view) {
        this.view = view;
    }

    public void move(int x) {
        task = new MoveTask(this, x);
    }
}