

public class Fraction {

    private int n;
    private int d;
    public class Main {
        public static void main(String[] args) {
            Fraction fraction = new Fraction(-19,20);
            Fraction fraction1 = new Fraction(1,1);
            Fraction fraction2 = new Fraction(2,12);
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
        public Fraction( int n, int d){
            if (d == 0) {
                throw new IllegalArgumentException("cannot divide by zero");
            }

            if (d < 0) {
                n *= -1;
                d *= -1;
            }

            if (n == 0) {
                this.n = n;
                this.d = 1;
            }

/**
 * finding NOD and returning divided fraction
 */
            int a = GCD(n, d);
            n = n / a;
            d = d / a;

            this.n = n;
            this.d = d;
        }

    public Fraction( int n){
            this.n = n;
            this.d = 1;
        }

    public Fraction() {
        }

        public int getNumerator () {
            return this.n;
        }

        public int getDenominator () {
            return this.d;
        }

        public int setNumerator ( int i){
            this.n = i;
            return this.n;
        }

        public int setDenominator ( int i){
            this.d = i;
            return this.d;
        }

        public String getFraction () {
            return this.n + "/" + this.d;
        }

        public static int GCD ( int a, int b){
            while (b != 0) {
                int remainder = a % b;
                a = b;
                b = remainder;
            }
            return a;
        }

        public static int LCM ( int a, int b){
            return (a / GCD(a, b)) * b;
        }

        public static String add (Fraction f, Fraction f1){
            Fraction result = new Fraction(1, 1);
            int denom = LCM(f.getDenominator(), f1.getDenominator());
            int nom = denom / f.getDenominator() * f1.getNumerator() + denom / f1.getDenominator() * f1.getNumerator();

            int k = GCD(nom, denom);
            nom = nom / k;
            denom = denom / k;
            result.setNumerator(nom);
            result.setDenominator(denom);

            return result.getFraction();
        }

        public static String substract (Fraction a, Fraction b){
            Fraction result = new Fraction(1, 1);
            int denom = LCM(a.getDenominator(), b.getDenominator());
            int nom = denom / a.getDenominator() * a.getNumerator() - denom / b.getDenominator() * b.getNumerator();

            int k = GCD(nom, denom);
            nom = nom / k;
            denom = denom / k;

            result.setNumerator(nom);
            result.setDenominator(denom);

            return result.getFraction();
        }

        public static String multiply (Fraction a, Fraction b){
            int denom = a.getDenominator() * b.getDenominator();
            int nom = a.getNumerator() * b.getNumerator();
            Fraction result = new Fraction(nom, denom);
            return result.getFraction();
        }

        public String divide (Fraction a, Fraction b){
            int nom = a.getNumerator() * b.getDenominator();
            int denom = a.getDenominator() * b.getNumerator();
            Fraction result = new Fraction(nom, denom);
            return result.getFraction();
        }

        public String add (Fraction b){
            Fraction result = new Fraction(1, 1);
            int denom = LCM(this.d, b.getDenominator());
            int nom = denom / this.d * this.n + denom / b.getDenominator() * b.getNumerator();

            int a = GCD(nom, denom);
            nom = nom / a;
            denom = denom / a;

            result.setNumerator(nom);
            result.setDenominator(denom);

            return result.getFraction();
        }

        public String substract (Fraction b){
            Fraction result = new Fraction(1, 1);
            int denom = LCM(this.d, b.getDenominator());
            int nom = denom / this.d * this.n - denom / b.getDenominator() * b.getNumerator();

            int a = GCD(nom, denom);
            nom = nom / a;
            denom = denom / a;

            result.setNumerator(nom);
            result.setDenominator(denom);

            return result.getFraction();
        }

        public String multiply (Fraction b){
            int denom = this.d * b.getDenominator();
            int nom = this.n * b.getNumerator();
            Fraction result = new Fraction(nom, denom);
            return result.getFraction();
        }

        public String divide (Fraction b){
            int nom = this.n * b.getDenominator();
            int denom = this.d * b.getNumerator();
            Fraction result = new Fraction(nom, denom);
            return result.getFraction();
        }

    }


