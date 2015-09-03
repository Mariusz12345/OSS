package OSS.server;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="serwis",schema="oss")
public class Serwis {

	@Id
	@SequenceGenerator(name = "id_serwisu_seq", sequenceName = "oss.id_serwisu_seq")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id_serwisu_seq")
	private Long id_serwisu;
	
	@Column(name = "dataWykonania")
	private Date dataWykonania;
	@Column(name="pracownik")
	private String pracownik;
	public Long getId_serwisu() {
		return id_serwisu;
	}
	public void setId_serwisu(Long id_serwisu) {
		this.id_serwisu = id_serwisu;
	}
	public Date getDataWykonania() {
		return dataWykonania;
	}
	public void setDataWykonania(Date dataWykonania) {
		this.dataWykonania = dataWykonania;
	}
	public String getPracownik() {
		return pracownik;
	}
	public void setPracownik(String pracownik) {
		this.pracownik = pracownik;
	}
	public Serwis(Long id_serwisu, Date dataWykonania, String pracownik) {
		super();
		this.id_serwisu = id_serwisu;
		this.dataWykonania = dataWykonania;
		this.pracownik = pracownik;
	}
	
	
	
	
	
}
