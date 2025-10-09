enum SeatType{
	REGULAR,PREMIUM,VIP,RECLINER;
}

public class Seat{
	private String id; 
	private SeatType type; 
	private double price; 
	private boolean availability; 
	
	public Seat(int row,int col,SeatType type,double price){
		this.id=String.format("%d-%03d",row,col);
		this.type=type;
		this.price=price;
		this.availability=true;
	}
	
	public Seat(String id,SeatType type,double price){
		this.id=id;
		this.type=type;
		this.price=price;
		this.availability=true;
	}
	
	public String getId(){ return this.id;}
	public SeatType getType(){ return this.type;}
	public double getPrice(){ return this.price;}
	public boolean getAvailability(){ return this.availability;}
	
	public void setId(String id){ this.id=id;}
	public void setIType(SeatType type){ this.type=type;}
	public void setPrice(double price){ this.price=price;}
	public void setAvailability(boolean availability){ this.availability=availability;}
	
	public boolean book(){
		if(getAvailability()){
			availability=false;
		    return true;
		}
		return false;
	}
	
	public boolean cancel(){
		if(!getAvailability()){
			availability=true;
		    return true;
		}
		return false;
	}
	
	@Override
	public String toString(){
		return String.format("%s(%s)-%.2f-%s",id, type, price,availability);
	}
	
}