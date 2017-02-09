package fr.mikrethor.cardroom.app.utils;

import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.widgets.Display;

public class ColorUtils {
    /**
     * Constructeur privé.
     */
    private ColorUtils() {
    }

    public static final Color FOND = new Color(Display.getCurrent(), 255, 255,
            255);

    public static final Color FOND_ALT = new Color(Display.getCurrent(), 228,
            237, 228);

    public static final Color MODIFIED_TEXT = new Color(Display.getCurrent(),
            162, 123, 0);

    public static final Color WHITE = new Color(Display.getCurrent(), 255, 255,
            255);

    public static final Color GREY = new Color(Display.getCurrent(), 171, 171,
            171);

    public static final Color BLACK = new Color(Display.getCurrent(), 0, 0, 0);

    public static final Color STANDARD_TEXT = new Color(Display.getCurrent(),
            0, 0, 0);

    public static final Color PLAYER_TEXT = GREY;

    public static final Color ERROR_TEXT = new Color(Display.getCurrent(), 255,
            0, 0);

    public static final Color RED_STAT = new Color(Display.getCurrent(), 255,
            0, 0);

    public static final Color GREEN_STAT = new Color(Display.getCurrent(), 0,
            255, 0);

    public static final Color ORANGE_STAT = new Color(Display.getCurrent(),
            255, 153, 51);

    public static final Color REQUIRED_FIELD_BACKGROUND = new Color(
            Display.getCurrent(), 166, 202, 240);

    public static final Color NORMAL_FIELD_BACKGROUND = new Color(
            Display.getCurrent(), 255, 255, 255);

    private static ColorUtils instance;

    public static ColorUtils getInstance() {
        if (instance == null) {
            instance = new ColorUtils();
        }
        return instance;
    }

}
