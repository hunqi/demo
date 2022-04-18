package org.rs.exercise.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.rs.exercise.pojo.DataModelVO;
import org.rs.exercise.xml.PdmParser;

import java.io.File;

public class PdmParserTest {

    @Test
    void shouldParseCorrectly(){
        File file = new File("doc/data_model_management.pdm");

        DataModelVO dataModelVO = PdmParser.parse(file);

        Assertions.assertNotNull(dataModelVO.getName());
        Assertions.assertNotNull(dataModelVO.getCode());
        Assertions.assertNotNull(dataModelVO.getCreator());
        Assertions.assertNotNull(dataModelVO.getCreateTime());
    }

}
