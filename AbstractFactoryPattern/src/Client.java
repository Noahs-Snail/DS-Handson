
public class Client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Factory audiFactory = FactoryGetter.getFactory("Audi");
		Tire audiTire = audiFactory.makeTire();
		HeadLight audiHeadlight = audiFactory.makeHeadlight();
		if (audiTire instanceof AudiTire && audiHeadlight instanceof AudiHeadlight) {
			System.out.println("Tire and Headlight belongs to AUDI.");
		}

		Factory mercedesFactory = FactoryGetter.getFactory("Mercedes");
		Tire mercedesTire = mercedesFactory.makeTire();
		HeadLight mercedesHeadlight = mercedesFactory.makeHeadlight();
		if (mercedesTire instanceof MercedesTire && mercedesHeadlight instanceof MercedesHeadlight) {
			System.out.println("Tire and Headlight belongs to MERCEDES.");
		}

	}

}
