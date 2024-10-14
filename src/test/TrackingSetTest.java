package test;

import main.TrackingSet;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TrackingSetTest {
    private TrackingSet<Integer> trackingSet;

    @BeforeEach
    public void setUp() {
        trackingSet = new TrackingSet<>();
    }

    @Test
    public void testAddElementIncreasesModificationCount() {
        trackingSet.add(1);
        Assertions.assertEquals(1, trackingSet.getAdditionsCount());
    }

    @Test
    public void testAddExistingElementIncreasesModificationCount() {
        trackingSet.add(1);
        trackingSet.add(2);
        Assertions.assertEquals(2, trackingSet.getAdditionsCount());
    }

    @Test
    public void testRemoveElementIncreasesModificationCount() {
        trackingSet.add(1);
        trackingSet.add(2);
        trackingSet.remove(1);
        trackingSet.remove(2);
        Assertions.assertEquals(2, trackingSet.getRemovalsCount());
    }

    @Test
    public void testTotalModificationCount() {
        trackingSet.add(1);
        trackingSet.add(2);
        trackingSet.remove(1);
        trackingSet.remove(2);
        Assertions.assertEquals(4, trackingSet.getOperationsCount());
    }

    @Test
    public void testRemoveNonExistingElementDoesNotIncreasesModificationCount() {
        trackingSet.remove(6);
        Assertions.assertEquals(0, trackingSet.getRemovalsCount());
    }
}
