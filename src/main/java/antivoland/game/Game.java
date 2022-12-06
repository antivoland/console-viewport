package antivoland.game;

import antivoland.console.viewport.stage.Stage;
import antivoland.console.viewport.story.Story;
import antivoland.console.viewport.view.component.Token;
import antivoland.game.asset.Asset;
import antivoland.game.model.Actor;
import antivoland.game.model.Player;

import java.util.List;

public class Game {
    public static void main(String[] args) throws Exception {
        var story = new Story();

//        System.in.read();
        try (var stage = new Stage()) {
            var player = new Player(new Token(Asset.FACE_2));
            var medic = new Actor(new Token(Asset.FACE_1_HAPPY));
            var soldier = new Actor(new Token(Asset.FACE_1_SAD));
            var engineer = new Actor(new Token(Asset.FACE_1_HAPPY_INVERTED));
            var actors = List.of(player, medic, soldier, engineer);
            var i = 0;
            for (Actor actor : actors) {
                stage.views.add(actor.view);
                actor.view.x = ++i;
            }

            stage.play();

            stage.player.view.x = 0;
            stage.player.velocity = 2.0;

            // attack
//            stage.player.move(20);

            // move
            stage.player.move(20);

            Thread.sleep(30000);

            stage.pause();

            // do nothing
        }
    }
}