package antivoland.console.viewport;

import antivoland.console.viewport.stage.Stage;

public class World {

    public static void main(String[] args) {
        try (var stage = new Stage()) {
            stage.player.view.x = 0;
            stage.player.velocity = 2.0;
            stage.player.move(20);
        }
    }
}