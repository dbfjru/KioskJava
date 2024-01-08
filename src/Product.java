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
        System.out.printf("%-10s | W %s |%s%n",name,price,description);
    }

}
