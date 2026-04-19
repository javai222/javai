package Logic;
import Contract.unaryOp;

public class UnaryOp extends unaryOp {
    
    @Override
    public double squareRoot(double a) {
        if (a < 0)
            throw new IllegalArgumentException("Cannot take square root of a negative number");
        return Math.sqrt(a);
    }

    @Override
    public double factorial(double a) {
        if (a < 0)
            throw new IllegalArgumentException("Cannot take factorial of a negative number");
        if (a != (int) a)
            throw new IllegalArgumentException("Cannot take factorial of a non-integer");
        double result = 1;
        for (int i = 1; i <= (int) a; i++) {
            result *= i;
        }
        return result;
    }

    @Override
    public double logarithm(double a) {
        if (a <= 0)
            throw new IllegalArgumentException("Cannot take logarithm of non-positive numbers");
        return Math.log(a);
    }

    @Override
    public double sine(double a) {
        return Math.sin(a);
    }

    @Override
    public double cosine(double a) {
        return Math.cos(a);
    }

    @Override
    public double tangent(double a) {
        if (Math.cos(a) == 0)
            throw new IllegalArgumentException("Tangent is undefined at this angle");
        return Math.tan(a);
    }




}
