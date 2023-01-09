package spacecolonies;

/**
 * Implementation of the Planet class
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
public class Planet implements Comparable<Planet> {
    
    private String name;
    private Skillset minSkills;
    private Person[] population;
    private int populationSize;
    private int capacity;
    
    /**
     * Constructor for Planet object
     * 
     * @param planetName
     * Name of Planet
     * 
     * @param planetAgri
     * Planet Min Skillset Rating for Agri
     * 
     * @param planetMedi
     * Planet Min Skillset Rating for Medi
     * 
     * @param planetTech
     * Planet Min Skillset Rating for Tech 
     * 
     * @param planetCap
     * Planet's Capacity
     */
    
    public Planet(String planetName, int planetAgri, 
        int planetMedi, int planetTech, int planetCap) {
        this.name = planetName;
        this.minSkills = new Skillset(planetAgri, planetMedi, planetTech);
        this.population = new Person[planetCap];
        this.populationSize = 0;
        this.capacity = planetCap;
    }
    /**
     * Method to get the population of planet
     * 
     * @return population array
     */
    public Person[] getPopulation() {
        return population;
    }
    /**
     * Method to get name of planet 
     * 
     * @return name of planet
     */
    public String getName() {
        return this.name;
    }
    /**
     * Getter method for capacity
     * @return capacity of planet
     */
    public int getCapacity() {
        return capacity;
    }
    /**
     * Getter method for population size
     * @return populationSize of planet
     */
    public int getPopulationSize() {
        return populationSize;
    }
    /**
     * Getter method for minSkills
     * @return minSkill requirement of planet
     */
    public Skillset getSkills() {
        return minSkills;
    }
    /**
     * Method to get the remaining spots left on the planet
     * 
     * @return remaining space on planet
     */
    public int getAvailability() {
        return (population.length - populationSize);
    }
    /**
     * Method to see whether planet is full or not
     * @return true if full
     * false otherwise
     */
    public boolean isFull() {
        return (population.length == populationSize);
    }
    /**
     * Method to see whether Person object meets requirements
     * to live on the planet
     * 
     * These requirements are fufilled when the planet is not full
     * and the Person object skills' are more than or equal to min 
     * requirements of the planet
     * 
     * @param newbie
     * Person object
     * 
     * @return true if above requirements are fufilled
     * false otherwise
     */
    public boolean addPerson(Person newbie) {
        if (isFull() || newbie == null) {
            return false;
        }
        else {
            Skillset n = newbie.getSkills();
            if (minSkills.isLessThanOrEqualTo(n)) {
                this.population[populationSize] = newbie;
                populationSize++;
                return true;
            }
            else {
                return false;
            }
        }
    }
    /**
     * Helper method for ColonyCalc class
     * 
     * @param newbie
     * Person being checked
     * 
     * @return true if conditions are met, 
     * false otherwise
     */
    public boolean checkAdd(Person newbie) {
        if (isFull() || newbie == null) {
            return false;
        }
        else {
            Skillset n = newbie.getSkills();
            return (minSkills.isLessThanOrEqualTo(n));
        }
    }
    /**
     * Method to convert Planet's contents to a String
     * @return toString of planet object
     */
    public String toString() { 
        StringBuilder sb = new StringBuilder();
        sb.append(name + ", ");
        sb.append("population ");
        sb.append(populationSize + " ");
        sb.append("(");
        sb.append("cap: ");
        sb.append(capacity);
        sb.append("), ");
        sb.append("Requires: ");
        sb.append("A >= " + minSkills.getAgriculture() + ", ");
        sb.append("M >= " + minSkills.getMedicine() + ", ");
        sb.append("T >= " + minSkills.getTechnology());
        return sb.toString();   
    }
    /**
     * Method to compare equality of planets
     * 
     * @param obj 
     * Other planet object
     * 
     * @return true if requirements of equality are met
     * false otherwise
     * 
     */
    @Override
    public boolean equals(Object obj) { 
        if (obj == null) {
            return false;
        }
        else if (obj == this) {
            return true;
        }
        else if (obj.getClass() == this.getClass()) {
            Planet o = (Planet)obj;
            if (o.populationSize != this.populationSize
                || o.capacity != this.capacity) {
                return false;
            }
            for (int i = 0; i < this.populationSize; i++) {
                if (!(o.population[i].equals(this.population[i]))) {
                    return false;
                }
            }
            return (o.name.equals(this.name) 
                && o.minSkills.equals(this.minSkills));   
        }
        else {
            return false;
        }
        
    }
    /**
     * Method to compare two Planet based on certain attritbutes
     * Capacity, availability, Skillset, then Name
     * 
     * @param o
     * other planet object that is being compared to "this"
     * 
     * @return a number less than 0, 0, or a number greater than 0
     * 
     */
    @Override
    public int compareTo(Planet o) { 
        if (o.capacity != this.capacity) {
            return (this.capacity - o.capacity);
        }
        else if (this.getAvailability() != o.getAvailability()) {
            return (this.getAvailability() - o.getAvailability());
        }
        else if (!(this.minSkills.equals(o.minSkills))) {
            return (this.minSkills.compareTo(o.minSkills));
        }
        else {
            String thisName = this.name;
            String oName = o.name;
            return (thisName.compareTo(oName));
        } 
    }
    /**
     * Sets the planet name to input name
     * 
     * @param input
     * new planet name
     */
    public void setName(String input) {
        this.name = input;
    }
}