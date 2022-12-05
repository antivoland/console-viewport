package antivoland.console.viewport;

import antivoland.console.viewport.stage.Stage;
import antivoland.console.viewport.tick.Tick;
import antivoland.console.viewport.view.Camera;
import antivoland.console.viewport.view.Viewport;
import antivoland.console.viewport.view.component.Fps;
import antivoland.console.viewport.view.component.Timer;

public class World {

//    public final Stage stage;
//
//    public final Viewport viewport;
//    public final Camera camera;
//    public final Container hud;
//    public final Timer timer;
//    public final Fps fps;


    public World() {

//        viewport = new Viewport();
//        viewport.add(new Timer(viewport));
//        viewport.add(new Fps(viewport));
//
//        camera = new Camera(stage, viewport);

//        hud = new Panel(viewport.size, viewport, Align.LEFT);

//        fps = new Fps(viewport);
//        hud.add(fps);

    }

    public void run() {
        try (var stage = new Stage(this)) {
            stage.player.view.x = 0;
            stage.player.velocity = 2.0;

            // attack
//            stage.player.move(20);

            // move
            stage.player.move(20);

            // do nothing
        }
    }

//    private void handleTickEvent(Tick event) {
//        var snapshot = camera.snapshot(event);
//        viewport.draw(snapshot);
//    }

    public static void main(String[] args) {
        new World().run();
    }
}