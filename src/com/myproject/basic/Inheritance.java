package com.myproject.basic;

import static com.myproject.basic.Main.print;

public final class Inheritance implements Demo {
    public void test(){
        Admin vova = new Admin("Vova Vovochkin", 1);
        print(vova);

        BaseUser userBob = new BaseUser("Bob");
        print(userBob);

        BaseUser customGrom = new BaseUser("Gromozeka"){
            {
                extInfo = "Планета Шелезяка населена роботами";
            }
        };
        print(customGrom);
    }
}

interface Informable {
    String info();
}

interface Printable {
    void print();
}

interface InformPrintable extends Informable, Printable {

}

abstract class Somebody {

    protected String name;

    // Abstract method
    public abstract String someInfo();

    public String getName(){
        return name;
    }
}

abstract class SomeUser extends Somebody implements InformPrintable {

    // Real method but still uses abstract method inside
    public String someInfo(){
        return info();
    }
}

class BaseUser extends SomeUser {

    String extInfo = null;

    public BaseUser(String name){
        this.name = name;
    }

    @Override
    public String info() {
        String ext = extInfo == null ? "" :  String.format("[%s]", extInfo);
        return String.format("User(%s)%s", name, ext);
    }

    @Override
    public void print() {
        System.out.println(info());
    }
}

class Admin extends BaseUser {

    private int accessLevel = 0;

    public Admin(String name, int accessLevel){
        super(name);
        this.accessLevel = accessLevel;
        extInfo = String.format("lvl=%d", accessLevel);
    }

    final public int getAccessLevel(){
        return accessLevel;
    }
}


