package antivoland.console.viewport.component;

import antivoland.console.viewport.Ticker;

import static java.lang.String.format;

public class Timer extends Component {

    @Override
    public int size() {
        return 5;
    }

    @Override
    public String data(final Ticker.Event event) {
        var dt = event.currentTimestamp - createdTimestamp;
        var minutes = dt / 1000 / 60;
        var seconds = dt / 1000;
        return format("%02d:%02d", minutes, seconds);
    }
}
