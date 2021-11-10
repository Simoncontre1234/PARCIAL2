package com.emergentes.controlador;

import com.emergentes.dao.AvisoDAO;
import com.emergentes.dao.AvisoDAOimpl;
import com.emergentes.modelo.Seminario;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.persistence.metamodel.SetAttribute;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "Inicio", urlPatterns = {"/Inicio"})
public class Inicio extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            AvisoDAO dao = new AvisoDAOimpl();
            int id;
            Seminario sem= new Seminario();
            String action = (request.getParameter("action") != null) ? request.getParameter("action") : "view";

            switch (action) {
                case "add":
                    request.setAttribute("seminario", sem);
                    request.getRequestDispatcher("formSemestre.jsp").forward(request, response);
                    break;
                case "edit":
                    id=Integer.parseInt(request.getParameter("id"));
                    sem = dao.getById(id);
                    request.setAttribute("seminario", sem);
                    request.getRequestDispatcher("formSemestre.jsp").forward(request, response);
                    break;

                case "delete":
                    id = Integer.parseInt(request.getParameter("id"));
                    dao.delete(id);
                    response.sendRedirect("Inicio");
                    break;

                default:
                    //listar
                    List<Seminario> lista = dao.getAll();
                    request.setAttribute("seminarios",lista);
                    request.getRequestDispatcher("listado.jsp").forward(request, response);
                    break;
            }            
        } catch (Exception e) {
            System.out.println("error"+e.getMessage());
        }        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        AvisoDAO dao = new AvisoDAOimpl();

        int id = Integer.parseInt(request.getParameter("id"));
        String titulo = request.getParameter("titulo");
        String expositor = request.getParameter("expositor");
        String fecha = request.getParameter("fecha");
        String hora = request.getParameter("hora");
        int cupo = Integer.parseInt(request.getParameter("cupo"));
        
        Seminario sem = new Seminario();
        
        sem.setId(id);
        sem.setTitulo(titulo);
        sem.setExpositor(expositor);
        sem.setFecha(fecha);
        sem.setHora(hora);
        sem.setCupo(cupo);
        
        if(id==0){
            //nuevo
            try {
                dao.insert(sem);
                response.sendRedirect("Inicio");
            } catch (Exception e) {
                System.out.println("error" + e.getMessage());
            }
        } else {
            //modificacion
            try {
                dao.update(sem);
                response.sendRedirect("Inicio");
            } catch (Exception e) {
                System.out.println("error" + e.getMessage());
            }
        }
    }

}
