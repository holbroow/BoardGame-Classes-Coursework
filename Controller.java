public class Controller
{
    public static void main(String args[])
    {
        BoardGame pictionary = new BoardGame("Pictionary", "Will", 10, 60, 2, 5, 0);
        GamingParty party = new GamingParty("Friends Gathering", pictionary);
        
        Player p1 = new Player("Ioannis", 25);
        Player p2 = new Player("Adrian", 20);
        Player p3 = new Player("Paul", 50);
        Player p4 = new Player("Will", 19);

        party.addPlayer(p1);
        party.addPlayer(p2);
        party.addPlayer(p3);
        party.addPlayer(p4);

        Snack s1 = new Snack("Fruit salad", 2, p2);
        Snack s2 = new Snack("Coca Cola", 1.50, p3);
        Snack s3 = new Snack("Mango", 0.50, p4);
        Snack s4 = new Snack("Chocolate Bar", 1.20, p4);
        party.addSnack(s1);
        party.addSnack(s2);
        party.addSnack(s3);
        party.addSnack(s4);
        

        party.play();

        party.setWinner(p1);

        party.outputPartyDetails();

        party.calculateRecommendedSnacks();

        System.out.println(party.getPartyCost());
    }
}