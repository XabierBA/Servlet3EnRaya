package servlets;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
import clases.Controller;
import clases.FParser;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Enumeration;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author brais.fernandezvazqu
 */
@WebServlet(urlPatterns = {"/TresEnRaya"})
public class TresEnRaya extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        Controller cont = new Controller();

        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            try {
                String a1 = request.getParameter("A1");
                String a2 = request.getParameter("A2");
                String a3 = request.getParameter("A3");
                String b1 = request.getParameter("B1");
                String b2 = request.getParameter("B2");
                String b3 = request.getParameter("B3");
                String c1 = request.getParameter("C1");
                String c2 = request.getParameter("C2");
                String c3 = request.getParameter("C3");
                String restart = request.getParameter("clear");

                boolean hayParametro = false;

                if (a1 != null && cont.isFree(FParser.A1)) {
                    cont.pasaCasilla(FParser.A1);
                    hayParametro = true;
                }
                if (a2 != null && cont.isFree(FParser.A2)) {
                    cont.pasaCasilla(FParser.A2);
                    hayParametro = true;
                }
                if (a3 != null && cont.isFree(FParser.A3)) {
                    cont.pasaCasilla(FParser.A3);
                    hayParametro = true;
                }
                if (b1 != null && cont.isFree(FParser.B1)) {
                    cont.pasaCasilla(FParser.B1);
                    hayParametro = true;
                }
                if (b2 != null && cont.isFree(FParser.B2)) {
                    cont.pasaCasilla(FParser.B2);
                    hayParametro = true;
                }
                if (b3 != null && cont.isFree(FParser.B3)) {
                    cont.pasaCasilla(FParser.B3);
                    hayParametro = true;
                }
                if (c1 != null && cont.isFree(FParser.C1)) {
                    cont.pasaCasilla(FParser.C1);
                    hayParametro = true;
                }
                if (c2 != null && cont.isFree(FParser.C2)) {
                    cont.pasaCasilla(FParser.C2);
                    hayParametro = true;
                }
                if (c3 != null && cont.isFree(FParser.C3)) {
                    cont.pasaCasilla(FParser.C3);
                    hayParametro = true;
                }
                boolean ganado = false;
                if (cont.ganaX()) {
                    response.setContentType("text/html");
                    out.println("<script type=\"text/javascript\">");
                    out.println("alert('Gana x');");
                    out.println("</script>");
                    ganado = true;
                    cont.limpiaCasillas();
                }
                if (cont.ganaO()) {

                    response.setContentType("text/html");
                    out.println("<script type=\"text/javascript\">");
                    out.println("alert('Gana O');");
                    out.println("</script>");
                    ganado = true;
                    cont.limpiaCasillas();
                }

                if (cont.finDePartida() || restart != null) {
                    cont.limpiaCasillas();
                } else {
                    if (hayParametro && !ganado) {
                        cont.pasaTurno();
                    }
                }
            } catch (Exception e) {

            }

            String cadena1 = "<!DOCTYPE html>"
                    + "<html>"
                    + "<head>"
                    + "    <title>juego</title>"
                    + "    <style>"
                    + "        .cabecera {"
                    + "            margin: auto;"
                    + "            width: 50%;"
                    + "            height: 10vh;"
                    + "            background: red;"
                    + "        }"
                    + ""
                    + "        table {"
                    + "            margin: auto;"
                    + "            border: 3px solid green;"
                    + "            padding: 10px;"
                    + "        }"
                    + ""
                    + "        input {"
                    + "            width: 20vh;"
                    + "            height: 20vh;"
                    + "            font-size: 15vh;"
                    + "        }"
                    + "        table.restart {"
                    + "            margin: auto;"
                    + "            border: 3px solid blue;"
                    + "            width: 50%;"
                    + "            padding: 10px;"
                    + "        }"
                    + "        input.restart {"
                    + "            width: 100%;"
                    + "            height: 10vh;"
                    + "            font-size: 7vh;"
                    + "        }"
                    + "    </style>"
                    + "</head>"
                    + "<body>"
                    + "    <div class=cabecera>"
                    + "        <h1>3 EN RAYA</h1>"
                    + "    </div>"
                    + "    <form action=TresEnRaya method=get>"
                    + "        <table>"
                    + "            <tr>"
                    + "                <td><input type=submit name=A1 value=\u200e></td>"
                    + "                <td><input type=submit name=A2 value=\u200e></td>"
                    + "                <td><input type=submit name=A3 value=\u200e></td>"
                    + "            </tr>"
                    + "            <tr>"
                    + "                <td><input type=submit name=B1 value=\u200e></td>"
                    + "                <td><input type=submit name=B2 value=\u200e></td>"
                    + "                <td><input type=submit name=B3 value=\u200e></td>"
                    + "            </tr>"
                    + "            <tr>"
                    + "                <td><input type=submit name=C1 value=\u200e></td>"
                    + "                <td><input type=submit name=C2 value=\u200e></td>"
                    + "                <td><input type=submit name=C3 value=\u200e></td>"
                    + "            </tr>"
                    + "        </table>"
                    + "    </form>"
                    + "    <form>"
                    + "        <table class=\"restart\">"
                    + "            <tr>"
                    + "                <td><input type=submit name=clear value=RESTART class=\"restart\"></td>"
                    + "            </tr>"
                    + "        </table>"
                    + "    </form>"
                    + "</body>"
                    + "</html>";

            cadena1 = cont.cambiaValores(cadena1);
            out.println(cadena1);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
