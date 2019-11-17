package com.byinal.creditLimits;

public class CsvCreditLimitRetriever implements CreditLimitRetriever {

    private final CsvReader csvReader;

    public CsvCreditLimitRetriever(CsvReader csvReader) {
        this.csvReader = csvReader;
    }


    @Override
    public void retrieveByName() {

    }
}
