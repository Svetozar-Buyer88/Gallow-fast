//import java.io.BufferedReader;
//import java.io.FileReader;
//import java.io.IOException;
//import java.util.List;
//import java.util.Random;
//import java.util.stream.Collectors;
//
//public class RandomLoader {
//    private static final String FILE="C:\\Users\\Svetozar\\Desktop\\Gallows\\src\\main\\resources\\words.txt";
//  private final Random r=new Random();
//List<String> list;
//    int size;
//    public String getRandom(){
//        try(BufferedReader bufferedReader=new BufferedReader(new FileReader(FILE))) {
//            list=bufferedReader.lines().collect(Collectors.toList());
//            size= list.size();
//        }
//        catch (IOException e){
//            System.out.println("какая то ошибка при чтении файла");
//        }
//        return list.get(r.nextInt(size));
//    }
//
//
//}
