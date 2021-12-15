package servlet.academic;

import dal.AcademicDAO;
import dal.StudentDAO;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class RejectStudentServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            String studentId = request.getParameter("studentId");
            
            AcademicDAO acdDao = new AcademicDAO();
            acdDao.deleteStudent(studentId);
            
            StudentDAO stdDao = new StudentDAO();
            stdDao.deleteStudent(studentId);
            
            response.sendRedirect("ShowListStudentRegisterServlet");
        } catch (Exception ex) {
            Logger.getLogger(RejectStudentServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
