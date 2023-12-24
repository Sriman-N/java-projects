import java.util.ArrayList;

/**
 * The StopAndFrisk class represents stop-and-frisk data, provided by
 * the New York Police Department (NYPD), that is used to compare
 * during when the policy was put in place and after the policy ended.
 *
 * @author Tanvi Yamarthy
 * @author Vidushi Jindal
 */
public class StopAndFrisk {

    /*
     * The ArrayList keeps track of years that are loaded from CSV data file.
     * Each SFYear corresponds to 1 year of SFRecords.
     * Each SFRecord corresponds to one stop and frisk occurrence.
     */
    private ArrayList<SFYear> database;

    /*
     * Constructor creates and initializes the @database array
     *
     * DO NOT update nor remove this constructor
     */
    public StopAndFrisk () {
        database = new ArrayList<>();
    }

    /*
     * Getter method for the database.
     * *** DO NOT REMOVE nor update this method ****
     */
    public ArrayList<SFYear> getDatabase() {
        return database;
    }

    /**
     * This method reads the records information from an input csv file and populates 
     * the database.
     *
     * Each stop and frisk record is a line in the input csv file.
     *
     * 1. Open file utilizing StdIn.setFile(csvFile)
     * 2. While the input still contains lines:
     *    - Read a record line (see assignment description on how to do this)
     *    - Create an object of type SFRecord containing the record information
     *    - If the record's year has already is present in the database:
     *        - Add the SFRecord to the year's records
     *    - If the record's year is not present in the database:
     *        - Create a new SFYear 
     *        - Add the SFRecord to the new SFYear
     *        - Add the new SFYear to the database ArrayList
     *
     * @param csvFile
     */
    public void readFile ( String csvFile ) {



        // DO NOT remove these two lines
        StdIn.setFile(csvFile); // Opens the file
        StdIn.readLine();       // Reads and discards the header line

        while(!StdIn.isEmpty()) {
            String[] recordEntries = StdIn.readLine().split(",");

            int year = Integer.parseInt(recordEntries[0]);
            String description = recordEntries[2];
            String gender = recordEntries[52];
            String race = recordEntries[66];
            String location = recordEntries[71];
            boolean arrested = recordEntries[13].equals("Y");
            boolean frisked = recordEntries[16].equals("Y");

            SFRecord record = new SFRecord(description, arrested, frisked, gender, race, location);

            boolean a = false;
            for(SFYear sfYear : database) {
                if(sfYear.getcurrentYear() == year) {
                    a = true;
                    sfYear.addRecord(record);
                    break;
                }
            }

            if(a == false) {
                SFYear nYear = new SFYear(year);
                nYear.addRecord(record);
                database.add(nYear);
            }


        } 

    }

    /**
     * This method returns the stop and frisk records of a given year where
     * the people that was stopped was of the specified race.
     *
     * @param year we are only interested in the records of year.
     * @param race we are only interested in the records of stops of people of race.
     * @return an ArrayList containing all stop and frisk records for people of the
     * parameters race and year.
     */

    public ArrayList<SFRecord> populationStopped ( int year, String race ) {

        // WRITE YOUR CODE HERE
        ArrayList<SFRecord> recordList = new ArrayList<SFRecord>();

        for(SFYear sfy : database) {
            if(sfy.getcurrentYear() == year) {
                for(SFRecord r : sfy.getRecordsForYear()) {
                    if(r.getRace().equals(race)) {
                        recordList.add(r);
                    }
                }
            }
        }

        return recordList;
    }

    /**
     * This method computes the percentage of records where the person was frisked and the
     * percentage of records where the person was arrested.
     *
     * @param year we are only interested in the records of year.
     * @return the percent of the population that were frisked and the percent that
     *         were arrested.
     */
    public double[] friskedVSArrested ( int year ) {

        double[] friskedArrested = new double[2];
        double friskedCounter = 0;
        double arrestedCounter = 0;
        double numOfRecords = 0;

        for(SFYear sfy : database) {
            if(sfy.getcurrentYear() == year) {
                for(SFRecord sfr : sfy.getRecordsForYear()) {
                    if(sfr.getArrested() == true) {
                        friskedCounter++;
                    }
                    if(sfr.getFrisked() == true) {
                        arrestedCounter++;
                    }
                    numOfRecords++;
                }
            }
        }

        friskedArrested[0] = (arrestedCounter/numOfRecords)*100;
        friskedArrested[1] = (friskedCounter/numOfRecords)*100;
        return friskedArrested;
    }

