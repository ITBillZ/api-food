package cn.itbill.pojo;

import java.sql.Date;
import java.util.List;

public class Food {
    private Integer food_id;
    private String title;
    private String category_title;
    private String cook_name;
    private Date prod_time;
    private String valid_day;
    private String img;
    private List<Ingredient> ingredients;

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    public Integer getFood_id() {
        return food_id;
    }

    public void setFood_id(Integer food_id) {
        this.food_id = food_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCategory_title() {
        return category_title;
    }

    public void setCategory_title(String category_title) {
        this.category_title = category_title;
    }

    public String getCook_name() {
        return cook_name;
    }

    public void setCook_name(String cook_name) {
        this.cook_name = cook_name;
    }

    public Date getProd_time() {
        return prod_time;
    }

    public void setProd_time(Date prod_time) {
        this.prod_time = prod_time;
    }

    public String getValid_day() {
        return valid_day;
    }

    public void setValid_day(String valid_day) {
        this.valid_day = valid_day;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }


}
