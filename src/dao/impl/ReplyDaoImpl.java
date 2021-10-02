package dao.impl;

import dao.ReplyDao;
import entity.Reply;
import entity.Topic;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
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
        Reply reply = new Reply();
        String sql =
                "select content from TBL_REPLY where replyId = " + replyId;
        try {
            conn = this.getConn();
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();
            reply.setContent(rs.getString("replyId"));
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            closeAll(conn,pstmt,rs);
        }
        return reply;
    }

    /**
     * 添加回复
     * @param reply
     * @return 回复数量
     */
    @Override
    public int addReply(Reply reply) {
       String sql =
               "insert into TBL_REPLY(replyId,title,content,publishTime,modifyTime,userId,boardId) values(?,?,?,?,?,"
                       + reply.getUserId() +","+ reply.getBoardId() +")";
       String time = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
       String[] param = {String.valueOf(reply.getReplyId()),reply.getTitle(),reply.getContent(),time,time};
       return this.executeSQL(sql,param);
    }

    /**
     * 删除回复
     * @param replyId
     * @return
     */
    @Override
    public int deleteReply(int replyId) {
        String sql =
                "delete from TBL_REPLY where replyId = " + replyId;
        String[] param = {};
        return this.executeSQL(sql,param);
    }

    /**
     * 更新回复
     * @param reply
     * @return
     */
    @Override
    public int updateReply(Reply reply) {
        String sql =
                "update TBL_TOPIC set where content = " + reply.getContent()
                        + "where replyId = "+ reply.getReplyId();
        String[] param = {};
        return this.executeSQL(sql,param);
    }

    /**
     * 返回某主题的第page页回复列表
     * @param page
     * @param topicId
     * @return
     */
    @Override
    public List findListReply(int page, int topicId) {
        List list = new ArrayList();
        String sql =
                "select * from TBL_REPLY where topicId = " + topicId + "and page = " + page ;
        try {
            conn = this.getConn();
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                Reply reply = new Reply();
                reply.setReplyId(rs.getInt("replyId"));
                reply.setContent(rs.getString("content"));
                reply.setUserId(rs.getInt("userId"));
                reply.setBoardId(rs.getInt("boardId"));
                reply.setTitle(rs.getString("title"));
                reply.setPublishTime(rs.getDate("publishTime"));
                reply.setModifyTime(rs.getDate("modifyTime"));
                list.add(reply);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            closeAll(conn,pstmt,rs);
        }
        return list;
    }

    /**
     * 返回某主题的回复数
     * @param topicId
     * @return
     */
    @Override
    public int findCountReply(int topicId) {
        String sql =
                "select * from TBL_REPLY where topicId = " + topicId;
        String[] param = {};
        return this.executeSQL(sql,param);
    }
}
