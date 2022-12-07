package antivoland.console.viewport;

import antivoland.console.viewport.story.Story;
import antivoland.console.viewport.view.component.Health;
import antivoland.console.viewport.view.component.Monkey;
import antivoland.console.viewport.view.component.Token;
import antivoland.game.model.Player;

public class Game {

    public final Story story = new Story();
    public final Player player = new Player(new Token("X_x"));
    public final Monkey playerView;
    public final Health healthView;

    public Game() {
        playerView = new Monkey();
        healthView = new Health();
        healthView.set(player.health, player.maxHealth);
    }

    public static void main(String[] args) {

//        var viewport = new ConsoleViewport(System.out);
//        var game = new Game(viewport);
//
//        viewport.add(new Timer(viewport));
//        viewport.add(new Fps(viewport));
//        viewport.add(game.healthView);
//        viewport.add(game.playerView);
    }
}