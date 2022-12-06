package antivoland.game.model;

import antivoland.console.viewport.view.component.Animation;
import antivoland.console.viewport.view.component.Component;

public class Door {
    public volatile Component view = new Animation("▂", "▃", "▅", "▇", "█", "▇", "▅", "▃");
    public volatile boolean opened = false;

    public void open() {
        // todo: open
        opened = true;
        // todo: generate new room
        var room = Room.newRoom();
    }
}