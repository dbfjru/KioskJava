import java.util.ArrayList;

public class Menu {
    String name="";
    String description="";
    Menu(){};
    Menu(String name, String description){
        this.name = name;
        this.description = description;
    }
    void printInfo(){
        System.out.printf("%-10s | %s%n",name,description); // 포맷출력
    }
}
