public class Fraction {
    private int n, d;
    ///////////////////Constructors
    public Fraction() {
        this.n = 0;
        this.n = 1;
    }

    public Fraction (int n, int d) {
        this.n = n;
        this.d = d;
        if (d == 0) { 
            System.out.println("ERROR, Denominator = 0!");
            d = 1;
        } else {
            this.d = d;   
        } 
    }

    public Fraction (Fraction f) {
        this.n = f.n;
        this.d = f.d;

    }

    public Fraction (String s) {
        int slashIndex = s.indexOf("/");
        String num = s.substring(0, slashIndex);
        String den = s.substring(slashIndex+1);
        this.n = Integer.parseInt(num);
        this.d = Integer.parseInt(den);       
    }
    ////////////////Accessor Methods
    public int getNum() {
        return this.n;   
    }

    public int getDenom() {
        return this.d;   
    }

    public String toString() {
        return n + "/" + d; 
    }

    public double toDouble() {
        return this.n/this.d;
    }
    //////////////////Mutator Methods
    void reduce() {
        this.n = n;
        this.d = d;

        int gcf = gcf(n, d);
        n = n/gcf;
        d = d/gcf;
    }

    void setNum(int n) {
        this.n = n;    
    }

    void setDenom(int d) {
        this.d = d;
    }
    ///////////////Static Methods
    public static Fraction multiply(Fraction a, Fraction b) {
        int num = a.n*b.n;
        int den = a.d*b.d;
        return new Fraction(num, den);
    }

    public static Fraction divide(Fraction a, Fraction b) {
        int num = a.n*b.d;
        int den = a.d*b.n;
        return new Fraction (num, den);
    }

    public static Fraction add(Fraction a, Fraction b) {
        int num = a.n*b.d + b.n*a.d;
        int den = a.d*b.d;
        return new Fraction (num, den);
    }

    public static Fraction subtract(Fraction a, Fraction b) {
        int num = a.n*b.d - b.n*a.d;
        int den = a.d*b.d;
        return new Fraction (num, den); 
    }

    private int gcf(int _a, int _b) {

        int a = _a;
        int b = _b;
        while (a != b) {
            if (a > b) {
                a=-b;   
            } else if (b > a) {
                b=-a;   
            } else {
                break;   
            }

        }
        return a;
    }

    void multiply(Fraction f) {
        this.n *= f.n;
        this.d *= f.d;
        this.reduce();
    }

}