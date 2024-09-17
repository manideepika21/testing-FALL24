package hw1.problem1;
import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class TestPairwise {

    @Test
    public void testBothSetsNull() {
        Set result = Sets.intersection(null, null);
        assertEquals(new HashSet<>(), result);
    }

    @Test
    public void testSetOneNull() {
        Set<Object> s2 = new HashSet<>();
        s2.add(1);
        s2.add(2);
        Set result = Sets.intersection(null, s2);
        assertEquals(new HashSet<>(), result);
    }

    @Test
    public void testSetTwoNull() {
        Set<Object> s1 = new HashSet<>();
        s1.add(1);
        s1.add(2);
        Set result = Sets.intersection(s1, null);
        assertEquals(new HashSet<>(), result);
    }

    @Test
    public void testBothSetsEmpty() {
        Set<Object> s1 = new HashSet<>();
        Set<Object> s2 = new HashSet<>();
        Set result = Sets.intersection(s1, s2);
        assertEquals(new HashSet<>(), result);
    }

    @Test
    public void testSetsWithSameElements() {
        Set<Object> s1 = new HashSet<>();
        s1.add(1);
        s1.add(2);
        Set<Object> s2 = new HashSet<>();
        s2.add(1);
        s2.add(2);
        Set result = Sets.intersection(s1, s2);
        Set<Object> expected = new HashSet<>();
        expected.add(1);
        expected.add(2);
        assertEquals(expected, result);
    }

    @Test
    public void testFirstSetSubsetOfSecond() {
        Set<Object> s1 = new HashSet<>();
        s1.add(1);
        s1.add(2);
        Set<Object> s2 = new HashSet<>();
        s2.add(1);
        s2.add(2);
        s2.add(3);
        Set result = Sets.intersection(s1, s2);
        Set<Object> expected = new HashSet<>();
        expected.add(1);
        expected.add(2);
        assertEquals(expected, result);
    }

    @Test
    public void testSecondSetSubsetOfFirst() {
        Set<Object> s1 = new HashSet<>();
        s1.add(1);
        s1.add(2);
        s1.add(3);
        Set<Object> s2 = new HashSet<>();
        s2.add(1);
        s2.add(2);
        Set result = Sets.intersection(s1, s2);
        Set<Object> expected = new HashSet<>();
        expected.add(1);
        expected.add(2);
        assertEquals(expected, result);
    }

    @Test
    public void testNoCommonElements() {
        Set<Object> s1 = new HashSet<>();
        s1.add(1);
        s1.add(2);
        Set<Object> s2 = new HashSet<>();
        s2.add(3);
        s2.add(4);
        Set result = Sets.intersection(s1, s2);
        assertEquals(new HashSet<>(), result);
    }
    
    @Test
    public void testSetWithNullElement() {
        Set<Object> s1 = new HashSet<>();
        s1.add(null);
        Set<Object> s2 = new HashSet<>();
        s2.add(null);
        s2.add(1);
        Set result = Sets.intersection(s1, s2);
        Set<Object> expected = new HashSet<>();
        expected.add(null);
        assertEquals(expected, result);
    }
}
