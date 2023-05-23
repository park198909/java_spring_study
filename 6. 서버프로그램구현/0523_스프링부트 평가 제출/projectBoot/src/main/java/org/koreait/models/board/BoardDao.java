package org.koreait.models.board;

import org.koreait.controllers.board.BoardForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class BoardDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void insert(BoardForm boardForm) {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        String sql = "INSERT INTO BOARDDATA (ID,SUBJECT,CONTENT) VALUES (BOARDDATA_SEQ.nextval, ?, ?)";
        jdbcTemplate.update(con->{
            PreparedStatement pstmt = con.prepareStatement(sql,new String[] {"id"});
            pstmt.setString(1, boardForm.getSubject());
            pstmt.setString(2, boardForm.getContent());
            return pstmt;
        },keyHolder);

        Number key = keyHolder.getKey();
        boardForm.setId(key.longValue());
    }

    public Board get(Long id) {
        try {
            String sql = "SELECT * FROM BOARDDATA WHERE ID = ?";
            Board board = jdbcTemplate.queryForObject(sql, this::mapper, id);
            return board;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<Board> gets() {
        String sql = "SELECT * FROM BOARDDATA";
        List<Board> board = jdbcTemplate.query(sql,this::mapper);

        return board;
    }

    public Integer remove(Long id) {
        String sql = "DELETE FROM BOARDDATA WHERE ID = ?";
        Integer success = jdbcTemplate.update(sql,id);

        return success;
    }

    private Board mapper(ResultSet rs, int i) throws SQLException {
        Board board = new Board();
        board.setId(rs.getLong("ID"));
        board.setSubject(rs.getString("SUBJECT"));
        board.setContent(rs.getString("CONTENT"));
        board.setRegDt(rs.getTimestamp("REGDT").toLocalDateTime());

        return board;
    }

    public void processStat() {
        try {
            String sql = "SELECT SUBSTR(TO_CHAR(REGDT,'yyyy-MM-dd HH24'), 1, 14) CTIME, COUNT(*) CNT FROM BOARDDATA " +
                    "WHERE REGDT >= REGDT-1 GROUP BY SUBSTR(TO_CHAR(REGDT,'yyyy-MM-dd HH24'), 1, 14) ";
            List<BatchForm> batchForms = jdbcTemplate.query(sql, this::batchMapper);

            String sql2 = "INSERT INTO BOARDDATA_BAT (CNT,CTIME) VALUES(?, ?)";
            for (BatchForm batchForm : batchForms) {
                jdbcTemplate.update(sql2, batchForm.getCnt(), batchForm.getCTime());
            }
        } catch (Exception e) {
            //e.printStackTrace();
        }
    }

    private BatchForm batchMapper(ResultSet rs, int i) throws SQLException {
        BatchForm batchForm = new BatchForm();
        batchForm.setCnt(rs.getLong("CNT"));
        batchForm.setCTime(rs.getString("CTIME"));

        return batchForm;
    }

}
