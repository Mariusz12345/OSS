package OSS.client.application.shared;

import com.gwtplatform.dispatch.rpc.shared.UnsecuredActionImpl;

import OSS.client.application.shared.DTO.DodajSerwisDTO;

public class WyslijDoSerweraAction extends UnsecuredActionImpl<OdpowiedzZSerweraResult>  {

	//private DodajSerwisDTO serwisDTO = new DodajSerwisDTO(1l, 15, 20);
	private String tekst = "cos";
	public WyslijDoSerweraAction(){
		
	}
	
	public String getTekst() {
		return tekst;
	}
	public void setTekst(String tekst) {
		this.tekst = tekst;
	}
	public WyslijDoSerweraAction(String tekst) {
		super();
		this.tekst = tekst;
	}
//	public DodajSerwisDTO getSerwisDTO() {
//		return new DodajSerwisDTO(2l, 15, 20);
//	}
}
