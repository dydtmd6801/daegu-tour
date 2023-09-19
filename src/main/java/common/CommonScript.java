package common;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class CommonScript {

    public void alertScript(HttpServletResponse response, String alertText, String redirectUrl) throws IOException {
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println("<script>");
        out.println("alert('" + alertText + "');");
        out.println("location.reload();");
        out.println("location.href='" + redirectUrl + "';");
        out.println("</script>");
        out.close();
    }
}
