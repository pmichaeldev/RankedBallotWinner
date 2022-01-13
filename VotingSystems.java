import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;

public class VotingSystems {

    public static void main(String[] args) throws Exception {
        // Plurality Test Cases
        final var sample = Map.of(List.of("A", "B", "C"), 4, List.of("B", "C", "A"), 3, List.of("C", "B", "A"), 2);
        final var sample2 = Map.of(List.of("B", "A", "C"), 4, List.of("A", "C", "B"), 4, List.of("C", "B", "A"), 2);
        final var sample3 = Map.of(List.of("a", "b", "c"), 4, List.of("B", "C", "A"), 3, List.of("C", "B", "A"), 2);
        final var sample4 = Map.of(List.of("A", "B", "C"), 2, List.of("B", "C", "A"), 4, List.of("C", "B", "A"), 4);
        final var sample5 = Map.of(List.of("A", "B", "C"), 1, List.of("B", "C", "A"), 1, List.of("C", "B", "A"), 1);

        final Map<List<String>, Integer> case1 = new HashMap<>();
        case1.put(Arrays.asList("A", "B", "C"), 2);
        case1.put(Arrays.asList("A", "C", "B"), 2);
        case1.put(Arrays.asList("B", "A", "C"), 3);
        final Map<List<String>, Integer> case2 = new HashMap<>();
        case2.put(Arrays.asList("B", "A"), 2);
        case2.put(Arrays.asList("A", "B"), 2);

        // 1A Cases
        System.out.println("The plurality winner for sample is: " + getPluralityWinner(sample));
        System.out.println("The plurality winner for sample 2 is: " + getPluralityWinner(sample2));
        System.out.println("The plurality winner for sample 3 is: " + getPluralityWinner(sample3));
        System.out.println("The plurality winner for sample 4 is: " + getPluralityWinner(sample4));
        System.out.println("The plurality winner for sample 5 is: " + getPluralityWinner(sample5));

        // 1B Cases
        System.out.println("The plurality winner for case 1 is: " + getPluralityWinner(case1));
        System.out.println("The plurality winner for case 2 is: " + getPluralityWinner(case2));

        // Ranked Ballot Test Cases
        final var sample6 = Map.of(List.of("A", "B", "C"), 5, List.of("B", "C", "A"), 3, List.of("C", "B", "A"), 1);
        final var sample7 = Map.of(List.of("A", "B", "C"), 5, List.of("B", "C", "A"), 3, List.of("C", "B", "A"), 2);
        final var sample8 = Map.of(List.of("A", "B", "C", "D"), 4, List.of("B", "C", "A", "D"), 3,
                List.of("C", "B", "A", "D"), 2);
        final var sample9 = Map.of(List.of("A", "B", "C", "D"), 4, List.of("B", "C", "A", "D"), 3,
                List.of("C", "B", "A", "D"), 2, List.of("D", "B", "C", "D"), 5);
        final var sample10 = Map.of(List.of("A", "B", "C", "D"), 4, List.of("B", "C", "A", "D"), 3,
                List.of("C", "B", "A", "D"), 2, List.of("D"), 1);
        final var sample11 = Map.of(List.of("Alex", "Ben", "Cory", "Dan"), 4, List.of("Ben", "Cory", "Alex", "Dan"), 3,
                List.of("Cory", "Ben", "Alex", "Dan"), 2, List.of("Dan"), 1);
        final var sample12 = Map.of(List.of("A", "B", "C", "D", "E"), 5, List.of("B", "C", "A", "D", "E"), 4,
                List.of("C", "A", "B", "D", "E"), 3);
        
        final Map<List<String>, Integer> case3 = new HashMap<>();
        case3.put(Arrays.asList("A", "B", "C"), 2);
        case3.put(Arrays.asList("A", "C", "B"), 2);
        case3.put(Arrays.asList("B", "A", "C"), 3);

        final Map<List<String>, Integer> case4 = new HashMap<>();
        case4.put(Arrays.asList("B", "A"), 2);
        case4.put(Arrays.asList("A", "B"), 2);

        final Map<List<String>, Integer> case5 = new HashMap<>();
        case5.put(Arrays.asList("A", "B", "C"), 1);
        case5.put(Arrays.asList("B", "A", "C"), 2);
        case5.put(Arrays.asList("C", "A", "B"), 1);

        final Map<List<String>, Integer> case6 = new HashMap<>();
        case6.put(Arrays.asList("A", "B"), 5);
        case6.put(Arrays.asList("B"), 4);
        case6.put(Arrays.asList("C"), 3);
        case6.put(Arrays.asList("D"), 2);

        final Map<List<String>, Integer> case7 = new HashMap<>();
        case7.put(Arrays.asList("B", "A", "C", "D"), 1);
        case7.put(Arrays.asList("C", "A", "B", "D"), 1);
        case7.put(Arrays.asList("D", "A", "B", "C"), 1);

        final Map<List<String>, Integer> case8 = new HashMap<>();
        case8.put(Arrays.asList("B", "A", "C", "D", "E"), 1);
        case8.put(Arrays.asList("C", "A", "B", "D", "E"), 1);
        case8.put(Arrays.asList("D", "A", "B", "C", "E"), 1);

        // 2A Cases
        System.out.println("The ranked choice winner for sample is: " + getRankedChoiceWinner(sample));
        System.out.println("The ranked choice winner for sample 2 is: " + getRankedChoiceWinner(sample2));
        System.out.println("The ranked choice winner for sample 3 is: " + getRankedChoiceWinner(sample3));
        System.out.println("The ranked choice winner for sample 4 is: " + getRankedChoiceWinner(sample4));
        System.out.println("The ranked choice winner for sample 5 is: " + getRankedChoiceWinner(sample5));
        System.out.println("The ranked choice winner for sample 6 is: " + getRankedChoiceWinner(sample6));
        System.out.println("The ranked choice winner for sample 7 is: " + getRankedChoiceWinner(sample7));
        System.out.println("The ranked choice winner for sample 8 is: " + getRankedChoiceWinner(sample8));
        System.out.println("The ranked choice winner for sample 9 is: " + getRankedChoiceWinner(sample9));
        System.out.println("The ranked choice winner for sample 10 is: " + getRankedChoiceWinner(sample10));
        System.out.println("The ranked choice winner for sample 11 is: " + getRankedChoiceWinner(sample11));
        System.out.println("The ranked choice winner for sample 12 is: " + getRankedChoiceWinner(sample12));

        // 2B Cases
        System.out.println("The ranked choice winner for case 3 is: " + getRankedChoiceWinner(case3));
        System.out.println("The ranked choice winner for case 4 is: " + getRankedChoiceWinner(case4));
        System.out.println("The ranked choice winner for case 5 is: " + getRankedChoiceWinner(case5));
        System.out.println("The ranked choice winner for case 6 is: " + getRankedChoiceWinner(case6));
        System.out.println("The ranked choice winner for case 7 is: " + getRankedChoiceWinner(case7));
        System.out.println("The ranked choice winner for case 8 is: " + getRankedChoiceWinner(case8));

    }

