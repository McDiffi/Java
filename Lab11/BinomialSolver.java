package Lab11;

public class BinomialSolver {
    double a;
    double b;
    double c;
    double X1;
    double X2;
    double delta;

    public BinomialSolver(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
        try {
            delta = Math.pow(b, 2) - 4 * a * c;
            if(delta < 0) {
                throw  new ArithmeticException("Delta smaller than 0. No zero points.");
            }
            X1 = (-b - delta)/(2*a);
            X2 = (-b + delta)/(2*a);
        } catch (Throwable e){
            System.err.println("Error occured: " + e);
        }
    }

    double getX1(){
        if(delta > 0)
            return X1;
        else return 0;
    }

    double getX2(){
        if(delta > 0)
            return X2;
        else return 0;
    }

    public double getA() {
        return a;
    }

    public double getB() {
        return b;
    }

    public double getC() {
        return c;
    }

    double calculate(double x){
        return a*x*x + b*x + c;
    }

    void print_func(){
        System.out.print(a + "x^2 ");
        if(b > 0) System.out.print("+" + b + "x ");
        else System.out.print(b + "x ");
        if(c > 0) System.out.print("+" + c + "\n");
        else System.out.print(c + "\n");
    }
}
