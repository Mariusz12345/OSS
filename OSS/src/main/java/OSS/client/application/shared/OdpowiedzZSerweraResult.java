package OSS.client.application.shared;

import com.gwtplatform.dispatch.rpc.shared.Result;

public class OdpowiedzZSerweraResult implements Result {
	
	private String  odpowiedziZSerwera;

	public String getOdpowiedziZSerwera() {
		return odpowiedziZSerwera;
	}

	public void setOdpowiedziZSerwera(String odpowiedziZSerwera) {
		this.odpowiedziZSerwera = odpowiedziZSerwera;
	}

	public OdpowiedzZSerweraResult(String odpowiedziZSerwera) {
		super();
		this.odpowiedziZSerwera = odpowiedziZSerwera;
	}
	
}