    // implement this method for Part 1
    /**
     * Determines the plurality winner of the election
     * 
     * @param ballots The ballots that were cast by all voters
     * @return String representing the winner of the election
     */
    public static String getPluralityWinner(Map<List<String>, Integer> ballots) {
        // Use a TreeMap as it preserves lexicographic sorting
        TreeMap<String, Integer> result = new TreeMap<String, Integer>();

        HashMap<ArrayList<String>, Integer> ballotsCast = CopyBallotsCast(ballots);

        tallyFirstChoiceVotes(ballotsCast, result);

        // Return the maximum voted candidate, comparing by value
        return Collections.max(result.entrySet(), Map.Entry.comparingByValue()).getKey();
    }

    // implement this method for Part 2
    /**
     * Determines the ranked choice winner of the election
     * 
     * @param ballots The ballots that were cast by all voters
     * @return String representing the winner of the election
     */
    public static String getRankedChoiceWinner(Map<List<String>, Integer> ballots) {
        // Copy the ballots to a mutable object
        HashMap<ArrayList<String>, Integer> ballotsCast = CopyBallotsCast(ballots);

        // Get the majority vote count needed by getting the total number of votes
        int totalNumberOfVotes = getTotalNumberOfVotes(ballotsCast);
        int majorityNum = (totalNumberOfVotes / 2) + 1;

        // The result set is used to manipulate the data in rounds of ballot counting
        TreeMap<String, Integer> result = new TreeMap<String, Integer>();

        // Initially check if we already have a strict majority win
        String majorityWinner = getMajorityWinner(majorityNum, ballotsCast, result);
        if (majorityWinner != null)
            return majorityWinner;

        while (!ballotsCast.keySet().isEmpty()) {
            // Edge case: if we've removed all other possible candidates, then this one wins
            if (result.size() == 1) {
                return result.firstKey();
            }

            // Determine which candidate is to be removed from the ballots for this round
            String candidateToRemove = DetermineCandidateToRemove(ballotsCast, result);

            // Now remove the entries matching to the minimum votes from ballotsCast, if any
            RemoveCandidateFromPool(ballotsCast, candidateToRemove);

            // And also remove it from our result set before checking for a winner
            result.remove(candidateToRemove);

            // Re-calculate the new majority number value
            majorityNum = (getTotalNumberOfVotes(ballotsCast) / 2) + 1;

            // Check if a majority winner exists
            String winner = getMajorityWinner(majorityNum, ballotsCast, result);

            if (winner != null)
                return winner;
        }

        return null; // If no winner, we return null (should never happen)
    }

