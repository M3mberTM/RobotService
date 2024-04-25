package data;

import java.sql.Timestamp;
import java.util.Calendar;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name="legosetting")
public class LegoSetting {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private int maxspeed;
	private double turningPercentage;
	private float lowerThresh;
	private float upperThresh;
	private java.sql.Timestamp time=new java.sql.Timestamp(Calendar.getInstance().getTimeInMillis());
	
	
	@ManyToOne(fetch=FetchType.LAZY, cascade = CascadeType.PERSIST)
	@JsonBackReference //To handle converting object to JSON and backwards
	@JoinColumn(name="legoid")	
	private Lego lego;
	
	public LegoSetting() {
		super();
	}
	public LegoSetting(int id, int maxspeed, double turningPercentage, float lowerThresh, float upperThresh, Timestamp time) {
		super();
		this.id = id;
		this.maxspeed = maxspeed;
		this.turningPercentage = turningPercentage;
		this.lowerThresh = lowerThresh;
		this.upperThresh = upperThresh;
		this.time = time;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public java.sql.Timestamp getTime() {
		return time;
	}
	public void setTime(java.sql.Timestamp time) {
		this.time = time;
	}
	public Lego getLego() {
		return lego;
	}
	public void setLego(Lego lego) {
		this.lego = lego;
	}
	public int getMaxspeed() {
		return maxspeed;
	}
	public void setMaxspeed(int maxspeed) {
		this.maxspeed = maxspeed;
	}
	public double getTurningPercentage() {
		return turningPercentage;
	}
	public void setTurningPercentage(double turningPercentage) {
		this.turningPercentage = turningPercentage;
	}
	public float getLowerThresh() {
		return lowerThresh;
	}
	public void setLowerThresh(float lowerThresh) {
		this.lowerThresh = lowerThresh;
	}
	public float getUpperThresh() {
		return upperThresh;
	}
	public void setUpperThresh(float upperThresh) {
		this.upperThresh = upperThresh;
	}
	@Override
	public String toString() {
		return id+"#"+maxspeed+"#"+turningPercentage+lowerThresh+upperThresh+"#"+time;
	}
	
}
