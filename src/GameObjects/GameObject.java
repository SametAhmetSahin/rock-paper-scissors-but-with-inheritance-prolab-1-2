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

    protected abstract void ShowObjectStats();

    protected abstract double CalculateAttackValue(Rock enemyRock);

    protected abstract double CalculateAttackValue(Paper enemyPaper);

    protected abstract double CalculateAttackValue(Scissor enemyScissor);

    protected abstract double CalculateAttackValue(HeavyRock enemyHeavyRock);

    protected abstract double CalculateAttackValue(SpecialPaper enemySpecialPaper);

    protected abstract double CalculateAttackValue(MasterScissor enemyMasterScissor);

    protected abstract int UpdateStats(long addToDurability, long addToLevelPoint);
}
