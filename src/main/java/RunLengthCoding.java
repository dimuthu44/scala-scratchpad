public class RunLengthCoding {
    public static void main(String[] args) {
        System.out.println(calculate("aaaabbccc"));     // = 4a2b3c
        System.out.println(calculate("aaaabbcccaxyz")); // = 4a2b3c1a1x1y1z
    }

    public static String calculate(String code) {
        char[] charArray = code.toCharArray();
        StringBuilder builder = new StringBuilder();
        int charCounter = 1;

        for (int i = 0; i < charArray.length; i++) {
            if (i == charArray.length - 1) {
                builder.append("" + charCounter + charArray[i]);
                return builder.toString();
            } else if (charArray[i] != charArray[i + 1]) {
                builder.append("" + charCounter + charArray[i]);
                charCounter = 1;
            } else {
                charCounter++;
            }
        }

        return builder.toString();
    }
}
