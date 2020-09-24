package com.myproject.basic.oop;

public interface InfoItem extends InfoPrintable {
   default String info(){
       return "class: " + this.getClass().getName();
   }
}
