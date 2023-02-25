package cn.itbill.pojo;

public class Ingredient {
	private Integer ingredient_id;
	private String title;
	private String consumption;

	public String getConsumption() {
		return consumption;
	}

	public void setConsumption(String consumption) {
		this.consumption = consumption;
	}

	public Integer getIngredient_id() {
		return ingredient_id;
	}

	public void setIngredient_id(Integer ingredient_id) {
		this.ingredient_id = ingredient_id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
}
