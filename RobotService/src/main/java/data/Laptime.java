package data;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name="laptime")
public class Laptime {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private int timetaken;
	
	public Laptime() {
		super();
	}
	public Laptime(int id, int timetaken) {
		super();
		this.id = id;
		this.timetaken = timetaken;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getTimetaken() {
		return timetaken;
	}
	public void setTimetaken(int timetaken) {
		this.timetaken= timetaken;
	}
	@Override
	public String toString() {
		return id+"#"+timetaken;
	}
	
}
