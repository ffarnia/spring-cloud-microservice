package com.micro.currencyconversionservice;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * Created by Fazel on 5/9/2019.
 */
//@FeignClient(name = "currency-exchange-service",url = "127.0.0.1:8001")
//@FeignClient(name = "currency-exchange-service")
@FeignClient(name = "netflix-zuul-api-gateway-server")
@RibbonClient(name = "currency-exchange-service")
public interface CurrencyExchangeServiceProxy {

//    @GetMapping(value = "/currency-exchange/from/{from}/to/{to}")
    @GetMapping(value = "/currency-exchange-service/currency-exchange/from/{from}/to/{to}")
    public CurrentyConverterBean retrieveExchangeValue(@PathVariable("from") String from, @PathVariable("to") String to);

    }
