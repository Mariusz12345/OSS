package OSS.client.application.shared;

import com.gwtplatform.dispatch.rpc.shared.UnsecuredActionImpl;

import OSS.client.application.shared.DTO.UslugaDTO;

public class WyslijDoSerweraAction extends UnsecuredActionImpl<OdpowiedzZSerweraResult>  {
	
	private UslugaDTO usluga = new UslugaDTO("15", "16");
	public UslugaDTO getUsluga() {
		return usluga;
	}
	public void setUsluga(UslugaDTO usluga) {
		this.usluga = usluga;
	}
	
	
}