    /**
     * This method keeps track of the fraction of Black females, Black males,
     * White females and White males that were stopped for any reason.
     * Drawing out the exact table helps visualize the gender bias.
     *
     * @param year we are only interested in the records of year.
     * @return a 2D array of percent of number of White and Black females
     *         versus the number of White and Black males.
     */
    public double[][] genderBias ( int year ) {

        double[][] genderarray = new double[2][3];
        double nb = 0;
        double nw = 0;
        double nbm = 0;
        double nwm = 0;
        double nbf = 0;
        double nwf = 0;

        for(SFYear sfy : database) {
            if(sfy.getcurrentYear() == year) {
                for(SFRecord sfr : sfy.getRecordsForYear()) {
                    if(sfr.getRace().equals("B")) {
                        nb++;
                        if(sfr.getGender().equals("F")) {
                            nbf++;
                        } else if(sfr.getGender().equals("M")) {
                            nbm++;
                        }
                    } else if(sfr.getRace().equals("W")) {
                        nw++;
                        if(sfr.getGender().equals("F")) {
                            nwf++;
                        } else if(sfr.getGender().equals("M")) {
                            nwm++;
                        }
                    }
                }
            }
        }

        double blackFemalePerc = (nbf / nb) * 0.5 * 100;
        double blackMalePerc =  (nbm / nb) * 0.5 * 100;
        double whiteFemalePerc =  (nwf / nw) * 0.5 * 100;
        double whiteMalePerc =  (nwm / nw) * 0.5 * 100;
        double totalFemalePerc =  blackFemalePerc + whiteFemalePerc;
        double totalMalePerc = blackMalePerc + whiteMalePerc;

        genderarray[0][0] = blackFemalePerc;
        genderarray[0][1] = whiteFemalePerc;
        genderarray[0][2] = totalFemalePerc;
        genderarray[1][0] = blackMalePerc;
        genderarray[1][1] = whiteMalePerc;
        genderarray[1][2] = totalMalePerc;

        return genderarray; // update the return value
    }

    /**
     * This method checks to see if there has been increase or decrease 
     * in a certain crime from year 1 to year 2.
     *
     * Expect year1 to preceed year2 or be equal.
     *
     * @param crimeDescription
     * @param year1 first year to compare.
     * @param year2 second year to compare.
     * @return
     */

    public double crimeIncrease ( String crimeDescription, int year1, int year2 ) {

        double year1Count = 0;
        double year2Count = 0;
        double year1Total = 0;
        double year2Total = 0;

        for(SFYear sfy : database) {
            if(sfy.getcurrentYear() == year1) {
                for(SFRecord sfr : sfy.getRecordsForYear()) {
                    if(sfr.getDescription().indexOf(crimeDescription) != -1) {
                        year1Count++;
                    }
                    year1Total++;
                }
            }
        }

        for(SFYear sfy1 : database) {
            if(sfy1.getcurrentYear() == year2) {
                for(SFRecord sfr1 : sfy1.getRecordsForYear()) {
                    if(sfr1.getDescription().indexOf(crimeDescription) != -1) {
                        year2Count++;
                    }
                    year2Total++;
                }
            }
        }

        double year1Perc = (year1Count / year1Total) * 100;
        double year2Perc = (year2Count / year2Total) * 100;
        double x = year2Perc - year1Perc;

        return x; // update the return value
    }

    /**
     * This method outputs the NYC borough where the most amount of stops 
     * occurred in a given year. This method will mainly analyze the five 
     * following boroughs in New York City: Brooklyn, Manhattan, Bronx, 
     * Queens, and Staten Island.
     *
     * @param year we are only interested in the records of year.
     * @return the borough with the greatest number of stops
     */
    public String mostCommonBorough ( int year ) {

        int brooklyn = 0;
        int manhattan = 0;
        int bronx = 0;
        int queens = 0;
        int staten = 0;

        for(SFYear sfy : database) {
            if(sfy.getcurrentYear() == year) {
                for(SFRecord sfr : sfy.getRecordsForYear()) {
                    if(sfr.getLocation().equalsIgnoreCase("BROOKLYN")) {
                        brooklyn++;
                    } else if(sfr.getLocation().equalsIgnoreCase("MANHATTAN")) {
                        manhattan++;
                    } else if(sfr.getLocation().equalsIgnoreCase("BRONX")) {
                        bronx++;
                    } else if(sfr.getLocation().equalsIgnoreCase("QUEENS")) {
                        queens++;
                    } else if(sfr.getLocation().equalsIgnoreCase("STATEN ISLAND")) {
                        staten++;
                    }
                }
            }
        }
        int[] counts = {brooklyn, manhattan, bronx, queens, staten};
        String[] borough = {"Brooklyn", "Manhattan", "Bronx", "Queens", "Staten Island"};

        int index = 0;
        int num = brooklyn;

        for(int i = 0; i < counts.length; i++) {
            if(num < counts[i]) {
                index = i;
            }
        }

        return borough[index]; // update the return value
    }

}
