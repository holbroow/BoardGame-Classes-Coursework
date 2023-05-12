public class GamingParty
{
    private String theme;
    private BoardGame boardGame;
    private Player[] players;
    private Snack[] snacks;
    private Player winner;

    public GamingParty(String theme, BoardGame game)
    {
        this.theme = theme;
        this.boardGame = game;
        this.players = new Player[boardGame.getMaximumPlayers()];
        this.snacks = new Snack[boardGame.getMaximumPlayers() *2];
        this.winner = null;
    }

    public void addPlayer(Player newPlayer)
    {
        if (newPlayer.getAge() < boardGame.getMinimumAge())
        {
            System.out.println("The player does not meet the age requirements for the board game at this party.\n");
            return;
        }

        boolean playerInArray = false;
        for (Player existingPlayer : players)
        {
            if (existingPlayer != null)
            {
                if (newPlayer.getName() == existingPlayer.getName())
                {
                    playerInArray = true;
                }
            }
        }

        if (playerInArray == true)
        {
            System.out.println("The player is already playing the game at this party.\n");
            return;
        }

        if (boardGame.getPlayerCount() == boardGame.getMaximumPlayers())
        {
            System.out.println("The maximum number of players has been reached for the game at this party.\n");
            return;
        }

        for (int i = 0; i < players.length; i++)
        {
            if (players[i] == null)
            {
                players[i] = newPlayer;
                boardGame.incrementPlayerCount();
                return;
            }    
        }
    }

    public void play()
    {
        if (boardGame.getPlayerCount() >= boardGame.getMinimumPlayers())
        {
            System.out.println("Play!\n");
        }
        else
        {
            System.out.printf("You need %d more player(s)!\n", (boardGame.getMinimumPlayers() - boardGame.getPlayerCount()));
        }
    }

    public void addSnack(Snack newSnack)
    {
        if (boardGame.getSnackCount() == (boardGame.getMaximumPlayers() *2))
        {
            System.out.println("There are enough snacks!\n");
            return;
        }
        
        for (int i = 0; i < snacks.length; i++)
        {
            if (snacks[i] == null)
            {
                snacks[i] = newSnack;
                boardGame.incrementSnackCount();
                return;
            }
        }
    }

    public double getPartyCost()
    {
        double totalSnackCost = 0;

        for (Snack object : snacks)
        {
            if (object != null)
            {
                totalSnackCost = (totalSnackCost + object.getCost());
            }
        }

        return totalSnackCost;
    }

    public Player getWinner()
    {
        return winner;
    }

    public void setWinner(Player winningPlayer) //////////////////////// not sure if this is the correct parameter (name) etc etc.
    {
        boolean playerInArray = false;
        for (Player object : players)
        {
            if (object != null)
            {
                if (object.equals(winningPlayer))
                {
                    playerInArray = true;
                }
            }
        }

        if (winner != null)
        {
            System.out.printf("The winner has already been decided! It was %s.\n", winner);
        }
        else if (playerInArray == false)
        {
            System.out.println("The player didn't even play the game so cannot win!\n");
        }
        else
        {
            winner = winningPlayer;
        }
    }

    public void outputPartyDetails()
    {
        if (winner != null)
        {
            System.out.printf("Theme: %s\n", theme);
            System.out.printf("Board game: %s\n", boardGame.getTitle());

            System.out.println("Players:");
            for (Player object : players)
            {
                if (object != null)
                {
                    System.out.println(object.getName());
                }
            }

            System.out.println("Snacks:");
            for (Snack object : snacks)
            {
                if (object != null)
                {
                    System.out.printf("%s provided by %s\n", object.getDescription(), object.getProvider().getName());
                }
            }
            
            System.out.printf("The winner is %s!\n", winner.getName());
        }
        else
        {
            System.out.printf("Theme: %s\n", theme);
            System.out.printf("Board game: %s\n", boardGame.getTitle());
            
            System.out.println("Players:");
            for (Player object : players)
            {
                if (object != null)
                {
                    System.out.println(object.getName());
                }
            }

            System.out.println("Snacks:");
            for (Snack object : snacks)
            {
                if (object != null)
                {
                    System.out.printf("%s provided by %s\n", object.getDescription(), object.getProvider().getName());
                }
            }
            
            System.out.println("No winner yet!\n");
        }
    }

    public void calculateRecommendedSnacks()
    {
        // for (int i = 0; i < boardGame.getDuration(); i++)
        // {
            
        // }
        int recommendedSnacks;
        double durationInHours;
        int roundedDurationInHours;
        durationInHours = (boardGame.getDuration() /60);
        roundedDurationInHours = (int)Math.round(durationInHours);

        if (roundedDurationInHours > (boardGame.getMaximumPlayers() *2))
        {
            recommendedSnacks = (boardGame.getMaximumPlayers() *2);
            System.out.printf("A total of %d snack(s) are recommended for the game.\n", recommendedSnacks);
        }
        else if (roundedDurationInHours < 1)
        {
            recommendedSnacks = boardGame.getPlayerCount();
            System.out.printf("A total of %d snack(s) are recommended for the game.\n", recommendedSnacks);
        }
        else if (boardGame.getPlayerCount() == 0)
        {
            recommendedSnacks = 0;
        }
        else
        {
            recommendedSnacks = (roundedDurationInHours * boardGame.getPlayerCount());
            System.out.printf("A total of %d snack(s) are recommended for the game.\n", recommendedSnacks);
        }
    }
}