package currencyExchange.CurrencyExchange.model;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "curr_exchange")
public class CurrencyExcResponse {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private int id;
	@Column(name="curr_to")
	private String to;
	@Column(name="curr_from")
	private String from;
	@Column
	private BigDecimal conversionMultiple;
	@Column
	private String env;
	public CurrencyExcResponse() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public CurrencyExcResponse(int id, String to, String from, BigDecimal conversionMultiple, String env) {
		super();
		this.id = id;
		this.to = to;
		this.from = from;
		this.conversionMultiple = conversionMultiple;
		this.env = env;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTo() {
		return to;
	}
	public void setTo(String to) {
		this.to = to;
	}
	public String getFrom() {
		return from;
	}
	public void setFrom(String from) {
		this.from = from;
	}
	public BigDecimal getConversionMultiple() {
		return conversionMultiple;
	}
	public void setConversionMultiple(BigDecimal conversionMultiple) {
		this.conversionMultiple = conversionMultiple;
	}
	public String getEnv() {
		return env;
	}

	public void setEnv(String env) {
		this.env = env;
	}

	@Override
	public String toString() {
		return "CurrencyExcResponse [id=" + id + ", to=" + to + ", from=" + from + ", conversionMultiple="
				+ conversionMultiple + ", env=" + env + "]";
	}

}
