package Inventory;

public class Label {
	
	private String type;
	private int iD ;
	private int day;
	private int month;

		
//	Default Constructor
	public Label() {
		type = "No Labels";
		iD = 98000000 + (int)(Math.random()*1000000);
		day = 0;
		month= 0;
	}
	
//	Constructor with 4  parameters 
	public Label(String type,int iD,int day,int month) {
		this.type = type;
		this.iD = iD;
		
		if(day>=1 && day<=31)
			this.day=day;
		else
			this.day=0;
		
		if(month>=1 && month<=12)
			this.month = month;
		else
			this.month=0;	
	}
	
//	Copy Constructor
	public Label(Label other) {
		if (other==null) System.exit(0);
		type = other.type;
		iD = other.iD;
		day = other.day;
		month = other.month;
	}
	
//  Accessor Methods
	public String getType() {
		return type;
	}
	public int getiD() {
		return iD;
	}
	public int getDay() {
		return day;
	}
	public int getMonth() {
		return month;
	}
	
//  Mutator Methods
	public void setDay(int day) {
		if(day>=1 && day<=31)
			this.day=day;
		else
			this.day=0;
	}
	
	public void setMonth(int month) {
		if(month>=1 && month<=12)
			this.month = month;
		else
			this.month=0;
	}
	

//  method for type of the prepaid label, ID, the due date as dd/mm.
	public String toString() {
		String fDay= (day <10) ? "0"+(day) : String.valueOf(day);
		String fMonth = (month <10) ? "0"+(month) : String.valueOf(month);
		
		return  type + " - " + iD + " - " + fDay + "/" + fMonth;
	}
	
//  method for objects of type Label are identical 
	public boolean equals(Label otherLabel) {
		if(this.type.equals(otherLabel.type)  && this.iD == otherLabel.iD && this.day == otherLabel.day && this.month == otherLabel.month)
			return true;
		else
			return false;
	}
 
}
