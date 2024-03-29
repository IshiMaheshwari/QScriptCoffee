package com.coffee.shop.contact.dl;
public class ContactDTO implements java.io.Serializable,Comparable<ContactDTO>
{
private String name;
private String email;
private String message;
public ContactDTO()
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
if(!(object instanceof ContactDTO)) return false;
ContactDTO other=(ContactDTO)object;
return this.name.equals(other.name);
}
public int compareTo(ContactDTO other)
{
return this.name.compareToIgnoreCase(other.name);
}
public int hashName()
{
return name.hashCode();
}
}