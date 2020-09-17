package com.myproject.basic.subpack1;

import com.myproject.basic.sub_manyitems.BaseSubItem;
import static com.myproject.basic.Main.printInfo;
import static com.myproject.basic.Main.print;

public class SubItem extends BaseSubItem {

    public static NearItem getNear(){
        return new NearItem();
    }

    public void testNear(){
        NearItem nearItem = new NearItem();
        print("NearItem in SubItem");
        printInfo(nearItem);
    }
}

class NearItem {

}