////import java.io.BufferedReader;
////import java.io.IOException;
////import java.io.InputStreamReader;
////import java.util.ArrayList;
////import java.util.List;
////import java.util.Random;
////
////public class Log {
////    private final Random random = new Random();
////    private final RandomLoader randomLoader = new RandomLoader();
////    private final String word = randomLoader.getRandom();
////    //массив символов которые будет меняться
////    private final static StringBuilder mysteryWord = new StringBuilder();
////    Counter counter = new Counter();
////
////    //лист индексов символов
////    public void init() {
////        for (int i = 0; i < word.length(); i++) {
////            mysteryWord.append('*');
////        }
////    }
////
////    public void toConsole() {
////        int first = -1, second = -1, third = -1;
////        System.out.println("вам выпало слово из " + word.length() + " букв");
////        // если слово меньше 7 букв
////        if (word.length() <= 6) {
////            first = random.nextInt(word.length());
////        }
////        //логика если слово больше 6 букв
////        if (word.length() > 6 && word.length() <= 9) {
////            first = random.nextInt(word.length());
////            do {
////                second = random.nextInt(word.length());
////            }
////            while (first == second);
////
////
////        }
////        // логика если слово больше 9 букв
////        if (word.length() > 9) {
////            first = (char) random.nextInt(word.length());
////            //
////            do {
////                second = random.nextInt(word.length());
////            }
////            while (first == second);
////            //
////            do {
////                third = random.nextInt(word.length());
////            }
////            while (third == second || third == first);
////            //
////
////
////        }
////        //замена букв
////        mysteryWord.replace(first, first + 1, String.valueOf(word.charAt(first)));
////        if (second != -1) {
////            mysteryWord.replace(second, second + 1, String.valueOf(word.charAt(second)));
////        }
////        if (third != -1) {
////            mysteryWord.replace(third, third + 1, String.valueOf(word.charAt(third)));
////        }
////        System.out.println(mysteryWord);
////    }
////
////    public void contain() {
////        char simvol;
////        List<Integer> index;
////
////        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
////
////            while ((simvol = br.readLine().charAt(0)) != ' ') {
////
////                int count = 0;
////                System.out.println("вы ввели " + simvol);
////                //проверяем есть в слове буква
////
////                if (word.contains(String.valueOf(simvol))) {
////                    index = new ArrayList<>();
////                    System.out.println("в слове есть буква " + simvol);
////
//////записываем индекс этого символа
////                    for (int i = 0; i < word.length(); i++) {
////                        if (word.charAt(i) == simvol) {
////                            index.add(i);
////                        }
////                    }
////
////                    //заменяем символ в массиве
////                    for (int i = 0; i < index.size(); i++) {
////                        mysteryWord.replace(index.get(i), index.get(i) + 1, String.valueOf(simvol));
////                    }
////
////                    // выводим закодированное слово
////                    System.out.println(mysteryWord);
////
////                    if (isDone()) {
////                        System.out.println("ПОЗДРАВЛЯЮ , ВЫ ОТГАДАЛИ О");
////                        System.exit(0);
////                    }
////                } else {
////                    System.out.println("буквы " + simvol + " нет в слове");
////                    counter.decrement();
////                    counter.print();
////                    if(counter.count==0){
////                        System.out.println("вы проебали");
////                        System.exit(228);
////                    }
////                }
////            }
////            System.out.println("вы отгадали");
////
////        } catch (IOException | StringIndexOutOfBoundsException e) {
////            System.out.println("ошибочка при записи :" + e.getMessage());
////        }
////    }
////
////
////    public static boolean isDone() {
////        if (mysteryWord.indexOf("*") == -1)
////            return true;
////        else return false;
////    }
////
////
////    public static void main(String[] args) {
////
////        Log l = new Log();
////        new Counter().print();
////        System.out.println(l.word);
////        l.init();
////        l.toConsole();
////        l.contain();
////
////
////    }
////}
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.nio.charset.StandardCharsets;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Random;
//
//public class Log {
//    private final Random random = new Random();
//    private final RandomLoader randomLoader = new RandomLoader();
//    private final String word = randomLoader.getRandom();
//    private final StringBuilder mystery = new StringBuilder();
//    private final int maxRandomReveals;
//    Counter counter=new Counter();
//    public Log() {
//        initMask();
//        this.maxRandomReveals = calculateInitialReveals();
//    }
//    // Заполняем слово звёздочками
//    private void initMask() {
//        for (int i = 0; i < word.length(); i++) {
//            mystery.append('*');
//        }
//    }
//    //вычисляем сколько букв будет известно в зависимости от длины
//    private int calculateInitialReveals() {
//        int length = word.length();
//        if (length <= 6) {
//            return 1;
//        } else if (length <= 9) {
//            return 2;
//        } else {
//            return 3;
//        }
//    }
//    // Открываем maxRandomReveals случайных уникальных позиций
//    private void revealRandomLetters() {
//        List<Integer> indices = new ArrayList<>();
//        while (indices.size() < maxRandomReveals) {
//            int idx = random.nextInt(word.length());
//            if (!indices.contains(idx)) {
//                indices.add(idx);
//                mystery.replace(idx, idx + 1, String.valueOf(word.charAt(idx)));
//            }
//        }
//        System.out.println("Слово: " + mystery);
//    }
//    //начало игры
//    public void startGame() {
//        System.out.println(counter.string6);
//        System.out.println("Слово из " + word.length() + " букв.");
//        revealRandomLetters();
//        playLoop();
//
//    }
//    //
//    private void playLoop() {
//        try (BufferedReader br = new BufferedReader(
//                new InputStreamReader(System.in, StandardCharsets.UTF_8))) {
//            while (true) {
//                if (isComplete()) {
//                    System.out.println("Поздравляю! Вы отгадали слово: " + word);
//                    break;
//                }
//                char guess = readGuess(br);
//                processGuess(guess);
//            }
//        } catch (IOException e) {
//            System.err.println("Ошибка ввода: " + e.getMessage());
//        }
//    }
//    //пустой ввод
//    private char readGuess(BufferedReader br) throws IOException {
//        System.out.print("Введите букву: ");
//        String line = br.readLine();
//        if (line == null || line.isEmpty()) {
//            throw new IOException("Пустой ввод");
//        }
//        return line.charAt(0);
//    }
//    //замена букв
//    private void processGuess(char ch) {
//        boolean found = false;
//        for (int i = 0; i < word.length(); i++) {
//            if (word.charAt(i) == ch && mystery.charAt(i) == '*') {
//                mystery.setCharAt(i, ch);
//                found = true;
//            }
//        }
//        if (found) {
//            System.out.println("Есть буква '" + ch + "'. Слово: " + mystery);
//        } else {
//            System.out.println("Нет буквы '" + ch + "'. Попробуйте ещё.");
//            counter.decrement();
//            counter.print();
//            System.out.println(mystery);
//            if(counter.count==0){
//                System.out.println("вы проиграли !");
//                System.exit(1488);
//            }
//        }
//    }
//    //флажок на собранное слово
//    private boolean isComplete() {
//        return mystery.indexOf("*") < 0;
//    }
//
//}
