package antivoland.console.viewport.stage;

import antivoland.console.viewport.World;
import antivoland.console.viewport.model.Player;
import antivoland.console.viewport.tick.Tick;
import antivoland.console.viewport.tick.Ticker;
import antivoland.console.viewport.view.Camera;
import antivoland.console.viewport.view.Viewport;

import java.io.Closeable;

public class Stage implements Closeable {
    private final World world;
    private final Ticker ticker = new Ticker(this::handleTick);
    public final Player player = new Player();
    public final Camera camera = new Camera(this);
    public final Viewport viewport = new Viewport();

    public Stage(World world) {
        this.world = world;
        ticker.run();
    }

    private void handleTick(Tick tick) {
        if (player.task != null) {
            player.task.tick(tick);
        }

        var snapshot = camera.snapshot(tick, viewport.size);
        viewport.draw(snapshot);

        // animate movements
    }

    @Override
    public void close() {
        ticker.close();
    }
}