package antivoland.game;

import antivoland.console.viewport.stage.Stage;

public class Game {
    public static void main(String[] args) throws Exception {
//        var story = new Story();

//        System.in.read();
        try (var stage = new Stage()) {
            stage.player.view.x = 0;
            stage.player.velocity = 2.0;

            // attack
//            stage.player.move(20);

            // move
            stage.player.move(20);

            Thread.sleep(3000);

            stage.pause();

            // do nothing
        }
    }
}