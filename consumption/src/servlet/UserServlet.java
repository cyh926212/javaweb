package servlet;

import dao.UserDao;
import entity.User;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

@WebServlet("/user")
public class UserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {

        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=utf-8");
        response.setCharacterEncoding("utf-8");

        UserDao userDao = new UserDao();
        User user = new User();

        HttpSession session = request.getSession();

        String action = request.getParameter("action");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String repeatPassword = request.getParameter("repeatPassword");

        if("login".equals(action)){
            try {
                user = userDao.login(username,password);
                if(user!=null){
                    session.setAttribute("user",user);
                    response.sendRedirect("pages/expenditure?action=list");
                }else {
                    response.setCharacterEncoding("utf-8");
                    response.setContentType("text/html; charset=utf-8");
                    PrintWriter out = response.getWriter();
                    out.println("<html>");
                    out.println("<head>");
                    out.println("</head>");
                    out.println("<body>");
                    out.println("<script type='text/javascript'>");
                    out.println("alert('用户名或密码错误！');");
                    out.println("window.location.href='index.jsp';");
                    out.println("</script>");
                    out.println("</body>");
                    out.println("</html>");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if("register".equals(action)){
            user.setUsername(username);
            user.setPassword(password);
            try {
                if(password.equals(repeatPassword)){
                    if(userDao.register(user)==true){
                        response.setCharacterEncoding("utf-8");
                        response.setContentType("text/html; charset=utf-8");
                        PrintWriter out = response.getWriter();
                        out.println("<html>");
                        out.println("<head>");
                        out.println("</head>");
                        out.println("<body>");
                        out.println("<script type='text/javascript'>");
                        out.println("alert('注册成功');");
                        out.println("window.location.href='index.jsp';");
                        out.println("</script>");
                        out.println("</body>");
                        out.println("</html>");
                    }else {
                        response.setCharacterEncoding("utf-8");
                        response.setContentType("text/html; charset=utf-8");
                        PrintWriter out = response.getWriter();
                        out.println("<html>");
                        out.println("<head>");
                        out.println("</head>");
                        out.println("<body>");
                        out.println("<script type='text/javascript'>");
                        out.println("alert('用户名已存在');");
                        out.println("window.location.href='register.jsp';");
                        out.println("</script>");
                        out.println("</body>");
                        out.println("</html>");
                    }
                }else {
                    response.setCharacterEncoding("utf-8");
                    response.setContentType("text/html; charset=utf-8");
                    PrintWriter out = response.getWriter();
                    out.println("<html>");
                    out.println("<head>");
                    out.println("</head>");
                    out.println("<body>");
                    out.println("<script type='text/javascript'>");
                    out.println("alert('两次输入的密码不一致');");
                    out.println("window.location.href='register.jsp';");
                    out.println("</script>");
                    out.println("</body>");
                    out.println("</html>");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {
        this.doPost(request, response);
    }
}
