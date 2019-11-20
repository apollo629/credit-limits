package com.byinal.creditLimits;

import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class CreditLimitRetrieverRegistry {

    private Map<String, CreditLimitRetriever> creditLimitRetrieverMap;

    public CreditLimitRetrieverRegistry(Set<CreditLimitRetriever> creditLimitRetrievers) {
        creditLimitRetrieverMap = createStrategies(creditLimitRetrievers);
    }

    CreditLimitRetriever retrieveCreditLimitRetrieverByName(String repositoryName) {
        return creditLimitRetrieverMap.get(repositoryName);
    }


    Collection<CreditLimitRetriever> retrieveAllCreditLimitRetrievers(){
        return creditLimitRetrieverMap.values();
    }


    private Map<String, CreditLimitRetriever> createStrategies(Set<CreditLimitRetriever> creditLimitRetrievers){
        Map<String, CreditLimitRetriever> creditLimitRetrieverMap = new HashMap<>();
        creditLimitRetrievers.forEach(creditLimitRetriever -> creditLimitRetrieverMap.put(creditLimitRetriever.getName(), creditLimitRetriever));
        return creditLimitRetrieverMap;
    }
}
