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
    private Connection conn = null;
    private PreparedStatement pstmt =null;
    private ResultSet rs = null;
    private HashMap map = new HashMap();
    private int parentId = 0;
    private List sonList = null;

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
            closeAll(conn,pstmt,rs);
        }
        return map;
    }

    @Override
    public Board findBoard(int boardId) {
        return null;
    }
}
