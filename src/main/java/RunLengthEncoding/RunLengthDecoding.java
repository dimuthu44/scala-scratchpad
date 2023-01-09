package RunLengthEncoding;

public class RunLengthDecoding {
    public static void main(String args[]) {
		System.out.println(doReverse("4a2b3c1a"));
    }

    static String doReverse(String input) {
        char array[] = input.toCharArray();
        int counter = 0;
        char character = '_';
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < input.length(); i++) {
            if (i % 2 == 0) {
                counter = Integer.parseInt(String.valueOf(array[i])); // 4
            } else {
                character = array[i]; // a
                stringBuilder.append(appendLength(counter, character));
            }
        }

        return stringBuilder.toString();
    }

    static String appendLength(int counter, char character) { // 4, a
    	StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < counter; i++) { // 0, 1, 2, 3
            stringBuilder.append(character);
        }
        return stringBuilder.toString();
    }
}
