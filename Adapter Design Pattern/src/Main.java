
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BugattiVeyron b=new BugattiVeyron();
		MovableAdapter adapter=new MovableAdapterImpl(b);
		System.out.println(adapter.getSpeed());
		System.out.println(adapter.getPrice());

	}

}
