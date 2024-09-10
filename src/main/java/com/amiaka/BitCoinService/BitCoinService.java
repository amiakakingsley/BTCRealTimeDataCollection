package com.amiaka.BitCoinService;

import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class BitCoinService {

	public double getBitcoinPrice() {
        String url = "https://api.coingecko.com/api/v3/simple/price?ids=bitcoin&vs_currencies=usd";
        RestTemplate restTemplate = new RestTemplate();
        Map<String, Map<String, Double>> response = restTemplate.getForObject(url, Map.class);
        Object priceObj = response.get("bitcoin").get("usd");
        
     // Handle both Integer and Double cases
        if (priceObj instanceof Integer) {
            return ((Integer) priceObj).doubleValue();
        } else if (priceObj instanceof Double) {
            return (Double) priceObj;
        } else {
            throw new RuntimeException("Unexpected price format");
        }
    }
	
}
