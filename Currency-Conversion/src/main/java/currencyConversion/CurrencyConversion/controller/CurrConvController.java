package currencyConversion.CurrencyConversion.controller;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import currencyConversion.CurrencyConversion.CurrencyExchangeProxy;
import currencyConversion.CurrencyConversion.model.CurrConvResponse;

@RestController
@RequestMapping("/curr-conv")
public class CurrConvController {

	@Autowired
	private CurrencyExchangeProxy proxy; 
	
	/**
	 * using restTemplate
	 * 
	 */
	@GetMapping("/convert/from/{from}/to/{to}/quantity/{quantity}")
	public CurrConvResponse getConvertedAmt(@PathVariable String from, @PathVariable String to, @PathVariable BigDecimal quantity)
	{
		//return new CurrConvResponse(1, "USD", "INR", BigDecimal.valueOf(10), BigDecimal.valueOf(800), "8080");
		Map<String, String> uriVariables = new HashMap<>();
		uriVariables.put("from", from);
		uriVariables.put("to", to);
		ResponseEntity<CurrConvResponse> responseEntity = new RestTemplate().getForEntity(
				"http://localhost:8080/currency-excahange/from/{from}/to/{to}",
				CurrConvResponse.class, uriVariables);
		if(responseEntity.getStatusCode().value()!=200)
		{
			throw new RuntimeException("Status code in not 200");
		}
		CurrConvResponse currConvResponse = responseEntity.getBody();
		currConvResponse.setQuantity(quantity);
		currConvResponse.setEnv("-- from RestTemplate");
		currConvResponse.setTotalAmt(quantity.multiply(currConvResponse.getConversionMultiple()));
		return currConvResponse;
	}
	
	/**
	 * using Feign
	 * 
	 */
	@GetMapping("/convert-feign/from/{from}/to/{to}/quantity/{quantity}")
	public CurrConvResponse getConvertedAmtUsingFeign(@PathVariable String from, @PathVariable String to, @PathVariable BigDecimal quantity)
	{
		
		CurrConvResponse currConvResponse = proxy.getExcValue(from, to);
		currConvResponse.setQuantity(quantity);
		currConvResponse.setEnv("-- from Feign Client");
		currConvResponse.setTotalAmt(quantity.multiply(currConvResponse.getConversionMultiple()));
		return currConvResponse;
	}
	
}
