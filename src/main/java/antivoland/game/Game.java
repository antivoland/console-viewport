package antivoland.game;

import antivoland.console.viewport.Frame;
import antivoland.console.viewport.Frames;
import antivoland.console.viewport.stage.Stage;
import antivoland.console.viewport.story.Story;
import antivoland.console.viewport.view.component.Animation;
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
            var player = new Player(new Animation(
                    new Frame(Asset.FACE_1_SAD + "", 2000),
                    new Frame(Asset.FACE_1_HAPPY + "", 500),
                    new Frame(Asset.FACE_1_HAPPY_INVERTED + "", 2000),
                    new Frame(Asset.FACE_1_HAPPY + "", 500)
            ));

            var actors = List.of(
                    player,
                    new Actor(new Token(Asset.FACE_2)),
                    new Actor(new Animation(
                            new Frame(Asset.FACE_1_HAPPY + "", 200),
                            new Frame(Asset.FACE_1_HAPPY_INVERTED + "", 200))),
                    new Actor(new Animation(
                            new Frame(Asset.FACE_1_HAPPY + "", 1000),
                            new Frame(Asset.FACE_1_SAD + "", 1000))),
                    new Actor(new Animation(Frames.parse("°º¤ø,¸¸,ø¤º°`"))),
                    new Actor(new Animation(Frames.parse("¯`·._.·`")))
            );
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

            player.view.x = 0;
            player.velocity = 2.0;
            player.move(20);

            Thread.sleep(1000);
            stage.play();
        }
    }
}