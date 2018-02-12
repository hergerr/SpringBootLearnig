package pl.com.frankiewicz.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import pl.com.frankiewicz.dto.ExchangeRates;

@RestController
public class CurrencyExchangeController {

    @RequestMapping(method = RequestMethod.GET, value = "/currency/{from}/{to}")
    public String getRate(@PathVariable String from, @PathVariable String to){
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<ExchangeRates> entity = restTemplate.getForEntity("https://api.fixer.io/latest?base=" + from, ExchangeRates.class);
        Double rate = entity.getBody().getRates().get(to);

        return from + " to " + to + " is " + rate;
    }
}
