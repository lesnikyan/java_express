package com.myproject.basic;

import com.myproject.basic.oop.Entity;

import java.util.Arrays;

import static com.myproject.basic.Main.print;
import static com.myproject.basic.Main.hr;

public class BasicOOP {
    public void test(){
        hr(40);
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


