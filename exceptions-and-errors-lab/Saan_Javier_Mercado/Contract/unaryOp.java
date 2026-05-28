package Contract;

import Exception.FactorialExceptions;
import Exception.LogarithmException;
import Exception.UndefinedTangentException;

public abstract class unaryOp {

    public abstract double squareRoot(double a);

    public abstract double factorial(double a) throws FactorialExceptions;

    public abstract double logarithm(double a) throws LogarithmException;

    public abstract double sine(double a);

    public abstract double cosine(double a);

    public abstract double tangent(double a) throws UndefinedTangentException;
}
