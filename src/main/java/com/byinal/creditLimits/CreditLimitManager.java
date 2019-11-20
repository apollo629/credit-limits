package com.byinal.creditLimits;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class CreditLimitManager {

    private final CreditLimitRetrieverRegistry creditLimitRetrieverRegistry;

    public CreditLimitManager(CreditLimitRetrieverRegistry creditLimitRetrieverRegistry) {
        this.creditLimitRetrieverRegistry = creditLimitRetrieverRegistry;
    }

    public Map<String, List<Customer>> retrieveAllCreditLimits() {
        Map<String, List<Customer>> customerMapList = creditLimitRetrieverRegistry.retrieveAllCreditLimitRetrievers()
                .stream()
                .collect(Collectors.toMap(CreditLimitRetriever::getName, CreditLimitRetriever::retrieve));
        return customerMapList;
    }
}
