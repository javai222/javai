import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Java Exception and Error Demonstration ===\n");
        demonstrateCheckedException();
        System.out.println();
        demonstrateUncheckedExceptions();
        System.out.println();
        demonstrateTryCatchFinally();
        System.out.println();
        demonstrateThrowAndThrows();
        System.out.println();
        demonstrateCustomException();
        System.out.println();
        demonstrateAbstractionWithExceptions();
        System.out.println();
        demonstrateExceptionPolymorphism();
        System.out.println();
        demonstrateError();
    }

    private static void demonstrateCheckedException() {
        System.out.println("1) Checked Exception example:");
        try {
            readFileExample();
        } catch (IOException e) {
            System.out.println("Caught checked exception: " + e);
        }
    }

    private static void readFileExample() throws IOException {
        throw new IOException("Example IOException: failed to read the file.");
    }

    private static void demonstrateUncheckedExceptions() {
        System.out.println("2) Unchecked Exception examples:");

        try {
            causeNullPointerException();
        } catch (NullPointerException e) {
            System.out.println("- Caught NullPointerException: " + e.getMessage());
        }

        try {
            causeArithmeticException();
        } catch (ArithmeticException e) {
            System.out.println("- Caught ArithmeticException: " + e.getMessage());
        }

        try {
            causeArrayIndexOutOfBoundsException();
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("- Caught ArrayIndexOutOfBoundsException: " + e.getMessage());
        }
    }

    private static void demonstrateTryCatchFinally() {
        System.out.println("3) try-catch-finally example:");
        String message = null;

        try {
            message = tryCatchFinallyExample();
            System.out.println("- Try block completed: " + message);
        } catch (IllegalStateException e) {
            System.out.println("- Caught IllegalStateException: " + e.getMessage());
        } finally {
            System.out.println("- Finally block always runs, cleanup logic can go here.");
        }
    }

    private static String tryCatchFinallyExample() {
        throw new IllegalStateException("Example illegal state inside try block.");
    }

    private static void demonstrateThrowAndThrows() {
        System.out.println("4) throw and throws example:");

        try {
            validateUsername(null);
        } catch (IllegalArgumentException e) {
            System.out.println("- Caught thrown exception: " + e.getMessage());
        }
    }

    private static void validateUsername(String username) throws IllegalArgumentException {
        if (username == null || username.isBlank()) {
            throw new IllegalArgumentException("Username cannot be null or blank.");
        }
    }

    private static void demonstrateCustomException() {
        System.out.println("5) Custom exception example:");

        try {
            checkAge(15);
        } catch (InvalidAgeException e) {
            System.out.println("- Caught custom exception: " + e.getMessage());
        }
    }

    private static void checkAge(int age) throws InvalidAgeException {
        if (age < 18) {
            throw new InvalidAgeException("Age " + age + " is not allowed. Must be 18 or older.");
        }
    }

    private static void demonstrateAbstractionWithExceptions() {
        System.out.println("6) Abstraction and exception design example:");

        Validator<String> usernameValidator = new Validator<String>() {
            @Override
            public void validate(String value) throws ValidationException {
                if (value == null || value.isBlank()) {
                    throw new ValidationException("Username must not be blank.");
                }
            }
        };

        try {
            usernameValidator.validate("  ");
        } catch (ValidationException e) {
            System.out.println("- Caught validation exception from abstract contract: " + e.getMessage());
        }
    }

    private static void demonstrateExceptionPolymorphism() {
        System.out.println("7) Exception polymorphism example:");

        try {
            throwPolymorphicException();
        } catch (java.io.IOException e) {
            System.out.println("- Caught as IOException: " + e.getClass().getSimpleName() + " - " + e.getMessage());
        } catch (Exception e) {
            System.out.println("- Caught as Exception: " + e.getClass().getSimpleName() + " - " + e.getMessage());
        }
    }

    private static void throwPolymorphicException() throws Exception {
        throw new java.io.FileNotFoundException("Example FileNotFoundException handled by superclass catch.");
    }

    private static void causeNullPointerException() {
        String value = null;
        value.length();
    }

    private static void causeArithmeticException() {
        int result = 10 / 0;
        System.out.println(result);
    }

    private static void causeArrayIndexOutOfBoundsException() {
        int[] numbers = {1, 2, 3};
        int value = numbers[3];
        System.out.println(value);
    }

    private static void demonstrateError() {
        System.out.println("8) Error example:");
        try {
            causeError();
        } catch (Error e) {
            System.out.println("Caught java.lang.Error: " + e.getMessage());
        }
    }

    private static void causeError() {
        throw new Error("Example Error: this is not an Exception, but an Error.");
    }
}
