/**
 * Copyright (c) 2017 www.bonc.com.cn. All Rights Reserved.
 */
package com.jiajia.main.model;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * 订单的入网人信息
 *
 * @author yangwang1@bonc.com.cn
 * @version V1.0.0
 */
@Data
@Entity
@Table(name = "order_customer")
public class OrderCustomer implements Serializable {

    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    private String id;

    @OneToMany(mappedBy = "customer")
    private List<Order> orderList;
    /**
     * 客户类型
     */
    private int customerType;
    /**
     * 客户名
     */
    private String customerName;
    /**
     * 联系方式
     */
    private String contactNumber;
    /**
     * 传真号码
     */
    private String contactFixedNumber;
    /**
     * 帐号
     */
    private String accountNumber;
    /**
     * 证件类型
     */
    private int certificateType;
    /**
     * 证件号
     */
    private String certificateNumber;
    /**
     * 地址
     */
    private String address;
    /**
     * 邮编
     */
    private String postalCode;
    /**
     * 省编码
     */
    private String provinceCode;
    /**
     * 市编码
     */
    private String cityCode;
    /**
     * 县编码
     */
    private String countyCode;

}
