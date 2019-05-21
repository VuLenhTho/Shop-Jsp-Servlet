package model;

public class SubcategoryModel {
    private Integer id;
    private Integer categoryID;
    private String subcategoryName;

    public SubcategoryModel() {
    }

    public SubcategoryModel(int id, int categoryID, String subcategoryName) {
        this.id = id;
        this.categoryID = categoryID;
        this.subcategoryName = subcategoryName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(Integer categoryID) {
        this.categoryID = categoryID;
    }

    public String getSubcategoryName() {
        return subcategoryName;
    }

    public void setSubcategoryName(String subcategoryName) {
        this.subcategoryName = subcategoryName;
    }
}
