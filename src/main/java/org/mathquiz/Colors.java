package org.mathquiz;

public class Colors {
    // Reset and Erase
    public static final String RESET = "\033[0m";          // Text Reset
    public static final String ERASE = "\033[H\033[2J";    // Clear Screen
    public static final String HIDDEN = "\033[8;30m";      // Hidden Text

    // Special Effects
    public static final String BOXING = "\033[0;51m";      // Black box around text
    public static final String TEXT_BACKGROUND = "\033[0;7m"; // Inverse background color

    // Regular Colors
    public static final String BLACK = "\033[0;30m";       // BLACK
    public static final String RED = "\033[0;31m";         // RED
    public static final String GREEN = "\033[0;32m";       // GREEN
    public static final String YELLOW = "\033[0;33m";      // YELLOW
    public static final String BLUE = "\033[0;34m";        // BLUE
    public static final String PURPLE = "\033[0;35m";      // PURPLE
    public static final String CYAN = "\033[0;36m";        // CYAN
    public static final String WHITE = "\033[0;37m";       // WHITE

    // Additional Colors
    public static final String LIGHT_PURPLE = "\033[38;2;200;0;200m";   // LIGHT PURPLE
    public static final String TEAL = "\033[38;2;0;225;221m";           // TEAL
    public static final String ORANGE = "\033[38;2;225;153;0m";         // ORANGE
    public static final String LIGHT_GREEN = "\033[38;2;136;255;0m";    // LIGHT GREEN
    public static final String LIGHT_BLUE = "\033[38;2;120;172;255m";   // LIGHT BLUE
    public static final String DARK_BLUE = "\033[38;2;72;0;255m";       // DARK BLUE
    public static final String ROSY_PINK = "\033[38;2;255;0;162m";      // ROSY PINK
    public static final String BROWN = "\033[38;2;135;82;62m";          // BROWN
    public static final String FOREST_GREEN = "\033[38;2;62;135;81m";   // FOREST GREEN
    public static final String BANANA_YELLOW = "\033[38;2;240;238;113m"; // BANANA YELLOW
    public static final String DARK_RED = "\033[38;2;145;40;16m";       // DARK RED
    public static final String LIGHT_PINK = "\033[38;2;255;153;240m";   // LIGHT PINK

    // Bold Styles
    public static final String BLACK_BOLD = "\033[1;30m";   // BLACK
    public static final String RED_BOLD = "\033[1;31m";     // RED
    public static final String GREEN_BOLD = "\033[1;32m";   // GREEN
    public static final String YELLOW_BOLD = "\033[1;33m";  // YELLOW
    public static final String BLUE_BOLD = "\033[1;34m";    // BLUE
    public static final String PURPLE_BOLD = "\033[1;35m";  // PURPLE
    public static final String CYAN_BOLD = "\033[1;36m";    // CYAN
    public static final String WHITE_BOLD = "\033[1;37m";   // WHITE

    // Italic Styles
    public static final String BLACK_ITALIC = "\033[3;30m";  // BLACK
    public static final String RED_ITALIC = "\033[3;31m";    // RED
    public static final String GREEN_ITALIC = "\033[3;32m";  // GREEN
    public static final String YELLOW_ITALIC = "\033[3;33m"; // YELLOW
    public static final String BLUE_ITALIC = "\033[3;34m";   // BLUE
    public static final String PURPLE_ITALIC = "\033[3;35m"; // PURPLE
    public static final String CYAN_ITALIC = "\033[3;36m";   // CYAN
    public static final String WHITE_ITALIC = "\033[3;37m";  // WHITE

    // Underline Styles
    public static final String BLACK_UNDERLINED = "\033[4;30m";  // BLACK
    public static final String RED_UNDERLINED = "\033[4;31m";    // RED
    public static final String GREEN_UNDERLINED = "\033[4;32m";  // GREEN
    public static final String YELLOW_UNDERLINED = "\033[4;33m"; // YELLOW
    public static final String BLUE_UNDERLINED = "\033[4;34m";   // BLUE
    public static final String PURPLE_UNDERLINED = "\033[4;35m"; // PURPLE
    public static final String CYAN_UNDERLINED = "\033[4;36m";   // CYAN
    public static final String WHITE_UNDERLINED = "\033[4;37m";  // WHITE

}
