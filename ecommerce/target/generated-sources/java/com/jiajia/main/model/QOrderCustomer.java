package com.jiajia.main.model;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QOrderCustomer is a Querydsl query type for OrderCustomer
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QOrderCustomer extends EntityPathBase<OrderCustomer> {

    private static final long serialVersionUID = -1023952781L;

    public static final QOrderCustomer orderCustomer = new QOrderCustomer("orderCustomer");

    public final StringPath accountNumber = createString("accountNumber");

    public final StringPath address = createString("address");

    public final StringPath certificateNumber = createString("certificateNumber");

    public final NumberPath<Integer> certificateType = createNumber("certificateType", Integer.class);

    public final StringPath cityCode = createString("cityCode");

    public final StringPath contactFixedNumber = createString("contactFixedNumber");

    public final StringPath contactNumber = createString("contactNumber");

    public final StringPath countyCode = createString("countyCode");

    public final StringPath customerName = createString("customerName");

    public final NumberPath<Integer> customerType = createNumber("customerType", Integer.class);

    public final StringPath extProperty1 = createString("extProperty1");

    public final StringPath extProperty2 = createString("extProperty2");

    public final StringPath extProperty3 = createString("extProperty3");

    public final StringPath extProperty4 = createString("extProperty4");

    public final StringPath extProperty5 = createString("extProperty5");

    public final StringPath extProperty6 = createString("extProperty6");

    public final StringPath extProperty7 = createString("extProperty7");

    public final StringPath id = createString("id");

    public final ListPath<Order, QOrder> orderList = this.<Order, QOrder>createList("orderList", Order.class, QOrder.class, PathInits.DIRECT2);

    public final StringPath postalCode = createString("postalCode");

    public final StringPath provinceCode = createString("provinceCode");

    public QOrderCustomer(String variable) {
        super(OrderCustomer.class, forVariable(variable));
    }

    public QOrderCustomer(Path<? extends OrderCustomer> path) {
        super(path.getType(), path.getMetadata());
    }

    public QOrderCustomer(PathMetadata metadata) {
        super(OrderCustomer.class, metadata);
    }

}

