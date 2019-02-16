package com.revature;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

public class TodoServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private final ObjectMapper mapper = new ObjectMapper();
	private final List<Todo> todos = new ArrayList<>();
       
    public TodoServlet() {
        super();
        for (int i = 1; i < 21; i++) 
        	todos.add(new Todo("Title: " + i, "Body: " + i));
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/json");
		response.getWriter().println(mapper.writeValueAsString(todos));
	}

	public static class Todo {
		private String title;
		private String body;
		
		public Todo() {}

		public Todo(String title, String body) {
			super();
			this.title = title;
			this.body = body;
		}

		public String getTitle() {
			return title;
		}

		public void setTitle(String title) {
			this.title = title;
		}

		public String getBody() {
			return body;
		}

		public void setBody(String body) {
			this.body = body;
		}
		
		
	}
}
