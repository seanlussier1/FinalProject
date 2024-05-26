package Util;

public class Util {

    /**
     * Converts a string toTitleCase for 2 words
     * ex: hello world -> Hello World
     * ex: gRey cAT -> Grey Cat
     * @param str the input string
     * @return the string in toTitleCase
     */
    public static String toTitleCase(String str) {
        if (str == null || str.isEmpty()) {
            return str;
        }
        int spaceIdx = str.indexOf(" ");
        str = str.substring(0, 1).toUpperCase();
        str = str.substring(1, spaceIdx).toLowerCase();
        str = str.substring(spaceIdx + 1, spaceIdx + 2).toUpperCase();
        str = str.substring(spaceIdx + 2).toLowerCase();
        return str;
    }
}
