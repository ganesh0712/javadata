import java.sql.*;
public class AccessDb {
	 Statement st;
		ResultSet rs;
		static Connection con;
		PreparedStatement pst;
		public AccessDb(){
			con = EstablishedConnections.getConnection();
			System.out.println("Connection Estabished");
			
		}
		public void fetchData() throws SQLException{
			st= con.createStatement();
			rs=st.executeQuery("SELECT * FROM hospital.patient;");
			System.out.println("P_id"+"\t"+"P_name" +"\t"+"Age"+"\t"+"Weight"+"\t"+"email"+"\t"+"date");
			while(rs.next())
			{
				int id = rs.getInt(1);
				String name = rs.getNString(2);
				int age = rs.getInt(3);
				int weight = rs.getInt(4);
				String email= rs.getNString(5);
				Date d= rs.getDate(6);
				System.out.println(id+"\t"+name +"\t"+age+"\t"+weight+"\t"+email+"\t"+d);

			}
		}
		
		
		public void insertNewRecord(int id,String name,int age,int wt,String email,Date d ) throws SQLException{
			pst =con.prepareStatement("INSERT INTO hospital.patient VALUES (?, ?, ?, ?,?, ?)");
			pst.setInt(1, id);
			pst.setString(2, name);
			pst.setInt(3, age);
			pst.setInt(4,wt);
			pst.setString(5, email);
			pst.setDate(6, d);
			int r= pst.executeUpdate();
		}
	
		
	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		AccessDb o = new AccessDb();
		o.fetchData();
		System.out.println("*********************************");
		 long millis=2021-04-05;
		 java.sql.Date date=new java.sql.Date(millis);
		o.insertNewRecord(65,"devang",54,85,"devang@gmail.com",date);
		System.out.println("*********************************");
		o.fetchData();


	}

}
