

public class Car{
    private String color;
    private String brand;
    private String model;
    private String fuel;

    public void setColor(String carColor)
    {
        color = carColor; 
    }
    public void setBrand(String carBrand)
    {
        brand = carBrand; 
    }
    public void setModel(String carModel)
    {
        model = carModel;
    }
    public void setFuel(String carFuel)
    {
        fuel = carFuel; 
    }
} 

public static void main(String[] args)
{
    Car ford = new Car();

    Car toyota = new Car();

    Car volkswagon = new Car();

}