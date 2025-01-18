## Java's Functional Programming Capabilities

### Do you love Python for its simplicity? If Yes, Welcome to Java. 
```java
Calculator addition = (a, b) -> a + b; addition.calculate(5,3);
```
For some of us it's hard to believe that the above code is Java Compilable. After all, it's just a single-line function to add two numbers - something which we admire in Python. Coming from an object-oriented programming background, many of us find it challenging to understand the parallel universe of Functional Programming.

Calculator here is a FunctionalInterface in Java
```java
@FunctionalInterface
interface Calculator { 
   int calculate(int a, int b);
}
```

A Functional Interface is an interface with exactly one abstract method. This simplicity makes it ideal for lambda expressions, which are essentially shorthand implementations of that method. In the example above, abstract method calculate of the Calculator interface is implemented dynamically using a lambda expression. 
(a, b) -> a + b // Lambda 

This is Java's way of mimicking first-class functions, enabling cleaner and more concise code. We've seen that Java doesn't natively support higher-order functions, but with functional interfaces like **Function<T, R>**, we can mimic them effectively. Higher-order functions are functions that accept other functions as arguments or return functions.
In the below implementation I pass a function as a parameter and return a transformed function.

**The functional world is as exciting as the object-oriented one, and declarative programming can be just as effective as imperative styles. It's all about knowing when and why to use each approach.** 

#### Keep Learning