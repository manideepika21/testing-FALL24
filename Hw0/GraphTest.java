import static org.junit.Assert.*;

import java.util.TreeSet;
import java.util.Set;

import org.junit.Test;

public class GraphTest {
    // tests for method "insertEdge" in class "Graph"

    @Test public void testInsertEdge0() {
        Graph graph = new Graph(2);
        graph.insertEdge(0, 1);
        assertEquals(
                     "nodeCount: 2\nedges: [[false, true], [false, false]]",
                     graph.toString());
    }
    @Test public void testInsertEdge1() {
        Graph graph = new Graph(3);
        graph.insertEdge(0, 1);
        graph.insertEdge(1, 2);
        assertEquals(
            "nodeCount: 3\nedges: [[false, true, false], [false, false, true], [false, false, false]]",
            graph.toString()
        );
    }
    
    @Test public void testInsertEdge2() {
        Graph graph = new Graph(4);
        graph.insertEdge(0, 3);
        graph.insertEdge(1, 2);
        assertEquals(
            "nodeCount: 4\nedges: [[false, false, false, true], [false, false, true, false], [false, false, false, false], [false, false, false, false]]",
            graph.toString()
        );
    }
    
    @Test public void testInsertEdge3() {
        Graph graph = new Graph(5);
        graph.insertEdge(2, 2);
        graph.insertEdge(3, 4);
        assertEquals(
            "nodeCount: 5\nedges: [[false, false, false, false, false], [false, false, false, false, false], [false, false, true, false, false], [false, false, false, false, true], [false, false, false, false, false]]",
            graph.toString()
        );
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testInsertEdgeOutOfBounds() {
        Graph graph = new Graph(2);
        graph.insertEdge(0, 2);  // Should throw IllegalArgumentException
    }
    
    // you must provide at least 4 test methods;
    // each test method must
    //   have at least 1 invocation of insertEdge;
    //   create exactly 1 graph;
    //   create a unique graph w.r.t. the "equals" method; and
    //   have at least 1 test assertion;
    // your test methods must achieve full statement coverage of
    //   your implementation of insertEdge and any helper methods
    // no test method directly invokes any method that is not
    //   declared in the Graph class as specified in this homework

    // your tests for method "insertEdge" in class "Graph" go here


    // tests for method "isReachable" in class "Graph"

    @Test public void testIsReachable0() {
        Graph graph = new Graph(1);
        Set<Integer> nodes = new TreeSet<Integer>();
        nodes.add(0);
        assertTrue(graph.isReachable(nodes, nodes));
    }

    // you must provide at least 6 test methods;
    // each test method must
    //   invoke isReachable at least once; and
    //   have at least 1 test assertion;
    // at least 2 test methods must invoke insertEdge;
    // your test methods must acheive full statement coverage of your
    //   implementation of isReachable and any helper methods
    // no test method directly invokes any method that is not
    //   declared in the Graph class as specified in this homework

    // your tests for method "isReachable" in class "Graph" go here

    @Test public void testIsReachable1() {
        Graph graph = new Graph(2);
        graph.insertEdge(0, 1);
        Set<Integer> sources = new TreeSet<>();
        sources.add(0);
        Set<Integer> targets = new TreeSet<>();
        targets.add(1);
        assertTrue(graph.isReachable(sources, targets));
    }
    
    @Test public void testIsReachable2() {
        Graph graph = new Graph(3);
        graph.insertEdge(0, 1);
        graph.insertEdge(1, 2);
        Set<Integer> sources = new TreeSet<>();
        sources.add(0);
        Set<Integer> targets = new TreeSet<>();
        targets.add(2);
        assertTrue(graph.isReachable(sources, targets));
    }
    
    @Test public void testIsReachable3() {
        Graph graph = new Graph(3);
        graph.insertEdge(0, 1);
        Set<Integer> sources = new TreeSet<>();
        sources.add(1);
        Set<Integer> targets = new TreeSet<>();
        targets.add(2);
        assertFalse(graph.isReachable(sources, targets));
    }
    
    @Test public void testIsReachable4() {
        Graph graph = new Graph(4);
        graph.insertEdge(0, 1);
        graph.insertEdge(1, 2);
        graph.insertEdge(2, 3);
        Set<Integer> sources = new TreeSet<>();
        sources.add(0);
        Set<Integer> targets = new TreeSet<>();
        targets.add(3);
        assertTrue(graph.isReachable(sources, targets));
    }
    
    @Test public void testIsReachableWithNoEdges() {
        Graph graph = new Graph(2);
        Set<Integer> sources = new TreeSet<>();
        sources.add(0);
        Set<Integer> targets = new TreeSet<>();
        targets.add(1);
        assertFalse(graph.isReachable(sources, targets));
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testIsReachableWithNullSources() {
        Graph graph = new Graph(2);
        graph.isReachable(null, new TreeSet<>());
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testIsReachableWithNullTargets() {
        Graph graph = new Graph(2);
        graph.isReachable(new TreeSet<>(), null);
    }
    
}
