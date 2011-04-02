package com.apress.springbatch.statement.domain;

public enum PricingTier {
   UNDEFINED(0), I(1), II(2), III(3), IV(4);
   
   private int value;
   
   PricingTier(int value) {
       this.value = value;
   }
   
   public int getValue() {
       return value;
   }
   
   public static PricingTier convert(Integer i) {
       if(i != null && i >= 0) {
           return values()[i];
       } else {
           return UNDEFINED;
       }
   }
   
   public String toString() {
       return name();
   }
}
