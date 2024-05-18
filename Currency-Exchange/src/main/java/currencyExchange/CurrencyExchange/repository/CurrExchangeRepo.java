package currencyExchange.CurrencyExchange.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import currencyExchange.CurrencyExchange.model.CurrencyExcResponse;

public interface CurrExchangeRepo extends JpaRepository<CurrencyExcResponse, Integer>{

	public CurrencyExcResponse findByFromAndTo(String from, String to);

}
