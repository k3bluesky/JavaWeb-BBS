package dao.impl;

import java.sql.*;


public class BaseDao {
	public final static String driver = "com.mysql.cj.jdbc.Driver";
	public final static String url = "jdbc:mysql://localhost:3306/bbs";
	public final static String dbName = "root";  //���ݿ��û���
	public final static String dbPass = "976457598"; //���ݿ�����
	/**
	 * �õ����ݿ�����
	 * 
	 * @return ���ݿ�����
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public Connection getConn() throws ClassNotFoundException, SQLException{
		Class.forName(driver);
		Connection conn = DriverManager.getConnection(url, dbName, dbPass);
		return conn;	
	}
	/**
	 * �ͷ���Դ
	 * @param rs �����
	 * @param conn PreparedStatement����
	 * @param pstmt �����
	 */
	public void closeAll(Connection conn, PreparedStatement pstmt,ResultSet rs){
		if(rs != null){
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(pstmt != null){
			try {
				pstmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(conn != null){
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	/**
	 * ִ��SQL��䣬���Խ�����ɾ�ĵĲ���������ִ�в�ѯ
	 * @param  sql Ԥ�����SQL���
	 * @param param Ԥ�����SQL����е�'?'�������ַ�������
	 * @return Ӱ�������
	 */
	public int executeSQL(String preparedSql,String[] param){
		Connection conn = null;
		PreparedStatement pstmt = null;
		int num = 0;
		
		try {
			conn = getConn();
			pstmt = conn.prepareStatement(preparedSql);
			if(param != null){
				for(int i=0;i<param.length;i++){
					pstmt.setString(i+1, param[i]);
				}
			}
			num = pstmt.executeUpdate();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			closeAll(conn,pstmt,null);
		}
		return num;
	}
}
