package learn.enums;

public class Test {
    public static void main(String[] args) {
        
        System.out.println(EventConst.EventTypeEnum.ORDER_DEAL_NO.name());
        System.out.println(EventConst.EventTypeEnum.ORDER_DEAL_NO.getCode());
        System.out.println(EventConst.EventTypeEnum.ORDER_DEAL_NO.getMessage());

    }
}
