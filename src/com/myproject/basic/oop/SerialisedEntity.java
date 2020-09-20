package com.myproject.basic.oop;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class SerialisedEntity implements Serializable {

    public final static long serialVersionId = 1;

    private String name;

    private List<EntOption<?>> options = new ArrayList<>();

    public SerialisedEntity(String name){
        this.name = name;
    }

    public void addOption(EntOption<?> opt){
        options.add(opt);
    }

    public String toString(){
        StringBuilder sb = new StringBuilder(String.format("SerialisedEntity(%s)", name));
        for(EntOption opt: options){
            sb.append(
                    String.format("\n\t[%s: %s(%s)]",
                            opt.name,
                            opt.value.getClass().getSimpleName(),
                            opt.value.toString()));
        }
        return sb.toString();
    }

    // inner static class
    public static class EntOption <T> implements Serializable {

        String name;

        T value;

        public EntOption(String name, T value){
            this.name = name;
            this.value = value;
        }
    }
}

