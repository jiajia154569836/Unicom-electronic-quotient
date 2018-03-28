/**
 * Copyright (c) 2018 www.bonc.com.cn. All Rights Reserved.
 */
package com.jiajia.flow.flow.entity;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 订单和流程的关系表
 *
 * @author yangwang1@bonc.com.cn
 * @version V1.0.0
 */
@Entity
@Table(name = "oc_order_flow_instance_rel")
@Data
public class OrderFlowInstanceRel implements Serializable {

    /**
     * 主键
     */
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    private String id;
    /**
     * 订单ID
     */
    private String orderId;
    /**
     * 订单号
     */
    private String orderNum;
    /**
     * 订单类型
     */
    private String orderType;
    /**
     * 流程定义的KEY
     */
    private String processKey;
    /**
     * 流程名
     */
    private String processInstanceId;
    /**
     * 是否可用， true 可用， false 禁用
     */
    private boolean available;
    /**
     * 创建时间
     */
    private LocalDateTime createTime;
    /**
     * 创建人
     */
    private String creator;
    /**
     * 更新时间
     */
    private LocalDateTime updateTime;
    /**
     * 更新人
     */
    private String modifier;

}
