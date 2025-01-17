package org.example;
import java.util.function.Function;

public class Main {
    public static void main(  String[] args) {

        Function<Integer, Integer> add5 = (x) -> x + 5;
        // Using the higher-order function
        Function<Integer, Integer> resultFunc = applyAndMultiplyBy2(add5);

        // Apply the result function to an input
        int result = resultFunc.apply(10);  // (10 + 5) * 2 = 30
        System.out.println("Result: " + result);  // Output: Result: 30
    }
    
    // Higher-order function that accepts a function and applies it to a value, 
    // then multiplies the result by 2
    public static Function<Integer, Integer> applyAndMultiplyBy2(Function<Integer, Integer> func) {
        return (Integer x) -> {
            // Apply the passed function and multiply by 2
            return func.apply(x) * 2;
        };
    }
}