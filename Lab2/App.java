public class App {
    public static void main(String[] args) {
        Product p1=new Product();
        Product p2=new Product();
        Product p3=new Product("Lenovo",234,9000,false);
        Product p4=new Product("Hp",987,8000,true);
        p1.setId(123);
        p2.setName("Abc");
        p3.setAvailable(true);
        p4.setPrice(10000);
        System.out.println(p1.getId());
        System.out.println(p2.getName());
        System.out.println(p3.getAvailable());
        System.out.println(p4.getPrice());
        p1.display();
        p2.display();
        p3.display();
        p4.display();
    
    }
}
