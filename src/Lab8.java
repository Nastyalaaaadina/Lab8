import java.util.Scanner;
public class Lab8 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String[] fractions = new String[2];

        if (s.indexOf('+') != -1) {
            fractions = s.split("\\+");
            try {
                if (fractions[0].indexOf('/') == -1 || fractions[1].indexOf('/') == -1 || fractions[0].split("\\/").length != 2 || fractions[1].split("\\/").length != 2)
                    throw new IllegalArgumentException("Ошибка. Повторите ввод");
                Fraction fr1 = new Fraction(Integer.parseInt(fractions[0].split("\\/")[0]), Integer.parseInt(fractions[0].split("\\/")[1].replaceFirst(" ", "")));
                Fraction fr2 = new Fraction(Integer.parseInt(fractions[1].split("\\/")[0].replaceFirst(" ", "")), Integer.parseInt(fractions[1].split("\\/")[1]));
                System.out.println(fr1.add(fr2));
            } catch (Exception e) {
                throw new IllegalArgumentException("Ошибка. Повторите ввод");
            }
        } else if (s.lastIndexOf("--") != -1) {
            fractions = s.split("--");
            try {
                if (fractions[0].indexOf('/') == -1 || fractions[1].indexOf('/') == -1 || fractions[0].split("\\/").length != 2 || fractions[1].split("\\/").length != 2)
                    throw new IllegalArgumentException("Ошибка. Повторите ввод");
                Fraction fr1 = new Fraction(Integer.parseInt(fractions[0].split("\\/")[0]), Integer.parseInt(fractions[0].split("\\/")[1].replaceFirst(" ", "")));
                Fraction fr2 = new Fraction(Integer.parseInt(fractions[1].split("\\/")[0].replaceFirst(" ", "")), Integer.parseInt(fractions[1].split("\\/")[1]));
                System.out.println(fr1.substract(fr2));
            } catch (Exception e) {
                throw new IllegalArgumentException("Ошибка. Повторите ввод");
            }
        } else if (s.indexOf('*') != -1) {
            fractions = s.split("\\*");
            try {
                if (fractions[0].indexOf('/') == -1 || fractions[1].indexOf('/') == -1 || fractions[0].split("\\/").length != 2 || fractions[1].split("\\/").length != 2)
                    throw new IllegalArgumentException("Ошибка. Повторите ввод");
                Fraction fr1 = new Fraction(Integer.parseInt(fractions[0].split("\\/")[0]), Integer.parseInt(fractions[0].split("\\/")[1].replaceFirst(" ", "")));
                Fraction fr2 = new Fraction(Integer.parseInt(fractions[1].split("\\/")[0].replaceFirst(" ", "")), Integer.parseInt(fractions[1].split("\\/")[1]));
                System.out.println(fr1.multiply(fr2));
            } catch (Exception e) {
                throw new IllegalArgumentException("Ошибка. Повторите ввод");
            }
        } else if (s.indexOf(':') != -1) {
            fractions = s.split(":");
            try {
                if (fractions[0].indexOf('/') == -1 || fractions[1].indexOf('/') == -1 || fractions[0].split("\\/").length != 2 || fractions[1].split("\\/").length != 2)
                    throw new IllegalArgumentException("Ошибка. Повторите ввод");
                Fraction fr1 = new Fraction(Integer.parseInt(fractions[0].split("\\/")[0]), Integer.parseInt(fractions[0].split("\\/")[1].replaceFirst(" ", "")));
                Fraction fr2 = new Fraction(Integer.parseInt(fractions[1].split("\\/")[0].replaceFirst(" ", "")), Integer.parseInt(fractions[1].split("\\/")[1]));
                System.out.println(fr1.divide(fr2));
            } catch (Exception e) {
                throw new IllegalArgumentException("Ошибка. Повторите ввод");
            }
        } else if (s.indexOf('/') != -1) {
            fractions = s.split("\\/");
            try {
                if (fractions.length != 4)
                    throw new IllegalArgumentException("Ошибка. Повторите ввод");
                Fraction fr1 = new Fraction(Integer.parseInt(fractions[0]), Integer.parseInt(fractions[1].replaceFirst(" ", "")));
                Fraction fr2 = new Fraction(Integer.parseInt(fractions[2].replaceFirst(" ", "")), Integer.parseInt(fractions[3]));
                System.out.println(fr1.divide(fr2));
            } catch (Exception e) {
                throw new IllegalArgumentException("Ошибка. Повторите ввод");
            }
        } else {
            throw new IllegalArgumentException("Ошибка. Повторите ввод");
        }
    }
}