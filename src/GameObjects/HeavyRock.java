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
        System.out.println("Type = Heavy Rock");
        System.out.println("Durability = " + super.GetDurability());
        System.out.println("Level point = " + super.GetLevelPoint());
        System.out.println("Hardness = " + super.GetHardness());
        System.out.println("Heat = " + this.heat);
    }

    @Override
    public double CalculateAttackValue(Rock enemyRock)
    {
        // Dökümanda aynı tip nesnelerin birbirlerine karşı etkilerinin hesaplanmasına dair bir formül yer almaması nedeniyle
        // dökümandaki formüller esas alınmak suretiyle en gerçekçi formül oluşturulmaya çalışılmıştır.
        return (super.GetHardness() * this.heat) / enemyRock.GetHardness();
    }

    @Override
    public double CalculateAttackValue(Paper enemyPaper)
    {
        return (super.GetHardness() * this.heat) / ((1.0 - super.GetConstantA()) * enemyPaper.GetInfluence());
    }

    @Override
    public double CalculateAttackValue(Scissor enemyScissor)
    {
        return (super.GetHardness() * this.heat) / (super.GetConstantA() * enemyScissor.GetSharpness());
    }

    @Override
    public double CalculateAttackValue(HeavyRock enemyHeavyRock)
    {
        // Dökümanda aynı tip nesnelerin birbirlerine karşı etkilerinin hesaplanmasına dair bir formül yer almaması nedeniyle
        // dökümandaki formüller esas alınmak suretiyle en gerçekçi formül oluşturulmaya çalışılmıştır.
        return (super.GetHardness() * this.heat) / (enemyHeavyRock.GetHardness() * enemyHeavyRock.GetHeat());
    }

    @Override
    public double CalculateAttackValue(SpecialPaper enemySpecialPaper)
    {
        return (super.GetHardness() * this.heat) / ((1.0 - super.GetConstantA()) * enemySpecialPaper.GetInfluence() * enemySpecialPaper.GetThickness());
    }

    @Override
    public double CalculateAttackValue(MasterScissor enemyMasterScissor)
    {
        return (super.GetHardness() * this.heat) / (super.GetConstantA() * enemyMasterScissor.GetSharpness() * enemyMasterScissor.GetSpeed());
    }

    @Override
    public int UpdateStats(double addToDurability, double addToLevelPoint)
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
