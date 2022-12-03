package antivoland.console.viewport;

import antivoland.console.viewport.view.ConsoleViewport;
import antivoland.console.viewport.view.component.Health;
import antivoland.console.viewport.view.component.Monkey;
import antivoland.console.viewport.view.component.Timer;
import antivoland.console.viewport.model.Player;
import antivoland.console.viewport.story.Story;

public class Game {

    public final Story story = new Story();
    public final Player player = new Player();
    public final Monkey playerView = new Monkey();
    public final Health healthView = new Health();

    public Game() {
        healthView.set(player.health, player.maxHealth);
    }

    public static void main(String[] args) {
        var game = new Game();

        var viewport = new ConsoleViewport(System.out);

        viewport.add(new Timer());
        viewport.add(game.healthView);
        viewport.add(game.playerView);
    }
}