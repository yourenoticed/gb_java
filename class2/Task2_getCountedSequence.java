public class Task2_getCountedSequence {
    public static void main(String[] args) {
        String chars = "aaabbcdddeefe";
        System.out.println(getCountedSequence(chars));
    }

    public static String getCountedSequence(String string) {
        char[] stringArr = string.toCharArray();
        StringBuilder result = new StringBuilder();
        char currentChar = stringArr[0];
        int count = 0;
        for (char c : stringArr) {
            if (c == currentChar) count++;
            else {
                result.append(currentChar);
                if (count > 1) result.append(count);
                currentChar = c; 
                count = 1;
            }
        }

        result.append(currentChar);
        if (count > 1) result.append(count);

        return result.toString();
    }
    
}