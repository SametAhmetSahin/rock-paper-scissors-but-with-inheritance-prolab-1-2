package GameObjects;

public class ComputerPlayer extends Player
{
    public ComputerPlayer()
    {
        super.playerID = 0;
        super.playerName = "Computer";
        super.score = 0;
    }

    public ComputerPlayer(long ID, String name)
    {
        super.playerID = ID;
        super.playerName = name;
        super.score = 0;
    }

    public ComputerPlayer(long ID, String name, long startScore)
    {
        super.playerID = ID;
        super.playerName = name;
        super.score = startScore;
    }
}
