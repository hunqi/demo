package com.rs.spbwebdemo.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QTRaBonusSalesStatus is a Querydsl query type for TRaBonusSalesStatus
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QTRaBonusSalesStatus extends EntityPathBase<TRaBonusSalesStatus> {

    private static final long serialVersionUID = -814088941L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QTRaBonusSalesStatus tRaBonusSalesStatus = new QTRaBonusSalesStatus("tRaBonusSalesStatus");

    public final DatePath<java.util.Date> cdate = createDate("cdate", java.util.Date.class);

    public final StringPath creator = createString("creator");

    public final DatePath<java.util.Date> edate = createDate("edate", java.util.Date.class);

    public final StringPath editor = createString("editor");

    public final StringPath homeridRa = createString("homeridRa");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final DatePath<java.util.Date> lastDMonth = createDate("lastDMonth", java.util.Date.class);

    public final QTReportType TReportType;

    public final QTStatus TStatus;

    public QTRaBonusSalesStatus(String variable) {
        this(TRaBonusSalesStatus.class, forVariable(variable), INITS);
    }

    public QTRaBonusSalesStatus(Path<? extends TRaBonusSalesStatus> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QTRaBonusSalesStatus(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QTRaBonusSalesStatus(PathMetadata metadata, PathInits inits) {
        this(TRaBonusSalesStatus.class, metadata, inits);
    }

    public QTRaBonusSalesStatus(Class<? extends TRaBonusSalesStatus> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.TReportType = inits.isInitialized("TReportType") ? new QTReportType(forProperty("TReportType")) : null;
        this.TStatus = inits.isInitialized("TStatus") ? new QTStatus(forProperty("TStatus")) : null;
    }

}

