public class MethodOverloadTest {
    
    public static void main(String[] args)
    {
        MethodOverload test = new MethodOverload();
        int test1 = test.square(2);
        double test2 = test.square(2.5);
        System.out.println(test1);
        System.out.println(test2);
    }
}
