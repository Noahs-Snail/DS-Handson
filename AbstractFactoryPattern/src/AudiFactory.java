
public class AudiFactory extends Factory{
	public HeadLight makeHeadlight() {
		return new AudiHeadlight();
	}

	public Tire makeTire() {
		return new AudiTire();
	}

}
