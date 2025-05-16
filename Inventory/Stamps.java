package Inventory;

public class Stamps {
	
	private  int  category_A;
	private  int  category_B;
	private  int  category_C;
	private  int  category_D;
	private  int  category_E;
	
//	static constants for the values 
	public static final int category_A_Price = 2;
	public static final int category_B_Price = 5;
	public static final int category_C_Price = 10;
	public static final int category_D_Price = 15;
	public static final int category_E_Price = 20;
	
	
//	Default Constructor
	public Stamps() {	
		category_A=0;
		category_B=0;
		category_C=0;
		category_D=0;
		category_E=0;
	}
	
//	Constructor with 5 integer parameters 
	public Stamps(int category_A, int category_B, int category_C, int category_D, int category_E ) {
		
		this.category_A = category_A;
		this.category_B = category_B;
		this.category_C = category_C;
		this.category_D = category_D;
		this.category_E = category_E;	
		}
	
//	Copy Constructor
	
	public Stamps(Stamps other) {
		if (other==null) System.exit(0);
		this.category_A = other.category_A;
		this.category_B = other.category_B;
		this.category_C = other.category_C;
		this.category_D = other.category_D;
		this.category_E = other.category_E;	
	}
	
//  Accessor and mutator methods
	
	public int getCategory_A() {
		return category_A;
	}
	
	public void setCategory_A(int category_A) {
		this.category_A = category_A;
	}
	
	public int getCategory_B() {
		return this.category_B;
	}
	
	public void setCategory_B(int category_B ) {
		this.category_B = category_B;
	}
	
	public int getCategory_C() {
		return category_C;
	}
	
	public void setCategory_C(int category_C) {
		this.category_C = category_C; 
	}
	
	public int getCategory_D() {
		return category_D;
	}
	public void setCategory_D(int category_D) {
		this.category_D = category_D;
	}
	
	public int getCategory_E() {
		return category_E;
	}
	public void setCategory_E(int category_E) {
		this.category_E = category_E;
	}
	
//	Method to add stamps
	
	public void addStamps(int A, int B, int C, int D,int E) {
		
		category_A += A;
		category_B += B;
		category_C += C;
		category_D += D;
		category_E += E;
		
		}
	
//	total value of the stamps
	public int StampsTotal() {
		return category_A*2 + category_B*5 + category_C*10 + category_D*15 + category_E*20;
	}
	
//	count of each stamp
	public String toString() {
		return "Numbers of stamps:\r\n" 
			 + "   category_A($2): " + category_A + "\r\n"
			 + "   category_B($5): " + category_B + "\r\n"
			 + "   category_C($10): "+ category_C + "\r\n"
	         + "   category_D($15): "+ category_D + "\r\n"
			 + "   category_E($20): "+ category_E ; 
	}
	
//	Compare stamps
	public boolean equals(Stamps otherStamps) {
		if(this.category_A == otherStamps.category_A  && this.category_B == otherStamps.category_B && this.category_C == otherStamps.category_C && this.category_D == otherStamps.category_D && this.category_E == otherStamps.category_E) 
			return true;
		else
			return false;
	}
	

}
