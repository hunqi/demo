package org.rs.exercise.pojo;

import lombok.Data;
import lombok.ToString;

import java.util.Date;

@Data
@ToString
public class DataModelVO {
    private String name;
    private String code;
    private String creator;
    private Date createTime;
}
