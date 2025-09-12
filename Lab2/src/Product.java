class Product {
   private String name;
   private int id;
   private double price;
   private boolean available;

   public Product(){
      this.name="Dell";
      this.id=908;
      this.price=9000;
      this.available=true;
   }
    
   public Product(String name,int id,double price,boolean availability){
      this.name="Dell";
      this.id=908;
      this.price=9000;
      this.available=true;
   }
    
   public void setId(int id){
       if(id>0)
           this.id=id;
        else
           System.out.println("Invalid");
   }

   public int getId(){
       return id;
   }

    public void setName(String name){
       if(name!="")
           this.name=name;
        else
           System.out.println("Invalid");
   }

   public String getName(){
       return name;
   }

    public void setPrice(double price){
       if(price>0)
           this.price=price;
        else
           System.out.println("Invalid");
   }

   public double getPrice(){
       return price;
   }

    public void setAvailable(boolean available){
       if(available!=false)
           this.available=available;
        else
           System.out.println("Invalid");
   }

   public boolean getAvailable(){
       return available;
   }

   void display(){
    System.out.printf("Name: %s \n",name);
    System.out.printf("Product Id: %d \n",id);
    System.out.printf("Price: %.3f \n",price);
    System.out.printf("Product Availability: %b \n",available);
   }
}
