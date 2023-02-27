package cn.itbill.pojo;

import java.sql.Time;
import java.sql.Timestamp;
import java.util.List;

public class Plate {
	private int plate_id;
	private int food_id;
	private Timestamp time;

	public int getPlate_id() {
		return plate_id;
	}

	public void setPlate_id(int plate_id) {
		this.plate_id = plate_id;
	}

	public int getFood_id() {
		return food_id;
	}

	public void setFood_id(int food_id) {
		this.food_id = food_id;
	}

	public Timestamp getTime() {
		return time;
	}

	public void setTime(Timestamp time) {
		this.time = time;
	}
}
