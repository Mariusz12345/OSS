package OSS.client.application.shared.DTO;

import java.io.Serializable;

import OSS.server.DodajSerwis;

public class DodajSerwisDTO implements Serializable {
	private Long id_dodajSerwis;
	private double kosztJednostki;
	private double liczbaGodzin;
	public Long getId_dodajSerwis() {
		return id_dodajSerwis;
	}
	public void setId_dodajSerwis(Long id_dodajSerwis) {
		this.id_dodajSerwis = id_dodajSerwis;
	}
	public double getKosztJednostki() {
		return kosztJednostki;
	}
	public void setKosztJednostki(double kosztJednostki) {
		this.kosztJednostki = kosztJednostki;
	}
	public double getLiczbaGodzin() {
		return liczbaGodzin;
	}
	public void setLiczbaGodzin(double liczbaGodzin) {
		this.liczbaGodzin = liczbaGodzin;
	}
	public DodajSerwisDTO(Long id_dodajSerwis, double kosztJednostki, double liczbaGodzin) {
		super();
		this.id_dodajSerwis = id_dodajSerwis;
		this.kosztJednostki = kosztJednostki;
		this.liczbaGodzin = liczbaGodzin;
	}
	public DodajSerwisDTO(){
		
	}
	public DodajSerwis dodajSerwisNaSztywno(){
		return new DodajSerwis(this.id_dodajSerwis,this.kosztJednostki,this.liczbaGodzin);
	}
}
