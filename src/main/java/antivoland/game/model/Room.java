package antivoland.game.model;

import antivoland.console.viewport.tick.Tick;
import antivoland.console.viewport.view.component.Component;

public class Room extends Component {

    static final String EMPTY = "[㋡ ]";
    static final String B = "[☺ ]";
    static final String C = "[☹ ]";
    static final String D = "[☻ ]";

    public Actor actor;
    public Component view;

    private Room(int size) {
        super(size);
    }

    public static int MIN_SIZE = 20;
    public static int MAX_SIZE = 40;


    public static Room newRoom() {
        var extra = Math.random() * (MAX_SIZE - MIN_SIZE);
        return new Room(MIN_SIZE + (int) extra);
    }
}