    /**
     * Determines the candidate to be removed from this round of ballot counting
     * 
     * @param ballotsCast All the ballots that were cast
     * @param result The result to be used in manipulating the round winner or who to be removed next
     * @return A string representing the candidate to be removed
     */
    private static String DetermineCandidateToRemove(HashMap<ArrayList<String>, Integer> ballotsCast, TreeMap<String, Integer> result) {
        // Start by removing the candidate with the least votes at current iteration
        int currentMinimumVotes = Integer.MAX_VALUE;
        String candidateToRemove = null;

        // Validate if we've tallied votes for each candidate, or not
        // (if one got no votes in this pass, they are removed)
        HashMap<String, Boolean> candidateEncountered = new HashMap<String, Boolean>();
        for (var entry : ballotsCast.entrySet()) {
            for (var candidate : entry.getKey()) {
                if (!candidateEncountered.containsKey(candidate)) {
                    candidateEncountered.put(candidate, false);
                }
            }
        }

        // Find the minimum votes cast
        for (var entry : result.entrySet()) {
            int votesCast = entry.getValue();
            if (votesCast < currentMinimumVotes
                    || (votesCast == currentMinimumVotes && entry.getKey().compareTo(candidateToRemove) > 0)) {
                currentMinimumVotes = votesCast;
                candidateToRemove = entry.getKey();
                candidateEncountered.put(candidateToRemove, true); // Mark that we encountered this candidate
            }
        }

        // Validate if we're removing the candidate with the least votes or
        // the one that was never voted for in this round
        boolean newCandidateToRemove = false;
        for (var entry : candidateEncountered.entrySet()) {
            if (!entry.getValue()) // If we did not see any votes for this candidate
            {
                // Verify if there was another one we didn't encounter
                // If so, check lexicographic order to determine who to remove
                if (newCandidateToRemove && entry.getKey().compareTo(candidateToRemove) > 0) {
                    candidateToRemove = entry.getKey();
                } else {
                    candidateToRemove = entry.getKey(); // Update who we're removing
                    newCandidateToRemove = true;
                }
            }
        }

        return candidateToRemove;
    }

    /**
     * Tallies the first choice votes to a map of (candidate name, number of votes)
     * 
     * @param ballots The ballots that were cast by all voters
     * @param result The resulting map that will be used to for this round of counting
     */
    private static void tallyFirstChoiceVotes(HashMap<ArrayList<String>, Integer> ballots,
            TreeMap<String, Integer> result) {
        // Iterate through each ballot entry set
        for (var ballot : ballots.entrySet()) {
            // Get the value representing the number of votes for this ballot (number of
            // times it was cast)
            var numberOfBallots = ballot.getValue();

            // Then go through each 1st candidate (the key here)
            var candidateChoice = ballot.getKey().get(0);

            // If we had already counted votes for this candidate, then add the new ballot's
            // number of votes
            if (result.containsKey(candidateChoice)) {
                result.put(candidateChoice, result.get(candidateChoice) + numberOfBallots);
            } else {
                // Else we just need to add the record
                result.put(candidateChoice, numberOfBallots);
            }
        }
    }

    /**
     * Returns an integer representing the total number of votes cast for this round
     * 
     * @param ballots The ballots that were cast by voters for this round
     * @return An integer representing the total number of votes for the round
     */
    private static int getTotalNumberOfVotes(HashMap<ArrayList<String>, Integer> ballots) {
        return ballots.values().stream().mapToInt(d -> d).sum();
    }

    /**
     * Determines if there is a majority winner for this round
     * 
     * @param majorityNum The current integer representing the majority vote count needed
     * @param ballots The ballots that were cast for the round
     * @param result The result map that we use for this round of counting
     * @return A string representing a winner, null if no one won
     */
    private static String getMajorityWinner(int majorityNum, HashMap<ArrayList<String>, Integer> ballots,
            TreeMap<String, Integer> result) {
        // Tally up the first pass of votes (first choices)
        result.clear(); // Clear it out, so we always get the 1st choice winners
        tallyFirstChoiceVotes(ballots, result);

        // Traverse the firstPass map to see if there's any majority vote
        if (result.containsValue(majorityNum)) {
            for (var candidate : result.entrySet()) {
                if (candidate.getValue() == majorityNum) {
                    return candidate.getKey();
                }
            }
        }

        return null;
    }

    /**
     * Removes a candidate from all ballots cast if they ranked last in a round
     * 
     * @param ballotsCast The ballots cast by all voters
     * @param candidateToRemove The string representing a candidate to remove
     */
    private static void RemoveCandidateFromPool(HashMap<ArrayList<String>, Integer> ballotsCast,
            String candidateToRemove) {
        for (var entry : ballotsCast.entrySet()) {
            entry.getKey().removeIf(n -> n.equals(candidateToRemove));
        }

        // Remove from ballotsCast if there is no key (no candidates anymore), i.e.
        // empty ballot
        ballotsCast.entrySet().removeIf(e -> e.getKey().size() == 0);
    }

    /**
     * Creates a deep copy of the initial immutable ballots map to a mutable HashMap
     * 
     * @param ballots The original ballots cast by all voters
     * @return A HashMap<ArrayList<String>, Integer> that is mutable for further manipulation
     */
    private static HashMap<ArrayList<String>, Integer> CopyBallotsCast(Map<List<String>, Integer> ballots) {
        HashMap<ArrayList<String>, Integer> output = new HashMap<ArrayList<String>, Integer>();

        for (var ballot : ballots.entrySet()) {
            ArrayList<String> key = new ArrayList<String>();
            key.addAll(ballot.getKey());
            output.put(key, ballot.getValue());
        }

        return output;
    }
}
