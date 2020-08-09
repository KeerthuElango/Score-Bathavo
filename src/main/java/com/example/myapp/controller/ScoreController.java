package com.example.myapp.controller;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;

import javax.servlet.http.HttpServletRequest;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.myapp.modal.Score;


@Controller
public class ScoreController 
{
	public static String passUniqueId(int i,long id)
	{
		try
		{
			URL url = new URL("http://cricapi.com/api/cricketScore?apikey=WHZybJYEPzgyc67Hqvd4Y4Anpkq1&unique_id="+id);
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
				final JSONObject data = new JSONObject(inline);
				if(i==1)
				{
					String str1 = (String) data.get("score"); 
					return str1;
				}
				if(i==2)
				{
					String str2 =  (String) data.get("stat"); 
					return str2;
				}
			}
		} 
		catch (Exception e) 
		{
			System.out.println(e);
		}
		return null;
	}
	@RequestMapping("/live-score")
	public String schedule(HttpServletRequest request) throws IOException
	{
		try
		{
			URL url = new URL("http://cricapi.com/api/matches?apikey=Niy8bXpjpQey2TnNXzevr1TgnLA3");
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
				String str1="";
				String str2="";
				final JSONObject obj = new JSONObject(inline);
			    final JSONArray data = obj.getJSONArray("matches");
			    final int n = data.length();
			    ArrayList<Score> sch = new ArrayList<Score>(); 
			    for (int i = 0; i < n; ++i) 
			    {
			      final JSONObject person = data.getJSONObject(i);
			      if(person.getBoolean("matchStarted")) 
			      {
			      str1=passUniqueId(1,person.getLong("unique_id"));
			      str2=passUniqueId(2,person.getLong("unique_id"));
			      }
			      else
			      {
			    	  str1="";
			    	  str2="";
			      }
			      sch.add(new Score(person.getLong("unique_id"), person.getString("date"),person.getString("team-1"),person.getString("team-2"), person.getBoolean("matchStarted"), person.getString("type"), str1, str2));
			      
			      //System.out.println(person.getLong("unique_id"));
			    }
			    request.setAttribute("matches", sch);
			}
		} 
		catch (MalformedURLException e) 
		{
			System.out.println("catch block of url executed");
		}
		return "scorepage";
	}

}
	