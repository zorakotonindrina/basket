<%@ page import ="java.util.*" %>
<%@ page import ="java.lang.*" %>
<%@ page import ="tabs.*" %>
<%@ page import ="connect.*" %>
<%@ page import ="java.lang.reflect.*" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Statistiques</title>
	<link href="index.css" rel="stylesheet" />
</head>
<body>
    <h1>STATISTIQUES</h1>
    <%
        try
        {
            Connexion con=new Connexion();
            Match m=new Match(1);
            m=(Match)m.selectMe(con, "id_Match");
            Team equipe1=new Team(m.getId_Team1());
            equipe1=(Team)equipe1.selectMe(con, "id_Team");
            Team equipe2=new Team(m.getId_Team2());
            equipe2=(Team)equipe2.selectMe(con,"id_Team");
            Gameur[] gam1=equipe1.getMyGameurs(con);
            Gameur[] gam2=equipe2.getMyGameurs(con);
            
    %>
    <div class="equip1">
        <h2><% out.println(equipe1.getNom_Team()); %></h2>
        <p><% out.println(equipe1.getPoints(con)); %></p>
        <div class="tt">
            <table width="400" border="0">
                <tr>
                    <th width="100">Nom</th>
                    <th> Points</th>
                    <th> Tentatives </th>
                    <th> R0 </th>
                    <th> RD </th>
                    <th> PD </th>
                </tr>
                 <% for(int i=0; i<5; i++) { %>
                    <tr>
                        <td width="100"><% out.println(gam1[i].getNom());%></td>
                        <td><% out.println(gam1[i].getPoints(con,"T"));%></td>
                        <td> <% out.println(gam1[i].getTentativeOk(con,"T") +"/"+gam1[i].getTentative(con,"T"));%> </td>
                        <td> <% out.println(gam1[i].getTentativeNull(con,"R")); %></td> 
                        <td> <% out.println(gam1[i].getTentativeOk(con,"R")); %> </td>
                        <td> <% out.println(gam1[i].getTentativeOk(con,"P")); %> </td>
                    </tr>
                   <%
                   }
                   %>
               
            </table>
        </div>
    </div>
    <div class="equip2">
        <h2><% out.println(equipe2.getNom_Team());%></h2>
        <p><% out.println(equipe2.getPoints(con));%></p>
        <div class="tt">
            <table width="400" border="0">
                <tr>
                    <th width="130">Nom</th>
                    <th> Points</th>
                    <th> Tentatives </th>
                    <th> R0 </th>
                    <th> RD </th>
                    <th> PD </th>
                </tr>
                 <% for(int i=0; i<5; i++) { %>
                    <tr>
                        <td width="130"><% out.println(gam2[i].getNom());%></td>
                        <td><% out.println(gam2[i].getPoints(con,"T"));%></td>
                        <td> <% out.println(gam2[i].getTentativeOk(con,"T") +"/"+gam2[i].getTentative(con,"T"));%> </td>
                        <td> <% out.println(gam2[i].getTentativeNull(con,"R")); %></td> 
                        <td> <% out.println(gam2[i].getTentativeOk(con,"R")); %> </td>
                        <td> <% out.println(gam2[i].getTentativeOk(con,"P")); %> </td>
                    </tr>
                   <%
                   }
                   %>
               
            </table>
        </div>

    </div>

    <% } catch(Exception e)
        {  
            e.printStackTrace();
        } %>
   
</body>
</html>