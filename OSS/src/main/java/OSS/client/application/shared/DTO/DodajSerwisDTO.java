package OSS.client.application.shared.DTO;

import java.io.Serializable;

import OSS.server.DodajSerwis;

public class DodajSerwisDTO implements Serializable {
	private Long id_dodajSerwis;
	private String kosztJednostki;
	private String liczbaGodzin;
	
	public Long getId_dodajSerwis() {
		return id_dodajSerwis;
	}
	public void setId_dodajSerwis(Long id_dodajSerwis) {
		this.id_dodajSerwis = id_dodajSerwis;
	}
	public String getKosztJednostki() {
		return kosztJednostki;
	}
	public void setKosztJednostki(String kosztJednostki) {
		this.kosztJednostki = kosztJednostki;
	}
	public String getLiczbaGodzin() {
		return liczbaGodzin;
	}
	public void setLiczbaGodzin(String liczbaGodzin) {
		this.liczbaGodzin = liczbaGodzin;
	}
	public DodajSerwisDTO(String kosztJednostki ,String liczbaGodzin){
		super();
		this.kosztJednostki=kosztJednostki;
		this.liczbaGodzin=liczbaGodzin;
	}
	
	public DodajSerwisDTO(Long id_dodajSerwis, String kosztJednostki, String liczbaGodzin) {
		super();
		this.id_dodajSerwis = id_dodajSerwis;
		this.kosztJednostki = kosztJednostki;
		this.liczbaGodzin = liczbaGodzin;
	}
	public DodajSerwisDTO(){
		
	}
	@Override
	public String toString() {
		return "DodajSerwisDTO [kosztJednostki=" + kosztJednostki + ", liczbaGodzin=" + liczbaGodzin + "]";
	}
	

//	public DodajSerwis dodajSerwisNaSztywno(){
//		return new DodajSerwis(this.id_dodajSerwis,this.kosztJednostki,this.liczbaGodzin);
//	}
}
