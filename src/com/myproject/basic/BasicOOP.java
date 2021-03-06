package com.myproject.basic;

import com.myproject.basic.oop.Entity;
import com.myproject.basic.oop.Options;
import com.myproject.basic.oop.SimpleObject;

import java.lang.reflect.Type;
import java.util.Arrays;

import static com.myproject.basic.Main.print;
import static com.myproject.basic.Main.hr;

public class BasicOOP implements Demo {

    public void test(){

        Object obj = new Object();
        Class classVal = obj.getClass();
        Type t;

        SimpleObject so = new SimpleObject("Im Groot");
        SimpleObject so2 = new SimpleObject("Rembo");

        Entity defEnt = new Entity();
        Entity entityFire = new Entity("Red-Fire");
        Entity entityFire2 = new Entity("Blue-Fire", new String[]{"Temperature-10000"});
        Entity entityWater = Entity.getShiningInstance(
                "Blue-Water",
                new String[]{"Colored-Fishes"},
                new String[]{"Bubbles", "Waves"});

        Entity.setDefaultName("Anonymous-Kompot");
        Entity redefEnt = new Entity();
        Entity[] entArr = new Entity[]{defEnt, entityFire, entityFire2};
        for(Entity ent: entArr){
            printEntity(ent);
        }
        print(entityWater);
        print(redefEnt);
        print("Options: ", Options.userName, ",", Options.textColor);
    }

    public static void printEntity(Entity entity){
        print(
                String.format(
                    "Entity(%s)%s",
                    entity.getName(),
                    Arrays.toString(entity.getOptions())
                ));
    }
}


