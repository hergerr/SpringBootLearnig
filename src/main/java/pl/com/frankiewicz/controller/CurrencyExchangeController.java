package pl.com.frankiewicz.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import pl.com.frankiewicz.dto.ExchangeRates;

import java.math.BigDecimal;

@RestController
public class CurrencyExchangeController {

    @RequestMapping(method = RequestMethod.GET, value = "/currency/{howMany}/{from}/{to}")
    public String getRate(@PathVariable BigDecimal howMany, @PathVariable String from, @PathVariable String to){
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<ExchangeRates> entity = restTemplate.getForEntity("https://api.fixer.io/latest?base=" + from, ExchangeRates.class);
        Double rate = entity.getBody().getRates().get(to);
        BigDecimal multiply = howMany.multiply(BigDecimal.valueOf(rate));

        return from + " to " + to + " is " + multiply ;
    }

//    @GetMapping("/requested-entity/{howMany}/{from}/{to}")
//    public String getRate2(@PathVariable BigDecimal howMany, @PathVariable String from, @PathVariable String to){
//        RestTemplate restTemplate = new RestTemplate();
//        ResponseEntity<ExchangeRates> entity =
//                restTemplate.getForEntity("https://api.fixer.io/latest?base=" + from, ExchangeRates.class);
//        Double rate = entity.getBody().getRates().get(to);
//
//        return new ResponseEntity<Double>(entity.getBody().getRates().get(to), HttpStatus.CREATED);
//    }
}