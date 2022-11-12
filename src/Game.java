import WebServer.*;
import GameObjects.*;
import java.io.IOException;
import java.util.Random;

public class Game
{
    static Player player1, player2;
    static Player.DeckItem deckItem1, deckItem2;
    static int maxRound = 10;
    static boolean isHumanGame;
    static Random rng = new Random();

    public static void main(String[] args) //throws IOException
    {
        int port = 8080;

        //WebServer server = new WebServer();
        //server.Start(port);

        InitializeGame(false);

        int i;
        for(i = 0; i < maxRound; i++)
        {
            PlayARound();

            boolean resetIsUsedFlag = false;
            for(Player.DeckItem item : player1.GetItemDeck())
                resetIsUsedFlag |= item.isUsed;

            if(resetIsUsedFlag)
                for(Player.DeckItem item : player1.GetItemDeck())
                    item.isUsed = false;

            for(Player.DeckItem item : player2.GetItemDeck())
                resetIsUsedFlag |= item.isUsed;

            if(resetIsUsedFlag)
                for(Player.DeckItem item : player2.GetItemDeck())
                    item.isUsed = false;

            if(player1.GetItemDeck().size() == 0 && player2.GetItemDeck().size() != 0)
            {
                System.out.println(player2.GetPlayerName() + " won! His stats");
                player2.ShowScore();
                break;
            }
            else if(player1.GetItemDeck().size() != 0 && player2.GetItemDeck().size() == 0)
            {
                System.out.println(player1.GetPlayerName() + " won! His stats");
                player1.ShowScore();
                break;
            }
            else if(player1.GetItemDeck().size() == 0 && player2.GetItemDeck().size() == 0)
            {
                System.out.println("Draw! Player's stats");
                player1.ShowScore();
                player2.ShowScore();
                break;
            }
        }

        if(i >= maxRound)
        {
            if(player1.GetPlayerScore() > player2.GetPlayerScore())
            {
                System.out.println(player1.GetPlayerName() + " won! Player's stats");
                player1.ShowScore();
                player2.ShowScore();
            }
            else if(player1.GetPlayerScore() < player2.GetPlayerScore())
            {
                System.out.println(player2.GetPlayerName() + " won! Player's stats");
                player1.ShowScore();
                player2.ShowScore();
            }
            else
            {
                System.out.println("Draw! Player's stats");
                player1.ShowScore();
                player2.ShowScore();
            }
        }
    }

    public static void InitializeGame(boolean isHuman)
    {
        isHumanGame = isHuman;

        if(isHumanGame)
            InitializeHumanAiGame();
        else
            InitializeAiAiGame();
    }

    public static void InitializeHumanAiGame()
    {
        player1 = new HumanPlayer(rng.nextLong(), "Sen");
        player2 = new ComputerPlayer(rng.nextLong(), "Bilgisayar");
    }

    public static void InitializeAiAiGame()
    {
        player1 = new ComputerPlayer(rng.nextLong(), "Bilgisayar 1");
        player2 = new ComputerPlayer(rng.nextLong(), "Bilgisayar 2");
    }

