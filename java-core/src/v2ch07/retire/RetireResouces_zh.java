package v2ch07.retire;

import java.awt.*;

/**
 * These are the Chinese non-string resources for retirement calculator
 */
public class RetireResouces_zh extends java.util.ListResourceBundle {
    private static final Object[][] contents = {
            // begin localize
            {"colorPre", Color.RED},
            {"colorGain", Color.BLUE},
            {"colorLoss", Color.YELLOW}
            //end localize
    };

    public Object[][] getContents() {
        return contents;
    }
}
