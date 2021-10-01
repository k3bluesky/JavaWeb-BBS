package dao.impl;

import dao.ReplyDao;
import entity.Reply;
import entity.Topic;

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
     * ��ӻظ�
     * @param reply
     * @return �ظ�����
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

        }
    }

    /**
     * ����ĳ����Ļظ���
     * @param topicId
     * @return
     */
    @Override
    public int findCountReply(int topicId) {
        return 0;
    }
}
