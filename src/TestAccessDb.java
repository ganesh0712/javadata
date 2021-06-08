import java.sql.*;
public class TestAccessDb {
	 	Statement st;
	//	ResultSet rs;
		static Connection con;
		PreparedStatement pst;
		
		
	 public TestAccessDb() throws SQLException {
		con = EstablishedConnections.getConnection();
		System.out.println("Connection Estabished");
		
	}
		
	 public void Salary(int n) throws SQLException {
//		 pst = con.prepareStatement("UPDATE employees SET SALARY= 50000 WHERE DEPARTMENT_ID = ?");
		 pst = con.prepareStatement("SELECT EMPLOYEE_ID ,FIRST_NAME,SALARY FROM employees WHERE DEPARTMENT_ID = ?",ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
		 pst.setInt(1,n );

		ResultSet rs = pst.executeQuery();
		 while (rs.next())
		 {
			 rs.updateFloat(3, 5000.00F );
			 rs.updateRow();
		 }
		
		 
		 
	 }
	 public void call() throws SQLException{
	  CallableStatement stmt = con.prepareCall("{ call getEmpName(?,?)}");
			 int id =103;
			 stmt.setInt(1, id);
			 stmt.registerOutParameter(1, java.sql.Types.VARCHAR);
			 String name =stmt.getNString(2);
			 System.out.println(id + " "+name);
			 	
	 }
	 
	 
	 
		
	

	public static void main(String[] args) throws SQLException {
		
		TestAccessDb o = new TestAccessDb();
	//	o.Salary(100);
		o.call();
	}

}
