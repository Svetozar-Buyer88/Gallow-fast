package New;

/**
 * Отвечает за рендеринг состояния виселицы.
 */
public class HangmanRenderer {
    private static final String[] STAGES = {

            "        ___________\n"
                    + "        |/     |\n"
                    + "        |      \n"
                    + "        |       \n"
                    + "        |       \n"
                    + "        |\n"
                    + "      __|________\n"
                    + "      |         |",

            "        ___________\n"
                    + "        |/     |\n"
                    + "        |      0\n"
                    + "        |       \n"
                    + "        |       \n"
                    + "        |\n"
                    + "      __|________\n"
                    + "      |         |",

            "        ___________\n"
                    + "        |/     |\n"
                    + "        |      0\n"
                    + "        |      |\n"
                    + "        |       \n"
                    + "        |\n"
                    + "      __|________\n"
                    + "      |         |",

            "        ___________\n"
                    + "        |/     |\n"
                    + "        |      0\n"
                    + "        |     /|\n"
                    + "        |       \n"
                    + "        |\n"
                    + "      __|________\n"
                    + "      |         |",

            "        ___________\n"
                    + "        |/     |\n"
                    + "        |      0\n"
                    + "        |     /|"+"\\"+"\n"
                    + "        |       \n"
                    + "        |\n"
                    + "      __|________\n"
                    + "      |         |",

            "        ___________\n"
                    + "        |/     |\n"
                    + "        |      0\n"
                    + "        |     /|"+"\\"+"\n"
                    + "        |     /  \n"
                    + "        |\n"
                    + "      __|________\n"
                    + "      |         |",

            "        ___________\n"
                    + "        |/     |\n"
                    + "        |      X\n"
                    + "        |     /|"+"\\"+"\n"
                    + "        |     / "+"\\"+" \n"
                    + "        |\n"
                    + "      __|________\n"
                    + "      |         |"
    };

    public void render(int attemptsLeft, int maxAttempts) {
        int idx = maxAttempts - attemptsLeft;
        idx = Math.max(0, Math.min(idx, STAGES.length - 1));
        System.out.println(STAGES[idx]);
    }
}
