package spacecolonies;

/**
 * Creation of a unique exception extends the regular Java extensions
 * Will be thrown if data within the input files are incorrect
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
@SuppressWarnings("serial")
public class SpaceColonyDataException extends Exception {
    /**
     * Uses Java standard Exception to construct 
     * a new unique exception with message 'string'
     * 
     * @param string
     * message which will be shown with the exception
     */
    public SpaceColonyDataException(String string) {
        super(string);
    } 
}
