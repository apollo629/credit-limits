package com.byinal.creditLimits;

import java.util.List;

public interface CreditLimitRetriever {

    List<Customer> retrieve();

    String getName();
}
