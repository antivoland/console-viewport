package antivoland.console.viewport.story;

import java.util.List;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

public class Choices {
    final String title;
    final List<Choice> choices;

    public Choices(String title, String... choices) {
        this.title = title;
        this.choices = IntStream
                .range(0, choices.length)
                .boxed()
                .map(i -> new Choice(i + 1, choices[i]))
                .collect(toList());

    }
}