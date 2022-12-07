package antivoland.console.viewport.view.component;

public class Token extends Component {
    public final String value;

    public Token(String value) {
        super(value.length());
        this.value = value;
    }

    public Token(char value) {
        super(1);
        this.value = value + "";
    }

    @Override
    public String value() {
        return value;
    }
}