package spacecolonies;

import student.TestCase;

/**
* Class made to test the methods within Person class
* 
*Virginia Tech Honor Code Pledge:
*As a Hokie, I will conduct myself with honor and integrity at all times.
*I will not lie, cheat, or steal, 
*nor will I accept the actions of those who do.
* 
* @author Antonio Balanzategui, antbalanzategui
* 
* @version 2022.10.24
*
*/

public class PersonTest extends TestCase {
    
    private Person p1;
    private Person p2;
    private Person p3;
    
    /**
     * Sets up
     */
    public void setUp() {
        p1 = new Person("Dave", 1, 2, 3, "Jupiter");
        p2 = new Person("Dave", 1, 2, 3, "Jupiter");
        p3 = new Person("Bob", 4, 8, 10, ""); 
    }
    /**
     * Tests getName method
     */
    public void testGetName() {
        assertEquals("Dave", p1.getName());
        assertEquals("Dave", p2.getName());
        assertEquals("Bob", p3.getName());
    }
    /**
     * Tests getSkills method
     */
    public void testGetSkills() {
        assertTrue(p1.getSkills().equals(p2.getSkills()));
        assertFalse(p1.getSkills().equals(p3.getSkills()));
    }
    /**
     * Tests getPlanetPreference
     */
    public void testGetPlanetPreference() {
        assertEquals("Jupiter", p1.getPlanetPreference());
        assertEquals("Jupiter", p2.getPlanetPreference());
        assertEquals("", p3.getPlanetPreference());
    }
    /**
     * Tests toString method
     */
    public void testToString() {
        assertEquals(p1.toString(), "Dave A:1 M:2 T:3 Wants: Jupiter");
        assertEquals(p3.toString(), "No-Planet Bob A:4 M:8 T:10");
    }
    /**
     * Tests equals method
     */
    public void testEquals() {
        assertTrue(p1.equals(p1));
        assertFalse(p1.equals(null));
        assertFalse(p1.equals("Do"));
        assertTrue(p1.equals(p2));
        assertFalse(p1.equals(p3));
        Person p4 = new Person("Dave", 1, 2, 4, "Jupiter");
        Person p5 = new Person("Dave", 1, 2, 4, "Mars");
        assertFalse(p4.equals(p5));
        assertFalse(p1.equals(p4));
    }
    

}
