package Game;

import WebServer.*;
import GameObjects.*;
import java.io.IOException;
import java.util.Random;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.io.File;
import java.io.FileWriter;

public class Game
{
    public static Player player1, player2;
    public static Player.DeckItem deckItem1, deckItem2;
    public static int maxRound = 10;
    public static boolean isHumanGame = false;
    public static int gameStatus = 0;
    static Random rng = new Random();
    static String logText = "";
    static File logFile = null;

    public static int selectionOfHuman = 0;
    public static double startDurability = 20.0, startLevelPoint = 0.0,
                  startRockHardness = 2.0, startHeavyRockHeat = 2.0,
                  startPaperInfluence = 2.0, startSpecialPaperThickness = 2.0,
                  startScissorSharpness = 2.0, startMasterScissorSpeed = 2.0;

    public static void main(String[] args) throws IOException
    {
        int port = 8080;

        //WebServer server = new WebServer();
        //server.Start(port);

        InitializeGame();
        InitializeLogFile();
        HandleGameplay();
    }

    public static void HandleGameplay()
    {
        int i;
        for(i = 0; i < maxRound; i++)
        {
            PlayARound(selectionOfHuman);
            CheckAndResetIsUsedFlags();
            gameStatus = CheckGameStatus(i);

            if(gameStatus != 0)
                break;

            WriteToLogFile();
        }

        gameStatus = CheckGameStatus(i);
        WriteToLogFile();
    }

    public static void CheckAndResetIsUsedFlags()
    {
        boolean resetIsUsedFlag = true;
        for(Player.DeckItem item : player1.GetItemDeck())
            resetIsUsedFlag &= item.isUsed;

        if(resetIsUsedFlag)
        {
            for(Player.DeckItem item : player1.GetItemDeck())
                item.isUsed = false;

            System.out.println(player1.GetPlayerName() + " used all of his items!\n\n");
            logText += player1.GetPlayerName() + " used all of his items!\n\n\n";
        }

        for(Player.DeckItem item : player2.GetItemDeck())
            resetIsUsedFlag &= item.isUsed;

        if(resetIsUsedFlag)
        {
            for(Player.DeckItem item : player2.GetItemDeck())
                item.isUsed = false;

            System.out.println(player2.GetPlayerName() + " used all of his items!\n\n");
            logText += player2.GetPlayerName() + " used all of his items!\n\n\n";
        }
    }

    // 0: Game still continues | 1: Player 1 won | 2: Player 2 won | 3: Draw
    public static int CheckGameStatus(int currentRound)
    {
        if(currentRound < maxRound)
        {
            if(player1.GetItemDeck().size() > 0 && player2.GetItemDeck().size() == 0)
            {
                System.out.println(player1.GetPlayerName() + " won! Player's stats");

                logText += player1.GetPlayerName() + " won! Player's stats\n";
                logText += player1.ShowScore();
                logText += player2.ShowScore();

                return 1;
            }
            else if(player1.GetItemDeck().size() == 0 && player2.GetItemDeck().size() > 0)
            {
                System.out.println(player2.GetPlayerName() + " won! Player's stats");

                logText += player2.GetPlayerName() + " won! Player's stats\n";
                logText += player1.ShowScore();
                logText += player2.ShowScore();

                return 2;
            }
            else if(player1.GetItemDeck().size() == 0 && player2.GetItemDeck().size() == 0)
            {
                System.out.println("Draw! Player's stats");

                logText += "Draw! Player's stats\n";
                logText += player1.ShowScore();
                logText += player2.ShowScore();

                return 3;
            }
            else
                return 0;
        }
        else
        {
            if(player1.GetPlayerScore() > player2.GetPlayerScore())
            {
                System.out.println(player1.GetPlayerName() + " won! Player's stats");

                logText += player1.GetPlayerName() + " won! Player's stats\n";
                logText += player1.ShowScore();
                logText += player2.ShowScore();

                return 1;
            }
            else if(player1.GetPlayerScore() < player2.GetPlayerScore())
            {
                System.out.println(player2.GetPlayerName() + " won! Player's stats");

                logText += player2.GetPlayerName() + " won! Player's stats\n";
                logText += player1.ShowScore();
                logText += player2.ShowScore();

                return 2;
            }
            else
            {
                System.out.println("Draw! Player's stats");

                logText += "Draw! Player's stats\n";
                logText += player1.ShowScore();
                logText += player2.ShowScore();

                return 3;
            }
        }
    }

