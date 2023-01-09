package spacecolonies;

import student.TestCase;

/**
 * Class to test all methods within the Planet class
 * 
 *Virginia Tech Honor Code Pledge:
 *As a Hokie, I will conduct myself with honor and integrity at all times.
 *I will not lie, cheat, or steal, 
 *nor will I accept the actions of those who do.
 * 
 * @author Antonio Balanzategui, antbalanzategui
 * 
 * @version 2022.10.29
 *
 */

public class PlanetTest extends TestCase {
    
    private Planet p1;
    private Planet p2;
    private Planet p3;
    private Person pp1;
    private Person pp2;
    private Person pp3;
    
    /**
     * Set up
     */
    public void setUp() {
        p1 = new Planet("Mars", 4, 4, 5, 4);
        p2 = new Planet("Mars", 4, 4, 5, 4);
        p3 = new Planet("Nars", 5, 7, 2, 10);
        pp1 = new Person("Dave", 4, 4, 5, "Jupiter");
        pp2 = new Person("David", 1, 2, 4, "Nars");
        pp3 = new Person("Bob", 5, 8, 10, "Bars"); 
    }
    /**
     * Tests getAvailability
     */
    public void testGetAvailability() {
        assertEquals(p1.getAvailability(), 4);
        assertEquals(p2.getAvailability(), 4);
        assertEquals(p3.getAvailability(), 10);
    }
    /**
     * Tests isFull
     */
    public void testIsFull() {
        p1 = new Planet("Mars", 4, 4, 5, 0);
        assertTrue(p1.isFull());
        assertFalse(p3.isFull());
    }
    /**
     * Tests addPerson
     */
    public void testAddPerson() {
        assertFalse(p1.checkAdd(null));
        p1 = new Planet("Mars", 4, 4, 5, 2);
        assertTrue(p1.addPerson(pp1));
        p1.addPerson(pp1);
        assertEquals(p1.getAvailability(), 0);
        assertFalse(p1.addPerson(pp3));
        assertFalse(p1.addPerson(pp2));
        p1.addPerson(pp3);
        assertEquals(p1.getAvailability(), 0);
        assertFalse(p1.checkAdd(pp1));
        assertFalse(p1.addPerson(pp2));
        assertFalse(p2.addPerson(null));
    }
    /**
     * Tests toString
     */
    public void testToString() {
        assertEquals(p1.toString(), p2.toString());
        assertEquals(p2.toString(), "Mars, population 0 "
            + "(cap: 4), Requires: A >= 4, M >= 4, T >= 5");
        p3.addPerson(pp3);
        p3.addPerson(pp3);
        p3.addPerson(pp3);
        assertEquals(p3.toString(), "Nars, population 3 "
            + "(cap: 10), Requires: A >= 5, M >= 7, T >= 2");
    }
    /**
     * Tests equals 
     */
    public void testEquals() {
        assertFalse(p1.equals(null));
        assertFalse(p1.equals("Do"));
        p1.addPerson(pp1);
        assertEquals(p1.getPopulationSize(), 1);
        assertTrue(p1.equals(p1));
        assertFalse(p1.equals(p2));
        p3.addPerson(pp3);
        assertFalse(p1.equals(pp3));
        p3.addPerson(pp3);
        assertFalse(p3.equals(p1));
        p2.addPerson(pp1);
        Person pp4 = new Person("Dave", 5, 5, 5, "Jupiter");
        p1.addPerson(pp1);
        p2.addPerson(pp4);
        assertEquals(p1.getPopulationSize(), 2);
        assertEquals(p2.getPopulationSize(), 2);
        assertFalse(p1.equals(p2));
        p2 = new Planet("Mars", 4, 4, 5, 4);
        p2.addPerson(pp1);
        p2.addPerson(pp1);
        assertTrue(p1.equals(p2));
        p2 = new Planet("Jupiter", 4, 4, 5, 4);
        p2.addPerson(pp1);
        p2.addPerson(pp1);
        assertFalse(p1.equals(p2));
        p2 = new Planet("Jupiter", 4, 7, 5, 4);
        p2.addPerson(pp1);
        p2.addPerson(pp1);
        assertFalse(p1.equals(p2));
        p2 = new Planet("Mars", 4, 7, 5, 4);
        p2.addPerson(pp1);
        p2.addPerson(pp1);
        assertFalse(p1.equals(p2));
    }
    /**
     * Tests compareTo
     */
    public void testCompareTo() {
        assertTrue(p1.compareTo(p3) < 0);
        assertEquals(p1.compareTo(p2), 0);
        p1.addPerson(pp3);
        assertTrue(p1.compareTo(p2) < 0);
        p2 = new Planet("Mars", 9, 7, 5, 4);
        p2.addPerson(pp3);
        assertTrue(p1.compareTo(p2) < 0);
        Planet p4 = new Planet("Aliex", 5, 7, 2, 10);
        assertTrue(p3.compareTo(p4) > 0);
        p1 = new Planet("Mars", 9, 7, 5, 4);
        p2 = new Planet("Mars", 8, 4, 5, 4);
        assertTrue(p1.compareTo(p2) > 0);
        assertTrue(p2.compareTo(p1) < 0);
    }
}
