package com.myproject.basic;

import com.myproject.basic.annotations.*;
import static com.myproject.basic.Main.*;

import java.lang.annotation.Annotation;

public class AnnotationsDemo implements Demo {

    public void test(){
        Service serv3 = new Service03();
        Annotation[] annotations = serv3.getClass().getAnnotations();
        for(Annotation ann: annotations){
            print(ann.toString());
            print("Service name", ((CustomEntity) ann).value());
            print("Service order", ((CustomEntity) ann).order());
        }
    }
}

abstract class Service {
    public abstract void doWork();
}

@CustomEntity("First")
class Service01 extends Service {
    public void doWork(){
        //
    }
}

@CustomEntity(value="Second")
class Service02 extends Service {
    public void doWork(){
        //
    }
}

@CustomEntity(value="Serv003", order=3)
class Service03 extends Service {
    public void doWork(){
        //
    }
}
