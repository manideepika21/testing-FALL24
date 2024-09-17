package hw1.problem1;
import java.util.HashSet;
import java.util.Set;
public class Sets {
    public static Set intersection(Set s1, Set s2) {
    // Effects: Return a (non null) Set equal to the intersection of sets s1 and s2
    // A null argument is treated as an empty set
	// complete the implemenation below
        if (s1 == null) s1 = new HashSet<>();
        if (s2 == null) s2 = new HashSet<>();
        Set result = new HashSet(s1);
        result.retainAll(s2);  
        return result;       
    }
}

