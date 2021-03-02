package LC.hash_table;

import java.util.BitSet;
import java.util.HashSet;
import java.util.Set;

public class DistributeCandies {

    public int distributeCandies(int[] candyType) {
        Set<Integer> set;
        set = new HashSet<>();
        int N = candyType.length;
        int N2 = N / 2;
        for (int j : candyType) {
            set.add(j);
            if (set.size() == N2)
                return N2;
        }

        return Math.min(N2, set.size());
    }
}
