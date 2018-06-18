/**
 * 
 */
package com.hemant_bhilwadikar.Customer;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.core.MediaType;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.hemant_bhilwadikar.Customer.*;

/**
 * @author Hemant
 *
 */
public class CustomerServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String actionName = request.getParameter("actionName") ;
		try {
			
			Client client = Client.create();
			WebResource webResource = null;
			ClientResponse clientResp = null;

			if (actionName == null || actionName.equals("")) {
			webResource = client
			   .resource("http://localhost:8080/CustomerREST/api/cust/verify");

			clientResp = webResource.accept(MediaType.TEXT_PLAIN)
	                   .get(ClientResponse.class);

			if (clientResp.getStatus() != 200) {
			   throw new RuntimeException("Failed : HTTP error code : "
				+ clientResp.getStatus());
			}

			String output = clientResp.getEntity(String.class) + clientResp.getStatus();
			
			System.out.println("Output from Server .... \n");
			System.out.println(output);
			request.getSession().setAttribute("StartMsg", output);

			webResource = client
					   .resource("http://localhost:8080/CustomerREST/api/cust/get");

			clientResp = webResource.accept(MediaType.APPLICATION_JSON)
			                   .get(ClientResponse.class);

					if (clientResp.getStatus() != 200) {
					   throw new RuntimeException("Failed : HTTP error code : "
						+ clientResp.getStatus());
					}

			String customerListJSON = clientResp.getEntity(String.class);
					
					System.out.println("Customer List JSON Output from Server .... \n");
					System.out.println(customerListJSON);
					request.getSession().setAttribute("CustListJson", output);
			
			
			PrintWriter out = response.getWriter();
	        out.println ( CustomerHTML.getCustomerHTML(output, customerListJSON)
	                );	        
			}
			  else if (actionName.equals("add")) {
					String firstName = request.getParameter("firstName");
					String surName = request.getParameter("surName");
					
					webResource = client
							   .resource("http://localhost:8080/CustomerREST/api/cust/add/"+firstName+"/"+surName);

					clientResp = webResource.accept(MediaType.TEXT_PLAIN)
					                   .get(ClientResponse.class);

							if (clientResp.getStatus() != 200) {
							   throw new RuntimeException("Failed : HTTP error code : "
								+ clientResp.getStatus());
							}

					String insertMessage = clientResp.getEntity(String.class);

					webResource = client
							   .resource("http://localhost:8080/CustomerREST/api/cust/get");
					clientResp = webResource.accept(MediaType.APPLICATION_JSON)
					                   .get(ClientResponse.class);

							if (clientResp.getStatus() != 200) {
							   throw new RuntimeException("Failed : HTTP error code : "
								+ clientResp.getStatus());
							}
							String customerListJSON = clientResp.getEntity(String.class);
					
					
							System.out.println("Customer List JSON Output from Server .... \n");
							System.out.println(customerListJSON);
					
					
					PrintWriter out = response.getWriter();
			        out.println (CustomerHTML.getCustomerHTML(insertMessage, customerListJSON));
					
				}
				  else if (actionName.equals("del")) {
						String id = request.getParameter("id");
						
						webResource = client
								   .resource("http://localhost:8080/CustomerREST/api/cust/del/"+id+"/");

						clientResp = webResource.accept(MediaType.TEXT_PLAIN)
						                   .get(ClientResponse.class);

								if (clientResp.getStatus() != 200) {
								   throw new RuntimeException("Failed : HTTP error code : "
									+ clientResp.getStatus());
								}

						String deleteMessage = clientResp.getEntity(String.class);

						webResource = client
								   .resource("http://localhost:8080/CustomerREST/api/cust/get");
						clientResp = webResource.accept(MediaType.APPLICATION_JSON)
						                   .get(ClientResponse.class);

								if (clientResp.getStatus() != 200) {
								   throw new RuntimeException("Failed : HTTP error code : "
									+ clientResp.getStatus());
								}
								String customerListJSON = clientResp.getEntity(String.class);
						
						
								System.out.println("Customer List JSON Output from Server .... \n");
								System.out.println(customerListJSON);
						
						
						PrintWriter out = response.getWriter();
				        out.println (CustomerHTML.getCustomerHTML(deleteMessage, customerListJSON));
						
					}
				  
			
		  } catch (Exception e) {
			  
			e.printStackTrace();

		  }		

		
		//getServletContext().getRequestDispatcher("manage").forward(request, response);
		
	
	
	}
	
}
