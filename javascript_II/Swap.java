public class Swap {
    
    private int firstnum;
    private int secondnum;

    public void setFirstNum(int number)
    {
        firstnum = number;
    }

    public void setSecondNum(int secondnumber)
    {
        secondnum = secondnumber;
    }

    public void SwapVals()
    {
        firstnum = firstnum + secondnum;
        secondnum = firstnum - secondnum;
        firstnum = firstnum - secondnum;

    }

    public int getFirstNum()
    {
        return firstnum;
    }

    public int getSecondNum()
    {
        return secondnum;
    }

    public static void main(String[] args)
    {
        Swap test = new Swap();
        test.setFirstNum(5);
        test.setSecondNum(6);
        test.SwapVals();
        int firstprint = test.getFirstNum();
        int secondprint = test.getSecondNum();
        System.out.println("Swapped First Number: " + firstprint);
        System.out.println("Swapped Second Number: " + secondprint);
    }
}


