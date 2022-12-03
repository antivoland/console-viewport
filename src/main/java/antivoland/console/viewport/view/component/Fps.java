package antivoland.console.viewport.view.component;

import antivoland.console.viewport.Ticker;

import static java.lang.String.format;

public class Fps extends Component {

    private static final int MEASUREMENT_INTERVAL_MILLIS = 1000;
    private volatile int fps = 0;
    private volatile int eventsSinceLastMeasurement = 0;
    private long lastMeasurementTimestamp = System.currentTimeMillis();

    @Override
    public int size() {
        return 8;
    }

    @Override
    public synchronized String data(Ticker.Event event) {
        var dt = event.currentTimestamp - lastMeasurementTimestamp;
        if (dt < MEASUREMENT_INTERVAL_MILLIS) {
            ++eventsSinceLastMeasurement;
        } else {
            lastMeasurementTimestamp = event.currentTimestamp;
            fps = eventsSinceLastMeasurement * 1000 / MEASUREMENT_INTERVAL_MILLIS;
            eventsSinceLastMeasurement = 0;
        }
        return format("[%02d FPS]", fps);
    }
}