package OSS.client.application.shared.DTO;

public class SerwisDTO {
	private String data;
	private String guzik;
	
	//private String  pracownik;
	
	
	public SerwisDTO(){
		
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getGuzik() {
		return guzik;
	}

	public void setGuzik(String guzik) {
		this.guzik = guzik;
	}



	public SerwisDTO(String data, String guzik) {
		super();
		this.data = data;
		this.guzik = guzik;
	}



	


	
	
}
