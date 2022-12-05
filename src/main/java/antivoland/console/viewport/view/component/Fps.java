package antivoland.console.viewport.view.component;

import antivoland.console.viewport.tick.Tick;

import static java.lang.String.format;

public class Fps extends Component {

    private static final int MEASUREMENT_INTERVAL_MILLIS = 1000;
    private volatile int fps = 0;
    private volatile int eventsSinceLastMeasurement = 0;
    private long lastMeasurementTimestamp = System.currentTimeMillis();

    public Fps() {
        super(8);
    }

    @Override
    public synchronized String value(Tick event) {
        var dt = event.currentTimeMillis - lastMeasurementTimestamp;
        if (dt < MEASUREMENT_INTERVAL_MILLIS) {
            ++eventsSinceLastMeasurement;
        } else {
            lastMeasurementTimestamp = event.currentTimeMillis;
            fps = eventsSinceLastMeasurement * 1000 / MEASUREMENT_INTERVAL_MILLIS;
            eventsSinceLastMeasurement = 0;
        }
        return format("[%02d FPS]", fps);
    }
}