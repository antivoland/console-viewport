package antivoland.game;

import antivoland.console.viewport.stage.Stage;
import antivoland.console.viewport.story.Story;
import antivoland.console.viewport.view.component.Token;
import antivoland.game.asset.Asset;
import antivoland.game.model.Actor;
import antivoland.game.model.Door;
import antivoland.game.model.Player;

import java.util.List;

public class Game {
    public static void main(String[] args) throws Exception {
        var story = new Story();

//        System.in.read();
        try (var stage = new Stage()) {
            var captain = new Player(new Token(Asset.FACE_2));
            var medic = new Actor(new Token(Asset.FACE_1_HAPPY));
            var scientist = new Actor(new Token(Asset.FACE_1_SAD));
            var engineer = new Actor(new Token(Asset.FACE_1_HAPPY_INVERTED));
            var actors = List.of(captain, medic, scientist, engineer);
            var actorX = 0;
            for (Actor actor : actors) {
                stage.views.add(actor.view);
                actor.view.x = actorX;
                actorX += 2;
            }

            var door = new Door();
            stage.views.add(door.view);
            door.view.x = actorX + 4;

            // todo: open the door and reveal the next room

            stage.play();

            stage.player.view.x = 0;
            stage.player.velocity = 2.0;

            // attack
//            stage.player.move(20);

            // move
            stage.player.move(20);

//            Thread.sleep(30000);

//            stage.pause();

            // do nothing
        }
    }
}