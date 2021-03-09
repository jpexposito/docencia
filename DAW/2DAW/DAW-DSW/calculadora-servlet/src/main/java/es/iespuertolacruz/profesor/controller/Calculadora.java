package es.iespuertolacruz.profesor.controller;

import javax.servlet.*;
import java.io.IOException;
import java.io.PrintWriter;

public class Calculadora implements Servlet {

    private ServletConfig servletConfig;

    @Override
    /**
     * Metodo que inicializa el servlet calculadora
     */
    public void init(ServletConfig servletConfig) throws ServletException {
       if (servletConfig != null) {
           this.servletConfig = servletConfig;
       } else {
           throw new ServletException("Se ha producido un error inicializando el servlet");
       }
    }

    @Override
    public ServletConfig getServletConfig() {
        return servletConfig;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        servletResponse.setContentType( "text/html" );
        PrintWriter out = servletResponse.getWriter();
        out.println( "<html><head>" );
        out.println( "<title>A Sample Servlet!</title>" );
        out.println( "</head>" );
        out.println( "<body>" );
        out.println( "<h1>Hello, World!</h1>" );
        out.println( "</body></html>" );
        out.close();
    }

    @Override
    public String getServletInfo() {
        if (servletConfig != null) {
            return "Servicio Calculadora funcionando";
        } else {
            return "Servicio Calculadora NO se ha iniciado correctamente";
        }
    }

    @Override
    public void destroy() { }
}
