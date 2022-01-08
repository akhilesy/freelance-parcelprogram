package itemSrc;

/**
 * A class about a parcel that forms the order item For you, it will be another
 * item. I will email you the item to work with. You will decide on attributes
 * and methods and do appropriate tests
 * 
 * @author John Kanyaru
 *
 */

public class Parcel implements Comparable<Parcel> {
	/**
	 * id - to identify each parcel(item) days - number of days waiting to be
	 * collected width, height, weight - dimensions and how heavy closed - whether
	 * the parcel/item is now closed, not waiting any more
	 */
	private String id;
	private int days;
	private int length;
	private int width;
	private int height;
	private int weight;
	private boolean collected = false;

	/**
	 * You are to complete this parameterised constructor complete the
	 * implementation of the constructor
	 * 
	 * @param id
	 * @param days
	 * @param length
	 * @param width
	 * @param height
	 * @param weight
	 */

	public Parcel(String id, int days, int length, int width, int height, int weight) {
		super();
		this.id = id;
		this.days = days;
		this.length = length;
		this.width = width;
		this.height = height;
		this.weight = weight;

	}

	public Parcel() {
		// TODO Auto-generated constructor stub
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getDays() {
		return days;
	}

	public void setDays(int days) {
		this.days = days;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public boolean isCollected() {
		return collected;
	}

	public void setCollected(boolean collected) {
		this.collected = collected;
	}

	/**
	 * Test for content equality between two objects.
	 * 
	 * @param other The object to compare to this one.
	 * @return true if the argument object has same id logic for working this out is
	 *         as follows: 1) check whether formal local parameter other is an
	 *         instance of Parcel 2) declare an object reference to parcel, e.g.,
	 *         otherItem, and coerce other to it 3) Return true if id is the same as
	 *         otherItem.getId(), otherwise, false
	 */
	public boolean equals(Object other) {
		// to remove
		if (other instanceof Parcel) {
			Parcel otherItem = (Parcel) other;
			return id.equals(otherItem.getId());
		} else {
			return false;
		}
	}

	/**
	 * We want to compare this object against another, for the purpose of sorting.
	 * The fields are compared by id.
	 * 
	 * @param otherDetails - the object be compared against.
	 * @return a negative integer if this id comes before the parameter's id, zero
	 *         if they are equal and a positive integer if this comes after the
	 *         other.
	 * 
	 *         You are to complete this method appropriately
	 */

	public int compareTo(Parcel otherDetails) {
		// to remove
		return id.compareTo(otherDetails.getId());
	}

	/**
	 * provide a complete implementation of the toString method return appropriate
	 * details of the parcel and an informative message, e.g. Parcel id days length
	 * width height weight collected where id, days, length, width, height, weight,
	 * collected are values of those fields
	 */

	@Override
	public String toString() {
		// to remove
		return "Parcel [id=" + id + ", days=" + days + ", length=" + length + ", width=" + width + ", height=" + height
				+ ", weight=" + weight + "collected:" + collected + "]";
	}

}
