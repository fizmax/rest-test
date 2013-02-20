package com.test.max.factor;

import java.io.IOException;

import static com.test.max.validation.Validator.isLessThan;

public class CalculationService {

    private Storage storage;

    public CalculationService(Storage storage) {
        this.storage = storage;
    }

    /**
     * Finds factor in a storage by index and returns it's value adjusted by a defined formula.
     *
     * @param v1 factor index
     * @return adjusted factor
     * @throws IOException in case of bad things happen during storage access
     */
    public double getFactor(int v1) throws IOException {
        String[] factors = storage.readFactors();
        isLessThan(v1, factors.length);
        double factor = Double.valueOf(factors[v1]);

        return adjustFactor(factor);
    }

    private double adjustFactor(double factor) {
        return factor > 10 ? factor - 10 : factor;
    }

    /**
     * Calculates a result from a value and a factor using two-branch formula.
     * Stores the result afterwards.
     *
     * @param v2 value
     * @param v3 factor index
     * @param v4 index to store the result at
     * @return 0 if formula's condition was met, 1 if not
     * @throws IOException in case of bad things happen during storage access
     */
    public int calculateResult(double v2, int v3, int v4) throws IOException {
        String[] factors = storage.readFactors();
        isLessThan(v3, factors.length);
        double factor = Double.valueOf(factors[v3]);
        boolean meetsCondition = checkCondition(factor, v2);
        double result = meetsCondition ? calcConditionTrue(factor, v2) : calcConditionFalse(factor, v2);
        storage.writeResult(v4, result);

        return meetsCondition ? 0 : 1;
    }

    private boolean checkCondition(double factor, double v2) {
        return factor + v2 < 10;
    }

    private double calcConditionTrue(double factor, double v2) {
        return factor + v2 + 10;
    }

    private double calcConditionFalse(double factor, double v2) {
        return factor + v2;
    }
}