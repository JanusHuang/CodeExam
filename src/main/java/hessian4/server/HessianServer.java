package hessian4.server;

import com.caucho.hessian.server.HessianServlet;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

/**
 * @author zhijing.huang
 *         Created by zhijing.huang on 2014/9/9.
 */
public class HessianServer {
    private void startHttpServer() {
        ServletContextHandler contextHandler = new ServletContextHandler(ServletContextHandler.SESSIONS);
        contextHandler.setContextPath("/HessianServer");
        final ServletHolder helloServletHolder = new ServletHolder(new HessianServlet());
        helloServletHolder.setInitParameter("service-class", HelloImpl.class.getName());
        contextHandler.addServlet(helloServletHolder, "/hessian");

        try {
            Server server = new Server(8080);
            server.setHandler(contextHandler);
            server.start();
            server.join();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        HessianServer server = new HessianServer();
        server.startHttpServer();
    }
}
