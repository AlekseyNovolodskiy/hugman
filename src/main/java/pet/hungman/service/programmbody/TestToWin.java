package pet.hungman.service.programmbody;

//import java.util.List;

import java.util.List;

public class TestToWin {
    public static boolean testToWin (List list){
        for(int i = 0; i<list.size();i++){
            if(list.get(i).equals('*')) {
                return false;
            }
        }
        System.out.println("Ok you win");
        return true;
    }
}
