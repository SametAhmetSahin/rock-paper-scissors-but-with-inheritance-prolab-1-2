package GameObjects;

public class Rock extends GameObject
{
    private double hardness;

    public Rock()
    {
        super.SetDurability(20);
        super.SetLevelPoint(0);
        super.SetType(GameObjectType.Rock);
        this.hardness = 2.0;
    }

    public Rock(double startDurability, double startLevelPoint)
    {
        super.SetDurability(startDurability);
        super.SetLevelPoint(startLevelPoint);
        super.SetType(GameObjectType.Rock);
        this.hardness = 2.0;
    }

    public Rock(double startDurability, double startLevelPoint, double startHardness)
    {
        super.SetDurability(startDurability);
        super.SetLevelPoint(startLevelPoint);
        super.SetType(GameObjectType.Rock);
        this.hardness = startHardness;
    }

    public void SetHardness(double newHardness)
    {
        this.hardness = newHardness;
    }

    public double GetHardness()
    {
        return this.hardness;
    }

    @Override
    public void ShowObjectStats()
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
    public double CalculateAttackValue(Rock enemyRock)
    {
        // Dökümanda aynı tip nesnelerin birbirlerine karşı etkilerinin hesaplanmasına dair bir formül yer almaması nedeniyle
        // dökümandaki formüller esas alınmak suretiyle en gerçekçi formül oluşturulmaya çalışılmıştır.
        return this.hardness / enemyRock.GetHardness();
    }

    @Override
    public double CalculateAttackValue(Paper enemyPaper)
    {
        return this.hardness / ((1.0 - super.GetConstantA()) * enemyPaper.GetInfluence());
    }

    @Override
    public double CalculateAttackValue(Scissor enemyScissor)
    {
        return this.hardness / (super.GetConstantA() * enemyScissor.GetSharpness());
    }

    @Override
    public double CalculateAttackValue(HeavyRock enemyHeavyRock)
    {
        // Dökümanda aynı tip nesnelerin birbirlerine karşı etkilerinin hesaplanmasına dair bir formül yer almaması nedeniyle
        // dökümandaki formüller esas alınmak suretiyle en gerçekçi formül oluşturulmaya çalışılmıştır.
        return this.hardness / (enemyHeavyRock.GetHardness() * enemyHeavyRock.GetHeat());
    }

    @Override
    public double CalculateAttackValue(SpecialPaper enemySpecialPaper)
    {
        return this.hardness / ((1.0 - super.GetConstantA()) * enemySpecialPaper.GetInfluence() * enemySpecialPaper.GetThickness());
    }

    @Override
    public double CalculateAttackValue(MasterScissor enemyMasterScissor)
    {
        return this.hardness / (super.GetConstantA() * enemyMasterScissor.GetSharpness() * enemyMasterScissor.GetSpeed());
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
