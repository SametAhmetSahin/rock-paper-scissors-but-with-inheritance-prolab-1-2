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

    public void ShowObjectStats()
    {
        System.out.println("Scissor");
        System.out.println("Durability = " + super.GetDurability());
        System.out.println("Level point = " + super.GetLevelPoint());
        System.out.println("Influence = " + this.sharpness);
    }

    public double CalculateAttackValue()
    {
        double finalAttackValue = 0.0;

        return finalAttackValue;
    }

    public void UpdateStats()
    {

    }
}
