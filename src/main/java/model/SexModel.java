package model;

public class SexModel {
    private Integer id;
    private String sexName;

    public SexModel() {
    }

    public SexModel(int id, String sexName) {
        this.id = id;
        this.sexName = sexName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSexName() {
        return sexName;
    }

    public void setSexName(String sexName) {
        this.sexName = sexName;
    }
}
