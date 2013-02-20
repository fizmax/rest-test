package com.test.max.validation;

public class Validator {

    public static void isLessThan(int index, int value) {
        if (index >= value) {
            throw new ValidationException(String.format("Index %d is too great", index));
        }
    }

    public static void isPositive(int index) {
        if (index < 0) {
            throw new ValidationException(String.format("Index %d must be positive", index));
        }
    }

    public static void isValid(Validatable entity) {
        if (!entity.isValid()) {
            throw new ValidationException("Not valid");
        }
    }
}
