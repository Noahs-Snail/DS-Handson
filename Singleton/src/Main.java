
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DBConn dbConn = DBConn.getInstance();
		System.out.println(dbConn.hashCode());
		DBConn dbConn1 = DBConn.getInstance();
		System.out.println(dbConn1.hashCode());
	

	}

}
