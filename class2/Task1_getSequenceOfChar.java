public class Task1_getSequenceOfChar {
    public static void main(String[] args) {
        char c1 = 'a';
        char c2 = 'b';
        System.out.println(getSequenceOfChar(4, c1, c2));
    }
    
    public static String getSequenceOfChar(int n, char c1, char c2) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) result.append(c1);
            else result.append(c2);
        }
        return result.toString();
    }
}