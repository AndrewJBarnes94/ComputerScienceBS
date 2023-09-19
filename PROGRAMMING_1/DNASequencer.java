import java.util.*;

public class DNASequencer {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Get the DNA sequence from the user
        System.out.println("Enter the DNA sequence (using A, T, C, and G):");
        String dnaSequence = scanner.nextLine();

        // Validate the sequence
        if (isValidDNASequence(dnaSequence)) {
            // Convert the sequence to an array and print
            char[] dnaArray = dnaSequence.toCharArray();
            System.out.println("DNA sequence stored: " + Arrays.toString(dnaArray));
            
            // Count the occurrences of each base
            countBases(dnaArray);
        } else {
            System.out.println("Invalid DNA sequence!");
        }
    }

    private static boolean isValidDNASequence(String sequence) {
        for (char ch : sequence.toCharArray()) {
            if (ch != 'A' && ch != 'T' && ch != 'C' && ch != 'G') {
                return false;
            }
        }
        return true;
    }

    private static void countBases(char[] dnaArray) {
        Map<Character, Integer> baseCounts = new HashMap<>();
        for (char base : dnaArray) {
            baseCounts.put(base, baseCounts.getOrDefault(base, 0) + 1);
        }
        for (Map.Entry<Character, Integer> entry : baseCounts.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue() + " occurrences");
        }
    }
}
