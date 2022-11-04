import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) throws IOException {

            Scanner scanner = new Scanner(System.in);

                String equ = new String();


            do {
                System.out.println("**************************************************************");
                System.out.print("Введите ваше выражение с целыми числами от 1 до 10 в арабской или римской системе счисления \n и одно из арифметических действий +, -, *, /: ");
                equ = scanner.nextLine();

System.out.println();
                calc(equ); // передача значения переменной equ во второй метод calc
System.out.println();
                System.out.println("Для выхода из программы введите \"Выход\"");
                System.out.println();
            } while (!equ.equals("Выход"));

       /*if (equ.contains(" + "))
        {
            String [] str = new String[3];
            str = equ.split(" ");
            System.out.println(Arrays.toString(str));
            Roman x = Roman.valueOf(str[0]); // заносим римскую цифру из массива типа String в значение x
            int number1 = x.getArabic(); // переводим римские в арабские
            Roman y = Roman.valueOf(str[2]); // заносим римскую цифру из массива типа String в значение y
            int number2 = y.getArabic();
            System.out.println(calcSum(number1, number2));
        }*/

        /*
       if (equ.line.contains(" + ")) { // такая очерёдность обусловлена тем, что происходит запись сначала большего кол-ва
                                        // символов в массив, при обратном порядке получим ошибку отсутствия третьего элемента
            str = equ.line.split(" ");
            equ.number1 = Integer.parseInt(str[0]); // переводим переменную типа String в Int
            equ.number2 = Integer.parseInt(str[2]); // переводим вторую переменную типа String в Int
            System.out.println("Сумма составит: " + equ.calcSum());
        } else if (equ.line.contains("+")) {
            str = equ.line.split("\\+");
            equ.number1 = Integer.parseInt(str[0]); // переводим переменную типа String в Int
            equ.number2 = Integer.parseInt(str[1]); // переводим вторую переменную типа String в Int
            System.out.println("Сумма составит: " + equ.calcSum());
        }

*/
    }
   public static void calc(String equ) throws IOException, IllegalArgumentException, NumberFormatException {
       String[] str = new String[2]; // создаём массив типа String на 3 символа для арабских
       String[] strR = new String[3];
       int number1;
       int number2;
       int number3;
       int number4;
       String R;


       //System.out.println(Arrays.toString(str)); // проверка чем заполнен наш массив типа String
       // System.out.println(str.length); // проверка длины массива типа String
       //
       //               Часть кода для арабских цифр
       //

       str = equ.split(" ");
       if (str.length==1) {
           System.out.println("Введи выражение!");
           throw new IOException();
       }

       if ((equ.contains("+")||equ.contains(" + ")) && !equ.contains("I") && !equ.contains("V") && !equ.contains("X")) {
           str = equ.split(" \\+ "); // делим строку символом + и записываем в массив
           //System.out.println(Arrays.toString(str)); // проверка записи в массив
           if (str.length<2)
           {
               System.out.println("Неверный формат ввода, попробуй a + b!");
               throw new NumberFormatException();
           } else if (str.length>2)
           {
               System.out.println("Неверный формат ввода, попробуй a + b!");
               throw new NumberFormatException();
           }
           number1 = Integer.parseInt(str[0]); // переводим переменную типа String в Int
           number2 = Integer.parseInt(str[1]); // переводим вторую переменную типа String в Int
           System.out.println("Сумма составит: " + calcSum(number1, number2));
       } else if ((equ.contains("-")||equ.contains(" - ")) && !equ.contains("I") && !equ.contains("V") && !equ.contains("X")) {
           str = equ.split(" - ");
           if (str.length<2)
           {
               System.out.println("Неверный формат ввода, попробуй a - b!");
               throw new NumberFormatException();
           } else if (str.length>2)
           {
               System.out.println("Неверный формат ввода, попробуй a - b!");
               throw new NumberFormatException();
           }
           number1 = Integer.parseInt(str[0]); // переводим переменную типа String в Int
           number2 = Integer.parseInt(str[1]); // переводим вторую переменную типа String в Int
           System.out.println("Разность составит: " + calcSub(number1, number2));
       } else if ((equ.contains("*")||equ.contains(" * ")) && !equ.contains("I") && !equ.contains("V") && !equ.contains("X")) {
           str = equ.split(" \\* ");
           if (str.length<2)
           {
               System.out.println("Неверный формат ввода, попробуй a * b!");
               throw new NumberFormatException();
           } else if (str.length>2)
           {
               System.out.println("Неверный формат ввода, попробуй a * b!");
               throw new NumberFormatException();
           }
           number1 = Integer.parseInt(str[0]); // переводим переменную типа String в Int
           number2 = Integer.parseInt(str[1]); // переводим вторую переменную типа String в Int
           System.out.println("Произведение составит: " + calcMult(number1, number2));
       } else if ((equ.contains("/")||equ.contains(" / ")) && !equ.contains("I") && !equ.contains("V") && !equ.contains("X")) {
           str = equ.split(" / ");
           if (str.length<2)
           {
               System.out.println("Неверный формат ввода, попробуй a / b!");
               throw new NumberFormatException();
           } else if (str.length>2)
           {
               System.out.println("Неверный формат ввода, попробуй a / b!");
               throw new NumberFormatException();
           }
           number1 = Integer.parseInt(str[0]); // переводим переменную типа String в Int
           number2 = Integer.parseInt(str[1]); // переводим вторую переменную типа String в Int
           System.out.println("Частное составит: " + calcDiv(number1, number2));
       }





       //
       //           Часть кода для римских цифр
       //

      if ((equ.contains("+")||equ.contains(" + "))&&(equ.contains("I")||equ.contains("V")||equ.contains("X")))
       {
           strR = equ.split(" \\+ ");
           if (strR.length<2)
           {
               System.out.println("Неверный формат ввода, попробуй a + b!");
               throw new NumberFormatException();
           } else if (strR.length>2)
           {
               System.out.println("Неверный формат ввода, попробуй a + b!");
               throw new NumberFormatException();
           }
           Roman x = Roman.valueOf(strR[0]);
           Roman y = Roman.valueOf(strR[1]);
           number3 = x.getArabic();
           number4 = y.getArabic();
           int x1 = calcSumR(number3, number4);
           System.out.println("Сумма составит: "+convert2ar(x1));
       } else if ((equ.contains("-")||equ.contains(" - "))&&(equ.contains("I")||equ.contains("V")||equ.contains("X"))) {
          strR = equ.split(" - ");
          if (strR.length<2)
          {
              System.out.println("Неверный формат ввода, попробуй a - b!");
              throw new NumberFormatException();
          } else if (strR.length>2)
          {
              System.out.println("Неверный формат ввода, попробуй a - b!");
              throw new NumberFormatException();
          }
          Roman x = Roman.valueOf(strR[0]);
          Roman y = Roman.valueOf(strR[1]);
          number3 = x.getArabic();
          number4 = y.getArabic();
          int x1 = calcSubR(number3, number4);
          System.out.println("Разность составит: "+convert2ar(x1));
       }  else if ((equ.contains("*")||equ.contains(" * "))&&(equ.contains("I")||equ.contains("V")||equ.contains("X"))) {
          strR = equ.split(" \\* ");
          if (strR.length<2)
          {
              System.out.println("Неверный формат ввода, попробуй a * b!");
              throw new NumberFormatException();
          } else if (strR.length>2)
          {
              System.out.println("Неверный формат ввода, попробуй a * b!");
              throw new NumberFormatException();
          }
          Roman x = Roman.valueOf(strR[0]);
          Roman y = Roman.valueOf(strR[1]);
          number3 = x.getArabic();
          number4 = y.getArabic();
          int x1 = calcMultR(number3, number4);
          System.out.println("Произведение составит: "+convert2ar(x1));
      } else if ((equ.contains("/")||equ.contains(" / "))&&(equ.contains("I")||equ.contains("V")||equ.contains("X"))) {
          strR = equ.split(" / ");
          if (strR.length<2)
          {
              System.out.println("Неверный формат ввода, попробуй a / b!");
              throw new NumberFormatException();
          } else if (strR.length>2)
          {
              System.out.println("Неверный формат ввода, попробуй a / b!");
              throw new NumberFormatException();
          }
          Roman x = Roman.valueOf(strR[0]);
          Roman y = Roman.valueOf(strR[1]);
          number3 = x.getArabic();
          number4 = y.getArabic();
          int x1 = calcDivR(number3, number4);
          System.out.println("Частное составит: "+convert2ar(x1));
       }



   }



    public static int calcSum(int number1, int number2) throws IOException {
        if (number1 > 10 || number2 > 10)
        {
            System.out.println("Число больше 10!");
            throw new IOException(); // проверка диапазона чисел
        } else if (number1 <= 10 || number2 <=10) {
            int sum = number1 + number2;
            return sum;
        }
        return 0;
    }

    public static int calcSub(int number1, int number2) throws IOException {
       if (number1 > 10 || number2 > 10)
       {
           System.out.println("Число больше 10!");
           throw new IOException();
       } else if (number1 <= 10 || number2 <=10) {
           int sub = number1 - number2;
           return sub;
       }
       return 0;
    }
        public static int calcDiv(int number1, int number2) throws IOException {
            if (number1 > 10 || number2 > 10)
            {
                System.out.println("Число больше 10!");
                throw new IOException();
            } else if (number1 <= 10 || number2 <=10) {
                int div = number1 / number2;
                return div;
            }
            return  0;
    }
    public static int calcMult(int number1, int number2) throws IOException {
        if (number1 > 10 || number2 > 10)
        {
            System.out.println("Число больше 10!");
            throw new IOException();
        } else if (number1 <= 10 || number2 <=10) {
            int mult = number1 * number2;
            return mult;
        }
        return 0;
    }
    public  static int calcSumR (int number3, int number4)
    {
        int sumR = number3+number4;
        return sumR;
    }
    public  static int calcSubR (int number3, int number4) throws IOException
    {

        int subR = number3-number4;
        if (subR <= 0){
            System.out.println("Число меньше 0 или результат равен 0!");
            throw new IOException();
        }
        return subR;
    }
    public  static int calcDivR (int number3, int number4) throws IOException
    {
        int divR = number3/number4;
        if (divR <= 0){
            System.out.println("Число меньше 0 или результат равен 0!");
            throw new IOException();
        }
        return divR;
    }
    public  static int calcMultR (int number3, int number4) throws IOException
    {
        int multR = number3*number4;
        if (multR <= 0){
            System.out.println("Число меньше 0 или результат равен 0!");
            throw new IOException();
        }
        return multR;
    }
