public class Task4_findEquation {
    public static void main(String[] args) {
        String equation = "2? + 5? = 69";
        findEquation(equation);
    }

    public static int findAmountOfMissingDigits(String equation) {
        char[] eqArr = equation.toCharArray();
        int amount = 0;
        for (char c : eqArr) {
            if (c == '?') amount++;
        }
        return amount;
    }

    public static int[] findMissingIndexes(String equation) {
        int[] missingIndexes = new int[findAmountOfMissingDigits(equation)];
        char[] eqArr = equation.toCharArray();
        int i = 0;
        for (int j = 0; j < eqArr.length; j++) {
            if (eqArr[j] == '?') {
                missingIndexes[i] = j;
                i++;
            }
        }
        return missingIndexes;
    }
    
    public static boolean checkEquation(int firstNum, int secondNum, char op, int equal) {
        switch(op) {
            case '+':
                if (firstNum + secondNum == equal) return true;
                break;
            case '-':
                if (firstNum + secondNum == equal) return true;
                break;
            case '*':
                if (firstNum + secondNum == equal) return true;
                break;
            case '/':
                if (firstNum + secondNum == equal) return true;
                break;
            default:
                throw new Exception("Unknown operator");
        }
        return false;
    }

    public static String findEquation(String startEquation) {
        int[] missingIndexes = findMissingIndexes(startEquation);
        char[] startEqArr = startEquation.toCharArray();
        
        
    }

}