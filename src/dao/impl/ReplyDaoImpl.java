package dao.impl;

import dao.ReplyDao;
import entity.Reply;
import entity.Topic;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ReplyDaoImpl extends BaseDao implements ReplyDao {
    private Connection conn =null;
    private PreparedStatement pstmt = null;
    private ResultSet rs =null;

    /**
     * 根据回复ID查找回复
     * @param replyId
     * @return 回复
     */
    @Override
    public Reply findReply(int replyId) {
        return null;
    }

    /**
     * 添加回复
     * @param reply
     * @return 回复数量
     */
    @Override
    public int addReply(Reply reply) {
        List list = new ArrayList();
        String sql = "update ";
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
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            this.closeAll(conn,pstmt,rs);
        }
        return 0;
    }

    /**
     * 删除回复
     * @param replyId
     * @return
     */
    @Override
    public int deleteReply(int replyId) {
        return 0;
    }

    /**
     * 更新回复
     * @param reply
     * @return
     */
    @Override
    public int updateReply(Reply reply) {
        return 0;
    }

    /**
     * 返回某主题的第page页回复列表
     * @param page
     * @param topicId
     * @return
     */
    @Override
    public List findListReply(int page, int topicId) {
        return null;
    }

    /**
     * 返回某主题的回复数
     * @param topicId
     * @return
     */
    @Override
    public int findCountReply(int topicId) {
        return 0;
    }
}
