package model;

public class ProductSizeModel {
    private Long productID;
    private Integer sizeID;
    private Long amount;

    public ProductSizeModel() {
    }

    public ProductSizeModel(Long productID, Integer sizeID, Long amount) {
        this.productID = productID;
        this.sizeID = sizeID;
        this.amount = amount;
    }

    public Long getProductID() {
        return productID;
    }

    public void setProductID(Long productID) {
        this.productID = productID;
    }

    public Integer getSizeID() {
        return sizeID;
    }

    public void setSizeID(Integer sizeID) {
        this.sizeID = sizeID;
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }
}
