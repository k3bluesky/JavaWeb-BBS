package dao.impl;

import dao.TopicDao;
import entity.Board;
import entity.Topic;
import entity.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TopicDaoImpl extends BaseDao implements TopicDao {
    private Connection conn =null;
    private PreparedStatement pstmt = null;
    private ResultSet rs =null;

    /**
     * �������
     * @param topic
     * @return ��������
     */
    @Override
    public int addTopic(Topic topic) {
        String sql =
                "insert into TBL_TOPIC(topicId,title,content,publishTime,modifyTime,userId,boardId) values(?,?,?,?,?,"+
                        topic.getUserId() +","+ topic.getBoardId() +")";
        String time = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
        String[] param = {String.valueOf(topic.getTopicId()),topic.getTitle(),topic.getContent(),time,time};
        return this.executeSQL(sql, param);
    }

    /**
     * ɾ������
     * @param topicId
     * @return ɾ������
     */
    @Override
    public int deleteTopic(int topicId) {
        String sql =
                "delede from TBL_TOPIC where topicId = "+ topicId ;
        String[] param = {};
        return this.executeSQL(sql, param);
    }

    /**
     * ��������
     * @param topic
     * @return ��������
     */
    @Override
    public int updateTopic(Topic topic) {
        String sql =
                "update TBL_TOPIC set where title = " +topic.getTitle()
                        + "where topicId = "+ topic.getTopicId();
        String[] param = {};
        return this.executeSQL(sql, param);
    }

    /**
     * ����һ�������������Ϣ
     * @param topicId
     * @return ������Ϣ
     */
    @Override
    public Topic findTopic(int topicId) {
        Topic topic = new Topic();
        String sql =
                "select title from TBL_TOPIC where topicId =" + topicId;
        try{
            conn = this.getConn();
            pstmt= conn.prepareStatement(sql);
            rs = pstmt.executeQuery();
            topic.setTopicId(rs.getInt("topicId"));
            topic.setTitle(rs.getString("title"));
            topic.setPublishTime(rs.getDate("publishTime"));
            topic.setModifyTime(rs.getDate("modifyTime"));
            topic.setUserId(rs.getInt("userId"));
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            this.closeAll(conn,pstmt,rs);
        }
        return topic;
    }

    /**
     * ��������List
     * @param page
     * @return ����List
     */
    @Override
    public List findListTopic(int page, int boardId) {
        List list = new ArrayList();
        int rowBegin = 0;
        if (page > 1) {
            rowBegin = 20 * (page - 1);
        }
        String sql = "select top 20 * from TBL_TOPIC where boardId=" + boardId
                + "and topicId not in (select tp " + rowBegin
                + "topicId from TBL_TOPIC where boardId=" + boardId
                + "order by publishTime desc ) order by publishTime desc";
        try {
            conn = this.getConn();
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                Topic topic = new Topic();
                topic.setTopicId(rs.getInt("topicId"));
                topic.setTitle(rs.getString("title"));
                topic.setPublishTime(rs.getDate("publishTime"));
                topic.setUserId(rs.getInt("userId"));
                list.add(topic);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.closeAll(conn, pstmt, rs);
        }
        return list;
    }

    /**
     * ���ݰ��IDȡ�øð���������
     * @param boardId
     * @return ��������
     */
    public int findCountTopic(int boardId) {
        String sql =
                "select * from TBL_TOPIC where boardId = " + boardId;
        String[] param = {};
        return this.executeSQL(sql, param);
    }
}
