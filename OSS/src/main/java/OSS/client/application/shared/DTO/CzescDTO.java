package OSS.client.application.shared.DTO;

import OSS.client.application.presenterdodajczesci.Jednostki;

public class CzescDTO {
	private String wykonaj;
	private String anuluj;
	private String cenna;
	private Jednostki jednostka;
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
	public String getCenna() {
		return cenna;
	}
	public void setCenna(String cenna) {
		this.cenna = cenna;
	}
	public Jednostki getJednostka() {
		return jednostka;
	}
	public void setJednostka(Jednostki jednostka) {
		this.jednostka = jednostka;
	}
	public CzescDTO(String wykonaj, String anuluj, String cenna, Jednostki jednostka) {
		super();
		this.wykonaj = wykonaj;
		this.anuluj = anuluj;
		this.cenna = cenna;
		this.jednostka = jednostka;
	}
	

}
