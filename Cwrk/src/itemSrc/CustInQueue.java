package itemSrc;

/**
 * This class maintains a queue of parcels for customers
 * @author John Kanyaru
 *
 */
public class CustInQueue 
{
	/**
	 * the meaning of instance fields is:
	 * name - parcel name e.g., markerpen
	 * pId - parcel id
	 * qNum - number in the queue of the parcel
	 * inQueue - whether the parcel is currently in the queue or not
	 * sequence - a way to initialise the counting of parcels in the queue
	 */
	private static int sequence = 0;
	private String name;
	private String pId;
	private int qNum;
	private boolean inQueue = false;
	/**
	 * This parameterised constructor requires two arguments
	 * An instance of the class is created, the sequence field is a class field, incremented
	 * then used to generate the queue number for the parcel
	 * Complete the constructor in the manner described above.
	 * You're to perform unit tests for this constructor
	 * 
	 * @param name
	 * @param pId
	 */

    public CustInQueue(String name, String pId) {
    	super();
    	this.name=name;
    	this.pId=pId;
		
	}
    
	public String getName() {
		
		return name;
	}
	public void setName(String name) {
		 
		this.name=name;
	}
	public String getpId() {
	
		return pId;
	}
	public void setpId(String pId) {
		
		this.pId=pId;
	}
	/**
	 * write tests for this method
	 * 
	 */
	public int getqNum() {
		return qNum;
	}
	public void setqNum(int qNum) {
	
		this.qNum=qNum;
	}
	

	public boolean isInQueue() {
	
		return inQueue;
	}

	public void setInQueue(boolean inQueue) {
		this.inQueue=inQueue;
	}
	
	
	
	
	
/**
 * you are to override the toString method to return the details of 
 * customer in queue  - with an informative message
 * e.g., Customer in queue is [name is:, pId is:,qNum is:]  
 * 
 * Customise this for the class provided to you
 */
	@Override 
	public String toString() {
		//to remove the
		return "CustInQueue [name=" + name + ", pId=" + pId + ", qNum=" + qNum
				+ ",queueing :  " + inQueue + ")";
	}
    
}
