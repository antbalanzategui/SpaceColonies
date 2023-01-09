package spacecolonies;
/**
 * Implementation of the SkillSet class
 * The Skillset is what a Person has
 * determines "skill"
 * 
 *Virginia Tech Honor Code Pledge:
 *As a Hokie, I will conduct myself with honor and integrity at all times.
 *I will not lie, cheat, or steal, 
 *nor will I accept the actions of those who do.
 * 
 * @author Antonio Balanzategui, antbalanzategui
 * 
 * @version 2022.10.23
 *
 */

public class Skillset implements Comparable<Skillset> {
   
    private int agriculture;
    private int medicine;
    private int technology;
    
    /**
     * Constructor for Skillset class
     * 
     * @param ag
     * Agriculture skill
     * 
     * @param med
     * Medicine Skill
     * 
     * @param tech
     * Technology skill
     */
    public Skillset(int ag, int med, int tech) {
        agriculture = ag;
        medicine = med;
        technology = tech;
    }
    /**
     * Getter method for agriculture
     * 
     * @return agriculture
     * rating skill of agri
     */
    public int getAgriculture() {
        return agriculture;
    }
    /**
     * Getter method for medicine
     * 
     * @return medicine
     * rating skill of med
     */
    public int getMedicine() {
        return medicine;
    }
    /**
     * Getter method for technology
     * 
     * @return technology
     * rating skill of tech
     */
    public int getTechnology() {
        return technology;
    }
    /**
     * Method to compare two objects based on certain
     * qualities listed below
     * 
     * Returns True only if "this.agriculture" is less or equal to 
     * "other.agriculture" AND "this.medicine" is less or equal to 
     * "other.medicine" AND "this.technology" is less or equal to 
     * "other.technology
     * 
     * @param other 
     * comparable object
     * 
     * @return True if conditions above are met
     */
    public boolean isLessThanOrEqualTo(Skillset other) {
        if (other == null) {
            return false;
        }
        if (this.agriculture > other.agriculture) {
            return false;
        }
        if (this.medicine > other.medicine) {
            return false;
        }
        return (this.technology <= other.technology);
    }
    /**
     * Converts object status into string format
     * 
     * @return String format of object properties
     */
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("A:" + this.agriculture + " ");
        sb.append("M:" + this.medicine + " ");
        sb.append("T:" + this.technology);
        return sb.toString();
    }
    /**
     * Compares two objects to see whether
     * they are equal
     * 
     * Equal implies of same class
     * and agriculture, medicine, and technology
     * are all the same
     * 
     * @param obj 
     * object being compared
     * 
     * @return true if all conditions above are met,
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
            Skillset ss = (Skillset)obj;
            return (agriculture == ss.agriculture
                && medicine == ss.medicine 
                && technology == ss.technology);
        }
        else {
            return false;
        }
    }
    /** Compares to objects of skillset category
     * returns the difference of "this" object's sum
     * and the parameter's sum
     * 
     * @param skills
     * the object which is being compared to "this"
     * 
     * @return thisSum - paramSum (negative, 0, or positive)
     * 
     */
    @Override
    public int compareTo(Skillset skills) {
        int thisSum = this.agriculture + this.medicine + this.technology;
        int paramSum = skills.agriculture + skills.medicine + skills.technology;
        return (thisSum - paramSum);
    }
}
