package com.test.max.factor;

import au.com.bytecode.opencsv.CSVReader;
import au.com.bytecode.opencsv.CSVWriter;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import static com.test.max.validation.Validator.isLessThan;

public class Storage {

    final private String FACTORS_FILE_PATH;
    final private String RESULTS_FILE_PATH;

    public Storage(String factorsFilePath, String resultsFilePath) {
        this.FACTORS_FILE_PATH = factorsFilePath;
        this.RESULTS_FILE_PATH = resultsFilePath;
    }

    public String[] readFactors() throws IOException {
        try (CSVReader reader = new CSVReader(new FileReader(FACTORS_FILE_PATH))) {
            return reader.readNext();
        }
    }

    synchronized public void writeResult(int index, Object result) throws IOException {
        String[] results;
        try (CSVReader reader = new CSVReader(new FileReader(RESULTS_FILE_PATH))) {
            results = reader.readNext();
        }
        isLessThan(index, results.length);
        results[index] = result.toString();
        try (CSVWriter writer = new CSVWriter(new FileWriter(RESULTS_FILE_PATH))) {
            writer.writeNext(results);
        }
    }
}
