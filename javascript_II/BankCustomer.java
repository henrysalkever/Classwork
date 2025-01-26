public class BankCustomer{
    private int accountNumber;
    private String customerName;
    private String customerAddress;
    private String customerDateOfBirth;

    public void setAccountNumber(int number)
    {
        accountNumber = number;
    }
    public void setName(String name)
    {
        customerName = name; 
    }
    public void setAddress(String address)
    {
        customerAddress = address;
    }
    public void setBirthday(String birthday)
    {
        customerDateOfBirth = birthday;
    }
    public int getAccountNumber()
    {
        return accountNumber;
    }
    public String getCustomerName()
    {
        return customerName;
    }
    public String getAddress()
    {
        return customerAddress;
    }
    public String getBirthday()
    {
        return customerDateOfBirth;
    }

}



