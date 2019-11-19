package com.byinal.creditLimits;

import java.io.BufferedReader;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class CsvCreditLimitRetriever implements CreditLimitRetriever {

    @Override
    public void retrieve() {
        try {
            URI uri = getClass().getClassLoader().getResource("Workbook2.csv").toURI();
            BufferedReader bufferedReader = Files.newBufferedReader(Paths.get(uri));
            List<Customer> customerListFromCsv = bufferedReader.lines()
                    .skip(1)
                    .map(this::mapToCustomer)
                    .collect(Collectors.toList());
            System.out.println(customerListFromCsv);
        } catch (URISyntaxException | IOException e) {
            e.printStackTrace();
        }
    }

    private Customer mapToCustomer(String line) {
        String[] customerInfo = line.split(",");
        return new CustomerBuilder()
                .name(customerInfo[0] + "," + customerInfo[1])
                .address(customerInfo[2])
                .postcode(customerInfo[3])
                .phoneNumber(customerInfo[4])
                .creditLimit(new Double(customerInfo[5]))
                .birthday(customerInfo[6])
                .build();
    }
}
