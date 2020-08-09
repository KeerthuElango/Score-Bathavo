<%@page import="com.example.myapp.modal.Score"%> 
<%@page import="java.util.ArrayList"%> 
<!DOCTYPE html> 
<html> 
  <head> 
   <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"> 
   <title>Score List</title> 
  </head> 
  <body> 
      <h1>LIVE SCORES</h1> 
      <table border ="1" width="1500" align="center"> 
         <tr bgcolor="00FF7F"> 
          <th><b>Match ID</b></th> 
          <th><b>Date</b></th> 
          <th><b>Team1</b></th> 
          <th><b>Team2</b></th> 
          <th><b>Match Type</b></th> 
          <th><b>Match Started</b></th> 
          <th><b>Live Score</b></th> 
          <th><b>Details</b></th> 
         </tr> 
        <%-- Fetching the attributes of the request object 
             which was previously set by the servlet  
              "StudentServlet.java" 
        --%>  
        <div class="bg-login">
        <%ArrayList<Score> sch =  
            (ArrayList<Score>)request.getAttribute("matches"); 
        for(Score s:sch){%> 
        <%-- Arranging data in tabular form 
        --%> 
            <tr> 
                <td><%=s.getUnique_id()%></td> 
                <td><%=s.getDate()%></td> 
                <td><%=s.getTeam1()%></td> 
                <td><%=s.getTeam2()%></td> 
                <td><%=s.getMatchType()%></td> 
                <td><%=s.getMatchStarted()%></td> 
                <td><%=s.getScore()%></td> 
                <td><%=s.getStat()%></td> 
            </tr> 
            <%}%> 
            </div>
        </table>  
        <hr/> 
    </body> 
</html>