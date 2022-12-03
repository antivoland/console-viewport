package antivoland.console.viewport.story;

import static java.lang.String.format;

public class Choice {
    public final int no;
    public final String description;

    public Choice(int no, String description) {
        this.no = no;
        this.description = description;
    }

    public String data() {
        return format("[%s] %s", no, description);
    }
}