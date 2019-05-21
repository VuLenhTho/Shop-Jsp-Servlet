package model;

import java.sql.Timestamp;

public class ProductModel {
    private Long id;
    private String productName;
    private Long importPrice;
    private Long Price;
    private Long amount;
    private String createdBy;
    private Timestamp createdDate;
    private String modifiedBy;
    private Timestamp modifiedDate;
    private String thumbnail;
    private Integer sexID;
    private String status;
    private Integer subcategoryID;
    private Long discountID;
    private Integer trends;
    private Integer hotSelling;
    private Integer colorID;
    private Integer sizeID;
    private String thumbnailList;

    public ProductModel() {
    }

    public ProductModel(long id, String productName, long importPrice, long price, long amount, String createdBy, Timestamp createdDate, String modifiedBy, Timestamp modifiedDate, String thumbnail, int sexID, String status, int subcategoryID, long discountID, int trends, int hotSelling, int colorID, int sizeID, String thumbnailList) {
        this.id = id;
        this.productName = productName;
        this.importPrice = importPrice;
        Price = price;
        this.amount = amount;
        this.createdBy = createdBy;
        this.createdDate = createdDate;
        this.modifiedBy = modifiedBy;
        this.modifiedDate = modifiedDate;
        this.thumbnail = thumbnail;
        this.sexID = sexID;
        this.status = status;
        this.subcategoryID = subcategoryID;
        this.discountID = discountID;
        this.trends = trends;
        this.hotSelling = hotSelling;
        this.colorID = colorID;
        this.sizeID = sizeID;
        this.thumbnailList = thumbnailList;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Long getImportPrice() {
        return importPrice;
    }

    public void setImportPrice(Long importPrice) {
        this.importPrice = importPrice;
    }

    public Long getPrice() {
        return Price;
    }

    public void setPrice(Long price) {
        Price = price;
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public Timestamp getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Timestamp createdDate) {
        this.createdDate = createdDate;
    }

    public String getModifiedBy() {
        return modifiedBy;
    }

    public void setModifiedBy(String modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

    public Timestamp getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(Timestamp modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public Integer getSexID() {
        return sexID;
    }

    public void setSexID(Integer sexID) {
        this.sexID = sexID;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getSubcategoryID() {
        return subcategoryID;
    }

    public void setSubcategoryID(Integer subcategoryID) {
        this.subcategoryID = subcategoryID;
    }

    public Long getDiscountID() {
        return discountID;
    }

    public void setDiscountID(Long discountID) {
        this.discountID = discountID;
    }

    public Integer getTrends() {
        return trends;
    }

    public void setTrends(Integer trends) {
        this.trends = trends;
    }

    public Integer getHotSelling() {
        return hotSelling;
    }

    public void setHotSelling(Integer hotSelling) {
        this.hotSelling = hotSelling;
    }

    public Integer getColorID() {
        return colorID;
    }

    public void setColorID(Integer colorID) {
        this.colorID = colorID;
    }

    public Integer getSizeID() {
        return sizeID;
    }

    public void setSizeID(Integer sizeID) {
        this.sizeID = sizeID;
    }

    public String getThumbnailList() {
        return thumbnailList;
    }

    public void setThumbnailList(String thumbnailList) {
        this.thumbnailList = thumbnailList;
    }
}
