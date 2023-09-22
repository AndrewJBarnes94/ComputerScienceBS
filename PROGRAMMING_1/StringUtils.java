public class StringUtils {

    public static void main(String[] args) {
        String[] words = {"apple", "banana", "cherry", "orange"};
        String longestWord = StringUtils.findLongestWord(words);
        System.out.println("The longest word is: " + longestWord);
    }

    public static String findLongestWord(String[] words) {
        if (words == null || words.length == 0) {
            throw new IllegalArgumentException("Input array is empty or null.");
        }

        String longestWord = "";
        for (String word : words) {
            if (word.length() > longestWord.length()) {
                longestWord = word;
            }
        }
        return longestWord;
    }
}

