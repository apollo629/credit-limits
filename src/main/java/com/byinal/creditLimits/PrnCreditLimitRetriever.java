package com.byinal.creditLimits;

import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PrnCreditLimitRetriever implements CreditLimitRetriever {

    @Override
    public List<Customer> retrieve() {
        try {
            URI uri = getClass().getClassLoader().getResource("Workbook2.prn").toURI();
            BufferedReader bufferedReader = Files.newBufferedReader(Paths.get(uri), Charset.forName("ISO-8859-1"));
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
        return "PRN";
    }

    private Customer mapToCustomer(String line) {
        return new CustomerBuilder()
                .name(line.substring(0, 16).trim())
                .address(line.substring(16, 38).trim())
                .postcode(line.substring(38, 47).trim())
                .phoneNumber(line.substring(47, 61).trim())
                .creditLimit(new Double(line.substring(61, 73).trim()))
                .birthday(line.substring(73, 82).trim())
                .build();
    }
}
