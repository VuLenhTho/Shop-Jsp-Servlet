package model;

public class ColorModel {
    private Integer id;
    private String colorName;

    public ColorModel() {
    }

    public ColorModel(int id, String colorName) {
        this.id = id;
        this.colorName = colorName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getColorName() {
        return colorName;
    }

    public void setColorName(String colorName) {
        this.colorName = colorName;
    }
}
