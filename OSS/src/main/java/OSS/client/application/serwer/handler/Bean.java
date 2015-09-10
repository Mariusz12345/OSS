package OSS.client.application.serwer.handler;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import OSS.server.DodajSerwis;

@Stateless(name = "CallerName",mappedName="CallerMappedName")
public class Bean implements Wywolaj   {
	
	@PersistenceContext(name = "primary")
	private EntityManager entityManager;
	
	public void dodaj4(String wart1,String wart2) {
		DodajSerwis serwis   = new DodajSerwis(wart1, wart2);
		entityManager.merge(serwis);
	}
}
