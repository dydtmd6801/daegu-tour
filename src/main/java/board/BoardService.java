package board;

public class BoardService {

    private BoardDao boardDao;

    public BoardService(BoardDao boardDao) {
        this.boardDao = boardDao;
    }

    public void write(BoardDto boardDto) throws NullPointerException {
        boardDao.insert(boardDto);
    }
}