public static String convert2ar(int x1)
{
    if (x1 == 1) return "I";
    if (x1 == 2) return "II";
    if (x1 == 3) return "III";
    if (x1 == 4) return "IV";
    if (x1 == 5) return "V";
    if (x1 == 6) return "VI";
    if (x1 == 7) return "VII";
    if (x1 == 8) return "VIII";
    if (x1 == 9) return "IX";
    if (x1 == 10) return "X";
    if (x1 == 11) return "XI";
    if (x1 == 12) return "XII";
    if (x1 == 13) return "XIII";
    if (x1 == 14) return "XIV";
    if (x1 == 15) return "XV";
    if (x1 == 16) return "XVI";
    if (x1 == 17) return "XVII";
    if (x1 == 18) return "XVIII";
    if (x1 == 19) return "XIX";
    if (x1 == 20) return "XX";
    if (x1 == 21) return "XXI";
    if (x1 == 22) return "XXII";
    if (x1 == 23) return "XXIII";
    if (x1 == 24) return "XXIV";
    if (x1 == 25) return "XXV";
    if (x1 == 26) return "XXVI";
    if (x1 == 27) return "XXVII";
    if (x1 == 28) return "XVIII";
    if (x1 == 29) return "XXIX";
    if (x1 == 30) return "XXX";
    if (x1 == 31) return "XXXI";
    if (x1 == 32) return "XXXII";
    if (x1 == 33) return "XXXIII";
    if (x1 == 34) return "XXXIV";
    if (x1 == 35) return "XXXV";
    if (x1 == 36) return "XXXVI";
    if (x1 == 37) return "XXXVII";
    if (x1 == 38) return "XXXVIII";
    if (x1 == 39) return "XXXIX";
    if (x1 == 40) return "XL";
    if (x1 == 41) return "XLI";
    if (x1 == 42) return "XLII";
    if (x1 == 43) return "XLIII";
    if (x1 == 44) return "XLIV";
    if (x1 == 45) return "XLV";
    if (x1 == 46) return "XLVI";
    if (x1 == 47) return "XLVII";
    if (x1 == 48) return "XLVIII";
    if (x1 == 49) return "XLIX";
    if (x1 == 50) return "L";
    if (x1 == 51) return "LI";
    if (x1 == 52) return "LII";
    if (x1 == 53) return "LIII";
    if (x1 == 54) return "LIV";
    if (x1 == 55) return "LV";
    if (x1 == 56) return "LVI";
    if (x1 == 57) return "LVII";
    if (x1 == 58) return "LVIII";
    if (x1 == 59) return "LIX";
    if (x1 == 60) return "LX";
    if (x1 == 61) return "LXI";
    if (x1 == 62) return "LXII";
    if (x1 == 63) return "LXIII";
    if (x1 == 64) return "LXIV";
    if (x1 == 65) return "LXV";
    if (x1 == 66) return "LXVI";
    if (x1 == 67) return "LXVII";
    if (x1 == 68) return "LXVIII";
    if (x1 == 69) return "LXIX";
    if (x1 == 70) return "LXX";
    if (x1 == 71) return "LXXI";
    if (x1 == 72) return "LXXII";
    if (x1 == 73) return "LXXIII";
    if (x1 == 74) return "LXXIV";
    if (x1 == 75) return "LXXV";
    if (x1 == 76) return "LXXVI";
    if (x1 == 77) return "LXXVII";
    if (x1 == 78) return "LXXVIII";
    if (x1 == 79) return "LXXIX";
    if (x1 == 80) return "LXXX";
    if (x1 == 81) return "LXXXI";
    if (x1 == 82) return "LXXXII";
    if (x1 == 83) return "LXXXIII";
    if (x1 == 84) return "LXXXIV";
    if (x1 == 85) return "LXXXV";
    if (x1 == 86) return "LXXXVI";
    if (x1 == 87) return "LXXXVII";
    if (x1 == 88) return "LXXXVIII";
    if (x1 == 89) return "LXXXIX";
    if (x1 == 90) return "XC";
    if (x1 == 91) return "XCI";
    if (x1 == 92) return "XCII";
    if (x1 == 93) return "XCIII";
    if (x1 == 94) return "XCIV";
    if (x1 == 95) return "XCV";
    if (x1 == 96) return "XCVI";
    if (x1 == 97) return "XCVII";
    if (x1 == 98) return "XCVIII";
    if (x1 == 99) return "XCIX";
    if (x1 == 100) return "C";
return "0";
}

    }











