package com.apress.springbatch.statement.domain;

public enum PricingTier {
   I(1), II(2), III(3), IV(4), UNDEFINED(0);
   
   private int value;
   
   PricingTier(int value) {
       this.value = value;
   }
   
   public int getValue() {
       return value;
   }
   
   public static PricingTier convert(int i) {
       return values()[i - 1];
   }
   
   public String toString() {
       return name();
   }
}
