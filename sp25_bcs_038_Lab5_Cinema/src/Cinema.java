public class Cinema{
	private String branchName;
	private Screen[] screens;
	private int size;
	
	public Cinema(String branchName,int preCount){
		this.branchName=branchName;
		this.screens=new Screen[preCount];
		this.size=0;
		
		for(int i=0;i<screens.length;i++){
			addScreen("Screen-" + (i + 1));
		}
	}
	
	public String getBranchName() {
       return branchName;
	}

	public int getSize() {
		return size;
	}

	public void addScreen(String name){
		if(size==screens.length){
			growCapacity();
		}
		screens[size++]=new Screen();
	}
	
	public void growCapacity(){
		int newCapacity = (screens.length == 0) ? 1 : screens.length * 2;
		Screen[] newArray = new Screen[newCapacity];
		for (int i = 0; i < screens.length; i++) {
			newArray[i] = screens[i];                       
		}
		screens = newArray;
	}
	
	public Screen getScreen(int idx){
		if(idx>size || idx<1){
			return null;
		}
		return screens[idx-1];
	}
	
	public boolean bookSeat(int idx,String id){
		Screen s=getScreen(idx);
		return (s!=null) && s.bookSeat(id);
	}
	
	public boolean cancelSeat(int idx,String id){
		Screen s=getScreen(idx);
		return (s!=null) && s.cancelSeat(id);
	}
	
	public int getAvailableSeats(){
		int count=0;
		for(int i=0;i<size;i++){
			count+=screens[i].getAvailableSeats().length;
		}
		return count;
	}
	
	public int getAvailableSeatsByType(SeatType type){
		int count=0;
		for(int i=0;i<size;i++){
			count+=screens[i].getAvailableSeatsByType(type).length;
		}
		return count;
	}
	
	public void display(){
		System.out.println("Cinema:"+branchName);
		for(int i=0;i<size;i++){
			screens[i].display();
		}
	}
	
	@Override
	public String toString(){
		int totalSeats=0;
		int availableSeats=0;
		for(int i=0;i<size;i++){
			Screen s=screens[i];
			totalSeats += s.getTotalSeats();
			availableSeats+=s.getAvailableSeats().length;
		}
		return "Cinema[" + branchName + "] | Screens: " + size +
           " | Total Seats: " + totalSeats +
           " | Available: " + availableSeats;
	}
	
} 