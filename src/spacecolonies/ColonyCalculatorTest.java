package spacecolonies;


import student.TestCase;

/**
 * Used to test the ColonyCalculator class
 * 
 *Virginia Tech Honor Code Pledge:
 *As a Hokie, I will conduct myself with honor and integrity at all times.
 *I will not lie, cheat, or steal, 
 *nor will I accept the actions of those who do.
 * 
 * @author Antonio Balanzategui, antbalanzategui
 * 
 * @version 2022.10.30
 *
 */
public class ColonyCalculatorTest extends TestCase {
    
    
    private ColonyCalculator cc1;
    private ArrayQueue<Person> aq1;
    private Planet[] pArray;
    private Person person1;
    private Person person2;
    private Person person3;
    private Planet planet1;
    private Planet planet2;
    private Planet planet3;
    
    /**
     * Sets up
     */
    public void setUp() {
        pArray = new Planet[3];
        Exception e = null;
        try {
            ColonyCalculator cc2 = new ColonyCalculator(aq1, pArray);
        } 
        catch (Exception exception) {
            e = exception;
        }
        assertTrue(e instanceof IllegalArgumentException);
        aq1 = new ArrayQueue<Person>();
        person1 = new Person("Joseph", 2, 4, 4, "Mars");
        person2 = new Person("Albert", 4, 3, 4, "Nowhere");
        person3 = new Person("Larry", 2, 2, 2, "Jupiter");
        planet1 = new Planet("Jupiter", 2, 2, 3, 20);
        planet2 = new Planet("Mars", 2, 3, 2, 10);
        planet3 = new Planet("Saturn", 2, 2, 2, 3);
        pArray[0] = planet1;
        pArray[1] = planet2;
        pArray[2] = planet3;
        aq1.enqueue(person1);
        aq1.enqueue(person2);
        aq1.enqueue(person3);
        cc1 = new ColonyCalculator(aq1, pArray);
    }
    
    /**
     * Tests getQueue
     */
    public void testGetQueue() {
        assertEquals(cc1.getQueue(), aq1);
    }
    /**
     * Tests getPlanets
     */
    public void testGetPlanets() {
        assertEquals(cc1.getPlanets(), pArray);
    }
    /**
     * Tests getPlanetForPerson
     */
    public void testGetPlanetForPerson() {
        assertEquals(cc1.getPlanetForPerson(null), null);
        assertEquals(cc1.getPlanetForPerson(person3), null);
        assertEquals(cc1.getPlanetForPerson(person1), planet2);
        assertEquals(cc1.getPlanetForPerson(person2), planet1);
        Person person4 = new Person("Joseph", 2, 2, 2, "Nowhere");
        assertEquals(cc1.getPlanetForPerson(person4), planet3);
        Person person5 = new Person("Joseph", 2, 2, 2, "Nars");
        assertEquals(cc1.getPlanetForPerson(person5), planet3);
        Person person6 = new Person("D", 1, 1, 1, "Nowhere");
        assertNull(cc1.getPlanetForPerson(person6));
    }
    /**
     * Tests accept
     */
    public void testAccept() {
        assertFalse(cc1.getQueue().isEmpty());
        assertEquals(cc1.getQueue().getFront(), person1);
        assertTrue(cc1.accept());
        assertEquals(planet2.getPopulationSize(), 1);
        assertTrue(cc1.accept());
        assertEquals(planet2.getPopulationSize(), 1);
        assertEquals(cc1.getQueue().getFront(), person3);
        assertFalse(cc1.accept());
        assertFalse(cc1.accept());
        assertTrue(cc1.getQueue().isEmpty());

    }
    /**
     * Tests reject
     */
    public void testReject() {
        cc1.reject();
        assertEquals(cc1.getQueue().getSize(), 2);
    }
    /**
     * Tests getPlanetIndex
     */
    public void testGetPlanetIndex() {
        assertEquals(cc1.getPlanetIndex("Mars"), 1);
        assertEquals(cc1.getPlanetIndex("Jupiter"), 0);
        assertEquals(cc1.getPlanetIndex("Saturn"), 2);
        assertEquals(cc1.getPlanetIndex(""), -1);
    }
}
