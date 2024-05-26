package Util;

public class Util {

    /**
     * Converts a string toTitleCase for 2 words
     * ex: hello world -> Hello World
     * ex: gRey cAT -> Grey Cat
     * @param strIn the input string
     * @return the string in toTitleCase
     */
    public static String toTitleCase(String strIn) {
        if (strIn == null || strIn.isEmpty()) {
            return strIn;
        }
        String strOut = "";
        if (!strIn.contains(" ")) {
            strOut += strIn.substring(0, 1).toUpperCase();
            strOut += strIn.substring(1).toLowerCase();
            return strOut;
        }
        int spaceIdx = strIn.indexOf(" ");
        String strOut1 = strIn.substring(0, 1).toUpperCase();
        String strOut2 = strIn.substring(1, spaceIdx).toLowerCase();

        String strOut3 = strIn.substring(spaceIdx + 1, spaceIdx + 2).toUpperCase();
        String strOut4 = strIn.substring(spaceIdx + 2).toLowerCase();
        return strOut1 + strOut2 + " " + strOut3 + strOut4;
    }
}
