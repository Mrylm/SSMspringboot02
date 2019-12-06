package com.henu.ssm.dto;/**
 * Created by Administrator on 2019/9/24 0024.
 */

/**
 * 该类用于封装部分商品信息，并转换成json，与
 {
 "id": "123456",
 "name": "皮蛋粥",
 "price": 1.2,
 "description": "好吃的皮蛋粥",
 "icon": "http://xxx.com",
 }
 对应。
 * @author Administrator
 * @date 2019/9/24 0024 16:47
 * @description
 */
public class ProductDTO {
    public String id;
    public String name;
    public Double price;
    public String description;
    public String icon;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "ProductDTO{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", description='" + description + '\'' +
                ", icon='" + icon + '\'' +
                '}';
    }
}
