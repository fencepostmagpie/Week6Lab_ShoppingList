package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Aster
 */
public class ShoppingListServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ShoppingListServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ShoppingListServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        String username = request.getParameter("username");
        getServletContext().getRequestDispatcher("/WEB-INF/register.jsp")
                .forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");//Determines what we're gonna do
        String username = request.getParameter("username");
        request.setAttribute("username", username);
        HttpSession session = request.getSession();
        String url = "/WEB-INF/register.jsp";
        ArrayList<String> groceries = null;

        if (action == null) { //No action, continue to normal page
            action = "register";
            String message = action;
            request.setAttribute("message", message);
        }
        if (action.equals("logout")) { //session.invalidate should remove all session variables
            session.invalidate();
            url = "/WEB-INF/register.jsp";
        }
        if (action.equals("register")) {//If register is the action, validate username
            if (username == null || username.isEmpty()) { //If username is blank, display message and return back to the login page
                request.setAttribute("message", "Please enter one or more characters.");
                url = "/WEB-INF/register.jsp";
            } else { //Otherwise save the username and progress to the shopping list

                String message = "Hello, " + username;
                session.setAttribute("username", username);
                request.setAttribute("message", message);
                url = "/WEB-INF/shoppingList.jsp";
            }
        }

        if (action.equals("Add")) {
            String groceryItem = request.getParameter("item");
            groceries = (ArrayList<String>) session.getAttribute("item");
            if (groceries == null) {
                groceries = new ArrayList<String>();
            }
            session.setAttribute("groceries", groceries);
        }
        getServletContext().getRequestDispatcher(url).forward(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
