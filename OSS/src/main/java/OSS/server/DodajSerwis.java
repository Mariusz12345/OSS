package OSS.server;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity
@Table(name = "dadajSerwis",schema="oss")
public class DodajSerwis {
	
	@Id
	@SequenceGenerator(name = "id_dodajSerwis_seq", sequenceName = "oss.id_dodajSerwis_seq")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id_dodajSerwis_seq")
	private Long id_dodajSerwis;
	
	@Column(name="koszt_Jednostki")
	private Float kosztJednostki;
	
	@Column(name="liczbaGodzin")
	private Float liczbaGodzin;



	public Float getKosztJednostki() {
		return kosztJednostki;
	}

	public void setKosztJednostki(Float kosztJednostki) {
		this.kosztJednostki = kosztJednostki;
	}

	public Float getLiczbaGodzin() {
		return liczbaGodzin;
	}

	public void setLiczbaGodzin(Float liczbaGodzin) {
		this.liczbaGodzin = liczbaGodzin;
	}

	public Long getId_dodajSerwis() {
		return id_dodajSerwis;
	}

	public void setId_dodajSerwis(Long id_dodajSerwis) {
		this.id_dodajSerwis = id_dodajSerwis;
	}

	public DodajSerwis(Long id_dodajSerwis, Float kosztJednostki, Float liczbaGodzin) {
		super();
		this.id_dodajSerwis = id_dodajSerwis;
		this.kosztJednostki = kosztJednostki;
		this.liczbaGodzin = liczbaGodzin;
	}
}
