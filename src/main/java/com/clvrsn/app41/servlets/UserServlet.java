package com.clvrsn.app41.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.clvrsn.app41.dao.UserDAO;
import com.clvrsn.app41.dao.impl.UserDAOImpl;
import com.clvrsn.app41.entities.User;

@WebServlet(value = "/user", loadOnStartup = 1)
public class UserServlet extends HttpServlet {

	private static final long serialVersionUID = -36138938542088506L;

	private UserDAO userDao;

	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		ServletContext context = config.getServletContext();
		ApplicationContext ctx = WebApplicationContextUtils.getRequiredWebApplicationContext(context);
		userDao = ctx.getBean(UserDAOImpl.class);
	}

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String id = request.getParameter("id");

		PrintWriter out = response.getWriter();
		if (id == null) {
			out.println("Por favor, informe um Id (Exemplo: /app41/user?id=1)");
			return;
		}
		User u = userDao.findById(Integer.valueOf(id));
		out.println("Ola: " + u.getName());

	}

	public UserDAO getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDAO userDao) {
		this.userDao = userDao;
	}

}
