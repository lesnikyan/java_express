package com.myproject.basic.oop;

import java.util.Arrays;

public class Entity {

    // Static fields
    private static String defaultName = "Defaul-Name";

    private static int[] magicNumbers;

    // Static Initialization Block
    // Do before first static usage
    static {
        magicNumbers = new int[5];
        magicNumbers[0] = 2;
        magicNumbers[1] = 3;
        magicNumbers[2] = 5;
        magicNumbers[3] = 7;
        magicNumbers[4] = 11;
    }

    public static final int versionId = 101;

    // Non-static fields
    private String name; // = defaultName;

    private String[] options = new String[]{"Init"};

    // Instance Initialization Block
    // Do before constructor
    {
        String[] defaultOptions = {"Йа кросавчег!", "Всем шампанского!"};
        initOptions(defaultOptions);
    }

    // Constructors

    public Entity(){
        this(defaultName);
    }

    public Entity(String name){
        this(name, new String[]{"Empty-init", "Last-Magic:" + magicNumbers[magicNumbers.length - 1]});
    }

    public Entity(String name, String[] options){
        this.name = name;
        initOptions(options);
    }

    // Factory method
    public static Entity getShiningInstance(String name, String[] options, String[] named){
        String[] namedOptions = new String[named.length];
        for(int i = 0; i < named.length; ++i){
            namedOptions[i] = name + "-" + named[i];
        }
        Entity entity = new Entity(name, options);
        entity.initOptions(namedOptions);
        return entity;
    }

    private void initOptions(String[] options){
        if(options.length == 0){
            return;
        }
        String[] prevOptions = this.options;
        int newOptLen = prevOptions.length + options.length;
        this.options = new String[newOptLen];
        for(int i = 0; i < prevOptions.length; ++i){
            this.options[i] = prevOptions[i];
        }
        for(int i = 0; i < options.length; ++i){
            this.options[prevOptions.length + i] = options[i];
        }
    }

    @Override
    public String toString(){
        return String.format("%s(%s, %s)", getClass().getSimpleName(), name,
                Arrays.toString(Arrays.stream(options).map(
                        s -> String.format("\"%s\"", s)).toArray()));
    }

    public static void setDefaultName(String name){
        Entity.defaultName = name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public String[] getOptions(){
        return options;
    }

    public static int[] getMagicNumbers(){
        return magicNumbers.clone();
    }

}
