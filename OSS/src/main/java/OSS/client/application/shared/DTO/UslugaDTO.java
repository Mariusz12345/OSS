package OSS.client.application.shared.DTO;


public class UslugaDTO {
	
	private String koszJednostki;
	private String wykonaj;
	private String anuluj;
	private String lGodziny;
	private String odczyt;

	public String getOdczyt() {
		return odczyt;
	}
	public void setOdczyt(String odczyt) {
		this.odczyt = odczyt;
	}
	public UslugaDTO(){
	}
	public UslugaDTO(String koszJednostki,String lGodziny){
		this.koszJednostki = koszJednostki;
		this.lGodziny=lGodziny;
	}
	public String getKoszJednostki() {
		return koszJednostki;
	}
	public void setKoszJednostki(String koszJednostki) {
		this.koszJednostki = koszJednostki;
	}

	public String getWykonaj() {
		return wykonaj;
	}

	public void setWykonaj(String wykonaj) {
		this.wykonaj = wykonaj;
	}

	public String getAnuluj() {
		return anuluj;
	}

	public void setAnuluj(String anuluj) {
		this.anuluj = anuluj;
	}

	public String getlGodziny() {
		return lGodziny;
	}

	public void setlGodziny(String lGodziny) {
		this.lGodziny = lGodziny;
	}
	public UslugaDTO(String koszJednostki, String wykonaj, String anuluj, String lGodziny, String odczyt) {
		super();
		this.koszJednostki = koszJednostki;
		this.wykonaj = wykonaj;
		this.anuluj = anuluj;
		this.lGodziny = lGodziny;
		this.odczyt = odczyt;
	}
}
