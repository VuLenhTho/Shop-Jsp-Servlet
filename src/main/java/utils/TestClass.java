package utils;

public class TestClass {
    private String name;

    public TestClass(String name) {
        this.name = name;
    }

    public String hello(){
        if (name != null){
            return name;
        }else {
            return "hi!";
        }
    }
}
