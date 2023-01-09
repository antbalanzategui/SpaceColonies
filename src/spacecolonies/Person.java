package spacecolonies;

/**
 * Implementation of the Person class, which utilizes previous
 * skillset class
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
public class Person {
    
    private String name;
    private Skillset skills;
    private String planetPreference;
    
    /**
     * Constructor for the Person class 
     * 
     * @param name
     * name of Person (String)
     * 
     * @param ag
     * Person's agriculture rating
     * 
     * @param med
     * Person's medicine rating 
     * 
     * @param tech
     * Person's technology rating
     * 
     * @param planet
     * Planet Preference (String)
     */
    public Person(String name, int ag, int med, int tech, String planet) {
        this.name = name;
        this.skills = new Skillset(ag, med, tech);
        this.planetPreference = planet;
    }
    /**
     * Getter method for name
     * 
     * @return name
     */
    public String getName() {
        return name;
    }
    /**
     * Getter method for skills
     * 
     * @return skills
     * Skillset of individual
     */
    public Skillset getSkills() {
        return skills;
    }
    /**
     * Getter method for planet preference 
     * 
     * @return planetPreferene
     * Individual's preference of planet
     */
    public String getPlanetPreference() {
        return planetPreference;
    }
    /**
     * Method to convert Person's 
     * information into a string
     * 
     * @return Person's info in string format
     */
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (planetPreference.length() > 0) {
            sb.append(name + " ");
            sb.append(skills.toString() + " ");
            sb.append("Wants: " + planetPreference);
        }
        else {
            sb.append("No-Planet ");
            sb.append(name + " ");
            sb.append(skills.toString());
        }
        return sb.toString(); 
    }
    /**
     * Method to compare two objects 
     * for equivalence
     * 
     * @return true if equivalent,
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
            Person p = (Person)obj;
            return (this.name.equals(p.name)
                && this.planetPreference.equals(p.planetPreference)
                && this.skills.equals(p.skills));
        }
        else {
            return false;
        }
    }
}
