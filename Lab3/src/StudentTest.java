
public class StudentTest{
       public static void main(String[] args) {
               
        Student s1 = new Student("SP25-BCS-001", "Ali Khan", "Male", "1-9-2025", "Lahore, Pakistan");
        Student s2 = new Student("SP25-BCS-002", "Sara Ahmed", "Female","11-5-2025", "Karachi, Pakistan");
        Student s3 = new Student("Ali Khan","Male", "6-10-2025", "Lahore, Pakistan"); 
        Student s4 = new Student();
        Student s5 = new Student(s2);

        
        System.out.println("Student Details");
        System.out.println(s1);
        System.out.println(s2);
        System.out.println(s3);
        System.out.println(s4);
        System.out.println(s5);
        
        System.out.println("Student 1 is equal to Student 3? " + s1.equals(s3));
        System.out.println("Student 1 is equal to Student 2? " +s1.equals(s2));
        System.out.println("Student 2 is equal to Student 4? " + s2.equals(s4));
        System.out.println("Student 4 is equal to Student 5? " +s4.equals(s5));

        
             



}

}