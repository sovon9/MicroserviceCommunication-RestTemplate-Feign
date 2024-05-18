package currencyConversion.CurrencyConversion;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import currencyConversion.CurrencyConversion.model.CurrConvResponse;

@FeignClient(name = "Currency-Exchange", url = "localhost:8080", path = "/currency-excahange")
public interface CurrencyExchangeProxy{
	
	@GetMapping("/from/{from}/to/{to}")
	public CurrConvResponse getExcValue(@PathVariable String from, @PathVariable String to);
	
}
