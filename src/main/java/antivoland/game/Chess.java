package antivoland.game;

import antivoland.console.viewport.stage.Stage;
import antivoland.console.viewport.view.component.Token;

import java.util.List;

public class Chess {
    public static void main(String[] args) {
        System.out.println("12345678");
        try (var stage = new Stage("chess")) {
            var white = List.of(
                    new Token("♔"),
                    new Token("♙")
            );
            var black = List.of(
                    new Token("♝"),
                    new Token("♚")
            );
            for (int i = 0; i < white.size(); ++i) {
                var view = white.get(i);
                stage.views.add(view);
                view.x = i;
            }
            for (int i = 0; i < black.size(); ++i) {
                var view = black.get(i);
                stage.views.add(view);
                view.x = 8 - i - 1;
            }
            stage.play();
        }
    }
}