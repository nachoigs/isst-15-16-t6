package es.upm.dit.isst.tfg;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.*;

import com.google.appengine.api.users.*;

import es.upm.dit.isst.tfg.dao.*;
import es.upm.dit.isst.tfg.model.*;

@SuppressWarnings("serial")
public class Es_upm_dit_isst_tfgServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException{
		UserService userService = UserServiceFactory.getUserService();
        String url = userService.createLoginURL(req.getRequestURI());
        String urlLinktext = "Login";
        String user = "";
        if (req.getUserPrincipal() != null){
            user = req.getUserPrincipal().getName();
            url = userService.createLogoutURL(req.getRequestURI());
            urlLinktext = "Logout";
        }
      
        
        req.getSession().setAttribute("user", user);
        req.getSession().setAttribute("url", url);
        req.getSession().setAttribute("urlLinktext", urlLinktext);
        
        List<TFG> tfgs = TFGDAOImpl.getInstance().getAllTfg();
        
        req.getSession().setAttribute("tfgs", new ArrayList<TFG>(tfgs));
        
        
        resp.sendRedirect("/View_tfg.jsp");

	}

}
