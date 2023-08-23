package board;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class BoardDao {

    private JdbcTemplate jdbcTemplate;

    public BoardDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public void insert(BoardDto boardDto) {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(
                new PreparedStatementCreator() {
                    @Override
                    public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
                        PreparedStatement pstmt = con.prepareStatement("insert into BOARD (title, writer, content, date, password) values (?,?,?,?,?)", new String[]{"ID"});
                        pstmt.setString(1, boardDto.getTitle());
                        pstmt.setString(2, boardDto.getWriter());
                        pstmt.setString(3, boardDto.getContent());
                        pstmt.setString(4, boardDto.getDate());
                        pstmt.setString(5, boardDto.getPassword());
                        return pstmt;
                    }
                }, keyHolder);
        Number keyValue = keyHolder.getKey();
        boardDto.setId(keyValue.longValue());
    }

    public List<BoardDto> searchById(long index) {
        List<BoardDto> result = jdbcTemplate.query("select * from board where id=?",
                (ResultSet rs, int numRow) -> resultBoardDto(rs), index);
        return result.isEmpty() ? null : result;
    }

    public List<BoardDto> searchByTitleAndWriter(String title, String writer) {
        List<BoardDto> result = jdbcTemplate.query("select * from board where title = ? and writer = ?", (ResultSet rs, int numRow) -> resultBoardDto(rs), title, writer);
        return result.isEmpty() ? null : result;
    }

    public void resetAutoIncrement() {
        jdbcTemplate.execute("ALTER TABLE BOARD AUTO_INCREMENT = 1");
        jdbcTemplate.execute("SET @COUNT = 0");
        jdbcTemplate.execute("UPDATE BOARD SET ID = @COUNT:=@COUNT + 1");
    }

    public List<BoardDto> searchAll() {
        List<BoardDto> board = jdbcTemplate.query("select * from board order by id desc",
                (ResultSet rs, int numRow) -> resultBoardDto(rs));
        return board;
    }

    private BoardDto resultBoardDto(ResultSet rs) throws SQLException {
        BoardDto boardDto = new BoardDto();
        boardDto.setId(rs.getLong("id"));
        boardDto.setTitle(rs.getString("title"));
        boardDto.setWriter(rs.getString("writer"));
        boardDto.setContent(rs.getString("content"));
        boardDto.setDate(rs.getString("date"));
        boardDto.setPassword(rs.getString("password"));
        return boardDto;
    }

    public void remove(long id) {
        jdbcTemplate.update("delete from board where id=?",id);
    }

    public void update(BoardDto boardDto) {
        jdbcTemplate.update("update board set content = ? where id=?", boardDto.getContent(), boardDto.getId());
    }
}
