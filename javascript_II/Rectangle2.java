public class Rectangle2 implements Shape{

    private double length;
    private double width;

    @Override 
    public double getArea()
    {
        return length * width;
    }
}
