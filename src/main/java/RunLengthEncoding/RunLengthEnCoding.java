package RunLengthEncoding;

public class RunLengthEnCoding {
    public static void main(String[] args) {
        System.out.println(calculate("aaaabbccc"));     // = 4a2b3c
        System.out.println(calculate("aaaabbcccaxyz")); // = 4a2b3c1a1x1y1z
    }

    public static String calculate(String code) {
        char[] charArray = code.toCharArray(); //TODO: need validation for the input NPE
        StringBuilder builder = new StringBuilder();
        int charCounter = 1;

        for (int i = 0; i < charArray.length; i++) {                                // i = 0 - 9;
            if (i == charArray.length - 1 || charArray[i] != charArray[i + 1]) {    // i = 0  ->  0 == 8 || a != a  -> 2
                builder.append(charCounter).append(charArray[i]);                   // i = 1  ->  1 == 8 || a != a  -> 3
                charCounter = 1;                                                    //
            } else {
                charCounter++;
            }
        }

        return builder.toString();
    }
}
