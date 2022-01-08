package itemSrc;


import java.util.Scanner;

import java.io.*;

/**
 * This class puts everything together, it is the applications entry point
 * You can have your main method here if you wish.
 * @author John Kanyaru
 *
 */
public class Manager
{
	/**
	 * instance fields brief overview:
	 * workers - a number of workers in the warehouse. An  array is used here, feel free to use 
	 * an alternative data structure
	 * numWorkers - starting with with one worker. That is, this simulation is for one worker
	 * custQ - the collection of queueing customers
	 * allParcels - collection of items/parcels being processed
	 * wSpeed - work speed
	 */
	private Worker workers[];
	private int numWorkers = 1;
	private QueueOfCusts custQ;
    private ParcelMap allParcels;
   
   private int wSpeed [];
   
   /**
    * the constructor is done
    * instantiate it and use methods following it to perform unit tests
    */
    public Manager()
    {
    	custQ = new  QueueOfCusts();
    	allParcels = new ParcelMap();
    }
    

/**
 * this method is responsbile for reading relevant files such as
 * item/parcefile, customerfile
 * also, initialise a number of customers to be in the queue, e.g., 6 customers
 * perform a simple println of all parcel details, and queueing customers details
 * Logic of initialisation:
 * 1) read customer file
 * 2) read items/parcel file
 * 3) put 6 or so customers in the queue by:
 * 3.1) use for loop to repeat 6 times
 * 3.2) declare a reference of CustInQue and put in it the ith value of custQ.
 * 3.3) Now set the CustIQue reference to be in inQueue (setInQueue()).
 * 4) print all parcel details to the console
 * 5) print all queing customers to the console
 */
    public void initialiseData() {
    	// to remove
    	readCustFile();

    	readParcelFile();
    	
    	//put 10 customers in the queue
    	for (int i = 0; i < 10; i++ ) {
    		CustInQueue c = custQ.get(i);
    		c.setInQueue(true);
    	}

    	System.out.println(" parcel details"+allParcels.listDetails());

    	
    	
    }
    
    
   
/**
 * a method to read cust.csv file.
 * use an object of Scanner to read the file
 * You will need to use the split method of String class to read input appropriately
 * catch appropriate exceptions
 */
    public void readCustFile() {
    	// to remove
    	try {
    		Scanner scanner = new Scanner (new File("Custs.csv"));
    		System.out.println("Scanning");
        	while(scanner.hasNext()){  
            	String inputLine = scanner.nextLine();
            	System.out.println(inputLine);
        		processCustLine(inputLine);

        	}
    	}
    	catch (Exception e) {
    		
    	}
    }
    /**
     * 
     *this is to do the nitty gritty business of reading the file by splitting content
     *based on used delimeter.
     *its a private method because it is called in the readCustFile above.
     *You can keep it, that way or do all the work in the method above
     *once splitting has happened, identify which one is id, and which one is pid.
     *use the id and pid to create an object of CustInque
     *Add the object of CustinQue to custQ
     */
    private void processCustLine (String inputLine) {
//to remove
		try {
			String parts [] = inputLine.split(",");
			
			//first, the number
			String id =  parts[0].trim();
			
			//then the days
			String pid = parts[1].trim();
			
			//create  object and add to the list
			CustInQueue c= new CustInQueue (id, pid);
    		//add to list
            custQ.addDetails(c);
		}

			//  ignore lines in error and try and carry on
			
			//this catches trying to convert a String to an integer
			catch (NumberFormatException nfe) {
				String error = "Number conversion error in '"
	                   + inputLine + "'  - " + nfe.getMessage();
				System.out.println(error);
			}
			//this catches missing items if only one or two items
			//other omissions will result in other errors
			catch (ArrayIndexOutOfBoundsException air) {
				String error = "Not enough items in  : '" + inputLine
				            + "' index position : " + air.getMessage();
				System.out.println(error);
			}
		}
    
    /**
     * similar functionality as readcustomer file
     * follow same concept
     */
    public void readParcelFile() {
    	try {
    		Scanner scanner = new Scanner (new File("Parcels.csv"));
    		System.out.println("Scanning");
        	while(scanner.hasNext()){  
            	String inputLine = scanner.nextLine();
            	System.out.println(inputLine);
        		processParcelLine(inputLine);

        	}
    	}
    	catch (Exception e) {
    		
    	}
    }
    /**
     * similar to processcustline
     * simply, breakdown file content into appropriate data 
     * items using String's split() method 
     * once you obtain all parcel details, create a parcel object, and add 
     * it to allParcels collection
     */
    
    private void processParcelLine (String inputLine) {

				 
    	try {
			String parts [] = inputLine.split(",");
			String id = parts[0].trim();
			
			//then the days
			String dayString = parts[1].trim();
			int days = Integer.parseInt(dayString);
	

		    //then the dim
			String lenString = parts[2].trim();
			int l = Integer.parseInt(lenString);
			
			String widString = parts[3].trim();
			int w = Integer.parseInt(widString);
			
			String heightString = parts[4].trim();
			int h = Integer.parseInt(heightString);
			
			String weightString = parts[5].trim();
			int weight = Integer.parseInt(weightString);
			
			//create  object and add to the list
			Parcel p = new Parcel (id, days, l,h,w, weight);
    		//add to list
            allParcels.addDetails(p);
		}

			//  ignore lines in error and try and carry on
			
			//this catches trying to convert a String to an integer
			catch (NumberFormatException nfe) {
				String error = "Number conversion error in '"
	                   + inputLine + "'  - " + nfe.getMessage();
				System.out.println(error);
			}
			//this catches missing items if only one or two items
			//other omissions will result in other errors
			catch (ArrayIndexOutOfBoundsException air) {
				String error = "Not enough items in  : '" + inputLine
				            + "' index position : " + air.getMessage();
				System.out.println(error);
			}
		}

   
    	/* this code snippet can be used if you want to print a log to file.
    	 * The Log class is already available for your use.
    	 * 
    		System.out.println("Writing log file");
        	try {
        		File f = new File("Log.txt");
        		FileWriter fw = new FileWriter(f);
        		Log log = Log.getInstance();
        		fw.write(log.toString());
        		fw.close();
        	}
        	catch (IOException e){
        		e.printStackTrace();
        	}
        	System.exit(0);
    	}	
    	
    }
    */
    
    /**
     * Print to text file*/

    public void print() {
    	FileWriter fw = null;
    	try {
        	fw = new FileWriter("ItemDetails.txt");
        	fw.write(custQ.getNext().getName() +", " +custQ.getNext().getpId().toString());
        	fw.close();
    	}
    	catch (FileNotFoundException e) {
    		System.out.println(e.getMessage());
    		System.exit(1);
    	}
    	
    	catch (IOException ioe){
    		System.exit(1);
    	}

    }
    
          
}

