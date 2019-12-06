package com.henu.ssm.dto;

/**
 * @author shkstart
 * @create 2019-09-29 13:44
 */
public class OrderFormDTO {
    private String productId;
    private String productQuantity;

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductQuantity() {
        return productQuantity;
    }

    public void setProductQuantity(String productQuantity) {
        this.productQuantity = productQuantity;
    }

    @Override
    public String toString() {
        return "OrderFormDTO{" +
                "productId='" + productId + '\'' +
                ", productQuantity='" + productQuantity + '\'' +
                '}';
    }

}

