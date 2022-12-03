package antivoland.console.viewport.story;

public class Story {
    public Choices next() {
        return new Choices(
                "Let's do something here",
                "Attack", "Skip");
    }
}