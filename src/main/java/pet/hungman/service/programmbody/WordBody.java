package pet.hungman.service.programmbody;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pet.hungman.repository.WordRepository;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
@RequiredArgsConstructor
public class WordBody {
    private final WordRepository wordRepository;
//    private final Complexity compexity;



    public String word(int compl) {

//        compl = compexity.getInter();
//        String line = null;
//
//        if (compl == 8) {
//            line = wordRepository.getTheWords8();
//        }
//        if (compl == 7) {
//            line = wordRepository.getTheWords7();
//        }
//        if (compl == 6) {
//            line = wordRepository.getTheWords6();
//        }
//        if (compl == 5) {
//            line = wordRepository.getTheWords5();
//        }
//
//        return line;
        ArrayList<String> arrayOfWord = new ArrayList();


        String line = null;

        try {

            BufferedReader reader = null;

            if (compl == 8) {
                reader = new BufferedReader(new FileReader("src/main/java/pet/hungman/files/8lit.txt"));
                line = reader.readLine();
            } else if (compl == 7) {
                reader = new BufferedReader(new FileReader("src/main/java/pet/hungman/files/7lit.txt"));
                line = reader.readLine();
            } else if (compl == 6) {
                reader = new BufferedReader(new FileReader("src/main/java/pet/hungman/files/6lit.txt"));
                line = reader.readLine();
            } else if (compl == 5) {
                reader = new BufferedReader(new FileReader("src/main/java/pet/hungman/files/5lit.txt"));
                line = reader.readLine();
            }

            while (line != null) {
                arrayOfWord.add(line);
                line = reader.readLine();
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


        var random = new Random();
        String randomElement = arrayOfWord.get(random.nextInt(arrayOfWord.size()));
        return randomElement;
    }

    public List<Character> fillTheWord( int comp) {
        List<Character> list = new ArrayList<>(comp);
        for (int i = 0; i < comp; i++) {
            list.add('*');
        }
        return list;
    }

    public List<Character> masked(String symbol, String string, List list2) {
        List list = new ArrayList();
        for (int i = 0; i < string.length(); i++) {
            if (symbol.toLowerCase().charAt(0) == string.toLowerCase().charAt(i)) {
                list.add(symbol.toLowerCase().charAt(0));
            } else {
                list.add(list2.get(i));
            }
        }
        return list;

    }

    public boolean testToWin(List list) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).equals('*'))
                return false;
        }
        System.out.println("Ok you win");
        return true;
    }

}

