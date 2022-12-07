package antivoland.console.viewport.tick;

public class Tick {
    public final long previousTimestamp;
    public final long currentTimeMillis;
    public final long dt;

    Tick(long previousTimestamp, long currentTimestamp) {
        this.previousTimestamp = previousTimestamp;
        this.currentTimeMillis = currentTimestamp;
        dt = currentTimestamp - previousTimestamp;
    }

    @Override
    public String toString() {
        return "(" + previousTimestamp + ", " + currentTimeMillis + ")";
    }
}