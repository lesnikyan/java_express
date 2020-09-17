package com.myproject.basic;

public interface InfoItem extends InfoPrintable {
   default String info(){
       return "class: " + this.getClass().getName();
   }
}
