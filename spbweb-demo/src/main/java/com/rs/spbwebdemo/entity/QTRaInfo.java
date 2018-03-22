package com.rs.spbwebdemo.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QTRaInfo is a Querydsl query type for TRaInfo
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QTRaInfo extends EntityPathBase<TRaInfo> {

    private static final long serialVersionUID = -1391000254L;

    public static final QTRaInfo tRaInfo = new QTRaInfo("tRaInfo");

    public final DatePath<java.util.Date> cdate = createDate("cdate", java.util.Date.class);

    public final StringPath creator = createString("creator");

    public final DatePath<java.util.Date> edate = createDate("edate", java.util.Date.class);

    public final StringPath editor = createString("editor");

    public final StringPath homeridDsm = createString("homeridDsm");

    public final StringPath homeridRa = createString("homeridRa");

    public final StringPath nameDsm = createString("nameDsm");

    public final StringPath nameRa = createString("nameRa");

    public final StringPath textEmailAddress = createString("textEmailAddress");

    public QTRaInfo(String variable) {
        super(TRaInfo.class, forVariable(variable));
    }

    public QTRaInfo(Path<? extends TRaInfo> path) {
        super(path.getType(), path.getMetadata());
    }

    public QTRaInfo(PathMetadata metadata) {
        super(TRaInfo.class, metadata);
    }

}

