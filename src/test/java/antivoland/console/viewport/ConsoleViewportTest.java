package antivoland.console.viewport;

import antivoland.console.viewport.component.Component;

import static antivoland.console.viewport.ConsoleViewport.DEFAULT_SIZE;

public class ConsoleViewportTest {
    private static char EMPTY = ' ';

    public static void main(String[] args) throws Exception {
        var viewport = new ConsoleViewport(System.out);

        viewport.add(new Component.Timer());
        viewport.add(new Component.Player());

//        var x = 0;
//        viewport.message("Starting...");
//        for (int i = 0; i < 100; ++i) {
//        x += 1;
//            viewport.draw(new char[]{'@', Character.forDigit(i, 10)});
//            sleep(100);
//        }
//        System.in.read();
    }

    private static char[] draw(final char token, final int x) {

        final char[] tokens = layer(DEFAULT_SIZE);
        tokens[x] = '@';
        return tokens;
    }

    private static char[] layer(final int size) {
        final char[] tokens = new char[size];
        for (int i = 0; i < size; ++i) {
            tokens[i] = EMPTY;
        }
        return tokens;
    }
}