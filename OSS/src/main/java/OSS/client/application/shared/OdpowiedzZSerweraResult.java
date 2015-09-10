package OSS.client.application.shared;

import com.gwtplatform.dispatch.rpc.shared.Result;

public class OdpowiedzZSerweraResult implements Result {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String  odpowiedziZSerwera ;

	public OdpowiedzZSerweraResult(String odpowiedziZSerwera) {
		super();
		this.odpowiedziZSerwera = odpowiedziZSerwera;
	}
	public OdpowiedzZSerweraResult(){
		super();
	}
	public String getOdpowiedziZSerwera() {
		return odpowiedziZSerwera;
	}
}
