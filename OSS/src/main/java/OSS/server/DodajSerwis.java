package OSS.server;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import OSS.client.application.shared.DTO.UslugaDTO;


@Entity
@Table(name = "dadajSerwis",schema="oss")
public class DodajSerwis implements Serializable {
	
	@Id
	@SequenceGenerator(name = "id_dodajSerwis_seq", sequenceName = "oss.id_dodajSerwis_seq")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id_dodajSerwis_seq")
	private Long id_dodajSerwis;
	
	@Column(name="koszt_Jednostki")
	private double kosztJednostki;
	
	@Column(name="liczbaGodzin")
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
	public DodajSerwis(Long id_dodajSerwis, double kosztJednostki, double liczbaGodzin) {
		super();
		this.id_dodajSerwis = id_dodajSerwis;
		this.kosztJednostki = kosztJednostki;
		this.liczbaGodzin = liczbaGodzin;
	}
	public DodajSerwis(){
		
	}
	
}
