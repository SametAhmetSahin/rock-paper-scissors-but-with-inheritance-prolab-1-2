package GameObjects;

import Game.Game;

public class ComputerPlayer extends Player
{
    public ComputerPlayer()
    {
        do
        {
            super.SetPlayerID(this.rng.nextLong());
        } while(super.GetPlayerID() < 0);

        super.SetPlayerName("Computer");
        super.SetPlayerScore(0);
        super.InitializeDeck();
    }

    public ComputerPlayer(long ID, String name)
    {
        super.SetPlayerID(ID);
        super.SetPlayerName(name);
        super.SetPlayerScore(0);
        super.InitializeDeck();
    }

    public ComputerPlayer(long ID, String name, long startScore)
    {
        super.SetPlayerID(ID);
        super.SetPlayerName(name);
        super.SetPlayerScore(startScore);
        super.InitializeDeck();
    }

    @Override
    public void RemoveItem(DeckItem disqualified)
    {/*
        for(DeckItem i : super.deck)
        {
            if(disqualified.id == i.id)
            {
                super.deck.remove(i);
                break;
            }
        }*/
        super.deck.remove(disqualified);
    }

    @Override
    public void UpgradeItem(DeckItem obsolete)
    {
        DeckItem toAdded;

        switch(obsolete.object.GetType())
        {
            case Paper -> toAdded = new DeckItem(new SpecialPaper(obsolete.object.GetDurability(),
                                                                  obsolete.object.GetLevelPoint(),
                                                                  Game.startPaperInfluence,
                                                                  Game.startSpecialPaperThickness), obsolete.id);

            case Scissor -> toAdded = new DeckItem(new MasterScissor(obsolete.object.GetDurability(),
                                                                     obsolete.object.GetLevelPoint(),
                                                                     Game.startScissorSharpness,
                                                                     Game.startMasterScissorSpeed), obsolete.id);

            default -> toAdded = new DeckItem(new HeavyRock(obsolete.object.GetDurability(),
                                                            obsolete.object.GetLevelPoint(),
                                                            Game.startRockHardness,
                                                            Game.startHeavyRockHeat), obsolete.id);
        }

        toAdded.isUsed = obsolete.isUsed;

        for(DeckItem i : super.deck)
        {
            if(obsolete.id == i.id)
            {
                super.deck.set(super.deck.indexOf(i), toAdded);
                break;
            }
        }
    }

    @Override
    public void UpdateItem(DeckItem upToDate)
    {
        for(DeckItem i : super.deck)
        {
            if(upToDate.id == i.id)
            {
                super.deck.set(super.deck.indexOf(i), upToDate);
                break;
            }
        }
    }

    @Override
    public String ShowScore()
    {
        super.UpdatePlayerScore();

        System.out.println("=================================================================");
        System.out.println("Player ID: " + super.GetPlayerID());
        System.out.println("Player's Name: " + super.GetPlayerName());
        System.out.println("Player's Score: " + super.GetPlayerScore());
        System.out.println("=================================================================");

        return "=================================================================\n" +
               "Player ID: " + super.GetPlayerID() + "\n" +
               "Player's Name: " + super.GetPlayerName() + "\n" +
               "Player's Score: " + super.GetPlayerScore() + "\n" +
               "=================================================================\n";
    }

    @Override
    public DeckItem SelectItem(int selection)
    {
        do
        {
            selection = super.rng.nextInt(super.deck.size());
        } while(super.deck.get(selection).isUsed || super.deck.get(selection).object.GetDurability() <= 0.0);

        return super.deck.get(selection);
    }
}
