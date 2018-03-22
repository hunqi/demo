package com.rs.spbwebdemo.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QTStatus is a Querydsl query type for TStatus
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QTStatus extends EntityPathBase<TStatus> {

    private static final long serialVersionUID = -1344102985L;

    public static final QTStatus tStatus = new QTStatus("tStatus");

    public final DatePath<java.util.Date> cdate = createDate("cdate", java.util.Date.class);

    public final StringPath creator = createString("creator");

    public final StringPath description = createString("description");

    public final DatePath<java.util.Date> edate = createDate("edate", java.util.Date.class);

    public final StringPath editor = createString("editor");

    public final NumberPath<Long> statusCode = createNumber("statusCode", Long.class);

    public final ListPath<TMsgInfo, QTMsgInfo> TMsgInfos = this.<TMsgInfo, QTMsgInfo>createList("TMsgInfos", TMsgInfo.class, QTMsgInfo.class, PathInits.DIRECT2);

    public final ListPath<TRaBonusSalesStatus, QTRaBonusSalesStatus> TRaBonusSalesStatuses = this.<TRaBonusSalesStatus, QTRaBonusSalesStatus>createList("TRaBonusSalesStatuses", TRaBonusSalesStatus.class, QTRaBonusSalesStatus.class, PathInits.DIRECT2);

    public QTStatus(String variable) {
        super(TStatus.class, forVariable(variable));
    }

    public QTStatus(Path<? extends TStatus> path) {
        super(path.getType(), path.getMetadata());
    }

    public QTStatus(PathMetadata metadata) {
        super(TStatus.class, metadata);
    }

}

