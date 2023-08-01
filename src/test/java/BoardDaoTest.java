import board.BoardDao;
import board.BoardDto;
import config.DBConfig;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class BoardDaoTest {

    private DBConfig dbConfig;
    private BoardDao boardDao;

    @BeforeEach
    public void beforeEach() {
        dbConfig = new DBConfig();
        boardDao = new BoardDao(dbConfig.dataSource());
    }

    @Test
    public void insertTest() {
        BoardDto boardDto = new BoardDto();
        boardDto.setTitle("테스트데이터");
        boardDto.setWriter("tester");
        boardDto.setContent("데스트데이터 입니다.");
        boardDto.setDate(String.valueOf(LocalDateTime.now()));
        boardDao.insert(boardDto);
    }

    @Test
    public void searchByIdTest() {
        List<BoardDto> result = boardDao.searchById(1);

        assertThat(result.size()).isEqualTo(1);
    }
}
