public class RectangleTest {
    
    public static void main(String[] args)
    {
        Rectangle test1 = new Rectangle();
        test1.setLength(2.0);
        test1.setBreadth(4.0);
        double extracted_len = test1.getLength();
        double extracted_breadth = test1.getBreadth();
        System.out.println("Length"+ extracted_len);
        System.out.println("Breadth"+extracted_breadth);
    }
}
