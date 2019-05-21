package utils;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.BufferedReader;
import java.io.IOException;

public class JsonToModelUtil {
    String value;

    public JsonToModelUtil(String value) {
        this.value = value;
    }

    public static JsonToModelUtil of(BufferedReader reader){
        StringBuilder json = new StringBuilder();
        String line;
        try{
            while ((line = reader.readLine()) != null){
                json.append(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new JsonToModelUtil(json.toString());
    }

    public <T> T toModel(Class<T> tClass){
        try {
            return new ObjectMapper().readValue(this.value,tClass);
        }catch (IOException e){
            return null;
        }
    }
}
