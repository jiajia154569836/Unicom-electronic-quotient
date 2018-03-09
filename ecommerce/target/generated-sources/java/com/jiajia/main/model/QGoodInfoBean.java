package com.jiajia.main.model;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QGoodInfoBean is a Querydsl query type for GoodInfoBean
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QGoodInfoBean extends EntityPathBase<GoodInfoBean> {

    private static final long serialVersionUID = -445751839L;

    public static final QGoodInfoBean goodInfoBean = new QGoodInfoBean("goodInfoBean");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final NumberPath<Integer> order = createNumber("order", Integer.class);

    public final NumberPath<Double> price = createNumber("price", Double.class);

    public final StringPath title = createString("title");

    public final NumberPath<Long> typeId = createNumber("typeId", Long.class);

    public final StringPath unit = createString("unit");

    public QGoodInfoBean(String variable) {
        super(GoodInfoBean.class, forVariable(variable));
    }

    public QGoodInfoBean(Path<? extends GoodInfoBean> path) {
        super(path.getType(), path.getMetadata());
    }

    public QGoodInfoBean(PathMetadata metadata) {
        super(GoodInfoBean.class, metadata);
    }

}

