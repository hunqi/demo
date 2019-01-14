package v2ch07.retire;

import java.awt.*;

/**
 * These are the English non-string resources for retirement calculator
 */
public class RetireResources extends java.util.ListResourceBundle {

    private static final Object[][] contents = {
            // begin localize
            {"colorPre", Color.BLUE},
            {"colorGain", Color.WHITE},
            {"colorLoss", Color.RED}
            //end localize
    };

    public Object[][] getContents() {
        return contents;
    }
}