    public static void PlayARound()
    {
        System.out.println("======================== START OF ROUND =========================");

        int humanSelection = -1;

        if(isHumanGame)
            humanSelection = GetHumanSelection();

        deckItem1 = player1.SelectItem(humanSelection);
        deckItem2 = player2.SelectItem(humanSelection);

        System.out.println(player1.GetPlayerName() + " chose " + deckItem1.object.GetType().toString());
        System.out.println(player2.GetPlayerName() + " chose " + deckItem2.object.GetType().toString());

        System.out.println("\n" + player1.GetPlayerName() + "'s item's stats at start of this round");
        deckItem1.ShowStats();
        System.out.println("\n" + player2.GetPlayerName() + "'s item's stats at start of this round");
        deckItem2.ShowStats();

        double attackValueForItem1, attackValueForItem2;

        switch (deckItem2.object.GetType())
        {
            default -> attackValueForItem1 = 0.0;
            case Rock -> attackValueForItem1 = deckItem1.object.CalculateAttackValue((Rock) deckItem2.object);
            case Paper -> attackValueForItem1 = deckItem1.object.CalculateAttackValue((Paper) deckItem2.object);
            case Scissor -> attackValueForItem1 = deckItem1.object.CalculateAttackValue((Scissor) deckItem2.object);
            case HeavyRock -> attackValueForItem1 = deckItem1.object.CalculateAttackValue((HeavyRock) deckItem2.object);
            case SpecialPaper -> attackValueForItem1 = deckItem1.object.CalculateAttackValue((SpecialPaper) deckItem2.object);
            case MasterScissor -> attackValueForItem1 = deckItem1.object.CalculateAttackValue((MasterScissor) deckItem2.object);
        }

        switch (deckItem1.object.GetType())
        {
            default -> attackValueForItem2 = 0.0;
            case Rock -> attackValueForItem2 = deckItem2.object.CalculateAttackValue((Rock) deckItem1.object);
            case Paper -> attackValueForItem2 = deckItem2.object.CalculateAttackValue((Paper) deckItem1.object);
            case Scissor -> attackValueForItem2 = deckItem2.object.CalculateAttackValue((Scissor) deckItem1.object);
            case HeavyRock -> attackValueForItem2 = deckItem2.object.CalculateAttackValue((HeavyRock) deckItem1.object);
            case SpecialPaper -> attackValueForItem2 = deckItem2.object.CalculateAttackValue((SpecialPaper) deckItem1.object);
            case MasterScissor -> attackValueForItem2 = deckItem2.object.CalculateAttackValue((MasterScissor) deckItem1.object);
        }

        System.out.println("\nCalculated attack value for " + player1.GetPlayerName() + "'s item: " + attackValueForItem1);
        System.out.println("\nCalculated attack value for " + player2.GetPlayerName() + "'s item: " + attackValueForItem2);

        int statusOfItem1 = deckItem1.object.UpdateStats(-attackValueForItem2, 0);
        int statusOfItem2 = deckItem2.object.UpdateStats(-attackValueForItem1, 0);

        System.out.println("\n" + player1.GetPlayerName() + "'s item's stats after applying damage");
        deckItem1.ShowStats();
        System.out.println("\n" + player2.GetPlayerName() + "'s item's stats after applying damage");
        deckItem2.ShowStats();

        deckItem1.isUsed = true;
        deckItem2.isUsed = true;

        if(statusOfItem1 == -1)
        {
            player1.RemoveItem(deckItem1);
            System.out.println(player1.GetPlayerName() + "'s item, " + deckItem1.object.GetType() + ", eliminated from the game!");

            if(deckItem2.object.UpdateStats(0, 20) == 1 && statusOfItem2 != -1)
            {
                player2.UpgradeItem(deckItem2);
                System.out.println(player2.GetPlayerName() + "'s item, " + deckItem2.object.GetType() + ", is upgraded!");
            }
        }

        if(statusOfItem2 == -1)
        {
            player2.RemoveItem(deckItem2);
            System.out.println(player2.GetPlayerName() + "'s item, " + deckItem2.object.GetType() + ", eliminated from the game!");

            if(deckItem1.object.UpdateStats(0, 20) == 1 && statusOfItem1 != -1)
            {
                player1.UpgradeItem(deckItem1);
                System.out.println(player1.GetPlayerName() + "'s item, " + deckItem1.object.GetType() + ", is upgraded!");
            }
        }

        System.out.println("\n" + player1.GetPlayerName() + "'s item's stats at end of this round");
        deckItem1.ShowStats();
        System.out.println("\n" + player2.GetPlayerName() + "'s item's stats at end of this round");
        deckItem2.ShowStats();

        System.out.println("========================= END OF ROUND ==========================\n\n");
    }

    public static int GetHumanSelection()
    {
        return 0;
    }
}
