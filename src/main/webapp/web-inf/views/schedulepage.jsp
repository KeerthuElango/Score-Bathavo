<%@page import="com.example.myapp.modal.Schedule"%> 
<%@page import="java.util.ArrayList"%> 
<!DOCTYPE html> 
<html> 
  <head> 
   <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"> 
   <title>Schedule List</title> 
  </head> 
  <body> 
      <h1>MATCH SCEDULE</h1> 
      <table border ="1" width="1000" align="center"> 
         <tr bgcolor="00FF7F"> 
          <th><b>Match ID</b></th> 
          <th><b>Match Name</b></th> 
          <th><b>Date</b></th> 
         </tr> 
        <%-- Fetching the attributes of the request object 
             which was previously set by the servlet  
              "StudentServlet.java" 
        --%>  
        <%ArrayList<Schedule> sch =  
            (ArrayList<Schedule>)request.getAttribute("data"); 
        for(Schedule s:sch){%> 
        <%-- Arranging data in tabular form 
        --%> 
            <tr> 
                <td><%=s.getUnique_id()%></td> 
                <td><%=s.getName()%></td> 
                <td><%=s.getDate()%></td> 
            </tr> 
            <%}%> 
        </table>  
        <hr/> 
    </body> 
</html> 