package GameObjects;

public class Rock extends GameObject
{
    private double hardness;

    protected Rock()
    {
        super.SetDurability(20);
        super.SetLevelPoint(0);
        super.SetType(GameObjectType.Rock);
        this.hardness = 2.0;
    }

    protected Rock(double startDurability, double startLevelPoint)
    {
        super.SetDurability(startDurability);
        super.SetLevelPoint(startLevelPoint);
        super.SetType(GameObjectType.Rock);
        this.hardness = 2.0;
    }

    protected Rock(double startDurability, double startLevelPoint, double startHardness)
    {
        super.SetDurability(startDurability);
        super.SetLevelPoint(startLevelPoint);
        super.SetType(GameObjectType.Rock);
        this.hardness = startHardness;
    }

    protected void SetHardness(double newHardness)
    {
        this.hardness = newHardness;
    }

    protected double GetHardness()
    {
        return this.hardness;
    }

    @Override
    protected void ShowObjectStats()
    {
        System.out.println();
        System.out.println("=================================================================");
        System.out.println("Rock");
        System.out.println("Durability = " + super.GetDurability());
        System.out.println("Level point = " + super.GetLevelPoint());
        System.out.println("Hardness = " + this.hardness);
        System.out.println("=================================================================");
    }

    @Override
    protected double CalculateAttackValue(Rock enemyRock)
    {
        return 0;   // Çünkü taşın taşa karşı bir etkisi olamaz.
    }

    @Override
    protected double CalculateAttackValue(Paper enemyPaper)
    {
        return this.hardness / ((1.0 - a) * enemyPaper.GetInfluence());
    }

    @Override
    protected double CalculateAttackValue(Scissor enemyScissor)
    {
        return this.hardness / (a * enemyScissor.GetSharpness());
    }

    @Override
    protected double CalculateAttackValue(HeavyRock enemyHeavyRock)
    {
        return 0;   // Çünkü taşın ağır taşa karşı bir etkisi olamaz.
    }

    @Override
    protected double CalculateAttackValue(SpecialPaper enemySpecialPaper)
    {
        return this.hardness / ((1.0 - a) * enemySpecialPaper.GetInfluence() * enemySpecialPaper.GetThickness());
    }

    @Override
    protected double CalculateAttackValue(MasterScissor enemyMasterScissor)
    {
        return this.hardness / (a * enemyMasterScissor.GetSharpness() * enemyMasterScissor.GetSpeed());
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
