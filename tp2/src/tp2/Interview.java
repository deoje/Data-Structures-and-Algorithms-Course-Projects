package tp2;

import java.util.Collection;
import java.util.Iterator;
import java.util.ArrayList;

public class Interview {
    /**
     * Finds all pairs within values which sum up to targetSum
     * @param values All possible values that can form a pair (can contain duplicates)
     * @param targetSum Pairs should add up to this
     * @return A collection containing all valid pairs with no permutations, but all combinations (empty collection if none found)
     */
    public Collection<MatchingPair> matchingPairs(Collection<Integer> values, Integer targetSum){
        ArrayList<MatchingPair> finalCollection = new ArrayList<>();

        // Input arguments verification
        if (values.size() == 0 || targetSum == null){
            return finalCollection;
        }

        // Go through every value
        for (int first_value : values) {
            // Second iteration through every value
            for (int second_value : values) {
                // Verify if sum hits target when first_value is not second_value
                if ((second_value + first_value == targetSum && second_value != first_value)) {
                    // Create and add a pair to the final Collection
                    finalCollection.add(new MatchingPair(second_value, first_value));
                }
            }
        }

        // Start a counter for iteration through pairs
        int i = 0;
        while (i != finalCollection.size()){
            // Empty -> Do nothing
            if (finalCollection.size() == 0)
                break;

            MatchingPair first_pair = finalCollection.get(i);

            if (finalCollection.removeIf(
                    second_pair -> first_pair.first.equals(second_pair.second)
                            && first_pair.second.equals(second_pair.first)))
                i = 0;

            i++;
        }
        return finalCollection;
    }
}

