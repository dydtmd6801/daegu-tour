package dao;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import regist.RegistDto;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.List;

public class MemberDao {

    private JdbcTemplate jdbcTemplate;

    public MemberDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public void insert(RegistDto registDto) {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(
                new PreparedStatementCreator() {
                    @Override
                    public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
                        PreparedStatement ps = con.prepareStatement("insert into MEMBER (USERID, PASSWORD, NAME, PHONENUMBER, REGISTDATE) values (?,?,?,?,?)", new String[]{"ID"});
                        ps.setString(1, registDto.getUserId());
                        ps.setString(2, registDto.getPassword());
                        ps.setString(3, registDto.getName());
                        ps.setString(4, registDto.getPhoneNumber());
                        ps.setString(5, String.valueOf(LocalDateTime.now()));
                        return ps;
                    }
                }, keyHolder);
        Number keyValue = keyHolder.getKey();
        registDto.setId(keyValue.longValue());
    }

    public List<RegistDto> findById(String id) {
        List<RegistDto> result = jdbcTemplate.query("select * from MEMBER where USERID=?",
                (rs, rowNum) -> {
                    RegistDto registDto = new RegistDto();
                    registDto.setUserId(rs.getString("USERID"));
                    registDto.setPassword(rs.getString("PASSWORD"));
                    registDto.setName(rs.getString("NAME"));
                    registDto.setPhoneNumber(rs.getString("PHONENUMBER"));
                    return registDto;
                }, id);
        return result;
    }
}
