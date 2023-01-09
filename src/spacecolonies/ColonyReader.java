package spacecolonies;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Implementation of the ColonyReader class, used to receive text inputs from a file
 * and instantiate objects based on those inputs
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

public class ColonyReader {
    
    private Planet[] planets;
    private ArrayQueue<Person> queue;
    private static final int SKILL_MIN = 1;
    private static final int SKILL_MAX = 5;
    
    /**
     * Constructor for the ColonyReader object
     * 
     * @param applicantFileName
     * Text input file
     * 
     * @param planetFileName
     * Text input file
     * 
     * @throws java.text.ParseException
     * @throws FileNotFoundException
     * @throws SpaceColonyDataException
     */
    public ColonyReader(String applicantFileName, String planetFileName) 
        throws java.text.ParseException, FileNotFoundException, SpaceColonyDataException {
        this.planets = readPlanetFile(planetFileName);
        this.queue = readQueueFile(applicantFileName); 
    }
    /**
     * Uses the planet file for text to create three planet objects
     * 
     * @param fileName
     * Valid file will contain parameters for 3 planet objects
     * 
     * @return 3 planet objects within an Array
     * 
     * @throws FileNotFoundException
     * @throws java.text.ParseException
     * @throws SpaceColonyDataException
     */
    private Planet[] readPlanetFile(String fileName) 
        throws FileNotFoundException, java.text.ParseException, SpaceColonyDataException {
        Planet[] planetHolder = new Planet[3];
        String planetName = null;
        int [] integerParameters = new int[4];
        Scanner file = new Scanner(new File(fileName));
        int lineCount = 0;
        while (file.hasNextLine() && lineCount < 3) {
            String read = file.nextLine();
            Scanner currLine = new Scanner(read).useDelimiter(",\\s*");
            String tokens[] = new String[5];
            int tokenCount = 0;
            while (currLine.hasNext() && tokenCount < 5) {
                tokens[tokenCount++] = currLine.next();
            }
            currLine.close();
            if (tokenCount == 5) {
                for (int i = 0; i < 5; i++) {
                    if (i == 0) {
                        planetName = tokens[i]; 
                    }
                    else {
                        if (tokens[i].equals("")) {
                            throw new java.text.ParseException("parse exception", 1);
                        }
                        integerParameters[i-1] = Integer.valueOf(tokens[i]);
                    }
                }
            }
            else {
                throw new java.text.ParseException("parse exception", 1);
            }
            isInSkillRange(integerParameters[0], integerParameters[1], integerParameters[2]);
            Planet newPlanet = new Planet(planetName, integerParameters[0], 
                integerParameters[1], integerParameters[2], integerParameters[3]);
            planetHolder[lineCount] = newPlanet;
            lineCount++;
        }
        if (planetHolder[2] == null) {
            throw new SpaceColonyDataException("Less than Three Lines");
        }
        file.close();
        return planetHolder;   
    }
    /**
     * Uses applicant file to instantiate objects (Person)
     * and add it to the circular queue
     * 
     * @param fileName 
     * Valid file can contain any amount of lines, each line
     * holds parameters for the Person object
     * 
     * @return an ArrayQueue of people that were listed within the file
     * 
     * @throws FileNotFoundException
     * @throws java.text.ParseException
     * @throws SpaceColonyDataException
     */
    private ArrayQueue<Person> readQueueFile(String fileName) 
        throws FileNotFoundException, java.text.ParseException, SpaceColonyDataException {
        ArrayQueue<Person> aqHolder = new ArrayQueue<Person>();
        String personName = null;
        String planetName = null;
        int [] integerParameters = new int[3];
        Scanner file = new Scanner(new File(fileName));
        while (file.hasNextLine()) {
            String read = file.nextLine();
            Scanner currLine = new Scanner(read).useDelimiter(",\\s*");
            String tokens[] = new String[5];
            int tokenCount = 0;
            while (currLine.hasNext() && tokenCount < 5) {
                tokens[tokenCount++] = currLine.next();
            }
            currLine.close();
            if (tokenCount == 5) {
                for (int i = 0; i < 5; i++) {
                    if (i == 0) {
                        personName = tokens[i];
                    }
                    else if (i == 4) {
                        planetName = tokens[i];
                    }
                    else {
                        integerParameters[i-1] = Integer.valueOf(tokens[i]);
                    }
                }
            }
            else if (tokenCount == 4) {
                for (int i = 0; i < 5; i++) {
                    if (i == 0) {
                        personName = tokens[i];
                    }
                    else if (i == 4) {
                        planetName = "Nowhere";
                    }
                    else {
                        integerParameters[i-1] = Integer.valueOf(tokens[i]);
                    }
            }
            }
            else {
                throw new java.text.ParseException("parse exception", 1);
            }
            isInSkillRange(integerParameters[0], integerParameters[1], integerParameters[2]);
            Person p = new Person(personName, integerParameters[0], 
                integerParameters[1], integerParameters[2], planetName);
            aqHolder.enqueue(p);
        }
        file.close();
        return aqHolder;
    }
    /**
     * Tests to see whether three integers are within the skill range
     * determined by assignment details, must be between 1 and 5
     * 
     * @param num1
     * Skill 1
     * 
     * @param num2
     * Skill 2
     * 
     * @param num3
     * Skill 3
     * 
     * @return true if all conditions above are met
     * false otherwise
     * 
     * @throws SpaceColonyDataException
     */
    private boolean isInSkillRange(int num1, int num2, int num3) 
        throws SpaceColonyDataException {
        if (num1 < SKILL_MIN || num2 < SKILL_MIN || num3 < SKILL_MIN) {
            throw new SpaceColonyDataException("Skill Rating Below One");
        }
        if (num1 > SKILL_MAX || num2 > SKILL_MAX || num3 > SKILL_MAX) {
            throw new SpaceColonyDataException("Skill Rating Above Five");
        }
        else {
            return true;
        }
    }
    /**
     * Getter method for queue
     */
    public ArrayQueue<Person> getFileQueue() {
        return queue;
    }
    /**
     * Getter method for planets
     */
    public Planet[] getFilePlanets() {
        return planets;
    }
}
