package board;

import java.time.LocalDateTime;
import java.util.List;

public class BoardService {

    private BoardDao boardDao;

    public BoardService(BoardDao boardDao) {
        this.boardDao = boardDao;
    }

    public void write(BoardDto boardDto) throws NullPointerException {
        boardDto.setDate(String.valueOf(LocalDateTime.now()));
        boardDao.insert(boardDto);
    }

    public boolean checkDuplicateBoard(BoardDto boardDto) {
        return boardDao.searchByTitleAndWriter(boardDto.getTitle(), boardDto.getWriter()) == null;
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

    public void removeBoard(long id) {
        boardDao.remove(id);
    }

    public void updateBoard(BoardDto boardDto) {
        boardDao.update(boardDto);
    }

    public List<CommentDto> commentList(int boardId) {
        return boardDao.getComment(boardId);
    }
}
