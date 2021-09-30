package dao.impl;

import dao.BoardDao;
import entity.Board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class BoardDaoImpl extends BaseDao implements BoardDao {
    private Connection conn = null;                 //���ڱ������ݿ�����
    private PreparedStatement pstmt =null;          //����ִ��SQL���
    private ResultSet rs = null;                    //�û������ѯ�����
    private HashMap map = new HashMap();            //��������Ϣ
    private int parentId = 0;
    private List sonList = null;

    /**
     * ���Ұ��
     *
     * @return ��װ�˰����Ϣ��Map
     */
    public Map findBoard() {
        String sql = "select * from TBL_BOARD order by parentId,boardId";

        try {
            conn = this.getConn();
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();
            sonList = new ArrayList();

            while (rs.next()) {
                if (parentId != rs.getInt("parentId")) {
                    map.put(new Integer(parentId), sonList);
                    sonList = new ArrayList();
                    parentId = rs.getInt("parentId");
                }
                Board board = new Board();
                board.setBoardId(rs.getInt("boardId"));
                board.setBoardName(rs.getString("boardName"));
                sonList.add(board);
            }
            map.put(new Integer(parentId), sonList);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            this.closeAll(conn,pstmt,rs);
        }
        return map;
    }

    /**
     * ���ݰ��id���Ұ��
     * @param boardId
     * @return
     */
    @Override
    public Board findBoard(int boardId) {
        Board board = new Board();
        String sql =
                "select boardName from TBL_BOARD where boardId = " + boardId;
        try{
            conn = this.getConn();
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();
            board.setBoardName(rs.getString("boardName"));
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            this.closeAll(conn,pstmt,rs);
        }
        return board;
    }
}
