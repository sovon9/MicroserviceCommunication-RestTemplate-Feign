package currencyExchange.CurrencyExchange.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import currencyExchange.CurrencyExchange.model.CurrencyExcResponse;
import currencyExchange.CurrencyExchange.repository.CurrExchangeRepo;

@Service
public class CurrExchangeService {

	@Autowired
	private CurrExchangeRepo currExchangeRepo;
	
	public CurrencyExcResponse findByFromAndTo(String from, String to)
	{
		/**
		 *  spring data jpa will provide the implementation for this
		 */
		return currExchangeRepo.findByFromAndTo(from, to); 
	}
	
}
