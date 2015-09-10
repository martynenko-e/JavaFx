package ua.martynenko.calculator;

public class Model {

    public double calculate(double a, double b, String operation) {

        switch (operation) {
            case "+": return  a + b;
            case "-": return  a - b;
            case "*": return  a * b;
            case "/": return  a / b;
        }
        return 0;
    }
}