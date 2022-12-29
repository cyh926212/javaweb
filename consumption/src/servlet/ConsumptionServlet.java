package servlet;

import dao.ConsumptionDao;
import entity.Consumption;
import entity.User;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;


@WebServlet("/pages/expenditure")
public class ConsumptionServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=utf-8");
        response.setCharacterEncoding("utf-8");

        ConsumptionDao consumptionDao = new ConsumptionDao();
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        String action = request.getParameter("action");
        String searchType = request.getParameter("searchType");
        String key = request.getParameter("key");

        List<Consumption> list = new ArrayList<Consumption>();

        String id = request.getParameter("id");
        String type = request.getParameter("type");
        String money = request.getParameter("money");
        String name = request.getParameter("name");
        String createTime = request.getParameter("date");
        Integer userId = user.getId();
        //修改消费前
        if ("modify".equals(action)) {
            try {
                Consumption consumption = consumptionDao.getByIdConsumption(Integer.valueOf(id));
                request.setAttribute("consumption", consumption);
                request.getRequestDispatcher("expenditureEdie.jsp").forward(request, response);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        //修改消费后
        if ("modifyAfter".equals(action)) {
            Consumption consumption = new Consumption(Integer.valueOf(id), type, name, Double.parseDouble(money), Date.valueOf(createTime), userId);
            try {
                if (consumptionDao.updateConsumption(consumption)) {
                    response.setCharacterEncoding("utf-8");
                    response.setContentType("text/html; charset=utf-8");
                    PrintWriter out = response.getWriter();
                    out.println("<html>");
                    out.println("<head>");
                    out.println("</head>");
                    out.println("<body>");
                    out.println("<script type='text/javascript'>");
                    out.println("alert('修改成功');");
                    out.println("window.location.href='expenditure?action=list';");
                    out.println("</script>");
                    out.println("</body>");
                    out.println("</html>");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        //根据消费日期查询
        if ("search".equals(action) && "date".equals(searchType)) {
            try {
                list = consumptionDao.getByDateConsumption(Date.valueOf(key),userId);
                request.setAttribute("consumptionList", list);
                request.getRequestDispatcher("statistics.jsp").forward(request, response);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        //根据消费名称查询
        if ("search".equals(action) && "name".equals(searchType)) {
            try {
                list = consumptionDao.getByNameConsumption(key,userId);
                request.setAttribute("consumptionList", list);
                request.getRequestDispatcher("statistics.jsp").forward(request, response);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if ("del".equals(action)) {
            try {
                if (consumptionDao.delByConsumptionId(Integer.valueOf(id))) {
                    response.setCharacterEncoding("utf-8");
                    response.setContentType("text/html; charset=utf-8");
                    PrintWriter out = response.getWriter();
                    out.println("<html>");
                    out.println("<head>");
                    out.println("</head>");
                    out.println("<body>");
                    out.println("<script type='text/javascript'>");
                    out.println("alert('删除成功');");
                    out.println("window.location.href='expenditure?action=list';");
                    out.println("</script>");
                    out.println("</body>");
                    out.println("</html>");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if ("list".equals(action)) {
            try {
                list = consumptionDao.getByUserIdConsumption(user.getId());
                request.setAttribute("consumptionList", list);
                request.getRequestDispatcher("expenditure.jsp").forward(request, response);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if ("add".equals(action)) {
            Consumption consumption = new Consumption(0, type, name, Double.parseDouble(money), Date.valueOf(createTime), userId);
            try {
                if (consumptionDao.addConsumption(consumption)) {
                    response.setCharacterEncoding("utf-8");
                    response.setContentType("text/html; charset=utf-8");
                    PrintWriter out = response.getWriter();
                    out.println("<html>");
                    out.println("<head>");
                    out.println("</head>");
                    out.println("<body>");
                    out.println("<script type='text/javascript'>");
                    out.println("alert('添加成功');");
                    out.println("window.location.href='expenditure?action=list';");
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
