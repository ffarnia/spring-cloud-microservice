package com.micro.currencyconversionservice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Fazel on 5/9/2019.
 */
@RestController
public class CurrencyConverterController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private CurrencyExchangeServiceProxy proxy;

    @GetMapping("currency-converter/from/{from}/to/{to}/quantity/{quantity}")
    public CurrentyConverterBean convertCurrency(@PathVariable("from") String from, @PathVariable("to") String to, @PathVariable("quantity") BigDecimal quantity) {


        Map<String, String> urlVariables = new HashMap<>();
        urlVariables.put("from", from);
        urlVariables.put("to", to);
        ResponseEntity<CurrentyConverterBean> responseEntity = new RestTemplate().getForEntity("http://127.0.0.1:8001/currency-exchange/from/{from}/to/{to}", CurrentyConverterBean.class, urlVariables);
        CurrentyConverterBean currentyConverterBean = responseEntity.getBody();

        return new CurrentyConverterBean(currentyConverterBean.getId(), from, to, currentyConverterBean.getConversionMultiple(), quantity, quantity.multiply(currentyConverterBean.getConversionMultiple()), 8100);
    }

    @GetMapping("currency-converter-feign/from/{from}/to/{to}/quantity/{quantity}")
    public CurrentyConverterBean convertCurrencyFeign(@PathVariable("from") String from, @PathVariable("to") String to, @PathVariable("quantity") BigDecimal quantity) {

        CurrentyConverterBean currentyConverterBean = proxy.retrieveExchangeValue(from, to);
        logger.info("{}", currentyConverterBean);
        return new CurrentyConverterBean(currentyConverterBean.getId(), from, to, currentyConverterBean.getConversionMultiple(), quantity, quantity.multiply(currentyConverterBean.getConversionMultiple()), currentyConverterBean.getPort());
    }
}
