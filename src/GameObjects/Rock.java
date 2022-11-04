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
        System.out.println("Rock");
        System.out.println("Durability = " + super.GetDurability());
        System.out.println("Level point = " + super.GetLevelPoint());
        System.out.println("Hardness = " + this.hardness);
    }

    @Override
    public double CalculateAttackValue(Rock enemyRock)
    {
        return 0;   // Çünkü taşın taşa karşı bir etkisi olamaz.
    }

    @Override
    public double CalculateAttackValue(Paper enemyPaper)
    {
        return this.hardness / ((1.0 - a) * enemyPaper.GetInfluence());
    }

    @Override
    public double CalculateAttackValue(Scissor enemyScissor)
    {
        return this.hardness / (a * enemyScissor.GetSharpness());
    }

    @Override
    public double CalculateAttackValue(HeavyRock enemyHeavyRock)
    {
        return 0;   // Çünkü taşın ağır taşa karşı bir etkisi olamaz.
    }

    @Override
    public double CalculateAttackValue(SpecialPaper enemySpecialPaper)
    {
        return this.hardness / ((1.0 - a) * enemySpecialPaper.GetInfluence() * enemySpecialPaper.GetThickness());
    }

    @Override
    public double CalculateAttackValue(MasterScissor enemyMasterScissor)
    {
        return this.hardness / (a * enemyMasterScissor.GetSharpness() * enemyMasterScissor.GetSpeed());
    }

    @Override
    public void UpdateStats()
    {

    }
}
