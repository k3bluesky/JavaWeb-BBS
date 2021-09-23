package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;

import dao.UserDao;
import entity.User;

public class UserDaoImpl extends BaseDao implements UserDao {
	
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;

	/**
	 * 添加用户
	 * @param user
	 * @return 添加条数
	 */
	@Override
	public int addUser(User user) {
		String sql =
				"insert into TBL_USER(username,userpass,gender,head,regTime) values(?,?,"+ user.getGender()+",?,?)";
		String time = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
		String[] parm = {user.getUserName(),user.getUserPass(),user.getHead(),time};
		return this.executeSQL(sql, parm);
	}

	/**
	 * 修改用户密码
	 * @param user
	 * @return 更新条数
	 */
	@Override
	public int updateUser(User user) {
		String sql = "update TBL_USER(userpass) set userId = " + user.getUserPass()
				+ " where userId = " + user.getUserId();

		return 0;
	}

	/**
	 * 根据用户名查找用户
	 * @param userName
	 * @return 根据用户名查询的用户对象
	 */
	@Override
	public User findUser(String userName) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * 根据用户ID查找用户
	 * @param userId
	 * @return
	 */
	@Override
	public User findUser(int userId) {
		// TODO Auto-generated method stub
		return null;
	}

	
	

	

	

}
