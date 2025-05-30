package New;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Отвечает за загрузку слов из файла.
 */
public class WordLoader {
    private final String filePath;

    public WordLoader(String filePath) {
        this.filePath = Objects.requireNonNull(filePath);
    }

    public String getRandomWord() throws IOException {
        List<String> words;
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            words = reader.lines()
                    .map(String::trim)
                    .filter(s -> !s.isEmpty())
                    .collect(Collectors.toList());
        }
        if (words.isEmpty()) {
            throw new IllegalStateException("Словарь пуст: " + filePath);
        }
        return words.get(new Random().nextInt(words.size()));
    }
}

