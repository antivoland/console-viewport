package antivoland.console.viewport.view.component;

import antivoland.console.viewport.view.Viewport;

public class Root extends Panel {
    public Root(Viewport viewport) {
        super(viewport.size, viewport ,Align.LEFT);
    }
}