public class Snack 
{
    private String description;
    private double cost;
    private Player provider;

    public Snack(String description, double cost, Player provider) //  constructor to take description, cost, and provider parameters and assign them to a 'Snack' instance
    {
        this.description = description;
        this.cost = cost;
        this.provider = provider;
    }

    public String getDescription() // accessor for fetching the 'description' string variable
    {
        return description;
    }

    public double getCost() // accessor for fetching the 'cost' double variable
    {
        return cost;
    }
    
    public Player getProvider() // accessor for fetching the 'provider' string variable
    {
        return provider;
    }
}