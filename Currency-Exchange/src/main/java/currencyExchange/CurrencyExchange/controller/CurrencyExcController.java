package currencyExchange.CurrencyExchange.controller;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import currencyExchange.CurrencyExchange.model.CurrencyExcResponse;
import currencyExchange.CurrencyExchange.service.CurrExchangeService;

@Controller
@ResponseBody
@RequestMapping("/currency-excahange")
public class CurrencyExcController {

	@Autowired
	private CurrExchangeService exchangeService;
	
	@GetMapping("/from/{from}/to/{to}")
	public CurrencyExcResponse getExcValue(@PathVariable String from, @PathVariable String to)
	{
		//return new CurrencyExcResponse(1, to, from, BigDecimal.valueOf(80.00),"8080");
		return exchangeService.findByFromAndTo(from, to);
	}
	
}
