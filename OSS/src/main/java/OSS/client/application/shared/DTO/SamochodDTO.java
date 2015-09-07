package OSS.client.application.shared.DTO;

public class SamochodDTO {
	
	private String marka;
	private String model;
	private String przebieg;
	private String zatwierdz;
	
	public String getPrzebieg() {
		return przebieg;
	}

	public void setPrzebieg(String przebieg) {
		this.przebieg = przebieg;
	}

	public SamochodDTO(){
		
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getMarka() {
		return marka;
	}

	public void setMarka(String marka) {
		this.marka = marka;
	}

	public String getZatwierdz() {
		return zatwierdz;
	}

	public void setZatwierdz(String zatwierdz) {
		this.zatwierdz = zatwierdz;
	}


	public SamochodDTO(String marka, String model, String przebieg, String zatwierdz) {
		super();
		this.marka = marka;
		this.model = model;
		this.przebieg = przebieg;
		this.zatwierdz = zatwierdz;
	}

}
