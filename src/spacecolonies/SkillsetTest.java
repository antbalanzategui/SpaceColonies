package spacecolonies;

import student.TestCase;

/**
* Class made to test the methods within skillset class
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

public class SkillsetTest extends TestCase {
    
    private Skillset ss1;
    private Skillset ss2;
    private Skillset ss3; 
    
    /**
     * Set up
     */
    public void setUp() {
        ss1 = new Skillset(3, 4, 6);
        ss2 = new Skillset(3, 4, 6);
        ss3 = new Skillset(10, 9, 7);
    }
    /**
     * Tests getAgriculture method
     */
    public void testGetAgriculture() {
        assertEquals(ss1.getAgriculture(), 3);
        assertEquals(ss2.getAgriculture(), 3);
        assertEquals(ss3.getAgriculture(), 10);
    }
    /**
     * Tests getMedicine method
     */
    public void testGetMedicine() {
        assertEquals(ss1.getMedicine(), 4);
        assertEquals(ss2.getMedicine(), 4);
        assertEquals(ss3.getMedicine(), 9);
    }
    /**
     * Tests getTechnology method
     */
    public void testGetTechnology() {
        assertEquals(ss1.getTechnology(), 6);
        assertEquals(ss2.getTechnology(), 6);
        assertEquals(ss3.getTechnology(), 7);
    }
    /**
     * Tests isLessThanOrEqualTo method
     */
    public void testIsLessThanOrEqualTo() {
        assertFalse(ss1.isLessThanOrEqualTo(null));
        assertTrue(ss1.isLessThanOrEqualTo(ss2));
        assertTrue(ss1.isLessThanOrEqualTo(ss3));
        assertFalse(ss3.isLessThanOrEqualTo(ss2));
        Skillset ss4 = new Skillset(3, 4, 5);
        Skillset ss5 = new Skillset(3, 5, 6);
        assertTrue(ss4.isLessThanOrEqualTo(ss1));
        assertFalse(ss1.isLessThanOrEqualTo(ss4));
        assertFalse(ss5.isLessThanOrEqualTo(ss1));
    }
    /**
     * Tests toString method
     */
    public void testToString() {
        assertEquals(ss1.toString(), "A:3 M:4 T:6");
        assertEquals(ss3.toString(), "A:10 M:9 T:7");
    }
    /**
     * Tests Equals method
     */
    public void testEquals() {
        assertFalse(ss1.equals(null));
        assertFalse(ss1.equals("Do"));
        assertFalse(ss1.equals(ss3));
        assertTrue(ss1.equals(ss1));
        assertTrue(ss1.equals(ss2));
        Skillset ss4 = new Skillset(3, 10, 6);
        Skillset ss5 = new Skillset(3, 4, 9);
        assertFalse(ss1.equals(ss4));
        assertFalse(ss1.equals(ss5));
    }
    /**
     * Tests compareTo method
     */
    public void testCompareTo() {
        assertEquals(ss1.compareTo(ss2), 0);
        assertEquals(ss1.compareTo(ss1), 0);
        assertTrue(ss1.compareTo(ss3) < 0);
        assertTrue(ss3.compareTo(ss2) > 0);
    }
}
