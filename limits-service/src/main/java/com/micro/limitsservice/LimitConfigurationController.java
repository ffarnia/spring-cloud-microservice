package com.micro.limitsservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Fazel on 5/9/2019.
 */
@RestController
public class LimitConfigurationController {

    @Autowired
    private Configuration configuration;

    @GetMapping(value = "/limits")
    public LimitConfiguration getLimitsService(){
        return new LimitConfiguration(configuration.getMinimum(),configuration.getMaximum());
    }
}
