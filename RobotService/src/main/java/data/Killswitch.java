package data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="killswitch")
public class Killswitch {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private int killswitch;
	
	
	
	public Killswitch() {
		super();
	}
	
	public Killswitch(int killswitch) {
		super();
		
		this.killswitch = killswitch;
	}
	
	public Killswitch(int id, int killswitch) {
		super();
		this.id = id;
		this.killswitch = killswitch;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getKillswitch() {
		return killswitch;
	}
	public void setName(int killswitch) {
		this.killswitch= killswitch;
	}
	@Override
	public String toString() {
		return id+"#"+killswitch;
	}
	
}
