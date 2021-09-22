package dao;

import entity.User;

public interface UserDao {
	public static final int FEMALE = 1;
	public static final int MALE = 2;
	/**
	 * �����û���������̳�û�
	 * @param userName
	 * @return
	 */
	public User findUser(String userName);
	/**
	 * �����û�id������̳�û�
	 * @param userId
	 * @return
	 */
	public User findUser(int userId);
	/**
	 * �����̳�û���������Ӹ���
	 * @param user
	 * @return
	 */
	public int addUser(User user);
	/**
	 * �޸���̳�û�����Ϣ�������޸ĸ���
	 * @param user
	 * @return
	 */
	public int updateUser(User user);
}
