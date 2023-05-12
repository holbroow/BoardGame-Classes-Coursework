public class BoardGame
{
    private String title;
    private String owner;
    private int minimumAge;
    private int duration;
    private int minimumPlayers;
    private int maximumPlayers;
    private double rating;

    private int playerCount;
    private int snackCount;

    public BoardGame(String title, String owner, int minimumAge, int duration, int minimumPlayers, int maximumPlayers, double rating) ////////////////////////// add playerCount??
    {
        this.title = title;
        this.owner = owner;
        this.minimumAge = minimumAge;
        this.duration = duration;
        this.minimumPlayers = minimumPlayers;
        this.maximumPlayers = maximumPlayers;

        this.playerCount = 0;
        this.snackCount = 0;


        if (this.rating < 0 && this.rating > 100)
        {
            System.out.println("Rating percentage not valid. Setting to 0.\n");
            this.rating = 0;
        }
        else
        {
            this.rating = rating;
        }
    }

    public String getTitle() // accessor for fetching the 'title' string variable
    {
        return title;
    }

    public String getOwner() // accessor for fetching the 'owner' string variable
    {
        return owner;
    }

    public int getMinimumAge() // accessor for fetching the 'minimumAge' integer variable
    {
        return minimumAge;
    }

    public int getDuration() // accessor for fetching the 'duration' integer variable
    {
        return duration;
    }

    public int getMinimumPlayers() // accessor for fetching the 'minimumPlayers' integer variable
    {
        return minimumPlayers;
    }

    public int getMaximumPlayers() // accessor for fetching the 'maximumPlayers' integer variable
    {
        return maximumPlayers;
    }

    public double getRating() // accessor for fetching the 'rating' double variable
    {
        return rating;
    }

    public int getPlayerCount()
    {
        return playerCount;
    }

    public int getSnackCount()
    {
        return snackCount;
    }

    public void setRating(double rating) // mutator for setting the rating of the board game
    {
        if (this.rating < 0 && this.rating > 100)
        {
            System.out.println("Rating percentage not valid.\n");
        }
        else
        {
            System.out.printf("The new rating for this game is %d\n", rating);
            this.rating = rating;
        }
    }

    public void incrementPlayerCount()
    {
        playerCount++;
    }

    public void incrementSnackCount()
    {
        snackCount++;
    }
}