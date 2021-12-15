package servlet.academic;

import dal.StudentDAO;
import dataobj.Student;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class ShowListStudentRegisterServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            StudentDAO stdDao = new StudentDAO();
            ArrayList<Student> listStudentRegister = new ArrayList<>();
            
            listStudentRegister = stdDao.getListStudentRegister();
            
            request.setAttribute("listRegister", listStudentRegister);
            request.getRequestDispatcher("/academic/listregister.jsp").forward(request, response);
        } catch (Exception ex) {
            Logger.getLogger(ShowListStudentRegisterServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
