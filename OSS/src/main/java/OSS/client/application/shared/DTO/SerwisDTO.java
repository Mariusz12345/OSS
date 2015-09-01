package OSS.client.application.shared.DTO;

import java.util.Date;

import OSS.client.application.presenterserwis.Pracownik;

public class SerwisDTO {
	
	private String guzik;
	private Pracownik pracownik;
	private String dodajUsluge;
	private String dodajczesci;
	private Date biezacaData;
	
	public SerwisDTO(){
		
	}



	public String getGuzik() {
		return guzik;
	}

	public void setGuzik(String guzik) {
		this.guzik = guzik;
	}

	public Pracownik getPracownik() {
		return pracownik;
	}

	public void setPracownik(Pracownik pracownik) {
		this.pracownik = pracownik;
	}

	public String getDodajUsluge() {
		return dodajUsluge;
	}

	public void setDodajUsluge(String dodajUsluge) {
		this.dodajUsluge = dodajUsluge;
	}

	public String getDodajczesci() {
		return dodajczesci;
	}

	public void setDodajczesci(String dodajczesci) {
		this.dodajczesci = dodajczesci;
	}

	public Date getBiezacaData() {
		return biezacaData;
	}

	public void setBiezacaData(Date biezacaData) {
		this.biezacaData = biezacaData;
	}

	public SerwisDTO(String guzik, Pracownik pracownik, String dodajUsluge, String dodajczesci,
			Date biezacaData) {
		super();
		this.guzik = guzik;
		this.pracownik = pracownik;
		this.dodajUsluge = dodajUsluge;
		this.dodajczesci = dodajczesci;
		this.biezacaData = biezacaData;
	}

	
}
