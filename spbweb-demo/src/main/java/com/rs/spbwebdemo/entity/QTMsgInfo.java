package com.rs.spbwebdemo.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QTMsgInfo is a Querydsl query type for TMsgInfo
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QTMsgInfo extends EntityPathBase<TMsgInfo> {

    private static final long serialVersionUID = 228049578L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QTMsgInfo tMsgInfo = new QTMsgInfo("tMsgInfo");

    public final NumberPath<java.math.BigDecimal> batchId = createNumber("batchId", java.math.BigDecimal.class);

    public final DatePath<java.util.Date> cdate = createDate("cdate", java.util.Date.class);

    public final StringPath creator = createString("creator");

    public final DatePath<java.util.Date> edate = createDate("edate", java.util.Date.class);

    public final StringPath editor = createString("editor");

    public final StringPath homeridRa = createString("homeridRa");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath msgBody = createString("msgBody");

    public final QTStatus TStatus;

    public final QTTemplate TTemplate;

    public final QTTemplateType TTemplateType;

    public QTMsgInfo(String variable) {
        this(TMsgInfo.class, forVariable(variable), INITS);
    }

    public QTMsgInfo(Path<? extends TMsgInfo> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QTMsgInfo(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QTMsgInfo(PathMetadata metadata, PathInits inits) {
        this(TMsgInfo.class, metadata, inits);
    }

    public QTMsgInfo(Class<? extends TMsgInfo> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.TStatus = inits.isInitialized("TStatus") ? new QTStatus(forProperty("TStatus")) : null;
        this.TTemplate = inits.isInitialized("TTemplate") ? new QTTemplate(forProperty("TTemplate"), inits.get("TTemplate")) : null;
        this.TTemplateType = inits.isInitialized("TTemplateType") ? new QTTemplateType(forProperty("TTemplateType")) : null;
    }

}

