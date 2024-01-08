import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static void printMenu(ArrayList<Menu> list){
        int index = 1;
        for(Menu menu : list) {
            if(index == 1){
                System.out.println("[ Starbucks Menu ]");
            }else if (index == 4){
                System.out.println();
                System.out.println("[ Order Menu ]");
            }
            System.out.print(index++ + ". ");
            menu.printInfo();
        }
        System.out.printf("%n%s%n","[ Administrator ]");
        System.out.printf("%d. %-10s | %s%n",index,"End","키오스크를 종료합니다.");
    }
    static void printProduct(ArrayList<Product> list, String category){
        System.out.println("[ "+ category + " Menu ]");
        int index = 1;
        for(Product product : list) {
            System.out.print(index + ". ");
            product.printInfo();
            index++;
        }
    }
    static void printConfirm(){
        System.out.println("위 메뉴를 장바구니에 추가하겠습니까?");
        System.out.println("1. 확인       2. 취소");
    }
    static void printGreeting(){
        System.out.printf("%5s %s %5s%n","","Welcome to Starbucks!","");
//        System.out.printf("%5s %s %5s%n","","Please choose menu","");
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Menu> menuList = new ArrayList<>(); // 메뉴 목록
        menuList.add(new Menu("Coffee","Enjoy Coffee"));
        menuList.add(new Menu("Food","Enjoy Food"));
        menuList.add(new Menu("Goods","Enjoy Goods"));
        menuList.add(new Menu("Order","장바구니를 확인 후 주문합니다."));
        menuList.add(new Menu("Cancel","진행중인 주문을 취소합니다."));

        ArrayList<Product> coffeeList = new ArrayList<>(); // 커피 목록
        coffeeList.add(new Product("Americano",3.5, "This is Americano."));
        coffeeList.add(new Product("Latte",4.5, "This is Latte."));
        coffeeList.add(new Product("Espresso",3.0, "This is Espresso."));

        ArrayList<Product> foodList = new ArrayList<>(); // 음식 목록
        foodList.add(new Product("Sandwich", 6.0, "This is Sandwich"));
        foodList.add(new Product("Banana", 1.5, "This is Banana"));
        foodList.add(new Product("Cake", 6.5, "This is Cheese Cake"));

        ArrayList<Product> goodsList = new ArrayList<>(); //굿즈 목록
        goodsList.add(new Product("Mug", 7.0, "This is Mug"));
        goodsList.add(new Product("Tumbler", 15.0, "This is Tumbler"));
        goodsList.add(new Product("Tea Bag(5EA)", 5.0, "This is Tea Bag Set"));

        Order customer = new Order();//고객 1명의 경우 , 입장
        ArrayList<Order> customerList = new ArrayList<>();
        //주문하는 페이지를 무한 루프로 구현했다. 제대로 선택한 경우는 주문완료 후 종료하는 루프
        int user_input;
        boolean exitFlag = true; //종료 플래그
        while(exitFlag){
            printGreeting();//유저에게 화면 출력
            printMenu(menuList);//상품 카테고리 보여줌
            user_input = sc.nextInt();//고객의 입력 받아서 케이스별로 함수 실행.
            int confirm = 0;
            switch(user_input){
                case 1: //커피
                    printProduct(coffeeList, "Coffee" );
                    user_input = sc.nextInt();//메뉴 선택
                    printConfirm(); // 주문 확인
                    confirm = sc.nextInt();
                    if(confirm == 1){
                        customer.orderProduct(user_input,coffeeList);
                    }else{
                        System.out.println("Order Canceled");
                    }
                    break;
                case 2: //푸드
                    printProduct(foodList, "Food");
                    user_input = sc.nextInt();//메뉴 선택
                    printConfirm(); // 주문 확인
                    confirm = sc.nextInt();
                    if(confirm == 1){
                        customer.orderProduct(user_input,foodList);
                    }else{
                        System.out.println("Order Canceled");
                    }
                    break;
                case 3: //굿즈
                    printProduct(goodsList, "Goods");
                    user_input = sc.nextInt();//메뉴 선택
                    printConfirm(); // 주문 확인
                    confirm = sc.nextInt();
                    if(confirm == 1){
                        customer.orderProduct(user_input,goodsList);
                    }else{
                        System.out.println("Order Canceled");
                    }
                    break;
                case 4:
                    System.out.println("아래와 같이 주문 하시겠습니까?");
                    customer.printList();//주문 목록 출력
                    System.out.println("1. 주문       2.메뉴판");
                    user_input = sc.nextInt();
                    if(user_input == 1){//주문 결정
                        customerList.add(customer);
                        System.out.println("대기번호는 [" + customerList.size() + "] 번 입니다.");
                        System.out.println("메뉴판으로 돌아갑니다.");
                        System.out.println();
                    }
                    break;
                case 5:
                    System.out.println("진행하던 주문을 취소하시겠습니까?");
                    System.out.println("1. 확인       2.취소");
                    user_input = sc.nextInt();
                    if(user_input == 1){
                        System.out.println("진행하던 주문이 취소되었습니다.");
                        customer = new Order();
                    }
                    break;
                default:
                    System.out.println("Machine terminated.");
                    exitFlag = false;
            }
        }
    }
}
/* 개선사항
* 1. main안에 있는 switch문을 깔끔하게 할 수 있는 방법이 없을까?
* 2. main안에 커피리스트, 푸드리스트, 굿즈리스트 들을 다른곳에서 만들 수 없을까?
* 3. main 메소드가 너무 지저분하다. 깔끔하게 만들고싶다.*/
