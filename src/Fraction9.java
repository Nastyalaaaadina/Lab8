import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

 class Fraction9 {private int n;
    private int d;

    public Fraction9(int n, int d) {
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

        int a = GCD(n, d);
        n = n/a;
        d = d/a;

        this.n = n;
        this.d = d;
    }

    public Fraction9(int n) {
        this.n = n;
        this.d = 1;
    }

    public Fraction9 () {
    }

    public int getNumerator() {
        return this.n;
    }

    public int getDenominator() {
        return this.d;
    }

    public int setNumerator(int i) {
        this.n = i;
        return this.n;
    }

    public int setDenominator(int i) {
        this.d = i;
        return this.d;
    }

    public String getFraction() {
        return this.n + "/" + this.d;
    }

    public static int GCD(int a, int b) {
        while (b != 0) {
            int remainder = a % b;
            a = b;
            b = remainder;
        }
        return a;
    }

    public static int LCM(int a, int b) {
        return (a / GCD(a, b)) * b;
    }

    public static String add(Fraction f, Fraction f1) {
        Fraction result = new Fraction(1, 1);
        int denom = LCM(f.getDenominator(), f1.getDenominator());
        int nom = denom/f.getDenominator() * f1.getNumerator() + denom/f1.getDenominator() * f1.getNumerator();

        int k = GCD(nom, denom);
        nom = nom/k;
        denom = denom/k;
        result.setNumerator(nom);
        result.setDenominator(denom);

        return result.getFraction();
    }

    public static String substract(Fraction a, Fraction b) {
        Fraction result = new Fraction(1, 1);
        int denom = LCM(a.getDenominator(), b.getDenominator());
        int nom = denom/a.getDenominator() * a.getNumerator() - denom/b.getDenominator() * b.getNumerator();

        int k = GCD(nom, denom);
        nom = nom/k;
        denom = denom/k;

        result.setNumerator(nom);
        result.setDenominator(denom);

        return result.getFraction();
    }

    public static String multiply(Fraction a, Fraction b) {
        int denom = a.getDenominator() * b.getDenominator();
        int nom = a.getNumerator() * b.getNumerator();
        Fraction result = new Fraction(nom, denom);
        return result.getFraction();
    }

    public String divide(Fraction a, Fraction b) {
        int nom = a.getNumerator() * b.getDenominator();
        int denom = a.getDenominator() * b.getNumerator();
        Fraction result = new Fraction(nom, denom);
        return result.getFraction();
    }

    public String add(Fraction b) {
        Fraction result = new Fraction(1, 1);
        int denom = LCM(this.d, b.getDenominator());
        int nom = denom/this.d * this.n + denom/b.getDenominator() * b.getNumerator();

        int a = GCD(nom, denom);
        nom = nom/a;
        denom = denom/a;

        result.setNumerator(nom);
        result.setDenominator(denom);

        return result.getFraction();
    }

    public String substract(Fraction b) {
        Fraction result = new Fraction(1, 1);
        int denom = LCM(this.d, b.getDenominator());
        int nom = denom/this.d * this.n - denom/b.getDenominator() * b.getNumerator();

        int a = GCD(nom, denom);
        nom = nom/a;
        denom = denom/a;

        result.setNumerator(nom);
        result.setDenominator(denom);

        return result.getFraction();
    }

    public String multiply(Fraction b) {
        int denom = this.d * b.getDenominator();
        int nom = this.n * b.getNumerator();
        Fraction result = new Fraction(nom, denom);
        return result.getFraction();
    }

    public String divide(Fraction b) {
        int nom = this.n * b.getDenominator();
        int denom = this.d * b.getNumerator();
        Fraction result = new Fraction(nom, denom);
        return result.getFraction();
    }
}


