package GameObjects;

public class Paper extends GameObject
{
    protected double influence;

    public Paper()
    {
        super.SetDurability(20.0);
        super.SetLevelPoint(0.0);
        super.SetType(GameObjectType.Paper);
        this.influence = 2.0;
    }

    public Paper(double startDurability, double startLevelPoint)
    {
        super.SetDurability(startDurability);
        super.SetLevelPoint(startLevelPoint);
        super.SetType(GameObjectType.Paper);
        this.influence = 2.0;
    }

    public Paper(double startDurability, double startLevelPoint, double startInfluence)
    {
        super.SetDurability(startDurability);
        super.SetLevelPoint(startLevelPoint);
        super.SetType(GameObjectType.Paper);
        this.influence = startInfluence;
    }

    public void SetInfluence(double newInfluence)
    {
        this.influence = newInfluence;
    }

    public double GetInfluence()
    {
        return this.influence;
    }

    @Override
    public void ShowObjectStats()
    {
        System.out.println("Paper");
        System.out.println("Durability = " + super.GetDurability());
        System.out.println("Level point = " + super.GetLevelPoint());
        System.out.println("Influence = " + this.influence);
    }

    @Override
    public double CalculateAttackValue(Rock enemyRock)
    {
        return 2.0 + 2.0;
    }

    @Override
    public double CalculateAttackValue(Paper enemyPaper)
    {
        return 2.0 + 2.0;
    }

    @Override
    public double CalculateAttackValue(Scissor enemyScissor)
    {
        return 2.0 + 2.0;
    }

    @Override
    public double CalculateAttackValue(HeavyRock enemyHeavyRock)
    {
        return 2.0 + 2.0;
    }

    @Override
    public double CalculateAttackValue(SpecialPaper enemySpecialPaper)
    {
        return 2.0 + 2.0;
    }

    @Override
    public double CalculateAttackValue(MasterScissor enemyMasterScissor)
    {
        return 2.0 + 2.0;
    }

    @Override
    public void UpdateStats()
    {

    }
}
