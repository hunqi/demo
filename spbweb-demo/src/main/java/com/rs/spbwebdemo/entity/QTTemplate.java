package com.rs.spbwebdemo.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QTTemplate is a Querydsl query type for TTemplate
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QTTemplate extends EntityPathBase<TTemplate> {

    private static final long serialVersionUID = -1538048769L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QTTemplate tTemplate = new QTTemplate("tTemplate");

    public final DatePath<java.util.Date> cdate = createDate("cdate", java.util.Date.class);

    public final StringPath content = createString("content");

    public final StringPath creator = createString("creator");

    public final DatePath<java.util.Date> edate = createDate("edate", java.util.Date.class);

    public final StringPath editor = createString("editor");

    public final StringPath id = createString("id");

    public final ListPath<TMsgInfo, QTMsgInfo> TMsgInfos = this.<TMsgInfo, QTMsgInfo>createList("TMsgInfos", TMsgInfo.class, QTMsgInfo.class, PathInits.DIRECT2);

    public final QTTemplateType TTemplateType;

    public QTTemplate(String variable) {
        this(TTemplate.class, forVariable(variable), INITS);
    }

    public QTTemplate(Path<? extends TTemplate> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QTTemplate(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QTTemplate(PathMetadata metadata, PathInits inits) {
        this(TTemplate.class, metadata, inits);
    }

    public QTTemplate(Class<? extends TTemplate> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.TTemplateType = inits.isInitialized("TTemplateType") ? new QTTemplateType(forProperty("TTemplateType")) : null;
    }

}

