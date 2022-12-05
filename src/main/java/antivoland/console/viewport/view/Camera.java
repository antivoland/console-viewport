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
        var snapshot = new Snapshot(size);

        for (var animation : stage.animations) {
            snapshot = snapshot.append(animation.x - x, animation.value(tick));
        }

        return snapshot.append(stage.player.view.x - x, stage.player.view.value(tick));
    }
}