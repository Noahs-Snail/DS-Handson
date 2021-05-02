
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		INotificationObserver steve=new SteveObserver();
		INotificationObserver john=new JohnObserver();
		INotificationService service=new NotificationService();
		service.addSubscriber(steve);
		service.addSubscriber(john);
		service.notifySubscriber();
		service.removeSubscriber(john);
		service.notifySubscriber();

	}

}
