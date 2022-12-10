package antivoland.console.viewport.stage;

import antivoland.console.viewport.tick.Tick;
import antivoland.console.viewport.tick.Ticker;
import antivoland.console.viewport.view.Camera;
import antivoland.console.viewport.view.Viewport;
import antivoland.console.viewport.view.component.Component;
import antivoland.console.viewport.view.export.GifExporter;
import antivoland.console.viewport.view.export.Recorder;

import java.io.Closeable;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collection;

public class Stage implements Closeable {
    private final Ticker ticker = new Ticker(this::handleTick);
    public final Camera camera = new Camera(this);
    public final Viewport viewport = new Viewport();
    private volatile boolean paused;
    public final Collection<Component> views = new ArrayList<>();
    public final Recorder recorder = new Recorder();

    public Stage(String name) {
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            pause();
            GifExporter.export(recorder.frames, Paths.get("static/" + name + ".gif"));
        }));
        paused = true;
        ticker.run();
    }

    public void play() {
        paused = false;
    }

    public void pause() {
        paused = true;
    }

    private void handleTick(Tick tick) {
        if (paused) {
            return;
        }

        views.forEach(view -> view.tick(tick));

        var snapshot = camera.snapshot(viewport.size);
        viewport.draw(snapshot);
        recorder.record(tick, snapshot);
    }

    @Override
    public void close() {
        ticker.close();
    }
}