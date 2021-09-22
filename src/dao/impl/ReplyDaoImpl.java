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

    @Override
    public Reply findReply(int replyId) {
        return null;
    }

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

    @Override
    public int deleteReply(int replyId) {
        return 0;
    }

    @Override
    public int updateReply(Reply reply) {
        return 0;
    }

    @Override
    public List findListReply(int page, int topicId) {
        return null;
    }

    @Override
    public int findCountReply(int topicId) {
        return 0;
    }
}
