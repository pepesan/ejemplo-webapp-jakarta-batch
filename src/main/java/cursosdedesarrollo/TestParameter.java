package cursosdedesarrollo;

import jakarta.batch.operations.JobOperator;
import jakarta.batch.operations.JobSecurityException;
import jakarta.batch.operations.JobStartException;
import jakarta.batch.runtime.BatchRuntime;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Properties;

@WebServlet(urlPatterns = { "/TestParameter" })
public class TestParameter extends HttpServlet {

    protected void processRequest(HttpServletRequest request,
                                  HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            JobOperator jo = BatchRuntime.getJobOperator();
            Properties jobParameters = new Properties();

            // Configurar propiedades para el job
            jobParameters.setProperty("input_file", "input_prop.csv");
            jobParameters.setProperty("output_file", "output_prop.json");
            long id = jo.start("simplejobparameter", jobParameters);
            System.out.println("Parametrized Job submitted: " + id);
            out.println("Parametrized Job submitted: " + id);

        } catch (JobStartException | JobSecurityException ex) {
            out.println("Error submitting Job! " + ex.getMessage());
            ex.printStackTrace();
        }
        out.flush();

    }

    // <editor-fold defaultstate="collapsed"
    // desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request
     *            servlet request
     * @param response
     *            servlet response
     * @throws ServletException
     *             if a servlet-specific error occurs
     * @throws IOException
     *             if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request
     *            servlet request
     * @param response
     *            servlet response
     * @throws ServletException
     *             if a servlet-specific error occurs
     * @throws IOException
     *             if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

}
