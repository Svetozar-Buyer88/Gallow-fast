package New;

import java.util.Random;

public class NewClass {
    private String name;
    private NewClass(){
        Random random=new Random();
        name=random.ints(1,0,1234567).toString();
    }
}
