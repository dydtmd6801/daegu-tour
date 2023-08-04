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

    public void resetAutoIncrement() {
        boardDao.resetAutoIncrement();
    }

    public BoardDto searchDetail(long id) {
        List<BoardDto> result = boardDao.searchById(id);
        if(result.isEmpty()) {
            throw new NullPointerException();
        }
        return result.get(0);
    }
}
