package com.jiajia.main.controller;

public interface AddressConst {

    /**
     * 调用商品中心接口地址
     */
    public static class OfferingAddress{
        //通过商品id查询产品详情接口
        public static final String convertTOProductAddress = "http://133.195.235.70:38080/product/v1/offering/getOffer?offeringId={1}&eparchyCode={2}";

        // 商品 + 触点 (佣金计算地址)
        public static final String AA = "http://133.195.235.70:38080/product/v1/offering/getOfferingCommission?touchId={1}&offeringId={2}";
        public static final String BB = "http://133.195.235.81/tpc-test/v1/tpc/light/findLightPointById?id={1}";
        public static final String CC = "http://133.193.24.68:8088/channel/webservice/doRewardPay/queryWoacount?order_no={1}&staff_id={2}";
      // public static final String CC = "http://133.193.24.68:8088/channel/webservice/doRewardPay/queryWoacount";


        public static final String productListAddress = "http://133.195.235.70:38080/product/v1/offering/queryAllOnsaleAndSoldOffer";
    }


    public static class QrCodeAddress{
        public static final String SEND_MESSAGE_ADDRESS = "http://133.195.235.79:9091/v1/sendMessage?mobile=MOBILE&message=MESSAGE";
    }
}
