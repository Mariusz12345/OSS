package OSS.client.application.serwer.handler;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import OSS.server.DodajSerwis;


@Stateless
@Remote
public class Bean   {
	
	@PersistenceContext(name = "primary")
	private EntityManager entityManager;
	
	
	public void dodaj1(DodajSerwis dodajSerwis){
		entityManager.merge(dodajSerwis);
	}
	
	public void dodaj2(String text){
		DodajSerwis serwis = new DodajSerwis(1l, 15, 24);
		entityManager.persist(serwis);
	}
}
