package GameObjects;

public abstract class GameObject
{
    protected enum GameObjectType
    {
        Rock,
        Paper,
        Scissor,
        HeavyRock,
        SpecialPaper,
        MasterScissor
    }

    private GameObjectType type;
    private double durability;
    private double levelPoint;
    protected double a = 0.2;

    protected GameObject()
    {
        // Dökümanda belirtilen varsayılan değerler
        this.durability = 20.0;
        this.levelPoint = 0.0;
    }

    protected GameObject(double startDurability, double startLevelPoint)
    {
        this.durability = startDurability;
        this.levelPoint = startLevelPoint;
    }

    protected void SetDurability(double newDurability)
    {
        this.durability = newDurability;
    }

    protected void SetLevelPoint(double newLevelPoint)
    {
        this.levelPoint = newLevelPoint;
    }

    protected void SetType(GameObjectType newType)
    {
        this.type = newType;
    }

    protected double GetDurability()
    {
        return this.durability;
    }

    protected double GetLevelPoint()
    {
        return this.levelPoint;
    }

    protected GameObjectType GetType()
    {
        return this.type;
    }

    protected void ShowObjectStats()
    {
        System.out.println();
        System.out.println("=================================================================");
        System.out.println("This object's durability = " + durability);
        System.out.println("This object's level point = " + levelPoint);
        System.out.println("=================================================================");
    }

    protected double CalculateAttackValue(Rock enemyRock)
    {
        return 2.0 + 2.0;
    }

    protected double CalculateAttackValue(Paper enemyPaper)
    {
        return 2.0 + 2.0;
    }

    protected double CalculateAttackValue(Scissor enemyScissor)
    {
        return 2.0 + 2.0;
    }

    protected double CalculateAttackValue(HeavyRock enemyHeavyRock)
    {
        return 2.0 + 2.0;
    }

    protected double CalculateAttackValue(SpecialPaper enemySpecialPaper)
    {
        return 2.0 + 2.0;
    }

    protected double CalculateAttackValue(MasterScissor enemyMasterScissor)
    {
        return 2.0 + 2.0;
    }

    protected int UpdateStats(long addToDurability, long addToLevelPoint)
    {
        System.out.println("Something happened.");
        return 0;
    }
}
