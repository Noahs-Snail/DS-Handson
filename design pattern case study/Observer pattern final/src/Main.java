
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		INotificationService notification=new NotificationService();
		TeamMember1 member1=new TeamMember1();
		TeamMember2 member2=new TeamMember2();
		notification.addSubscriber(member1);
		notification.addSubscriber(member2);
		notification.notifySubscriber();
		notification.removeSubscriber(member1);
		notification.notifySubscriber();

	}

}
