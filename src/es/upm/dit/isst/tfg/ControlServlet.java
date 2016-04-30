package es.upm.dit.isst.tfg;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.appengine.api.users.UserService;
import com.google.appengine.api.users.UserServiceFactory;

import es.upm.dit.isst.tfg.dao.TFGDAOImpl;

@SuppressWarnings("serial")
public class ControlServlet  extends HttpServlet  {
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException{
		String titulo = req.getParameter("titulo");
		String resumen = req.getParameter("resumen");
		String tutor = req.getParameter("tutor");
		UserService userService = UserServiceFactory.getUserService();
        String autor = "";
        if (req.getUserPrincipal() != null){
        	autor = req.getUserPrincipal().getName();
        }
        
        TFGDAOImpl.getInstance().insertData(autor, titulo, resumen, tutor, "", "", 1);
	}
}
