package com.coffee.shop.contact.servlets;
import com.coffee.shop.contact.dl.*;
import com.coffee.shop.contact.beans.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class Contact extends HttpServlet
{
public void doGet(HttpServletRequest request,HttpServletResponse response)
{
doPost(request,response);
}
public void doPost(HttpServletRequest request,HttpServletResponse response)
{
try
{
ContactBean contactBean;
contactBean=(ContactBean)request.getAttribute("contactBean");
if(contactBean==null)
{
RequestDispatcher requestDispatcher;
requestDispatcher=request.getRequestDispatcher("/ContactForm.jsp");
requestDispatcher.forward(request,response);
return;
}
String name=contactBean.getName();
String email=contactBean.getEmail();
String message=contactBean.getMessage();
ContactDAO contactDAO=new ContactDAO();
try
{
ContactDTO contact=contactDAO.getByName(name);
if(message.equals(contact.getMessage())==false)
{
ErrorBean errorBean;
errorBean=new ErrorBean();
errorBean.setError("Invalid name/message");
request.setAttribute("errorBean",errorBean);
RequestDispatcher requestDispatcher;
requestDispatcher=request.getRequestDispatcher("/ContactForm.jsp");
requestDispatcher.forward(request,response);
return;
}
HttpSession session=request.getSession();
session.setAttribute("name",name);
RequestDispatcher requestDispatcher;
requestDispatcher=request.getRequestDispatcher("/index.jsp");
requestDispatcher.forward(request,response);
}catch(DAOException daoException)
{
ErrorBean errorBean;
errorBean=new ErrorBean();
errorBean.setError("Invalid name/message");
request.setAttribute("errorBean",errorBean);
RequestDispatcher requestDispatcher;
requestDispatcher=request.getRequestDispatcher("/ContactForm.jsp");
requestDispatcher.forward(request,response);
}
}catch(Exception exception)
{
RequestDispatcher requestDispatcher;
requestDispatcher=request.getRequestDispatcher("/ErrorPage.jsp");
try
{
requestDispatcher.forward(request,response);
}catch(Exception e)
{
//do nothing
}
}
}
}