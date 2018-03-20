/**
 * Copyright (c) 2017 www.bonc.com.cn. All Rights Reserved.
 */
package com.jiajia.main.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

/**
 * 订单详情
 *
 * @author yangwang1@bonc.com.cn
 * @version V1.0.0
 */
@Getter
@Setter
@EqualsAndHashCode
@Entity
@Table(name = "order_detail")
public class OrderDetail implements Serializable {

    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    private String id;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;
    /**
     * 销售品类型
     */
    private String classId;
    /**
     * 销售品ID
     */
    private String saleId;
    /**
     * 销售品ID 类型
     */
    private String saleIdType;
    /**
     * 销售品名称
     */
    private String saleName;
    /**
     * 订购的手机号
     */
    private String phoneNum;
    /**
     * 订单操作类型 可能值：
     * activate：新购；
     * renew：续费。
     */
    private String actionType;
    /**
     * 生效方式； 0 立即生效； 1 下月生效
     */
    private int effectiveMethod;
    /**
     * 购买周期单元。
     */
    private int periodUnit;
    /**
     * 购买周期长度。
     */
    private int periodNum;
    /**
     * 市场价
     */
    private BigDecimal marketPrice;
    /**
     * 当前价
     */
    private BigDecimal realPrice;

    /**
     * 扩展属性 序列化为字符串
     */
    private String characteristics;
    /**
     * 产品id
     */
    private String productId;
    /**
     * 产品名称
     */
    private String productName;

}
