package New;

import java.io.IOException;

/**
 * Точка входа.
 */
public class Main {
    public static void main(String[] args) {
        try {
            WordLoader loader = new WordLoader("src/main/resources/words.txt");
            String secret = loader.getRandomWord();
            HangmanGame game = new HangmanGame(secret, 6);
            game.start();
        } catch (IOException e) {
            System.err.println("Ошибка загрузки словаря: " + e.getMessage());
        }
    }
}
