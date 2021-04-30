
public class MercedesFactory extends Factory{
	public HeadLight makeHeadlight() {
		return new MercedesHeadlight();
	}

	public Tire makeTire() {
		return new MercedesTire();
	}

}
