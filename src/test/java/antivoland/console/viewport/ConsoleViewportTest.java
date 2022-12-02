package antivoland.console.viewport;

import static java.lang.Thread.sleep;

public class ConsoleViewportTest {
    public static void main(String[] args) throws Exception {
        final var player = "😃";
        final var viewport = new ConsoleViewport(System.out);

        System.out.println("Starting...");
        for (int i = 0; i < 10; ++i) {
            viewport.draw(player + i);
            sleep(100);
        }
    }
}