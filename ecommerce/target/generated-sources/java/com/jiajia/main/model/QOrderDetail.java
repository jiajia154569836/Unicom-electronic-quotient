package com.jiajia.main.model;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QOrderDetail is a Querydsl query type for OrderDetail
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QOrderDetail extends EntityPathBase<OrderDetail> {

    private static final long serialVersionUID = -349212122L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QOrderDetail orderDetail = new QOrderDetail("orderDetail");

    public final StringPath actionType = createString("actionType");

    public final StringPath characteristics = createString("characteristics");

    public final StringPath classId = createString("classId");

    public final NumberPath<Integer> effectiveMethod = createNumber("effectiveMethod", Integer.class);

    public final StringPath extProperty7 = createString("extProperty7");

    public final StringPath id = createString("id");

    public final NumberPath<java.math.BigDecimal> marketPrice = createNumber("marketPrice", java.math.BigDecimal.class);

    public final QOrder order;

    public final NumberPath<Integer> periodNum = createNumber("periodNum", Integer.class);

    public final NumberPath<Integer> periodUnit = createNumber("periodUnit", Integer.class);

    public final StringPath phoneNum = createString("phoneNum");

    public final StringPath productId = createString("productId");

    public final StringPath productName = createString("productName");

    public final NumberPath<java.math.BigDecimal> realPrice = createNumber("realPrice", java.math.BigDecimal.class);

    public final StringPath saleId = createString("saleId");

    public final StringPath saleIdType = createString("saleIdType");

    public final StringPath saleName = createString("saleName");

    public QOrderDetail(String variable) {
        this(OrderDetail.class, forVariable(variable), INITS);
    }

    public QOrderDetail(Path<? extends OrderDetail> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QOrderDetail(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QOrderDetail(PathMetadata metadata, PathInits inits) {
        this(OrderDetail.class, metadata, inits);
    }

    public QOrderDetail(Class<? extends OrderDetail> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.order = inits.isInitialized("order") ? new QOrder(forProperty("order"), inits.get("order")) : null;
    }

}

