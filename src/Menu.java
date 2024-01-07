import java.util.ArrayList;

public class Menu {
    String name="";
    String description="";
    static ArrayList<Menu> list = new ArrayList<>(); // 클래스 멤버로 목록을 만들 필요가 있을까?
    Menu(){};
    Menu(String name, String description){
        this.name = name;
        this.description = description;
    }
    void printInfo(){
        System.out.print(name+" : ");
        System.out.println(description);
    }
}
