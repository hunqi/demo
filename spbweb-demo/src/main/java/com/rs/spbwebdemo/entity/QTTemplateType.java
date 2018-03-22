package com.rs.spbwebdemo.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QTTemplateType is a Querydsl query type for TTemplateType
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QTTemplateType extends EntityPathBase<TTemplateType> {

    private static final long serialVersionUID = -1635342119L;

    public static final QTTemplateType tTemplateType = new QTTemplateType("tTemplateType");

    public final DatePath<java.util.Date> cdate = createDate("cdate", java.util.Date.class);

    public final StringPath code = createString("code");

    public final StringPath creator = createString("creator");

    public final StringPath description = createString("description");

    public final DatePath<java.util.Date> edate = createDate("edate", java.util.Date.class);

    public final StringPath editor = createString("editor");

    public final ListPath<TMsgInfo, QTMsgInfo> TMsgInfos = this.<TMsgInfo, QTMsgInfo>createList("TMsgInfos", TMsgInfo.class, QTMsgInfo.class, PathInits.DIRECT2);

    public final ListPath<TTemplate, QTTemplate> TTemplates = this.<TTemplate, QTTemplate>createList("TTemplates", TTemplate.class, QTTemplate.class, PathInits.DIRECT2);

    public QTTemplateType(String variable) {
        super(TTemplateType.class, forVariable(variable));
    }

    public QTTemplateType(Path<? extends TTemplateType> path) {
        super(path.getType(), path.getMetadata());
    }

    public QTTemplateType(PathMetadata metadata) {
        super(TTemplateType.class, metadata);
    }

}

