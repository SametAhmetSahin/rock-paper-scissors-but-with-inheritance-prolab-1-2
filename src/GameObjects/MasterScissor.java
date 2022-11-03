package GameObjects;

public class MasterScissor extends Scissor
{
    protected double speed;

    public MasterScissor()
    {
        super.SetDurability(20.0);
        super.SetLevelPoint(0.0);
        super.SetSharpness(2.0);
        super.SetType(GameObjectType.MasterScissor);
        this.speed = 2.0;
    }

    public MasterScissor(double startDurability, double startLevelPoint)
    {
        super.SetDurability(startDurability);
        super.SetLevelPoint(startLevelPoint);
        super.SetSharpness(2.0);
        super.SetType(GameObjectType.MasterScissor);
        this.speed = 2.0;
    }

    public MasterScissor(double startDurability, double startLevelPoint, double startSharpness, double startSpeed)
    {
        super.SetDurability(startDurability);
        super.SetLevelPoint(startLevelPoint);
        super.SetSharpness(startSharpness);
        super.SetType(GameObjectType.MasterScissor);
        this.speed = startSpeed;
    }

    public void SetSpeed(double newSpeed)
    {
        this.speed = newSpeed;
    }

    public double GetSpeed()
    {
        return this.speed;
    }

    @Override
    public void ShowObjectStats()
    {
        System.out.println("Professional Scissor");
        System.out.println("Durability = " + super.GetDurability());
        System.out.println("Level point = " + super.GetLevelPoint());
        System.out.println("Influence = " + super.GetSharpness());
        System.out.println("Speed = " + this.speed);
    }

    @Override
    public double CalculateAttackValue(Rock enemyRock)
    {
        return (this.sharpness * this.speed) / ((1.0 - a) * enemyRock.hardness);
    }

    @Override
    public double CalculateAttackValue(Paper enemyPaper)
    {
        return (this.sharpness * this.speed) / (a * enemyPaper.influence);
    }

    @Override
    public double CalculateAttackValue(Scissor enemyScissor)
    {
        return 0;   // Çünkü usta makasın makasa karşı bir etkisi olamaz.
    }

    @Override
    public double CalculateAttackValue(HeavyRock enemyHeavyRock)
    {
        return (this.sharpness * this.speed) / ((1.0 - a) * enemyHeavyRock.hardness * enemyHeavyRock.heat);
    }

    @Override
    public double CalculateAttackValue(SpecialPaper enemySpecialPaper)
    {
        return (this.sharpness * this.speed) / (a * enemySpecialPaper.influence * enemySpecialPaper.thickness);
    }

    @Override
    public double CalculateAttackValue(MasterScissor enemyMasterScissor)
    {
        return 0;   // Çünkü usta makasın usta makasa karşı bir etkisi olamaz.
    }

    @Override
    public void UpdateStats()
    {

    }
}
