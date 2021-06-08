import java.sql.Connection;
import java.sql.DriverManager;
public class EstablishedConnections {
	public static final String JDBC_Driver = "com.mysql.cj.jdbc.Driver";
	public static final String JDBC_URL ="jdbc:mysql://localhost:3306/testcoursedb";
	public static final String USER = "root";
	public static final String PASS = "root";
	static Connection conn=null;
		
		
			public static Connection getConnection(){
				try{
					Class.forName(JDBC_Driver);
					System.out.println("Driver Loaded....");
					System.out.println("COnnection to database ");
					conn= DriverManager.getConnection(JDBC_URL,  USER,  PASS);
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
				return conn;
			}

	public static void main(String[] args) {
			Connection con =getConnection();
	}

}
