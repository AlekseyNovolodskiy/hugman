package pet.hungman.service.programmbody;

import pet.hungman.repository.WordRepository;

import java.util.ArrayList;
import java.util.List;


public class WordBody {
    private final WordRepository wordRepository;
    private final Complexity compexity;

    public WordBody() {
        wordRepository = null;
        compexity = null;
    }


    public String word(int compl) {

        compl = compexity.getInter();
        String line = null;

        if (compl == 8) {
            line = wordRepository.getTheWords8();
        }
        if (compl == 7) {
            line = wordRepository.getTheWords7();
        }
        if (compl == 6) {
            line = wordRepository.getTheWords6();
        }
        if (compl == 5) {
            line = wordRepository.getTheWords5();
        }

        return line;
    }

    public List fillTheWord(List list, int comp) {
        for (int i = 0; i < comp; i++) {
            list.add('*');
        }
        return list;
    }

    public List masked(String symbol, String string, List list2) {
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

