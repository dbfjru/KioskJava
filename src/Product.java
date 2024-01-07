public class Product extends Menu{
    double price = 0;
    Product(){
        super();
    };
    Product(String name, double price, String description){
        this.name = name;
        this.description = description;
        this.price = price;
    }
    void printInfo(){
        System.out.print(name+" | ");
        System.out.print(price + " | ");
        System.out.println(description);
    }
}
