package antivoland.game;

import antivoland.console.viewport.Frame;
import antivoland.console.viewport.stage.Stage;
import antivoland.console.viewport.view.component.Animation;
import antivoland.game.asset.Asset;
import antivoland.game.model.Actor;

public class Dialog {
    public static void main(String[] args) {
        try (var stage = new Stage("dialog")) {
            var actor = new Actor(new Animation(
                    new Frame(Asset.FACE_1_HAPPY + "", 2000),
                    new Frame(Asset.FACE_1_HAPPY_INVERTED + "", 2000)
            ));

            stage.views.add(actor.view);
            actor.view.x = 0;

            stage.play();
        }
    }
}