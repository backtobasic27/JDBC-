package JDBCConnecttest;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class JDBCConnecttest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Connection con = null;
		Statement stmt = null; // �������� �ۼ� �� �����͸� ������ ����
		ResultSet rs = null;  // select ���� ���� ��ü
		// rs�� �ּҰ��� ����Ų��.
		
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String sql = "select * from EMP";
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection(url,"scott","tiger");
			System.out.println("���� ����");
			
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql); // executeQuery() : select , sxecuteUpdate() : insert, update, delete
			
			while(rs.next()) {
				int empno = rs.getInt("empno");
				String ename = rs.getString("ename");
				String job = rs.getString("job");
				int mgr = rs.getInt("mgr");
				Date hierdate = rs.getDate("hiredate");
				int sal = rs.getInt("sal");
				int comm = rs.getInt("comm");
				int deptno = rs.getInt("deptno");
				
//				int deptno = rs.getInt(1);
//				String dname = rs.getString(2);
//				String loc = rs.getString(3);
				
				System.out.println(empno + " : " + ename + " : " + job + " : " + mgr + " : " + hierdate +" : " + sal + " : " + comm + " : " + deptno );
			}
		
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		
		}
	}


