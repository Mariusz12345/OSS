package OSS.client.application.shared;

import com.gwtplatform.dispatch.rpc.shared.UnsecuredActionImpl;

import OSS.client.application.shared.DTO.DodajSerwisDTO;
import OSS.server.DodajSerwis;

public class WyslijDoSerweraAction extends UnsecuredActionImpl<OdpowiedzZSerweraResult>  {

	//private DodajSerwisDTO serwisek ;
	private String wart1 ;
	private String  wart2;
	public WyslijDoSerweraAction(){
		
	}
	public String getWart1() {
		return wart1;
	}
	public void setWart1(String wart1) {
		this.wart1 = wart1;
	}
	public String getWart2() {
		return wart2;
	}
	public void setWart2(String wart2) {
		this.wart2 = wart2;
	}
	public WyslijDoSerweraAction(String wart1, String wart2) {
		super();
		this.wart1 = wart1;
		this.wart2 = wart2;
	}
	
//	public DodajSerwisDTO getSerwisek() {
//		return serwisek;
//	}
//	public void setSerwisek(DodajSerwisDTO serwisek) {
//		this.serwisek = serwisek;
//	}
	

	

	
}
