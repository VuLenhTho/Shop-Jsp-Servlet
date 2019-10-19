package model;

public class ProductColorModel {
    private Long productID;
    private Integer colorID;
    private Long amount;

    public ProductColorModel() {
    }

    public ProductColorModel(Long productID, Integer colorID, Long amount) {
        this.productID = productID;
        this.colorID = colorID;
        this.amount = amount;
    }

    public Long getProductID() {
        return productID;
    }

    public void setProductID(Long productID) {
        this.productID = productID;
    }

    public Integer getColorID() {
        return colorID;
    }

    public void setColorID(Integer colorID) {
        this.colorID = colorID;
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }
}
