package antivoland.console.viewport;

import antivoland.console.viewport.view.component.Health;
import antivoland.console.viewport.view.component.Monkey;
import antivoland.game.model.Player;
import antivoland.console.viewport.story.Story;

public class Game {

    public final Story story = new Story();
    public final Player player = new Player();
    public final Monkey playerView;
    public final Health healthView;

    public Game() {
        playerView = new Monkey();
        healthView = new Health();
        healthView.set(player.health, player.maxHealth);
    }

    public static void main(String[] args) {

        var world = new World();
//        var viewport = new ConsoleViewport(System.out);
//        var game = new Game(viewport);
//
//        viewport.add(new Timer(viewport));
//        viewport.add(new Fps(viewport));
//        viewport.add(game.healthView);
//        viewport.add(game.playerView);
    }
}