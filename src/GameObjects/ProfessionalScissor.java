package GameObjects;

public class ProfessionalScissor extends Scissor
{
    private double speed;

    public ProfessionalScissor()
    {
        super.SetDurability(20.0);
        super.SetLevelPoint(0.0);
        super.SetSharpness(2.0);
        super.SetType(GameObjectType.ProfessionalScissor);
        this.speed = 2.0;
    }

    public ProfessionalScissor(double startDurability, double startLevelPoint)
    {
        super.SetDurability(startDurability);
        super.SetLevelPoint(startLevelPoint);
        super.SetSharpness(2.0);
        super.SetType(GameObjectType.ProfessionalScissor);
        this.speed = 2.0;
    }

    public ProfessionalScissor(double startDurability, double startLevelPoint, double startSharpness, double startSpeed)
    {
        super.SetDurability(startDurability);
        super.SetLevelPoint(startLevelPoint);
        super.SetSharpness(startSharpness);
        super.SetType(GameObjectType.ProfessionalScissor);
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

    public void ShowObjectStats()
    {
        System.out.println("Professional Scissor");
        System.out.println("Durability = " + super.GetDurability());
        System.out.println("Level point = " + super.GetLevelPoint());
        System.out.println("Influence = " + super.GetSharpness());
        System.out.println("Speed = " + this.speed);
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
