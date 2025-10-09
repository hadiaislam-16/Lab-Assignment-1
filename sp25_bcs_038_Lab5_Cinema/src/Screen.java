public class Screen{
	private Seat[][] seats;
	
	public Screen(){
		int[] rowLength={10,11,12,13,14};
		
		seats = new Seat[rowLength.length][];
		 
		for(int i=0;i<rowLength.length;i++){
			seats[i]= new Seat[rowLength[i]];
			
			SeatType type;
			if (i==0) type=SeatType.REGULAR;
			else if (i==1 || i==2) type=SeatType.PREMIUM;
			else if (i==3) type=SeatType.VIP;
			else type=SeatType.RECLINER;
		
			double price=getPriceByType(type);
			
			for(int j=0;j<rowLength[i];j++){
				seats[i][j]=new Seat(i+1,j+1,type,price);
			}
		}
	}
	
	public double getPriceByType(SeatType type){
		switch(type){
			case REGULAR: return 500;
			case PREMIUM: return 750;
			case VIP: return 1000;
			case RECLINER: return 1200;
			default: return 0;
		}
	}
	
	public Seat getSeat(String id){
		for(Seat[] i:seats)
			for(Seat j:i)
				if(j.getId().equals(id))
					return j;
		return null;
	}
	
	public Seat getSeat(int i,int j){
		if(i<1 || i>seats.length || j<1 || j>seats[i-1].length){
			return null;
		}
		return seats[i-1][j-1];
	}
	
	public boolean bookSeat(String id){
		Seat s=getSeat(id);
		return (s!=null) && (s.book());
	}
	
	public boolean cancelSeat(String id){
		Seat s=getSeat(id);
		return (s!=null) && (s.cancel());
	}
	
	public Seat[] getAvailableSeats(){
		int count=0;
		for(Seat[] i: seats){
			for(Seat j: i){
				if(j.getAvailability()) count++;
			}
		}
	    Seat[] result= new Seat[count];
		int index=0;
		for(Seat[] i: seats){
			for(Seat j: i){
				if(j.getAvailability()) 
					result[index++]=j;
			}
		}
		return result;
	}
	
	public Seat[] getAvailableSeatsByType(SeatType type){
		int count=0;
		for(Seat[] i: seats){
			for(Seat j: i){
				if(j.getType()== type && j.getAvailability()) count++;
			}
		}
		Seat[] result= new Seat[count];
		int index=0;
		for(Seat[] i: seats){
			for(Seat j: i){
				if(j.getType()== type && j.getAvailability()) 
					result[index++]=j;
			}
		}
		return result;	
	}
	
	public int getTotalSeats() {
    int total = 0;
    for (Seat[] row : seats) {
        total += row.length;
    }
    return total;
    }

	
	public void display(){
		for(int i=0;i<seats.length;i++){
			System.out.print("Row "+(i+1)+":");
			for(Seat j: seats[i]){
				System.out.print(j.getAvailability()?" O ":" X ");
			}
			System.out.println();
		}
	}
	
	@Override
	public String toString(){
		StringBuilder sb = new StringBuilder();
		for(Seat[] i: seats){
			for(Seat j: i){
				sb.append(j.toString()).append("\n");
			}
		}
		return sb.toString();
	}
	
}