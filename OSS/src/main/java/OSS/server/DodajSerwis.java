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
	private String kosztJednostki;
	
	@Column(name="liczbaGodzin")
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

	public DodajSerwis(Long id_dodajSerwis, String kosztJednostki, String liczbaGodzin) {
		super();
		this.id_dodajSerwis = id_dodajSerwis;
		this.kosztJednostki = kosztJednostki;
		this.liczbaGodzin = liczbaGodzin;
	}
	public DodajSerwis(String kosztJednostki, String liczbaGodzin) {
		super();
		this.kosztJednostki = kosztJednostki;
		this.liczbaGodzin = liczbaGodzin;
	}
	public DodajSerwis(){
		
	}
	
}
