package com.byinal.creditLimits;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/api/v1/credit-limits")
public class CreditLimitController {

    private final CreditLimitManager creditLimitManager;

    public CreditLimitController(CreditLimitManager creditLimitManager) {
        this.creditLimitManager = creditLimitManager;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public String retrieveCustomers(ModelMap modelMap) {
        Map<String, List<Customer>> customerListMap = creditLimitManager.retrieveAllCreditLimits();
        modelMap.put("customersBySource", customerListMap);
        return "index.html";
    }

}
