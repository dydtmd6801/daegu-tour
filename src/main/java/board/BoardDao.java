package board;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

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
                        PreparedStatement pstmt = con.prepareStatement("insert into BOARD (title, writer, content, date) values (?,?,?,?)");
                        pstmt.setString(1, boardDto.getTitle());
                        pstmt.setString(2, boardDto.getWriter());
                        pstmt.setString(3, boardDto.getContent());
                        pstmt.setString(4, boardDto.getDate());
                        return pstmt;
                    }
                }, keyHolder);
        Number keyValue = keyHolder.getKey();
        boardDto.setId(keyValue.longValue());
    }
}
