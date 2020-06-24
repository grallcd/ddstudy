package com.ddstudy.strategy;

public enum PayType {

    ALIPAY {
        @Override
        public void pay() {
            System.out.println("Pay by AliPay");
        }
    },

    WXPAY {
        @Override
        public void pay() {
            System.out.println("Pay by WxPay");
        }
    },

    CASHPAY {
        @Override
        public void pay() {
            System.out.println("Pay by Cash");
        }
    };

    public abstract void pay();
}
