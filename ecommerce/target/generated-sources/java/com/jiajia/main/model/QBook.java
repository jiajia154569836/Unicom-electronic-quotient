package com.jiajia.main.model;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QBook is a Querydsl query type for Book
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QBook extends EntityPathBase<Book> {

    private static final long serialVersionUID = 1648576482L;

    public static final QBook book = new QBook("book");

    public final NumberPath<Integer> bookId = createNumber("bookId", Integer.class);

    public final StringPath bookName = createString("bookName");

    public final StringPath bookPrice = createString("bookPrice");

    public final DateTimePath<java.util.Date> bookTime = createDateTime("bookTime", java.util.Date.class);

    public QBook(String variable) {
        super(Book.class, forVariable(variable));
    }

    public QBook(Path<? extends Book> path) {
        super(path.getType(), path.getMetadata());
    }

    public QBook(PathMetadata metadata) {
        super(Book.class, metadata);
    }

}