    public static void InitializeLogFile()
    {
        try
        {
            logFile = new File("RockPaperScissor " + LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH.mm.ss")) + ".log");
            logFile.createNewFile();
        }
        catch (Exception e)
        {
            System.out.println("Shit happened.");
            e.printStackTrace();
        }
    }

    public static void WriteToLogFile()
    {
        try
        {
            FileWriter fw = new FileWriter(logFile.getName(), true);
            fw.write(logText);
            fw.close();
        }
        catch(Exception e)
        {
            System.out.println("Shit happened.");
            e.printStackTrace();
        }
        finally
        {
            logText = "";
        }
    }

    public static void InitializeGame(int[] startingDeck)
    {
        InitializeHumanAiGame(startingDeck);
    }

    public static void InitializeGame()
    {
        InitializeAiAiGame();
    }

    public static void InitializeHumanAiGame(int[] startingDeck)
    {
        long startID;
        do
        {
            startID = rng.nextLong();
        } while(startID < 0);

        player1 = new HumanPlayer(startID, "Sen", startingDeck);

        do
        {
            startID = rng.nextLong();
        } while(startID < 0);

        player2 = new ComputerPlayer(startID, "Bilgisayar");
    }

    public static void InitializeAiAiGame()
    {
        long startID;
        do
        {
            startID = rng.nextLong();
        } while(startID < 0);

        player1 = new ComputerPlayer(startID, "Bilgisayar 1");

        do
        {
            startID = rng.nextLong();
        } while(startID < 0);

        player2 = new ComputerPlayer(startID, "Bilgisayar 2");
    }

    public static void PlayARound(int humanSelection)
    {
        System.out.println("======================== START OF ROUND =========================");
        logText += "======================== START OF ROUND =========================\n";

        System.out.println(player1.GetPlayerName() + " has " + player1.GetItemDeck().size() + " item(s) in his deck.");
        System.out.println(player2.GetPlayerName() + " has " + player2.GetItemDeck().size() + " item(s) in his deck.\n");
        logText += player1.GetPlayerName() + " has " + player1.GetItemDeck().size() + " item(s) in his deck.\n";
        logText += player2.GetPlayerName() + " has " + player2.GetItemDeck().size() + " item(s) in his deck.\n\n";

        deckItem1 = player1.SelectItem(humanSelection);
        deckItem2 = player2.SelectItem(humanSelection);

        System.out.println(player1.GetPlayerName() + " chose " + deckItem1.object.GetType().toString());
        System.out.println(player2.GetPlayerName() + " chose " + deckItem2.object.GetType().toString());
        logText += player1.GetPlayerName() + " chose " + deckItem1.object.GetType().toString() + "\n";
        logText += player2.GetPlayerName() + " chose " + deckItem2.object.GetType().toString() + "\n";

        System.out.println("\n" + player1.GetPlayerName() + "'s item's stats at start of this round");
        logText += "\n" + player1.GetPlayerName() + "'s item's stats at start of this round\n";
        logText += deckItem1.ShowStats();

        System.out.println("\n" + player2.GetPlayerName() + "'s item's stats at start of this round");
        logText += "\n" + player2.GetPlayerName() + "'s item's stats at start of this round\n";
        logText += deckItem2.ShowStats();

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
        System.out.println("Calculated attack value for " + player2.GetPlayerName() + "'s item: " + attackValueForItem2);
        logText += "\nCalculated attack value for " + player1.GetPlayerName() + "'s item: " + attackValueForItem1 + "\n";
        logText += "Calculated attack value for " + player2.GetPlayerName() + "'s item: " + attackValueForItem2 + "\n";

        int statusOfItem1 = deckItem1.object.UpdateStats(-attackValueForItem2, 0);
        int statusOfItem2 = deckItem2.object.UpdateStats(-attackValueForItem1, 0);

        deckItem1.isUsed = true;
        deckItem2.isUsed = true;

        System.out.println("\n" + player1.GetPlayerName() + "'s item's stats after applying damage");
        logText += "\n" + player1.GetPlayerName() + "'s item's stats after applying damage\n";
        logText += deckItem1.ShowStats();

        System.out.println("\n" + player2.GetPlayerName() + "'s item's stats after applying damage");
        logText += "\n" + player2.GetPlayerName() + "'s item's stats after applying damage\n";
        logText += deckItem2.ShowStats();

        if(statusOfItem1 == -1)
        {
            player1.RemoveItem(deckItem1);
            System.out.println(player1.GetPlayerName() + "'s item, " + deckItem1.object.GetType() + ", eliminated from the game!");
            logText += player1.GetPlayerName() + "'s item, " + deckItem1.object.GetType() + ", eliminated from the game!\n";

            if(deckItem2.object.UpdateStats(0, 20) == 1 && statusOfItem2 != -1)
            {
                player2.UpgradeItem(deckItem2);
                System.out.println(player2.GetPlayerName() + "'s item, " + deckItem2.object.GetType() + ", is upgraded!");
                logText += player2.GetPlayerName() + "'s item, " + deckItem2.object.GetType() + ", is upgraded!\n";
            }
        }

        if(statusOfItem2 == -1)
        {
            player2.RemoveItem(deckItem2);
            System.out.println(player2.GetPlayerName() + "'s item, " + deckItem2.object.GetType() + ", eliminated from the game!");
            logText += player2.GetPlayerName() + "'s item, " + deckItem2.object.GetType() + ", eliminated from the game!\n";

            if(deckItem1.object.UpdateStats(0, 20) == 1 && statusOfItem1 != -1)
            {
                player1.UpgradeItem(deckItem1);
                System.out.println(player1.GetPlayerName() + "'s item, " + deckItem1.object.GetType() + ", is upgraded!");
                logText += player1.GetPlayerName() + "'s item, " + deckItem1.object.GetType() + ", is upgraded!\n";
            }
        }

        //player1.UpdateItem(deckItem1);
        //player2.UpdateItem(deckItem2);

        System.out.println("\n" + player1.GetPlayerName() + "'s item's stats at end of this round");
        logText += "\n" + player1.GetPlayerName() + "'s item's stats at end of this round\n";
        logText += deckItem1.ShowStats();

        System.out.println("\n" + player2.GetPlayerName() + "'s item's stats at end of this round");
        logText += "\n" + player2.GetPlayerName() + "'s item's stats at end of this round\n";
        logText += deckItem2.ShowStats();

        System.out.println("========================= END OF ROUND ==========================\n\n");
        logText += "========================= END OF ROUND ==========================\n\n\n";
    }
}
