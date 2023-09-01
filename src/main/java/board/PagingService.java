package board;

import java.util.List;

public class PagingService {

    private PagingDto pagingDto;
    private BoardDao boardDao;

    public PagingService(PagingDto pagingDto, BoardDao boardDao) {
        this.pagingDto = pagingDto;
        this.boardDao = boardDao;
    }

    private void calcTotalPageNumber() {
        int totalNumber = (boardDao.totalBoardNumber() / 10) + 1;
        pagingDto.setTotalPage(totalNumber);
    }

    private void calcStartPageNumber(int nowPage) {
        if (nowPage % 10 == 0) {
            nowPage -= 1;
        }
        int startPageNumber = ((int) Math.floor((double) nowPage / pagingDto.getShowBoardNumber()) * 10) + 1;
        pagingDto.setStartPage(startPageNumber);
    }

    private void calcEndPageNumber(int nowPage) {
        int endPageNumber = ((int) Math.ceil((double) nowPage / pagingDto.getShowBoardNumber())) * 10;
        if (endPageNumber > pagingDto.getTotalPage()) {
            endPageNumber = pagingDto.getTotalPage();
        }
        pagingDto.setEndPage(endPageNumber);
    }

    private void calcNowPageNumber(int nowPage) {
        pagingDto.setNowPage(nowPage);
    }

    public PagingDto initPageNumber(int nowPage) {
        calcTotalPageNumber();
        calcStartPageNumber(nowPage);
        calcNowPageNumber(nowPage);
        calcEndPageNumber(nowPage);
        return pagingDto;
    }

    public List<BoardDto> listPage(int nowPage, int showBoardNumber) {
        int skipBoardNumber = (nowPage - 1) * pagingDto.getShowBoardNumber();
        return boardDao.searchForPage(skipBoardNumber, showBoardNumber);
    }
}
