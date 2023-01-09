package spacecolonies;

import java.io.FileNotFoundException;
import java.text.ParseException;

/**
 * Implemetation of the ProjectRunner class
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
public class ProjectRunner {
    /**
     * Main method for project runner
     * 
     * @param args 
     * ability to use run config to choose two seperate inputs of files, of user choice
     * 
     * @throws ParseException
     * @throws FileNotFoundException
     * @throws SpaceColonyDataException
     */
    public static void main(String[] args) throws ParseException, FileNotFoundException, SpaceColonyDataException {
        ColonyReader cr;
        ColonyCalculator cc;
        SpaceWindow sw;
        if (args.length == 2) {
            cr = new ColonyReader(args[0], args[1]);
        }
        else {
            cr = new ColonyReader("input.txt", "planets.txt");
        }
        cc = new ColonyCalculator(cr.getFileQueue(), cr.getFilePlanets());
        sw = new SpaceWindow(cc);
    }
}
