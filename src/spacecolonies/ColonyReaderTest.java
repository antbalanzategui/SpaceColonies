package spacecolonies;

import student.TestCase;

/**
 * Class to test ColonyReader class
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

public class ColonyReaderTest extends TestCase {
    
    private ColonyReader cr;
    
    /**
     * Sets up 
     */
    public void setUp() {
        
    }
    /**
     * Tests SpaceColonyDataException
     */
    public void testSpaceColonyDataException() {
        Exception e = null;
        try {
            cr = new ColonyReader("input.txt", "planetsHighSkill.txt");
        }
        catch (Exception exception) {
            e = exception;
        }
        assertTrue(e instanceof SpaceColonyDataException);
    }
 
}
