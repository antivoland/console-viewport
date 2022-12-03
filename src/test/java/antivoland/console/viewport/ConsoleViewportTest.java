package antivoland.console.viewport;


public class ConsoleViewportTest {
    private static char EMPTY = ' ';

    public static void main(String[] args) throws Exception {
//        var viewport = new ConsoleViewport(System.out);
//
//        viewport.add(new Timer());
//        viewport.add(new Monkey());
//        viewport.add(new Health());

//        var x = 0;
//        viewport.message("Starting...");
//        for (int i = 0; i < 100; ++i) {
//        x += 1;
//            viewport.draw(new char[]{'@', Character.forDigit(i, 10)});
//            sleep(100);
//        }
//        System.in.read();
    }

    private static char[] layer(final int size) {
        final char[] tokens = new char[size];
        for (int i = 0; i < size; ++i) {
            tokens[i] = EMPTY;
        }
        return tokens;
    }
}