package board;

import login.AuthInfo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/board")
public class BoardController {

    private BoardService boardService;
    private PagingService pagingService;

    public void setBoardService(BoardService boardService, PagingService pagingService) {
        this.boardService = boardService;
        this.pagingService = pagingService;
    }

    @GetMapping
    public String board(@RequestParam(required = false, defaultValue = "Y") String status,
                        @RequestParam int page, Model model) {
        boardService.resetAutoIncrement();
        if (status.equals("N")) {
            model.addAttribute("status", "notFoundInfo");
        }
        PagingDto pagingDto = pagingService.initPageNumber(page);
        if (page > pagingDto.getTotalPage()) {
            return "redirect:/board?page=" + pagingDto.getTotalPage();
        }
        model.addAttribute("paging", pagingDto);
        List<BoardDto> boards = pagingService.listPage(page, pagingDto.getShowBoardNumber());
        model.addAttribute("boards", boards);
        return "/board/list";
    }

    @GetMapping("/detail")
    public String showDetail(@RequestParam long id, @RequestParam int recentPage, Model model, HttpSession session) {
        BoardDto boardDetail = boardService.searchDetail(id);
        AuthInfo authInfo = (AuthInfo) session.getAttribute("AuthInfo");
        List<CommentDto> comments = boardService.commentList((int) boardDetail.getId());
        try {
            if (boardDetail.getWriter().equals(authInfo.getUserName())) {
                model.addAttribute("AuthInfo", authInfo);
            }
        } catch (NullPointerException e) {
        } finally {
            model.addAttribute("comments", comments);
            model.addAttribute("boardDetail", boardDetail);
            model.addAttribute("recentPage", recentPage);
            return "/board/detail";
        }
    }

    @GetMapping("/write")
    public String write(BoardDto boardDto, Model model, HttpSession session) {
        AuthInfo authInfo = (AuthInfo) session.getAttribute("AuthInfo");
        try {
            authInfo.getUserName();
            model.addAttribute("AuthInfo", authInfo);
            return "/board/write";
        } catch (NullPointerException NPE) {
            return "redirect:/board?status=N&page=1";
        }
    }

    @PostMapping("/write")
    public String writeBoard(BoardDto boardDto, Errors errors) {
        new BoardValidator().validate(boardDto, errors);
        if (errors.hasErrors()) {
            return "board/write";
        }
        if (!boardService.checkDuplicateBoard(boardDto)) {
            errors.rejectValue("title", "duplicateBoard");
            return "board/write";
        }
        boardDto.setContent(boardDto.getContent().replace("\r\n","<br/>"));
        boardService.write(boardDto);
        return "redirect:/board?page=1";
    }

    @GetMapping("/modify")
    public String modify(@RequestParam long id, @RequestParam int recentPage, Model model, HttpSession session, BoardDto boardDto) {
        AuthInfo authInfo = (AuthInfo) session.getAttribute("AuthInfo");
        BoardDto modifyBoard = boardService.searchDetail(id);
        if (!authInfo.getUserName().equals(modifyBoard.getWriter())) {
            return "redirect:/board/detail?id=" + id + "$recentPage=" + recentPage;
        }
        model.addAttribute("modifyBoard", modifyBoard);
        model.addAttribute("authInfo", authInfo);
        model.addAttribute("recentPage", recentPage);
        return "board/modify";
    }

    @PostMapping("/modify")
    public String modify(@RequestParam int recentPage, BoardDto boardDto, Model model, Errors errors) {
        BoardDto modifyBoard = boardService.searchDetail(boardDto.getId());
        new BoardValidator().validate(boardDto, errors);
        if (errors.hasErrors()) {
            model.addAttribute("modifyBoard", modifyBoard);
            return "board/modify";
        }
        if (!boardDto.getPassword().equals(modifyBoard.getPassword())) {
            model.addAttribute("modifyBoard", modifyBoard);
            errors.rejectValue("password", "notMatchBoardPassword");
            return "board/modify";
        }
        boardDto.setContent(boardDto.getContent().replace("\r\n","<br/>"));
        boardService.updateBoard(boardDto);
        return "redirect:/board/detail?id=" + boardDto.getId() + "&recentPage=" + recentPage;
    }

    @ResponseBody
    @PostMapping("/remove")
    public String remove(HttpServletRequest request) {
        long id = Long.parseLong(request.getParameter("id"));
        String password = request.getParameter("password");
        BoardDto removeBoard = boardService.searchDetail(id);
        if (password.equals(removeBoard.getPassword())) {
            boardService.removeBoard(id);
            return "success";
        }
        return "fail";
    }
}
