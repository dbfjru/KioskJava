import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static void printMenu(ArrayList<Menu> list){
        int index = 1;
        for(Menu menu : list) {
            System.out.print(index++ + ". ");
            menu.printInfo();
        }
    }
    static void printProduct(ArrayList<Product> list){
        int index = 1;
        for(Product product : list) {
            System.out.print(index + ". ");
            product.printInfo();
            index++;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Menu> menuList = new ArrayList<>(); // 메뉴 목록
        menuList.add(new Menu("Coffee","Enjoy Coffee"));
        menuList.add(new Menu("Food","Enjoy Food"));
        menuList.add(new Menu("Goods","Enjoy Goods"));

        ArrayList<Product> coffeeList = new ArrayList<>(); // 커피 목록
        coffeeList.add(new Product("Americano",3.5, "This is Americano."));
        coffeeList.add(new Product("Latte",4.5, "This is Latte."));
        coffeeList.add(new Product("Espresso",3.0, "This is Espresso."));

        ArrayList<Product> foodList = new ArrayList<>(); // 음식 목록
        foodList.add(new Product("Sandwich", 6.0, "This is Sandwich"));
        foodList.add(new Product("Banana", 1.5, "This is Banana"));
        foodList.add(new Product("Cheese Cake", 6.5, "This is Cheese Cake"));

        ArrayList<Product> goodsList = new ArrayList<>(); //굿즈 목록
        goodsList.add(new Product("Mug", 7.0, "This is Mug"));
        goodsList.add(new Product("Tumbler", 15.0, "This is Tumbler"));
        goodsList.add(new Product("Tea Bag(5EA)", 5.0, "This is Tea Bag Set"));

        //Todo : 주문 클래스 만들어야함

        //유저에게 화면 출력
        System.out.println("#######################");
        System.out.println("#Welcome to Starbucks!#");
        System.out.println("#######################");
        System.out.println();
        System.out.println("Please choose category.");

        //주문하는 페이지를 무한 루프로 구현했다. 제대로 선택한 경우는 주문완료 후 종료하는 루프
        int user_input;
        boolean exitFlag = true; //종료 플래그
        while(exitFlag){
            //상품 카테고리 보여줌
            printMenu(menuList);
            //고객의 입력 받아서 케이스별로 함수 실행.
            user_input = sc.nextInt();
            switch(user_input){
                case 1:
                    System.out.println("[Coffee Menu]");
                    printProduct(coffeeList);
                    //choose and add to orderList.
                    user_input = sc.nextInt(); //new user_input
                    coffeeList.get(user_input-1).printInfo();
                    //
                    exitFlag = false;//루프 종료
                    System.out.println("--------------------");
                    break;
                case 2:
                    System.out.println("[Food Menu]");
                    printProduct(foodList);
                    exitFlag = false;
                    break;
                case 3:
                    System.out.println("[Goods Menu]");
                    printProduct(goodsList);
                    exitFlag = false;
                    break;

                /*Todo : 장바구니 , 주문취소 기능
                 * case 5: 장바구니 확인기능
                 * case 6: 주문 취소 기능
                 * 추가해야함*/
                default:
                    System.out.println("Wrong Category!");
                    System.out.println("Choose Again!");
            }
        }
    }
}