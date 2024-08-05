//package pet.hungman.service;
//
//import org.springframework.stereotype.Service;
//
//import pet.hungman.service.programmbody.HungPicture;
//import pet.hungman.service.programmbody.WordBody;
//
//
//import java.awt.*;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Scanner;
//
//@Service
//public class ProgrammBody {
//    Scanner scanner = new Scanner(System.in);
//    WordBody wordBody;
//
//    HungPicture hungPicture = new HungPicture();
//
//
//    public void startProgramm() {
//        while (true) {
//            System.out.println();
//            System.out.println("Menu: (Н)овая игра, (В)ыйти ");
//            String symb = scanner.next();
//            int counter = 1;
//
//
//            if (symb.equalsIgnoreCase("н")) {
//                System.out.println("Выберите сложность");
//                System.out.println("8 букв - цифра (8)  | 7 букв - цифра (7)  |  6 букв - цифра (6)  |   5 букв - цифра (5)");
//
//                int comp = scanner.nextInt();
////                complexity.setInter(comp);
//                ArrayList<Character> list = new ArrayList();
//
//                String string = wordBody.word(comp).toLowerCase();
////                wordBody.fillTheWord(list, comp);
//
//                System.out.println("Введите снова букву");
//
//                while (true) {
//                    String symb2 = scanner.next();
//
//                    System.out.println("Введите снова букву");
//                    List list1 = new ArrayList<>(wordBody.masked(symb2, string, list));
//                    if (wordBody.testToWin(list1)) {
//                        break;
//                    }
//
//
//                    System.out.println(string);
//                    System.out.println(list1 + " list1");
//
//                    list = (ArrayList<Character>) list1;
//
//                    if (string.indexOf(symb2.charAt(0)) < 0) {
//
//                        hungPicture.risuemViselicu(counter);
//                        counter++;
//                        if (counter > 5) {
//                            System.out.println("Вы проиграли");
//                            break;
//                        }
//                    }
//
//                }
//
//
//            } else if (symb.equalsIgnoreCase("в")) {
//                System.out.println("Досвидание");
//                System.exit(0);
//            } else System.out.println("Вы ввели неправильное значение");
//
//
//        }
//    }
//
//
//}
