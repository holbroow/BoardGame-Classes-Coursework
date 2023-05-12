public class Player
{
    private String name;
    private int age;

    public Player(String name, int age) //  constructor to take name and age parameters from user and assign them to a 'Player' instance
    {
        this.name = name;
        this.age = age;
    }

    public String getName() // accessor for fetching the 'name' string variable
    {
        return this.name;
    }

    public int getAge() // accessor for fetching the 'age' integer variable
    {
        return this.age;
    }
}