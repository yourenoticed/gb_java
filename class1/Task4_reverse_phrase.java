public class Task4_reverse_phrase {
    public static void main(String[] args) {
        String phrase = "Добро пожаловать на скучный курс по Java";
        String reveredPhrase = reversePhrase(phrase);
        System.out.println(reveredPhrase);
    }

    public static String reversePhrase(String phrase) {
        String[] phraseArr = phrase.split(" ");
        for (int i = 0; i < phraseArr.length / 2; i++) {
            swap(phraseArr, i, (phraseArr.length - 1  - i));
        }

        StringBuilder resultPhrase = new StringBuilder();
        for (String string : phraseArr) {
            resultPhrase.append(string + " ");
        }
        
        return resultPhrase.toString();
    }

    public static void swap(String[] arr, int swappedIndexL, int swappedIndexR) {
        String temp = arr[swappedIndexL];
        arr[swappedIndexL] = arr[swappedIndexR];
        arr[swappedIndexR] = temp;
    }
}