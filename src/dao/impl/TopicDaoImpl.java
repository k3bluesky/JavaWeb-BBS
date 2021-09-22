package dao.impl;

import dao.TopicDao;
import entity.Topic;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class TopicDaoImpl extends BaseDao implements TopicDao {
    private Connection conn =null;
    private PreparedStatement pstmt = null;
    private ResultSet rs =null;

    @Override
    public Topic findTopic(int topicId) {
        return null;
    }

    @Override
    public List findListTopic(int page, int boardId) {
        List list = new ArrayList();
        int rowBegin = 0;
        if (page>1){
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
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            this.closeAll(conn,pstmt,rs);
        }
        return list;
    }

    @Override
    public int addTopic(Topic topic) {
        return 0;
    }

    @Override
    public int deleteTopic(int topicId) {
        return 0;
    }

    @Override
    public int updateTopic(Topic topic) {
        return 0;
    }

    @Override
    public int findCountTopic(int page, int boardId) {
        return 0;
    }
}
