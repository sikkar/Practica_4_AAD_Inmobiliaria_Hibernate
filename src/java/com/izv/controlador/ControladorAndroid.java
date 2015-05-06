/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.izv.controlador;

import com.izv.hibernate.Fotos;
import com.izv.hibernate.Inmueble;
import com.izv.modelo.ControlDB;
import com.izv.modelo.ModeloFoto;
import com.izv.modelo.ModeloInmueble;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author AngelakaMogu
 */
@WebServlet(name = "ControladorAndroid", urlPatterns = {"/controladorandroid"})
@MultipartConfig
public class ControladorAndroid extends HttpServlet {

    SimpleDateFormat format;
    JSONObject obj = new JSONObject();

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
        boolean forward = false;
        String target, op, action, view;
        ControlDB bd;

        target = request.getParameter("target");
        op = request.getParameter("op");
        action = request.getParameter("action");
        if (target.equals("inmobiliaria") && op.equals("insert") && action.equals("op")) {
            response.setContentType("text/html;charset=UTF-8");
            format = new SimpleDateFormat();
            format.applyPattern("yyyy-dd-MM");
            Calendar cal = Calendar.getInstance();
            Date date = cal.getTime();
            format.format(date);
            Inmueble inmueble = new Inmueble();
            inmueble.setLocalidad(request.getParameter("localidad"));
            inmueble.setDireccion(request.getParameter("direccion"));
            inmueble.setTipo(request.getParameter("tipo"));
            inmueble.setUsuario(request.getParameter("usuario"));
            inmueble.setPrecio(request.getParameter("precio"));
            inmueble.setFechaalta(date);
            ModeloInmueble.insert(inmueble);
            Inmueble inm = ModeloInmueble.get(inmueble.getId() + "");
            try (PrintWriter out = response.getWriter()) {
                out.println(inm.getId() + "");
            }
        } else {
            if (target.equals("inmobiliaria") && op.equals("imagen") && action.equals("op")) {
                forward = false;
                boolean error = false;
                String id = request.getParameter("id");
                response.setContentType("text/html;charset=UTF-8");
                Calendar calendario = new GregorianCalendar();
                Date date = calendario.getTime();
                SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd-hh-mm-ss-SSSSS");
                String fecha = formatoFecha.format(date);
                String titulo = "inmueble_" + id + "_" + fecha;
                Part archivoPost = request.getPart("archivo");
                String carpeta = getServletContext().getRealPath("/") + "fotos/";
                InputStream input = archivoPost.getInputStream();
                try {
                    OutputStream out = new FileOutputStream(carpeta + titulo + ".jpg");
                    byte[] b = new byte[2048];
                    int length;
                    while ((length = input.read(b)) != -1) {
                        out.write(b, 0, length);
                    }
                } catch (Exception e) {
                    error = true;
                } finally {
                    input.close();
                }
                Fotos fot = new Fotos();
                fot.setIdinmueble(Integer.valueOf(id));
                fot.setNombre(titulo + ".jpg");
                ModeloFoto.insert(fot);
                try (PrintWriter out = response.getWriter()) {
                    if (error) {
                        out.println("error");
                    } else {
                        out.println("foto subida"); // respuesta json chapucera
                    }
                }
            } else {
                if (target.equals("bar")) {
                    try {
                        bd = new ControlDB();
                        bd.cargarDriver();
                        bd.conectar();
                        response.setContentType("application/json");
                        /*
                         int r = bd.ejecutarDelete("delete from pedidos where idPedido=52");
                         System.out.println(r);
                         */
//                        String fechaHora = getFecha();
//                        String consulta = "insert into pedidos values(0, '" + fechaHora + "', 0, 0, null, 'admin ', 6, 1)";
//                        bd.ejecutarInsert(consulta);
                        ResultSet r = bd.ejecutarSelect("Select * from zona");
                        JSONArray array = new JSONArray();
                        ResultSetMetaData rsMetaData = r.getMetaData();
                        int columns = rsMetaData.getColumnCount();
                        try {
                            while (r.next()) {
                                JSONObject objetoJSON = new JSONObject();
                                for (int i = 1; i <= columns; i++) {
                                    objetoJSON.put(rsMetaData.getColumnLabel(i),r.getString(i));
                                }
                                System.out.println(objetoJSON+"\n");
//                                System.out.println(r.getString(1) + " " + r.getString(2) + " " + r.getString(3)
//                                        + " " + r.getString(4));
                                array.put(objetoJSON);
                            }
                        } catch (SQLException ex) {
                            Logger.getLogger(ControladorAndroid.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        PrintWriter out = response.getWriter();
                        out.print(array);
                        out.flush();
//                        obj.put("nombre", "Angel");
//                        obj.put("password", "1234");
//                        System.out.println("JSON " + obj.toString());
//                        System.out.println(obj.getString("nombre") + " " + obj.getString("password"));

                    } catch (JSONException ex) {
                        Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (SQLException ex) {
                        Logger.getLogger(ControladorAndroid.class.getName()).log(Level.SEVERE, null, ex);
                    }

                }
            }
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
