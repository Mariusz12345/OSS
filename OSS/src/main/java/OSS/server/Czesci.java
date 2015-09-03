package OSS.server;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "czesci",schema="oss")
public class Czesci {
	
	@Id
	@SequenceGenerator(name = "id_czesci_seq", sequenceName = "oss.id_czesci_seq")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id_czesci_seq")
	private Long id_czesci;
	
	@Column(name="cenna")
	private Float cenna;
	
	@Column(name="jednostki")
	private String jednostki;

	public Long getId_czesci() {
		return id_czesci;
	}

	public void setId_czesci(Long id_czesci) {
		this.id_czesci = id_czesci;
	}

	public Float getCenna() {
		return cenna;
	}

	public void setCenna(Float cenna) {
		this.cenna = cenna;
	}

	public String getJednostki() {
		return jednostki;
	}

	public void setJednostki(String jednostki) {
		this.jednostki = jednostki;
	}

	public Czesci(Long id_czesci, Float cenna, String jednostki) {
		super();
		this.id_czesci = id_czesci;
		this.cenna = cenna;
		this.jednostki = jednostki;
	}
	
}
