package com.myproject.basic;

// import section

// -- standard lib
// import java.lang.*; // available by default
import java.util.Arrays; // java.* - std lib
import java.util.List;
import javax.xml.xpath.XPath; // new java packages

// inner project import
import com.myproject.basic.subpack1.SubItem;
import com.myproject.basic.subpack1.sub2.Sub2Item;

// multi import
import com.myproject.basic.sub_manyitems.*;

// static import
import static com.myproject.basic.Main.*;


public class Importing implements Demo {

    public void test(){

        // java.lang

        // imported class from javax
        XPath xpath = null;

        List<Object> items;
        // imported from sub-packages
        items = Arrays.asList(
                new SubItem(), new Sub2Item(), new Sub1(),
                new Sub2(), new Sub3(), new Sub3());

        for(Object item : items){
            printInfo(item);
        }
        innerClasses();
    }

    public void innerClasses(){
        hr(20);

        InnerClasses innerClasses = new InnerClasses();
        innerClasses.test();

        InnerClasses.StatInClass statInner = new InnerClasses.StatInClass();

        // Can use non-public class from same package,
        // but can't define two classes with same name in different files.
        print("NearItem in Main");
        NearItem nearItem = new NearItem();
        printInfo(nearItem);


        // Can't import non-main class for another package
//        com.myproject.basic.subpack1.NearItem nearSubItem = SubItem.getNear();

        // Static classes.
        InnerStatic innerStatic = new InnerStatic();
        innerStatic.test();
    }


}
