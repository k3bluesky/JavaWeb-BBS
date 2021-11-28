package dao.impl;

import dao.ReplyDao;
import entity.Reply;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ReplyDaoImpl extends BaseDao implements ReplyDao {
    private Connection conn =null;
    private PreparedStatement pstmt = null;
    private ResultSet rs =null;

    /**
     * ���ݻظ�ID���һظ�
     * @param replyId
     * @return �ظ�
     */
    @Override
    public Reply findReply(int replyId) {
        Reply reply = new Reply();
        String sql =
                "select content from TBL_REPLY where replyId = " + replyId;
        try {
            conn = this.getConn();
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();rs.next();
            reply.setContent(rs.getString("replyId"));
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            closeAll(conn,pstmt,rs);
        }
        return reply;
    }

    /**
     * ��ӻظ�
     * @param reply
     * @return �ظ�����
     */
    @Override
    public int addReply(Reply reply) {
       String sql =
               "insert into TBL_REPLY(title,content,publishTime,modifyTime,uId,topicId) values(?,?,?,?,"
                       + reply.getUserId() +","+ reply.getTopicId() +")";
       String time = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
       String[] param = {reply.getTitle(),reply.getContent(),time,time};
       return this.executeSQL(sql,param);
    }

    /**
     * ɾ���ظ�
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
     * ���»ظ�
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
     * ����ĳ����ĵ�pageҳ�ظ��б�
     * @param topicId
     * @return
     */
    @Override
    public List findListReply(int topicId) {
        List list = new ArrayList();
        String sql =
                "select * from TBL_REPLY where topicId = " + topicId;
        try {
            conn = this.getConn();
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                Reply reply = new Reply();
                reply.setReplyId(rs.getInt("replyId"));
                reply.setContent(rs.getString("content"));
                reply.setUserId(rs.getInt("uId"));
                reply.setTopicId(rs.getInt("topicId"));
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
     * ����ĳ����Ļظ���
     * @param topicId
     * @return
     */
    @Override
    public int findCountReply(int topicId) {
        String sql =
                "select COUNT(replyId) from TBL_REPLY where topicId = " + topicId;
        String[] param = {};
        return this.executeSQL(sql,param);
    }
}
