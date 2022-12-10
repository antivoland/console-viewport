package antivoland.game;

import antivoland.console.viewport.Frame;
import antivoland.console.viewport.Frames;
import antivoland.console.viewport.stage.Stage;
import antivoland.console.viewport.story.Story;
import antivoland.console.viewport.view.component.Animation;
import antivoland.console.viewport.view.component.Token;
import antivoland.game.asset.Asset;
import antivoland.game.model.Door;
import antivoland.game.model.Player;

import java.util.List;

public class Game {
    public static void main(String[] args) {
        var story = new Story();

        try (var stage = new Stage("game")) {
            var player = new Player(new Animation(
                    new Frame(Asset.FACE_1_SAD + "", 2000),
                    new Frame(Asset.FACE_1_HAPPY + "", 500),
                    new Frame(Asset.FACE_1_HAPPY_INVERTED + "", 2000),
                    new Frame(Asset.FACE_1_HAPPY + "", 500)
            ));

            var views = List.of(
                    player.view,
                    new Token(Asset.FACE_2),
                    new Animation(
                            new Frame(Asset.FACE_1_HAPPY + "", 200),
                            new Frame(Asset.FACE_1_HAPPY_INVERTED + "", 200)),
                    new Animation(Frames.parse("°º¤ø,¸¸,ø¤º°`")),
                    new Animation(
                            new Frame(Asset.FACE_1_HAPPY + "", 1000),
                            new Frame(Asset.FACE_1_SAD + "", 1000)),
                    new Animation(Frames.parse("¯`·._.·`")),
                    new Animation(Frames.parse("¯`·.¸¸.·´")),
                    new Animation(Frames.parse("✢✣✤✥✤✣✢✢✢✢✢✢✢")),
                    new Animation(Frames.parse("✦✧")),
                    new Animation(Frames.parse("✩✪✫")),
                    new Animation(Frames.parse("✩✪✫✬✭✮✯✰★")),
                    new Token("🐩"),
                    new Animation(1000,
                            "♔",
                            "♕",
                            "♖",
                            "♗",
                            "♘",
                            "♙",
                            "♚",
                            "♛",
                            "♜",
                            "♝",
                            "♞",
                            "♟"
                    )
            );
            var viewX = 0;
            for (var view : views) {
                stage.views.add(view);
                view.x = viewX;
                viewX += 3;
            }

            var door = new Door();
            stage.views.add(door.view);
            door.view.x = viewX + 4;

            // todo: open the door and reveal the next room

            player.view.x = 30;
            player.velocity = 2.0;
            player.move(50);

            stage.play();
        }
    }
}