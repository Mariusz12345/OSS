package OSS.client.application.serwer.handler;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.management.Query;
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
		//wczytaj3();
	}
	@Override
	public void wczytaj() {
		entityManager.createQuery("From DodajSerwis");
	}
	public void wczytaj3(){
		List<DodajSerwis> listaSerwiso= new ArrayList<>();
		Query query = (Query) entityManager.createQuery("From DodajSerwis");
		List<DodajSerwis> listaObiektow = ((javax.persistence.Query) query).getResultList();
		for(DodajSerwis serwis : listaObiektow){
			System.out.println(serwis.toString());
			System.out.println();
		}
	}
}
