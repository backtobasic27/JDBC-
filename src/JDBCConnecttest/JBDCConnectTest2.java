package JDBCConnecttest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JBDCConnectTest2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Connection con = null;
		Statement stmt = null; // �������� �ۼ� �� �����͸� ������ ����
		ResultSet rs = null;  // select ���� ���� ��ü
		// rs�� �ּҰ��� ����Ų��.
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
//		String sql1 = "select * from emp01";
//		String sql2 = "insert into emp01 "
//				+ "values (1111,'kim','SALES',7788,sysdate,1000,null,30)";
//		String sql3 = "update emp01"
//				+ " set empno = 3333"
//				+ " where empno = 1111";
		String sql4 = "delete form emp01 where empno = 3333";
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection(url,"scott","tiger");
			System.out.println("���� ����");
			
			stmt = con.createStatement();
//			int result = stmt.executeUpdate(sql1);
//			int result = stmt.executeUpdate(sql2);
//			int result = stmt.executeUpdate(sql3);
			int result = stmt.executeUpdate(sql4);
			if(result <= 0) {
				System.out.println("������ ó�� ����");
			}else {
				System.out.println("������ ó�� ����");
			}
			rs = stmt.executeQuery(sql4); // executeQuery() : select , sxecuteUpdate() : insert, update, delete
			
			while(rs.next()) {
//				int empno = rs.getInt("deptno");
//				String ename = rs.getString("dname");
//				String sal = rs.getString("loc");
				
				int empno = rs.getInt(1);
				String ename = rs.getString(2);
				String job = rs.getString(3);
				
			System.out.println(empno + " : " + ename + " : " + job);
			}
		
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}

}
