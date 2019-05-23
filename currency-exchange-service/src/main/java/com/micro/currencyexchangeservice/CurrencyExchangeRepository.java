package com.micro.currencyexchangeservice;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Fazel on 5/9/2019.
 */
@Repository
public interface CurrencyExchangeRepository  extends JpaRepository<ExchangeValue,Long>{

    ExchangeValue findByFromAndTo(String from,String to);
}
