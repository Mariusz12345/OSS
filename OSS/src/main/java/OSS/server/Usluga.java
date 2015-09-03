package OSS.server;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="usluga",schema="oss")
public class Usluga {
	
	@Id
	@SequenceGenerator(name = "id_uslugi_seq", sequenceName = "oss.id_uslugi_seq")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id_uslugi_seq")
	private String id_uslugi;
	
	@Column(name = "koszt_Jednostkowy")
	private String kosztJednostkowy;

	@Column(name ="liczba_Godzin" )
	private Float liczbaGodzin;
	
	@Column(name="czesci")
	private String czesci;

	public String getId_uslugi() {
		return id_uslugi;
	}

	public void setId_uslugi(String id_uslugi) {
		this.id_uslugi = id_uslugi;
	}

	public String getKosztJednostkowy() {
		return kosztJednostkowy;
	}

	public void setKosztJednostkowy(String kosztJednostkowy) {
		this.kosztJednostkowy = kosztJednostkowy;
	}

	public Float getLiczbaGodzin() {
		return liczbaGodzin;
	}

	public void setLiczbaGodzin(Float liczbaGodzin) {
		this.liczbaGodzin = liczbaGodzin;
	}

	public String getCzesci() {
		return czesci;
	}

	public void setCzesci(String czesci) {
		this.czesci = czesci;
	}

	public Usluga(String id_uslugi, String kosztJednostkowy, Float liczbaGodzin, String czesci) {
		super();
		this.id_uslugi = id_uslugi;
		this.kosztJednostkowy = kosztJednostkowy;
		this.liczbaGodzin = liczbaGodzin;
		this.czesci = czesci;
	}
	
	
}
