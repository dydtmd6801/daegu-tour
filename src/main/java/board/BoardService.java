package board;

import java.util.List;

public class BoardService {

    private BoardDao boardDao;

    public BoardService(BoardDao boardDao) {
        this.boardDao = boardDao;
    }

    public void write(BoardDto boardDto) throws NullPointerException {
        boardDao.insert(boardDto);
    }

    public List<BoardDto> listAll() {
        List<BoardDto> results = boardDao.searchAll();
        return results;
    }
}
