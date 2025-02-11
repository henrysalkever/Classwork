public class Student2 {

    private String name;
    Student2(){
        
        name = "Unknown";
    }

    Student2(String new_name){
        name = new_name;
    }

    public String get_name(){
        return name;
    }

    public void printName(){
        System.out.println(name);
    }
    
}
