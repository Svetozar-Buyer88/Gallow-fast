package New;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.HashSet;
import java.util.Objects;
import java.util.Random;
import java.util.Set;

/**
 * Основная логика игры "Виселица".
 */
public class HangmanGame {
    private final String secretWord;
    private final StringBuilder mask;
    private final int maxAttempts;
    private int attemptsLeft;
    private final HangmanRenderer renderer;
    private final BufferedReader consoleReader;
    private final int initialReveals;

    public HangmanGame(String word, int maxAttempts) {
        this.secretWord = Objects.requireNonNull(word);
        this.maxAttempts = this.attemptsLeft = maxAttempts;
        this.renderer = new HangmanRenderer();
        this.mask = new StringBuilder("*".repeat(word.length()));
        this.consoleReader = new BufferedReader(
                new InputStreamReader(System.in, StandardCharsets.UTF_8)
        );
        this.initialReveals = calculateInitialReveals(word.length());
    }

    private int calculateInitialReveals(int length) {
        if (length <= 6) return 1;
        if (length <= 9) return 2;
        return 3;
    }

    private void revealInitial() {
        Set<Integer> revealed = new HashSet<>();
        Random rnd = new Random();
        while (revealed.size() < initialReveals) {
            int idx = rnd.nextInt(secretWord.length());
            if (revealed.add(idx)) {
                mask.setCharAt(idx, secretWord.charAt(idx));
            }
        }
        System.out.println("Начальная маска: " + mask);
    }

    public void start() {
        System.out.println("Начинаем игру. Слово длины " + secretWord.length());
        revealInitial();
        try {
            while (attemptsLeft > 0 && mask.indexOf("*") >= 0) {
                renderer.render(attemptsLeft, maxAttempts);
                System.out.println("Текущее: " + mask);
                char guess = readGuess();
                if (!processGuess(guess)) {
                    attemptsLeft--;
                }
            }
            renderer.render(attemptsLeft, maxAttempts);
            if (mask.indexOf("*") < 0) {
                System.out.println("Поздравляем, вы выиграли! Слово: " + secretWord);
            } else {
                System.out.println("Игра окончена. Было слово: " + secretWord);
            }
        } catch (IOException e) {
            System.err.println("Ошибка ввода: " + e.getMessage());
        }
    }

    private char readGuess() throws IOException {
        System.out.print("Введите букву: ");
        String line = consoleReader.readLine();
        if (line == null || line.isEmpty()) {
            return readGuess();
        }
        return line.charAt(0);
    }

    private boolean processGuess(char ch) {
        boolean found = false;
        for (int i = 0; i < secretWord.length(); i++) {
            if (secretWord.charAt(i) == ch && mask.charAt(i) == '*') {
                mask.setCharAt(i, ch);
                found = true;
            }
        }
        System.out.println(found
                ? "Угадано: " + ch
                : "Не угадано: " + ch + ". Оставшиеся попытки: " + (attemptsLeft - 1)
        );
        return found;
    }
}
