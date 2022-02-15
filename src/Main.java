public class Main {
    public static void main(String[] args) {
        Fraction fraction = new Fraction(10,20);
        Fraction fraction1 = new Fraction(1,3);
        Fraction fraction2 = new Fraction(2,3);
        System.out.println(fraction.add(fraction1));
        System.out.println(fraction.add(fraction, fraction1));
        System.out.println(fraction.substract(fraction1));
        System.out.println(fraction.substract(fraction, fraction1));
        System.out.println(fraction.multiply(fraction1));
        System.out.println(fraction.multiply(fraction, fraction1));
        System.out.println(fraction.divide(fraction1));
        System.out.println(fraction.divide(fraction, fraction1));
    }
}