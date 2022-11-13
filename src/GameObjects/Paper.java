package GameObjects;

public class Paper extends GameObject
{
    private double influence;

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
    public String ShowObjectStats()
    {
        System.out.println("Type: PAPER");
        System.out.println("Durability: " + super.GetDurability());
        System.out.println("Level point: " + super.GetLevelPoint());
        System.out.println("Influence: " + this.influence);

        return "Type: PAPER\n" +
               "Durability: " + super.GetDurability() + "\n" +
               "Level point: " + super.GetLevelPoint() + "\n" +
               "Influence: " + this.influence + "\n";
    }

    @Override
    public double CalculateAttackValue(Rock enemyRock)
    {
        return this.influence / (super.GetConstantA() * enemyRock.GetHardness());
    }

    @Override
    public double CalculateAttackValue(Paper enemyPaper)
    {
        // Dökümanda aynı tip nesnelerin birbirlerine karşı etkilerinin hesaplanmasına dair bir formül yer almaması nedeniyle
        // dökümandaki formüller esas alınmak suretiyle en gerçekçi formül oluşturulmaya çalışılmıştır.
        return this.influence / enemyPaper.GetInfluence();
    }

    @Override
    public double CalculateAttackValue(Scissor enemyScissor)
    {
        return this.influence / ((1.0 - super.GetConstantA()) * enemyScissor.GetSharpness());
    }

    @Override
    public double CalculateAttackValue(HeavyRock enemyHeavyRock)
    {
        return this.influence / (super.GetConstantA() * enemyHeavyRock.GetHardness() * enemyHeavyRock.GetHeat());
    }

    @Override
    public double CalculateAttackValue(SpecialPaper enemySpecialPaper)
    {
        // Dökümanda aynı tip nesnelerin birbirlerine karşı etkilerinin hesaplanmasına dair bir formül yer almaması nedeniyle
        // dökümandaki formüller esas alınmak suretiyle en gerçekçi formül oluşturulmaya çalışılmıştır.
        return this.influence / (enemySpecialPaper.GetInfluence() * enemySpecialPaper.GetThickness());
    }

    @Override
    public double CalculateAttackValue(MasterScissor enemyMasterScissor)
    {
        return this.influence / ((1.0 - super.GetConstantA()) * enemyMasterScissor.GetSharpness() * enemyMasterScissor.GetSpeed());
    }

    @Override
    public int UpdateStats(double addToDurability, double addToLevelPoint)
    {
        this.SetDurability(this.GetDurability() + addToDurability);
        this.SetLevelPoint(this.GetLevelPoint() + addToLevelPoint);

        if(this.GetDurability() <= 0.0)
            return -1;

        if(this.GetLevelPoint() > 30.0)
            return 1;

        return 0;
    }
}
