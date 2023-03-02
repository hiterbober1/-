import java.util.FormatterClosedException;
import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        System.out.println("Введите математическую операцию , размер операндов которой от 1 до 10 включительно.");
        Scanner s = new Scanner(System.in);
        String input = s.nextLine();
        Main x = new Main();
        if (x.calc(input) != "error") {
            System.out.println(x.calc(input));
        }else {
            try {
                System.out.println(x.calc2(input));
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("throws Exception //т.к. в римской системе нет отрицательных чисел");
            }
        }
    }
}




class Main {
    public String calc(String i) {
        String[] spisok = i.split(" ");
        if (spisok.length < 3) {
            try {
                throw new NumberFormatException();
            } catch (NumberFormatException e) {
                return "throws Exception //т.к. строка не является математической операцией";
            }
        }
        String[] list = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};
        String [] list2 = {"I","II","III" ,"IV" ,"V", "VI","VII", "VIII", "IX", "X"};
        if (spisok.length > 3) {
            try {
                throw new FormatterClosedException();
            } catch (FormatterClosedException e) {
                return "throws Exception //т.к. формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)";
            }
        }
        int count = 0;
        int count2 = 0;
        for (int y = 0; y < list.length; y++) { //цикл для проверки арабских цифр
            if (list[y].equals(spisok[0])) {
                count += 1;
            }
            if (list[y].equals(spisok[2])) {
                count += 1;
            }
        }
        for (int u = 0; u < list2.length; u++) {  //для проверки римских
            if (list2[u].equals(spisok[0])) {
                count2 += 1;
            }
            if (list2[u].equals(spisok[2])) {
                count2 += 1;
            }
        }
        if ((count == 1) & (count2 == 1)) {
            return "throws Exception //т.к. используются одновременно разные системы счисления";
        } else if (count2 == 2) {
            return "error";
        } else if (count == 2) {
            int s0 = Integer.parseInt(spisok[0]);
            int s2 = Integer.parseInt(spisok[2]);
            switch (spisok[1]) {
                case "+":
                    return String.valueOf(s0 + s2);
                case "/":
                    return String.valueOf(s0 / s2);
                case "-":
                    return String.valueOf(s0 - s2);
                case "*":
                    return String.valueOf(s0 * s2);
            }
        } else {
            return "throws Exception //т.к. операнды не соответствуют заданному значению или введено некорректное выражение";
        }
        return "error";
    }

    public static Rimskie calc2(String k) {
        String[] spis = k.split(" ");
        if (((Rimskie.valueOf(spis[0]) instanceof Rimskie) == true) & ((Rimskie.valueOf(spis[2]) instanceof Rimskie) == true)) {
            int c0 = Rimskie.valueOf(spis[0]).ordinal();
            int c2 = Rimskie.valueOf(spis[2]).ordinal();
            switch (spis[1]) {
                case "+":
                    return Rimskie.values()[c0 + c2];
                case "/":
                    return Rimskie.values()[c0 / c2];
                case "-":
                    return Rimskie.values()[c0 - c2];
                case "*":
                    return Rimskie.values()[c0 * c2];
                default:
                    return Rimskie.values()[0];
            }
        } else {
            return Rimskie.values()[0];
        }
    }
}



