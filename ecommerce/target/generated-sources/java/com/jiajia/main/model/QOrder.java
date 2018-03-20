package com.jiajia.main.model;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QOrder is a Querydsl query type for Order
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QOrder extends EntityPathBase<Order> {

    private static final long serialVersionUID = -421652107L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QOrder order = new QOrder("order1");

    public final StringPath assignReason = createString("assignReason");

    public final NumberPath<Integer> bizStatus = createNumber("bizStatus", Integer.class);

    public final StringPath channel = createString("channel");

    public final StringPath characteristics = createString("characteristics");

    public final DateTimePath<java.time.LocalDateTime> checkDate = createDateTime("checkDate", java.time.LocalDateTime.class);

    public final BooleanPath checkFlag = createBoolean("checkFlag");

    public final DateTimePath<java.time.LocalDateTime> completedDate = createDateTime("completedDate", java.time.LocalDateTime.class);

    public final StringPath consigneeAddress = createString("consigneeAddress");

    public final StringPath consigneeCityCode = createString("consigneeCityCode");

    public final StringPath consigneeCountyCode = createString("consigneeCountyCode");

    public final StringPath consigneeMobile = createString("consigneeMobile");

    public final StringPath consigneeName = createString("consigneeName");

    public final StringPath consigneeProvinceCode = createString("consigneeProvinceCode");

    public final QOrderCustomer customer;

    public final StringPath extProperty1 = createString("extProperty1");

    public final StringPath extProperty2 = createString("extProperty2");

    public final StringPath extProperty3 = createString("extProperty3");

    public final StringPath extProperty4 = createString("extProperty4");

    public final StringPath extProperty5 = createString("extProperty5");

    public final StringPath extProperty6 = createString("extProperty6");

    public final StringPath extProperty7 = createString("extProperty7");

    public final StringPath gridId = createString("gridId");

    public final StringPath gridName = createString("gridName");

    public final BooleanPath hasSubOrder = createBoolean("hasSubOrder");

    public final StringPath iccid = createString("iccid");

    public final StringPath id = createString("id");

    public final StringPath imsi = createString("imsi");

    public final StringPath lightTouchId = createString("lightTouchId");

    public final BooleanPath mainOrder = createBoolean("mainOrder");

    public final StringPath money = createString("money");

    public final StringPath openNumber = createString("openNumber");

    public final DateTimePath<java.time.LocalDateTime> orderDate = createDateTime("orderDate", java.time.LocalDateTime.class);

    public final ListPath<OrderDetail, QOrderDetail> orderDetailList = this.<OrderDetail, QOrderDetail>createList("orderDetailList", OrderDetail.class, QOrderDetail.class, PathInits.DIRECT2);

    public final StringPath orderNum = createString("orderNum");

    public final StringPath orderType = createString("orderType");

    public final QOrder parent;

    public final StringPath provOrderId = createString("provOrderId");

    public final StringPath qrId = createString("qrId");

    public final StringPath reason = createString("reason");

    public final StringPath refereeDepartNo = createString("refereeDepartNo");

    public final StringPath refereeNo = createString("refereeNo");

    public final StringPath saleIds = createString("saleIds");

    public final StringPath saleNames = createString("saleNames");

    public final StringPath salePhoneNum = createString("salePhoneNum");

    public final StringPath staffDepartNo = createString("staffDepartNo");

    public final StringPath staffNo = createString("staffNo");

    public final StringPath standardAddress = createString("standardAddress");

    public final StringPath standardAddressId = createString("standardAddressId");

    public final ListPath<Order, QOrder> subOrderList = this.<Order, QOrder>createList("subOrderList", Order.class, QOrder.class, PathInits.DIRECT2);

    public final StringPath thirdNo = createString("thirdNo");

    public final StringPath touchId = createString("touchId");

    public final StringPath transitionId = createString("transitionId");

    public final DateTimePath<java.time.LocalDateTime> updateDate = createDateTime("updateDate", java.time.LocalDateTime.class);

    public final StringPath userId = createString("userId");

    public final BooleanPath validFlag = createBoolean("validFlag");

    public QOrder(String variable) {
        this(Order.class, forVariable(variable), INITS);
    }

    public QOrder(Path<? extends Order> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QOrder(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QOrder(PathMetadata metadata, PathInits inits) {
        this(Order.class, metadata, inits);
    }

    public QOrder(Class<? extends Order> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.customer = inits.isInitialized("customer") ? new QOrderCustomer(forProperty("customer")) : null;
        this.parent = inits.isInitialized("parent") ? new QOrder(forProperty("parent"), inits.get("parent")) : null;
    }

}

