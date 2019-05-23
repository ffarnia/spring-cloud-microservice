package com.micro.currencyexchangeservice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Fazel on 5/9/2019.
 */
@RestController
public class CurrencyExchangeController {

    private Logger logger= LoggerFactory.getLogger(this.getClass());

    @Autowired
    private Environment environment;

    @Autowired
    private CurrencyExchangeRepository currencyExchangeRepository;

    @GetMapping(value = "/currency-exchange/from/{from}/to/{to}")
    public ExchangeValue retrieveExchangeValue(@PathVariable("from") String from, @PathVariable("to") String to) {

       /* ExchangeValue exchangeValue = new ExchangeValue(1L, from, to, BigDecimal.valueOf(300));
        exchangeValue.setPort(Integer.parseInt(environment.getProperty("local.server.port")));*/

//        return currencyExchangeRepository.findAll();
        ExchangeValue exchangeValue = currencyExchangeRepository.findByFromAndTo(from, to);
        exchangeValue.setPort(Integer.parseInt(environment.getProperty("local.server.port")));

        logger.info("{}",exchangeValue);
        return exchangeValue;
    }
}
