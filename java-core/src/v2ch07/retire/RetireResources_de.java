package v2ch07.retire;

import java.awt.*;

/**
 * These are the German non-string resources for retirement calculator
 */
public class RetireResources_de extends java.util.ListResourceBundle {

    private static final Object[][] contents = {
            // begin localize
            {"colorPre", Color.YELLOW},
            {"colorGain", Color.BLACK},
            {"colorLoss", Color.RED}
            //end localize
    };

    public Object[][] getContents() {
        return contents;
    }
}
