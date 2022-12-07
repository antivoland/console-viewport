package antivoland.console.viewport.view;

import antivoland.console.viewport.stage.Stage;
import antivoland.console.viewport.tick.Tick;

public class Camera {

    public volatile int x;
    public final Stage stage;

    public Camera(Stage stage) {
        this.stage = stage;
    }

    @Deprecated
    public Snapshot snapshot(Tick tick, int size) {
        throw new UnsupportedOperationException("Method was deprecated");
    }

    public Snapshot snapshot(int size) {
        var snapshot = new Snapshot(size);
        for (var view : stage.views) {
            snapshot = snapshot.append(view.x - x, view.value());
        }
        return snapshot;
    }
}