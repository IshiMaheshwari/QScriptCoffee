package com.coffee.shop.contact.beans;
public class ContactBean implements java.io.Serializable,Comparable<ContactBean>
{
private String name;
private String email;
private String message;
public ContactBean()
{ 
this.name="";
this.email="";
this.message="";
}
public void setName(String name)
{ 
this.name=name;
}
public String getName()
{
return this.name;
}
public void setEmail(String email)
{ 
this.email=email;
}
public String getEmail()
{
return this.email;
}
public void setMessage(String message)
{ 
this.message=message;
}
public String getMessage()
{
return this.message;
}
public boolean equals(Object object)
{ 
if(!(object instanceof ContactBean)) return false;
ContactBean other=(ContactBean)object;
return this.name.equals(other.name);
}
public int compareTo(ContactBean other)
{
return this.name.compareToIgnoreCase(other.name);
}
public int hashName()
{
return name.hashCode();
}
}