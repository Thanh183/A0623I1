package controller;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "discountServlet", urlPatterns = "/discount")
public class DiscountServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String describe = req.getParameter("describe");
        double price = Double.parseDouble(req.getParameter("price"));
        double percent = Double.parseDouble(req.getParameter("percent"));
        double discountAmount = price * percent * 0.01;
        double discountPrice = price - discountAmount;
        req.setAttribute("describe", describe);
        req.setAttribute("discountAmount", discountAmount);
        req.setAttribute("discountPrice", discountPrice);
        req.getRequestDispatcher("/display-discount.jsp").forward(req,resp);
    }
}
