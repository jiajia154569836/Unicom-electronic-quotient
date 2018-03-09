package com.jiajia.main.model;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QGoodTypeBean is a Querydsl query type for GoodTypeBean
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QGoodTypeBean extends EntityPathBase<GoodTypeBean> {

    private static final long serialVersionUID = -1300012435L;

    public static final QGoodTypeBean goodTypeBean = new QGoodTypeBean("goodTypeBean");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final NumberPath<Integer> isShow = createNumber("isShow", Integer.class);

    public final StringPath name = createString("name");

    public final NumberPath<Integer> order = createNumber("order", Integer.class);

    public QGoodTypeBean(String variable) {
        super(GoodTypeBean.class, forVariable(variable));
    }

    public QGoodTypeBean(Path<? extends GoodTypeBean> path) {
        super(path.getType(), path.getMetadata());
    }

    public QGoodTypeBean(PathMetadata metadata) {
        super(GoodTypeBean.class, metadata);
    }

}

