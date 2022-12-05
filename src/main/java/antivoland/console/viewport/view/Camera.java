package antivoland.console.viewport.view;

import antivoland.console.viewport.stage.Stage;
import antivoland.console.viewport.tick.Tick;

public class Camera {

    public volatile int x;
    public final Stage stage;

    public Camera(Stage stage) {
        this.stage = stage;
    }

    public Snapshot snapshot(Tick tick, int size) {
        var x = stage.player.view.x;
        var value = stage.player.view.value(tick);
        return new Snapshot(size).append(x - this.x, value);
    }
}