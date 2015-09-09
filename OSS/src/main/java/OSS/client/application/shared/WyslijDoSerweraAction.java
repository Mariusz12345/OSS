package OSS.client.application.shared;

import com.gwtplatform.dispatch.rpc.shared.UnsecuredActionImpl;

import OSS.client.application.shared.DTO.DodajSerwisDTO;
import OSS.server.DodajSerwis;

public class WyslijDoSerweraAction extends UnsecuredActionImpl<OdpowiedzZSerweraResult>  {

	private DodajSerwisDTO serwisek ;
	private String serwis ;
	public WyslijDoSerweraAction(){
		
	}
	public WyslijDoSerweraAction(String name) {
		super();
		this.serwis = name;
	}

	public String getSerwis() {
		return serwis;
	}
	public DodajSerwisDTO getSerwisek() {
		return serwisek;
	}
	public void setSerwisek(DodajSerwisDTO serwisek) {
		this.serwisek = serwisek;
	}
	public void setSerwis(String serwis) {
		this.serwis = serwis;
	}
	

	

	
}
