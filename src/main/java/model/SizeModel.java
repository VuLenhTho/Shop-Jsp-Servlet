package model;

public class SizeModel {
    private Integer id;
    private String sizeName;

    public SizeModel() {
    }

    public SizeModel(int id, String sizeName) {
        this.id = id;
        this.sizeName = sizeName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSizeName() {
        return sizeName;
    }

    public void setSizeName(String sizeName) {
        this.sizeName = sizeName;
    }
}
