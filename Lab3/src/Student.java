class Student{
   private String studentId;
   private String name;
   private String gender;
   private String dateOfBirth;
   private String address;
   static int counter=001;

   public Student(String name, String gender, String dateOfBirth,String address){
       this.name=name;
       this.gender=gender;
       this.dateOfBirth=dateOfBirth;
       this.address=address;
       this.studentId=getId();

   }

     public Student(String studentId,String name, String gender, String dateOfBirth,String address){
       this.name=name;
       this.gender=gender;
       this.dateOfBirth=dateOfBirth;
       this.address=address;
       this.studentId=studentId;
   }

     public Student(){
      this.name = "Unknown";
      this.gender="x";
      this.dateOfBirth="00-00-0000";
      this.address="Not found";
      this.studentId="SP25-BCS-000";

   }
   
     public Student(Student s){
       this.name=getName();
       this.gender=getGender();
       this.dateOfBirth=getDob();
       this.address=getAddress();
       this.studentId=getId();

   }
   
   public String getId(){
      return String.format("SP25-BCS-%03d",counter++);
   }

   public void setName(String name){
       this.name=name;
   }

   public String getName(){
      return this.name;
   }

   public void setAddress(String address){
       this.address=address;
   }

   public String getAddress(){
      return this.address;
   }

   public void setDob(String dateOfBirth){
       this.dateOfBirth=dateOfBirth;
   }

   public String getDob(){
      return this.dateOfBirth;
   }

   public void setGender(String gender){
       this.gender=gender;
   }

   public String getGender(){
      return this.gender;
}

   @Override
   public boolean equals(Object o){
          if(this == o)  return true;
          if (!(o instanceof Student)) return false;

          Student s = (Student) o;

          return this.name.equals(s.name) &&
               this.gender.equals(s.gender) &&
               this.dateOfBirth.equals(s.dateOfBirth) &&
               this.address.equals(s.address);
    }

          

   @Override
   public String toString(){
          return String.format("ID: %s\nName: %s\nGender: %s\nDate of Birth: %s\nAddress: %s\n",studentId, name, gender, dateOfBirth, address);
}

}