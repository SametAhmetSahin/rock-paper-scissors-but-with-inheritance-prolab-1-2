package GameObjects;

public class HeavyRock extends Rock
{
    private double heat;

    public HeavyRock()
    {
        super.SetDurability(20.0);
        super.SetLevelPoint(0.0);
        super.SetHardness(2.0);
        super.SetType(GameObjectType.HeavyRock);
        this.heat = 2.0;
    }

    public HeavyRock(double startDurability, double startLevelPoint)
    {
        super.SetDurability(startDurability);
        super.SetLevelPoint(startLevelPoint);
        super.SetHardness(2.0);
        super.SetType(GameObjectType.HeavyRock);
        this.heat = 2.0;
    }

    public HeavyRock(double startDurability, double startLevelPoint, double startHardness, double startHeat)
    {
        super.SetDurability(startDurability);
        super.SetLevelPoint(startLevelPoint);
        super.SetHardness(startHardness);
        super.SetType(GameObjectType.HeavyRock);
        this.heat = startHeat;
    }

    public void SetHeat(double newHeat)
    {
        this.heat = newHeat;
    }

    public double GetHeat()
    {
        return this.heat;
    }

    @Override
    public void ShowObjectStats()
    {
        System.out.println("=================================================================");
        System.out.println("Heavy Rock");
        System.out.println("Durability = " + super.GetDurability());
        System.out.println("Level point = " + super.GetLevelPoint());
        System.out.println("Hardness = " + super.GetHardness());
        System.out.println("Heat = " + this.heat);
        System.out.println("=================================================================");
    }

    @Override
    public double CalculateAttackValue(Rock enemyRock)
    {
        return 0;   // Çünkü ağır taşın taşa karşı bir etkisi olamaz.
    }

    @Override
    public double CalculateAttackValue(Paper enemyPaper)
    {
        return (super.GetHardness() * this.heat) / ((1.0 - a) * enemyPaper.GetInfluence());
    }

    @Override
    public double CalculateAttackValue(Scissor enemyScissor)
    {
        return (super.GetHardness() * this.heat) / (a * enemyScissor.GetSharpness());
    }

    @Override
    public double CalculateAttackValue(HeavyRock enemyHeavyRock)
    {
        return 0;   // Çünkü ağır taşın ağır taşa karşı bir etkisi olamaz.
    }

    @Override
    public double CalculateAttackValue(SpecialPaper enemySpecialPaper)
    {
        return (super.GetHardness() * this.heat) / ((1.0 - a) * enemySpecialPaper.GetInfluence() * enemySpecialPaper.GetThickness());
    }

    @Override
    public double CalculateAttackValue(MasterScissor enemyMasterScissor)
    {
        return (super.GetHardness() * this.heat) / (a * enemyMasterScissor.GetSharpness() * enemyMasterScissor.GetSpeed());
    }

    @Override
    public int UpdateStats(long addToDurability, long addToLevelPoint)
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
