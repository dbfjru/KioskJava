import java.util.ArrayList;

public class Order {
    private ArrayList<Product> orderList = new ArrayList<>();
    private double totalFee;
    Order(){}
    void orderProduct(int num, ArrayList<Product> productList){
        /*고객의 주문 메소드
        * num : 고객이 고른 번호
        * productList : 고객이 고른 카테고리 (커피, 푸드, 굿즈)*/
        orderList.add(productList.get(num-1));
    }
    void printList(){
        //고객의 장바구니 출력
        System.out.println("[Orders]");
        for(Product p : orderList){
            System.out.printf("%-10s | W %s |%s%n",p.name,p.price,p.description);
            totalFee += p.price;
        }
        System.out.printf("%s%n W %s%n","[Total]", totalFee);
//        System.out.println("[Total]");
//        System.out.println("W "+totalFee);
    }
}
