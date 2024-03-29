package com.coffee.shop.contact.dl;
import java.sql.*;
import java.util.*;
public class ContactDAO
{
public ContactDTO getByName(String name) throws DAOException
{
try
{
Connection connection=DAOConnection.getConnection();
PreparedStatement preparedStatement;
preparedStatement=connection.prepareStatement("select * from contact where name=?");
preparedStatement.setString(1,name);
ResultSet resultSet;
resultSet=preparedStatement.executeQuery();
if(resultSet.next()==false)
{
resultSet.close();
preparedStatement.close();
connection.close();
throw new DAOException("Invalid name : "+name);
}
ContactDTO contact=new ContactDTO();
contact.setName(name);
contact.setEmail(resultSet.getString("email").trim());
contact.setMessage(resultSet.getString("message").trim());
resultSet.close();
preparedStatement.close();
connection.close();
return contact;
}catch(Exception exception)
{
throw new DAOException(exception.getMessage());
}
}
}
