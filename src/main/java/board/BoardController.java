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
    public String board(Model model) {
        boardService.resetAutoIncrement();
        List<BoardDto> boards = boardService.listAll();
        model.addAttribute("boards", boards);
        return "/board/list";
    }

    @GetMapping("/detail")
    public String showDetail(@RequestParam long id, Model model) {
        BoardDto boardDetail = boardService.searchDetail(id);
        model.addAttribute("boardDetail", boardDetail);
        return "/board/detail";
    }

    @GetMapping("/write")
    public String write(BoardDto boardDto, Model model, HttpSession session) {
        model.addAttribute("AuthInfo", session.getAttribute("AuthInfo"));
        return "/board/write";
    }

    @PostMapping("/write")
    public String writeBoard(BoardDto boardDto) {
        boardService.write(boardDto);
        return "redirect:/board";
    }
}
