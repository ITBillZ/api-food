package cn.itbill.pojo;

import java.sql.Date;

public class Food {
    private int id;
    private String name;
    private String cate;
    private String manufacturer;
    private Date prodDate;
    private String validTime;
    private String img;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCate() {
        return cate;
    }

    public void setCate(String cate) {
        this.cate = cate;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public Date getProdDate() {
        return prodDate;
    }

    public void setProdDate(Date prodDate) {
        this.prodDate = prodDate;
    }

    public String getValidTime() {
        return validTime;
    }

    public void setValidTime(String validTime) {
        this.validTime = validTime;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    @Override
    public String toString() {
        return "Food{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", cate='" + cate + '\'' +
                ", manufacturer='" + manufacturer + '\'' +
                ", prodDate=" + prodDate +
                ", validTime='" + validTime + '\'' +
                ", img='" + img + '\'' +
                '}';
    }
}
