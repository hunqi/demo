package com.rs.spbwebdemo.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QTReportType is a Querydsl query type for TReportType
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QTReportType extends EntityPathBase<TReportType> {

    private static final long serialVersionUID = 31261139L;

    public static final QTReportType tReportType = new QTReportType("tReportType");

    public final DatePath<java.util.Date> cdate = createDate("cdate", java.util.Date.class);

    public final StringPath creator = createString("creator");

    public final StringPath description = createString("description");

    public final DatePath<java.util.Date> edate = createDate("edate", java.util.Date.class);

    public final StringPath editor = createString("editor");

    public final StringPath reportCode = createString("reportCode");

    public final ListPath<TRaBonusSalesStatus, QTRaBonusSalesStatus> TRaBonusSalesStatuses = this.<TRaBonusSalesStatus, QTRaBonusSalesStatus>createList("TRaBonusSalesStatuses", TRaBonusSalesStatus.class, QTRaBonusSalesStatus.class, PathInits.DIRECT2);

    public QTReportType(String variable) {
        super(TReportType.class, forVariable(variable));
    }

    public QTReportType(Path<? extends TReportType> path) {
        super(path.getType(), path.getMetadata());
    }

    public QTReportType(PathMetadata metadata) {
        super(TReportType.class, metadata);
    }

}

