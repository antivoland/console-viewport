package antivoland.console.viewport.view.component;

import antivoland.console.viewport.tick.Tick;
import antivoland.console.viewport.view.Viewport;
import antivoland.console.viewport.view.Snapshot;

import java.util.Map;

import static java.lang.String.format;

public class Fps extends Component {

    private static final int MEASUREMENT_INTERVAL_MILLIS = 1000;
    private volatile int fps = 0;
    private volatile int eventsSinceLastMeasurement = 0;
    private long lastMeasurementTimestamp = System.currentTimeMillis();

    public Fps(Viewport viewport) {
        super(8, viewport);
    }

    @Override
    public Map<Integer, String> values(Tick event) {
        var dt = event.currentTimeMillis - lastMeasurementTimestamp;
        if (dt < MEASUREMENT_INTERVAL_MILLIS) {
            ++eventsSinceLastMeasurement;
        } else {
            lastMeasurementTimestamp = event.currentTimeMillis;
            fps = eventsSinceLastMeasurement * 1000 / MEASUREMENT_INTERVAL_MILLIS;
            eventsSinceLastMeasurement = 0;
        }
        return Map.of(x, format("[%02d FPS]", fps));
    }

    @Override
    public synchronized Snapshot snapshot(Tick event) {
        var dt = event.currentTimeMillis - lastMeasurementTimestamp;
        if (dt < MEASUREMENT_INTERVAL_MILLIS) {
            ++eventsSinceLastMeasurement;
        } else {
            lastMeasurementTimestamp = event.currentTimeMillis;
            fps = eventsSinceLastMeasurement * 1000 / MEASUREMENT_INTERVAL_MILLIS;
            eventsSinceLastMeasurement = 0;
        }
        return new Snapshot(viewport.size).append(x, format("[%02d FPS]", fps));
    }
}