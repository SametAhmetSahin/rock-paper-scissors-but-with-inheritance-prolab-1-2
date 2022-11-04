package GameObjects;

public class Scissor extends GameObject
{
    private double sharpness;

    public Scissor()
    {
        super.SetDurability(20.0);
        super.SetLevelPoint(0.0);
        super.SetType(GameObjectType.Scissor);
        sharpness = 2.0;
    }

    public Scissor(double startDurability, double startLevelPoint)
    {
        super.SetDurability(startDurability);
        super.SetLevelPoint(startLevelPoint);
        super.SetType(GameObjectType.Scissor);
        this.sharpness = 2.0;
    }

    public Scissor(double startDurability, double startLevelPoint, double startSharpness)
    {
        super.SetDurability(startDurability);
        super.SetLevelPoint(startLevelPoint);
        super.SetType(GameObjectType.Scissor);
        this.sharpness = startSharpness;
    }

    public void SetSharpness(double newSharpness)
    {
        this.sharpness = newSharpness;
    }

    public double GetSharpness()
    {
        return this.sharpness;
    }

    @Override
    public void ShowObjectStats()
    {
        System.out.println("=================================================================");
        System.out.println("Scissor");
        System.out.println("Durability = " + super.GetDurability());
        System.out.println("Level point = " + super.GetLevelPoint());
        System.out.println("Influence = " + this.sharpness);
        System.out.println("=================================================================");
    }

    @Override
    public double CalculateAttackValue(Rock enemyRock)
    {
        return this.sharpness / ((1.0 - super.a) * enemyRock.GetHardness());
    }

    @Override
    public double CalculateAttackValue(Paper enemyPaper)
    {
        return this.sharpness / (a * enemyPaper.GetInfluence());
    }

    @Override
    public double CalculateAttackValue(Scissor enemyScissor)
    {
        return 0;   // Çünkü makasın makasa karşı bir etkisi olamaz.
    }

    @Override
    public double CalculateAttackValue(HeavyRock enemyHeavyRock)
    {
        return this.sharpness / ((1.0 - a) * enemyHeavyRock.GetHardness() * enemyHeavyRock.GetHeat());
    }

    @Override
    public double CalculateAttackValue(SpecialPaper enemySpecialPaper)
    {
        return this.sharpness / (a * enemySpecialPaper.GetInfluence() * enemySpecialPaper.GetThickness());
    }

    @Override
    public double CalculateAttackValue(MasterScissor enemyMasterScissor)
    {
        return 0;   // Çünkü makasın usta makasa karşı bir etkisi olamaz.
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
