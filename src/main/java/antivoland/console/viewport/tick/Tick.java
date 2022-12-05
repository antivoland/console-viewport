package antivoland.console.viewport.tick;

public class Tick {
    public final long previousTimestamp;
    public final long currentTimeMillis;

    Tick(long previousTimestamp, long currentTimestamp) {
        this.previousTimestamp = previousTimestamp;
        this.currentTimeMillis = currentTimestamp;
    }

    @Override
    public String toString() {
        return "(" + previousTimestamp + ", " + currentTimeMillis + ")";
    }
}