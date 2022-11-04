package GameObjects;

public class Paper extends GameObject
{
    private double influence;

    protected Paper()
    {
        super.SetDurability(20.0);
        super.SetLevelPoint(0.0);
        super.SetType(GameObjectType.Paper);
        this.influence = 2.0;
    }

    protected Paper(double startDurability, double startLevelPoint)
    {
        super.SetDurability(startDurability);
        super.SetLevelPoint(startLevelPoint);
        super.SetType(GameObjectType.Paper);
        this.influence = 2.0;
    }

    protected Paper(double startDurability, double startLevelPoint, double startInfluence)
    {
        super.SetDurability(startDurability);
        super.SetLevelPoint(startLevelPoint);
        super.SetType(GameObjectType.Paper);
        this.influence = startInfluence;
    }

    protected void SetInfluence(double newInfluence)
    {
        this.influence = newInfluence;
    }

    protected double GetInfluence()
    {
        return this.influence;
    }

    @Override
    protected void ShowObjectStats()
    {
        System.out.println();
        System.out.println("=================================================================");
        System.out.println("Paper");
        System.out.println("Durability = " + super.GetDurability());
        System.out.println("Level point = " + super.GetLevelPoint());
        System.out.println("Influence = " + this.influence);
        System.out.println("=================================================================");
    }

    @Override
    protected double CalculateAttackValue(Rock enemyRock)
    {
        return this.influence / (a * enemyRock.GetHardness());
    }

    @Override
    protected double CalculateAttackValue(Paper enemyPaper)
    {
        return 0;   // Çünkü kağıdın kağıda karşı bir etkisi olamaz.
    }

    @Override
    protected double CalculateAttackValue(Scissor enemyScissor)
    {
        return this.influence / ((1.0 - a) * enemyScissor.GetSharpness());
    }

    @Override
    protected double CalculateAttackValue(HeavyRock enemyHeavyRock)
    {
        return this.influence / (a * enemyHeavyRock.GetHardness() * enemyHeavyRock.GetHeat());
    }

    @Override
    protected double CalculateAttackValue(SpecialPaper enemySpecialPaper)
    {
        return 0;   // Çünkü kağıdın özel kağıda karşı bir etkisi olamaz.
    }

    @Override
    protected double CalculateAttackValue(MasterScissor enemyMasterScissor)
    {
        return this.influence / ((1.0 - a) * enemyMasterScissor.GetSharpness() * enemyMasterScissor.GetSpeed());
    }

    @Override
    protected int UpdateStats(long addToDurability, long addToLevelPoint)
    {
        this.SetDurability(this.GetDurability() + addToDurability);
        this.SetLevelPoint(this.GetLevelPoint() + addToLevelPoint);

        if(this.GetDurability() <= 0)
            return -1;

        if(this.GetLevelPoint() > 30)
            return 1;

        return 0;
    }
}
