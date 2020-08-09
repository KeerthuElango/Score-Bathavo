package com.example.myapp.controller;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
//import java.io.Exception;
import java.net.URL;
import java.util.ArrayList;
//import java.util.Iterator;
import java.util.Scanner;

import javax.servlet.http.HttpServletRequest;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.example.myapp.modal.User;
import com.example.myapp.modal.Schedule;
import com.example.myapp.services.UserService;

//import jdk.nashorn.internal.parser.JSONParser;


@Controller
public class ApplicationController {

	@Autowired
	UserService userService;

	@RequestMapping("/welcome")
	public String Welcome(HttpServletRequest request) {
		request.setAttribute("mode", "MODE_HOME");
		return "welcomepage";
	}

	@RequestMapping("/register")
	public String registration(HttpServletRequest request) {
		request.setAttribute("mode", "MODE_REGISTER");
		return "welcomepage";
	}

	@PostMapping("/save-user")
	public String registerUser(@ModelAttribute User user, BindingResult bindingResult, HttpServletRequest request) {
		userService.saveMyUser(user);
		request.setAttribute("mode", "MODE_HOME");
		return "welcomepage";
	}

	@PostMapping("/show-users")
	public String showAllUsers(@ModelAttribute User user,HttpServletRequest request) {
		if(userService.findByAUsernameAndPassword(user.getUsername(), user.getPassword())) {
				request.setAttribute("users", userService.showAllUsers());
				request.setAttribute("mode", "ALL_USERS");
				return "welcomepage";
			}
			else {
				request.setAttribute("error", "You are not an admin");
				request.setAttribute("mode", "MODE_LOGINADMIN");
				return "welcomepage";
				
			}
		
	}

	@RequestMapping("/delete-user")
	public String deleteUser(@RequestParam int id, HttpServletRequest request) {
		userService.deleteMyUser(id);
		request.setAttribute("users", userService.showAllUsers());
		request.setAttribute("mode", "ALL_USERS");
		return "welcomepage";
	}
	
	@RequestMapping("/edit-user")
	public String editUser(@RequestParam int id,HttpServletRequest request) {
		request.setAttribute("user", userService.editUser(id));
		request.setAttribute("mode", "MODE_UPDATE");
		return "welcomepage";
	}
	
	@RequestMapping("/login")
	public String login(HttpServletRequest request) {
		request.setAttribute("mode", "MODE_LOGIN");
		return "welcomepage";
	}
	
	@RequestMapping ("/login-user")
	public String loginUser(@ModelAttribute User user, HttpServletRequest request) {
		if(userService.findByUsernameAndPassword(user.getUsername(), user.getPassword())!=null) {
			return "homepage";
		}
		else {
			request.setAttribute("error", "Invalid Username or Password");
			request.setAttribute("mode", "MODE_LOGIN");
			return "welcomepage";
			
		}
	}
	@RequestMapping("/admin")
	public String loginadmin(HttpServletRequest request) {
		request.setAttribute("mode", "MODE_LOGINADMIN");
		return "welcomepage";
	}
	
	/*@RequestMapping("/live-score")
	public String score(HttpServletRequest request) {
		request.setAttribute("mode", "MODE_LIVESCORE");
		return "welcomepage";
	}*/
	
	@RequestMapping("/schedule")
	public String schedule(HttpServletRequest request) throws IOException {
		try
		{
			URL url = new URL("https://cricapi.com/api/matchCalendar?apikey=Niy8bXpjpQey2TnNXzevr1TgnLA3");
			HttpURLConnection conn = (HttpURLConnection)url.openConnection();
			conn.setRequestMethod("GET");
			conn.connect();
			int responsecode = conn.getResponseCode();
			if(responsecode!=200)
				throw new RuntimeException("HttpResponseCode:"+responsecode);
			else
			{
				Scanner sc = new Scanner(url.openStream());
				String inline="";
				while(sc.hasNext())
				{
					inline+=sc.nextLine();
				}
				//System.out.println(inline);
				//c.close();
				//Object obj = new JSONParser(inline, null, false).parse();  
		        //JSONObject jo = (JSONObject) obj; 
		        //JSONArray ja = (JSONArray) jo.get("data");  
		        //System.out.println(ja);
				final JSONObject obj = new JSONObject(inline);
			    final JSONArray data = obj.getJSONArray("data");
			    final int n = data.length();
			    ArrayList<Schedule> sch = new ArrayList<Schedule>(); 
			    for (int i = 0; i < n; ++i) {
			      final JSONObject person = data.getJSONObject(i);
			      sch.add(new Schedule(person.getString("unique_id"), person.getString("name"), person.getString("date")));
			      //request.setAttribute("rest", person.getString("unique_id"));
			      //System.out.println(person.getString("unique_id"));
			      //System.out.println(person.getString("name"));
			      //System.out.println(person.getString("date"));
			    }
			    request.setAttribute("data", sch);
			}
		} 
		catch (MalformedURLException e) 
		{
			System.out.println("catch block of url executed");
		}
		return "schedulepage";
	}

}
