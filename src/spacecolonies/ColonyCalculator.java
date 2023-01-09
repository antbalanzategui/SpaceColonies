package spacecolonies;

import java.util.Arrays;
import list.AList;

/**
 * Implementation of the ColonyCalculator Class, used to reject
 * and accept applicants from a queue into particular planets
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
public class ColonyCalculator {

    /**
     * Constant Array Size for Planet Array
     */
    public static final int NUM_PLANETS = 3;
    private ArrayQueue<Person> applicantQueue;
    private AList<Person> rejectBus;
    private Planet[] planets;
    
    /**
     * ColonyCalculator constructor 
     * 
     * @param aQ
     * ArrayQueue which holds applicants
     * 
     * @param p
     * Object which holds an array of size 3 of Planets
     */
    public ColonyCalculator(ArrayQueue<Person> aQ, Planet[] p) {
        if (aQ == null) {
            throw new IllegalArgumentException();
        }
        else {
            this.applicantQueue = aQ;
            this.planets = p;
            this.rejectBus = new AList<Person>();
        }
    }
    /**
     * Getter method for applicantQueue
     * 
     * @return applicantQueue
     */
    public ArrayQueue<Person> getQueue() {
        return applicantQueue;
    }
    /**
     * Getter method for Planets
     * 
     * @return planets
     */
    public Planet[] getPlanets() {
        return planets;
    }
    /**
     * Method see whether or not a Person can
     * live on a particular planet
     * 
     * @param nextPerson
     * The next person within the queue
     * 
     * @return A planet object, or null
     * 
     */
    private boolean canAccept(Planet p, Person nextPerson) {
        return (p.checkAdd(nextPerson));  
    }
    private Planet getHighestCapacityPlanet(Person nextPerson, 
        Planet[] planetsClone) {
        Arrays.sort(planetsClone);
        for (int i = NUM_PLANETS - 1; i >= 0; i--) {
            if (canAccept(planetsClone[i], nextPerson)) {
                return planetsClone[i];
            }
        }
        return null;
    }
    /**
     * Controls the logic behind adding a person to a planet
     * checks certain criteria, then calls the method to add
     * person
     * 
     * @param nextPerson
     * Person attempting to be added
     * 
     * @return A planet if criteria is met
     */
    public Planet getPlanetForPerson(Person nextPerson) {
        Planet[] planetsClone = new Planet[3];
        for (int i = 0; i < NUM_PLANETS; i++) {
            planetsClone[i] = planets[i];
        }
        if (nextPerson == null) {
            return null;
        }
        String preference = nextPerson.getPlanetPreference();
        if (!(preference.equals("Nowhere"))) {
            int planetIndex = getPlanetIndex(preference);
            if (planetIndex == -1) {
                return (getHighestCapacityPlanet(nextPerson, planetsClone));
            }
            else if (canAccept(planets[planetIndex], nextPerson)) {
                return planets[planetIndex];
            }
            else {
                return null;
            }
        }
        else {
            return (getHighestCapacityPlanet(nextPerson, planetsClone));
        }
    }
    /**
     * Calls to the getPlanetForPerson method, attempts to accept them
     * 
     * @return False if unable to accept, 
     * or rather getPlanetForPerson returns null
     * True if a Planet Object is passed 
     * via getPlanetForPerson
     */
    public boolean accept() {
        if (applicantQueue.isEmpty()) {
            return false;
        }
        Person p = applicantQueue.getFront();
        Planet holder = getPlanetForPerson(p);
        if (holder != null) {
            applicantQueue.dequeue();
            holder.addPerson(p);
            return true;  
        }
        else {
            reject();
            return false;
        }
    }
    /**
     * Used at the very end of the  getPlanetForPerson method, will
     * dequeue a person from applicantQueue if applicant is rejected 
     * from all three planets
     */
    public void reject() {
        Person holder = applicantQueue.dequeue();
        rejectBus.add(holder);
    }
    /**
     * Returns the planet index
     * 
     * @param planet 
     * String, planet name we are searching for
     * 
     * @return the index of the item, or -1 if it is not found
     */
    public int getPlanetIndex(String planet) {
        for (int i = 0; i < NUM_PLANETS; i++) {
            if (planets[i].getName().equals(planet)) {
                return i;
            }
        }
        return -1;
    }
}
