package OSS.client.application.shared;

import com.gwtplatform.dispatch.rpc.shared.UnsecuredActionImpl;

import OSS.client.application.shared.DTO.DodajSerwisDTO;
import OSS.server.DodajSerwis;

public class WyslijDoSerweraAction extends UnsecuredActionImpl<OdpowiedzZSerweraResult>  {

	//private DodajSerwisDTO serwisDTO ;
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

	public void setSerwis(String serwis) {
		this.serwis = serwis;
	}
	//public DodajSerwisDTO getSerwisDTO() {
		//return new DodajSerwisDTO(1l, 15, 20);
	//}
	
}
