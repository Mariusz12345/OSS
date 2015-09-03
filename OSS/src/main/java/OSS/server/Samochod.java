package OSS.server;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;



@Entity
@Table(name="samochod",schema="oss")
public class Samochod {
	@Id
	@SequenceGenerator(name = "id_seq", sequenceName = "oss.id_seq")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id_seq")
	private Long id;
	@Column(name="marka")
	private String marka;
	@Column(name="model")
	private String model;
	@Column(name="przebieg")
	private Float przebieg;
	
	
	
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public Float getPrzebieg() {
		return przebieg;
	}
	public void setPrzebieg(Float przebieg) {
		this.przebieg = przebieg;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getMarka() {
		return marka;
	}
	public void setMarka(String marka) {
		this.marka = marka;
	}
	public Samochod(Long id, String marka, String model, Float przebieg) {
		super();
		this.id = id;
		this.marka = marka;
		this.model = model;
		this.przebieg = przebieg;
	}
	
	
	
	

}
