package antivoland.console.viewport.tick;

public class Tick {
    public final long previousTimestamp;
    public final long currentTimestamp;

    Tick(long previousTimestamp, long currentTimestamp) {
        this.previousTimestamp = previousTimestamp;
        this.currentTimestamp = currentTimestamp;
    }

    @Override
    public String toString() {
        return "(" + previousTimestamp + ", " + currentTimestamp + ")";
    }
}