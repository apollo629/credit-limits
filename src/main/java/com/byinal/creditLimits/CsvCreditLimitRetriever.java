package com.byinal.creditLimits;

import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CsvCreditLimitRetriever implements CreditLimitRetriever {

    @Override
    public List<Customer> retrieve() {
        try {
            URI uri = getClass().getClassLoader().getResource("Workbook2.csv").toURI();
            BufferedReader bufferedReader = Files.newBufferedReader(Paths.get(uri));
            return bufferedReader.lines()
                    .skip(1)
                    .map(this::mapToCustomer)
                    .collect(Collectors.toList());
        } catch (URISyntaxException | IOException e) {
            return Collections.emptyList();
        }
    }

    @Override
    public String getName() {
        return "CSV";
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
