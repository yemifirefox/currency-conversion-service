package com.in28minutes.microservices.currencyconversionservice;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

//@FeignClient(name = "currency-exchange-service", url = "localhost:8001")
//@FeignClient(name = "currency-exchange-service") //direct call to Eureka Naming Service
@FeignClient(name = "netflix-zuul-api-gateway-server") //Call to Zuul api gateway
@RibbonClient(name = "currency-exchange-service")
public interface CurrencyExchangeServiceProxy {

    //@GetMapping("/currency-exchange/from/{from}/to/{to}") // direct call
    @GetMapping("/currency-exchange-service/currency-exchange/from/{from}/to/{to}") // through Zuul api gateway
    CurrencyConversionBean retrieveExchangeValue(@PathVariable String from, @PathVariable String to);
}
