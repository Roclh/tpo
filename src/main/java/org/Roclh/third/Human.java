package org.Roclh.third;

import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

@Getter
public class Human {
    private String name;

    private Map<String, String> conditions;

    private final Ear leftEar;
    private final Ear rightEar;

    public Human(String name){
        this.name = name;
        this.conditions = new HashMap<>();
        this.leftEar = new Ear();
        this.rightEar = new Ear();
    }

    public void applyCondition(String name, String description){
        this.conditions.put(name, description);
    }

    public String getCondition(String key){
        return this.conditions.get(key);
    }
}
