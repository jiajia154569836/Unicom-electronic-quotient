/**
 * Copyright (c) 2018 www.bonc.com.cn. All Rights Reserved.
 */
package learn.enums;

/**
 * 描述当前功能
 *
 * @author yangwang1@bonc.com.cn
 * @version V1.0.0
 */
public interface EventConst {

    public enum EventTypeEnum {

        ORDER_DEAL_NO("0010","订单未处理"),
        ORDER_DEAL_NOW("0020","订单处理中"),
        ORDER_DEAL_RESULT_SUCCESS("0031","订单处理成功"),
        ORDER_DEAL_RESULT_FALSE("0032","订单处理失败");


        private String code;
        private String message;

        EventTypeEnum(String code, String message) {
            this.code = code;
            this.message = message;
        }

        public String getCode() {
            return code;
        }

        public String getMessage() {
            return message;
        }
    }

}
