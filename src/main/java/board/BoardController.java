package board;

import login.AuthInfo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/board")
public class BoardController {

    private BoardService boardService;

    public void setBoardService(BoardService boardService) {
        this.boardService = boardService;
    }

    @GetMapping
    public String board(@RequestParam(required = false, defaultValue = "Y") String status, Model model) {
        boardService.resetAutoIncrement();
        if(status.equals("N")) {
            model.addAttribute("status","notFoundInfo");
        }
        List<BoardDto> boards = boardService.listAll();
        model.addAttribute("boards", boards);
        return "/board/list";
    }

    @GetMapping("/detail")
    public String showDetail(@RequestParam long id, Model model, HttpSession session) {
        BoardDto boardDetail = boardService.searchDetail(id);
            AuthInfo authInfo = (AuthInfo) session.getAttribute("AuthInfo");
            try {
                if (boardDetail.getWriter().equals(authInfo.getUserName())) {
                    model.addAttribute("auth", "Y");
                }
            } catch (NullPointerException e) {
            } finally {
                model.addAttribute("boardDetail", boardDetail);
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
            return "redirect:/board?status=N";
        }
    }

    @PostMapping("/write")
    public String writeBoard(BoardDto boardDto) {
        boardService.write(boardDto);
        return "redirect:/board";
    }
}
