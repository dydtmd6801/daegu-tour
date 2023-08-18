package board;

import login.AuthInfo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
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
    public String writeBoard(BoardDto boardDto, Errors errors) {
        new BoardValidator().validate(boardDto, errors);
        if (errors.hasErrors()) {
            return "board/write";
        }
        boardService.write(boardDto);
        return "redirect:/board";
    }

    @GetMapping("/modify")
    public String modify(@RequestParam long id, Model model, HttpSession session, BoardDto boardDto) {
        BoardDto modifyBoard = boardService.searchDetail(id);
        model.addAttribute("modifyBoard", modifyBoard);
        model.addAttribute("authInfo", session.getAttribute("AuthInfo"));
        return "board/modify";
    }

    @PostMapping("/modify")
    public String modify(BoardDto boardDto, Model model, Errors errors) {
        new BoardValidator().validate(boardDto, errors);
        if (errors.hasErrors()) {
            return "redirect:/board/modify?id=" + boardDto.getId();
        }
        BoardDto modifyBoard = boardService.searchDetail(boardDto.getId());
        if(!boardDto.getPassword().equals(modifyBoard.getPassword())) {
            errors.rejectValue("password","notMatchBoardPassword");
            return "redirect:/board/modify?id=" + boardDto.getId();
        }
        boardService.updateBoard(boardDto);
        return "redirect:/board/detail?id=" + boardDto.getId();
    }

    @ResponseBody
    @PostMapping("/remove")
    public String remove(HttpServletRequest request) {
        long id = Long.parseLong(request.getParameter("id"));
        String password = request.getParameter("password");

        System.out.println("id : " + id + ", password : " + password);

        BoardDto removeBoard = boardService.searchDetail(id);
        System.out.println("password : " + removeBoard.getPassword() + ", id : " + removeBoard.getTitle());
        if(password.equals(removeBoard.getPassword())) {
            boardService.removeBoard(id);
            return "success";
        }
        return "fail";
    }
}
