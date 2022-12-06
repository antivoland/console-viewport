package antivoland.game.model;


import antivoland.game.model.task.MoveTask;
import antivoland.game.model.task.Task;
import antivoland.console.viewport.view.component.Monkey;

public class Actor {

    public final int health = 60;
    public final int maxHealth = 100;
    public volatile double velocity = 1.0;

    // todo: inventory

    public final Monkey view = new Monkey();

    public volatile Task task;

    public void move(int x) {
        task = new MoveTask(this, x);
    }
}