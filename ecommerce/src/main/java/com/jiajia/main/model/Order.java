package com.jiajia.main.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

import static javax.persistence.FetchType.LAZY;

/**
 * 订单主表
 *
 * @author yangwang1@bonc.com.cn
 * @version V1.0.0
 */
@Getter
@Setter
@EqualsAndHashCode
@Entity
@Table(name = "order_info")
public class Order implements Serializable {

    /**
     * 订单ID
     */
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    private String id;
    /**
     * 唯一请求识别码。
     */
    private String transitionId;
    /**
     * 订单号
     */
    private String orderNum;

    private String userId;
    /**
     * 订单类型
     */
    private String orderType;
    /**
     * 订单结算时间。
     */
    private LocalDateTime checkDate;
    /**
     * 订单状态
     */
    private int bizStatus;
    /**
     * 更新时间。
     */
    private LocalDateTime updateDate;

    /**
     * 完成时间
     */
    private LocalDateTime completedDate;
    /**
     * 操作员员工号
     */
    private String staffNo;
    /**
     * 部门编号
     */
    private String staffDepartNo;
    /**
     * 发展人员工号
     */
    private String refereeNo;
    /**
     * 部门编号
     */
    private String refereeDepartNo;

    @OneToMany(mappedBy = "order", cascade = CascadeType.PERSIST, fetch = LAZY)
    private List<OrderDetail> orderDetailList;

    @ManyToOne(cascade = CascadeType.PERSIST, fetch = LAZY)
    @JoinColumn(name = "customer_id")
    private OrderCustomer customer;

    @Override
    public String toString() {
        return "Order{" +
                "id='" + id + '\'' +
                ", transitionId='" + transitionId + '\'' +
                ", orderNum='" + orderNum + '\'' +
                ", userId='" + userId + '\'' +
                ", orderType='" + orderType + '\'' +
                ", checkDate=" + checkDate +
                ", bizStatus=" + bizStatus +
                ", updateDate=" + updateDate +
                ", completedDate=" + completedDate +
                ", staffNo='" + staffNo + '\'' +
                ", refereeNo='" + refereeNo + '\'' +
                '}';
    }
}