class Main9 {
    public static Fraction convertToFraction(String s){
        String [] parts = new String[2];
        parts = s.split("\\/");
        Fraction toRet;
        try{
            toRet = new Fraction(Integer.parseInt(parts[0]), Integer.parseInt(parts[1]));
        }
        catch (Exception e){
            throw new IllegalArgumentException("Ошибка. Повторите ввод");
        }
        return toRet;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        while (!s.equals("quit")){
            //code
            List<String> stack = new ArrayList<String>();
            List<String> outQueue = new ArrayList<String>();
            int indexLastSpace = 0;
            boolean isFraction = false;
            for(int i = 0; i < s.length(); i++){
                if(i == s.length()-1){
                    if(isFraction)
                        outQueue.add(s.substring(indexLastSpace, s.length()));
                    else
                        throw new IllegalArgumentException("Ошибка. Повторите ввод");
                }
                if(s.charAt(i) == '/')
                    isFraction = true;

                if(s.charAt(i) == ' ') {
                    if (isFraction) {
                        outQueue.add(s.substring(indexLastSpace, i));
                    }
                    indexLastSpace = i+1;
                    isFraction = false;
                }

                if(s.charAt(i) == '*'){
                    if(stack.size() != 0)
                        while(stack.get(stack.size()-1).equals("*") || stack.get(stack.size()-1).equals(":")){
                            outQueue.add(stack.get(stack.size()-1));
                            stack.remove(stack.size()-1);
                            if(stack.size() == 0)
                                break;
                        }
                    stack.add("*");
                }

                if(s.charAt(i) == ':'){
                    if(stack.size() != 0)
                        while(stack.get(stack.size()-1).equals("*") || stack.get(stack.size()-1).equals(":")){
                            outQueue.add(stack.get(stack.size()-1));
                            stack.remove(stack.size()-1);
                            if(stack.size() == 0)
                                break;
                        }
                    stack.add(":");
                }

                if(s.charAt(i) == '+'){
                    if(stack.size() != 0)
                        while(stack.get(stack.size()-1).equals("*") || stack.get(stack.size()-1).equals(":") || stack.get(stack.size()-1).equals("+") || stack.get(stack.size()-1).equals("-")){
                            outQueue.add(stack.get(stack.size()-1));
                            stack.remove(stack.size()-1);
                            if(stack.size() == 0)
                                break;
                        }
                    stack.add("+");
                }

                if(s.charAt(i) == '-'){
                    if(i != 0 && s.charAt(i-1) == ' ' && i != s.length()-1 && s.charAt(i+1) == ' ') {
                        if (stack.size() != 0)
                            while (stack.get(stack.size()-1).equals("*") || stack.get(stack.size()-1).equals(":") || stack.get(stack.size()-1).equals("+") || stack.get(stack.size()-1).equals("-")) {
                                outQueue.add(stack.get(stack.size() - 1));
                                stack.remove(stack.size() - 1);
                                if(stack.size() == 0)
                                    break;
                            }
                        stack.add("-");
                    }
                }
            }
            while(stack.size() != 0){
                outQueue.add(stack.get(stack.size()-1));
                stack.remove(stack.size()-1);
            }
            int i = 0;
            while(i < outQueue.size()){
                if(outQueue.get(i).equals("+")){
                    Fraction fr1 = convertToFraction(outQueue.get(i-1));
                    Fraction fr2 = convertToFraction(outQueue.get(i-2));
                    outQueue.set(i-1, fr2.add(fr1));
                    outQueue.remove(i);
                    outQueue.remove(i-2);
                    i -= 2;
                }
                else if(outQueue.get(i).equals("-")){
                    Fraction fr1 = convertToFraction(outQueue.get(i-1));
                    Fraction fr2 = convertToFraction(outQueue.get(i-2));
                    outQueue.set(i-1, fr2.substract(fr1));
                    outQueue.remove(i);
                    outQueue.remove(i-2);
                    i -= 2;
                }
                else if(outQueue.get(i).equals("*")){
                    Fraction fr1 = convertToFraction(outQueue.get(i-1));
                    Fraction fr2 = convertToFraction(outQueue.get(i-2));
                    outQueue.set(i-1, fr2.multiply(fr1));
                    outQueue.remove(i);
                    outQueue.remove(i-2);
                    i -= 2;
                }
                else if(outQueue.get(i).equals(":")){
                    Fraction fr1 = convertToFraction(outQueue.get(i-1));
                    Fraction fr2 = convertToFraction(outQueue.get(i-2));
                    outQueue.set(i-1, fr2.divide(fr1));
                    outQueue.remove(i);
                    outQueue.remove(i-2);
                    i -= 2;
                }
                else i++;
            }
            System.out.println(outQueue.get(0));
            s = sc.nextLine();
        }
    }
}

