package services;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import data.*;

@Path("/lego")
public class LegoService {
	EntityManagerFactory emf=Persistence.createEntityManagerFactory("lego");	
	boolean isKilled = false;
	@Path("/test")
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String test() {
		return "This is a test";
	}
	
	@Path("/getlego")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Lego getLego() {
	    EntityManager em=emf.createEntityManager();
	    em.getTransaction().begin();
	    Lego l=em.find(Lego.class, 1);
	    em.getTransaction().commit();		
		return l;
	}
	
	
	@Path("/settimestamp/{par}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Laptime setTimestamp(@PathParam("par") int timestamp) {
		Laptime lt = new Laptime();
		lt.setTimetaken(timestamp);
		System.out.println(lt);
	    EntityManager em=emf.createEntityManager();
	    em.getTransaction().begin();
	    em.merge(lt);
	    em.getTransaction().commit();		
		return lt;
		

	}
	
	@Path("/gettimestamps")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Laptime> getTimestamps() {
		EntityManager em=emf.createEntityManager();
	    em.getTransaction().begin();
		Query q=em.createQuery("select s from Laptime s order by s.id desc");
		List<Laptime> list=q.getResultList();
		em.getTransaction().commit();

		return list;
	}
	
	
	
	@Path("/setvalues")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public LegoSetting setValues(LegoSetting ls) {
		System.out.println(ls);
	    EntityManager em=emf.createEntityManager();
	    em.getTransaction().begin();
	    em.merge(ls);
	    em.getTransaction().commit();		
		return ls;
	}
	
	
	
	@Path("/getkill")
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String getKill() {
		EntityManager em=emf.createEntityManager();
	    em.getTransaction().begin();
		Query q=em.createQuery("select s from Killswitch s order by s.id desc").setMaxResults(1);
		List<Killswitch> list=q.getResultList();
		em.getTransaction().commit();
		Killswitch currSetting = list.get(0);
		StringBuilder sb = new StringBuilder();

		sb.append(currSetting.getKillswitch());
		return sb.toString();
	}
	
	@Path("/setkill")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Killswitch setKill(Killswitch ks) {
		System.out.println(ks);
	    EntityManager em=emf.createEntityManager();
	    em.getTransaction().begin();
	    em.merge(ks);
	    em.getTransaction().commit();		
		return ks;
	}
	
	
	@Path("/getvalues")
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String getValues() {
	    EntityManager em=emf.createEntityManager();
	    em.getTransaction().begin();
		Query q=em.createQuery("select s from LegoSetting s order by s.id desc").setMaxResults(1);
		List<LegoSetting> list=q.getResultList();
		em.getTransaction().commit();
		LegoSetting currSetting = list.get(0);
		StringBuilder sb = new StringBuilder();
		String separator = "#";
		sb.append(currSetting.getMaxspeed());
		sb.append(separator);
		sb.append(currSetting.getTurningPercentage());
		sb.append(separator);
		sb.append(currSetting.getLowerThresh());
		sb.append(separator);
		sb.append(currSetting.getUpperThresh());
		
		return sb.toString();
	}
	
	
	@Path("/getallvalues")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List getAllValues() {
	    EntityManager em=emf.createEntityManager();
	    em.getTransaction().begin();
		Query q=em.createQuery("select s from LegoSetting s order by s.id desc").setMaxResults(10);
		List<LegoSetting> list=q.getResultList();
		em.getTransaction().commit();		
		return list;
	}
	@Path("/getspeed")
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String getSpeed() {
	    EntityManager em=emf.createEntityManager();
	    em.getTransaction().begin();
		Query q=em.createQuery("select s from LegoSetting s order by s.id desc").setMaxResults(1);
		List<LegoSetting> list=q.getResultList();
		em.getTransaction().commit();		
		return ""+list.get(0).getMaxspeed();

	}
	
}
