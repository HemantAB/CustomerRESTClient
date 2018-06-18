package com.hemant_bhilwadikar.Customer;

public class CustomerHTML {

public static String getCustomerHTML(String insertMsg, String customerListJSON )	
{
	return 
		"<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" +" +
        "http://www.w3.org/TR/html4/loose.dtd\">\n" +
        "<html> \n" +
          "<head> \n" +
            "<meta http-equiv=\"Content-Type\" content=\"text/html; " +
              "charset=ISO-8859-1\"> \n" +
            "<title> Customer Servlet JSP Servlet</title> \n" +
          "</head> \n" +
          "<body> " +
          "<h1> Manage Customers </h1>"
          + "<div align='center'> \n" +
            "<style= \"font-size=\"12px\" color='red'\"" + "\">" +
              "Message: " + insertMsg + " <br> " +
              "Current Customers List: " + customerListJSON + " <br> " +
              "</font></body> \n" +
          "</div>"+
          "<br/>"   +
          "<br/>"+	                    
          "<h1> Add Customer </h1>"+
			"<table>"+
			"<tr>"+
			"<form name=\"/CustomerRESTClient/\" action=\"/CustomerRESTClient/manageClients\">"+
			"<input type=\"hidden\" name=\"actionName\" value=\"add\">"+
			"<td>"+
			"First Name"+
			"</td>"+
			"<td>"+
			"<input type=\"text\" name=\"firstName\">"+
			"</td>"+
			"<td>"+
			"Surname"+
			"</td>"+
			"<td>"+
			"<input type=\"text\" name=\"surName\">"+
			"</td>"+
			"<td><input type=\"submit\" value=\"Add Customer\"> "+ 
			"</tr>"+
			"</form>"+
			"</table>"+
	          "<h1> Delete Customer </h1>"+
				"<table>"+
				"<tr>"+
				"<form name=\"/CustomerRESTClient/\" action=\"/CustomerRESTClient/manageClients\">"+
				"<input type=\"hidden\" name=\"actionName\" value=\"del\">"+
				"<td>"+
				"Customer Id"+
				"</td>"+
				"<td>"+
				"<input type=\"text\" name=\"id\">"+
				"</td>"+
				"<td>"+
				"<input type=\"text\" name=\"surName\">"+
				"</td>"+
				"<td><input type=\"submit\" value=\"Delete Customer\"> "+ 
				"</tr>"+
				"</form>"+
				"</table>"+
              
        "</html>"; 
			
			
	
}
	
	
}
