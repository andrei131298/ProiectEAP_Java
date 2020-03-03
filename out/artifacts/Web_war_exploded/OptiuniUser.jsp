<%@ page import="pachet.AlimentService" %>
<%@ page import="pachet.Utilizator" %>
<%@ page import="pachet.UtilizatorService" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body>
<center>
    <form action="OptiuniUser.jsp" method="post"/>
    <table border="0">
        <tbody>
        <tr>
            <td>Cauta denumire aliment:</td>
            <td><input type="text" name="denumireAlim" value="" size="30" /></td>
        </tr>
        <tr>
            <td>Cauta descriere aliment:</td>
            <td><input type="text" name="descAlim" value="" size="30" /></td>
        </tr>
        <tr>
            <td>Cauta sub un numar de calorii</td>
            <td><input type="text" name="subNrCal" value="" size="30" /></td>
        </tr>
        <tr>
            <td>Cauta peste un numar de calorii:</td>
            <td><input type="text" name="PesteNrCal" value="" size="30" /></td>
        </tr>
        <tr>
            <td>Seteaza o limita de calorii:</td>
            <td><input type="text" name="limitaCal" value="" size="30" /></td>
        </tr>
        </tbody>
    </table>
    <input type="submit" value="Cauta" name="cautare">
<%
    if(request.getParameter("cautare")!=null){
        AlimentService aServ=new AlimentService();
        String denumireAlim = request.getParameter("denumireAlim");
        String descAlim = request.getParameter("descAlim");
        String subNrCal=request.getParameter("subNrCal");
        String pesteNrCal=request.getParameter("PesteNrCal");
        String limitaCal=request.getParameter("limitaCal");
        if(denumireAlim!="") {
            String denumireAlimCautat = aServ.cautaNumeAliment(denumireAlim);
            out.println(aServ.afiseazaAliment(denumireAlimCautat));
            int id=aServ.cautaIdAliment(denumireAlimCautat);
            if(id!=0){
            %>
            <img src="<%out.println(aServ.cautaPoza(id));%>.jpg" >
            <%
            }
        }
        else if(descAlim!=""){
                String descAlimCautat=aServ.cautaDescriere(descAlim);
                out.println(aServ.afiseazaAlimentDupaDesc(descAlimCautat));
                int id=aServ.cautaIdAlimentDupaDesc(descAlimCautat);
                if(id!=0){
                    %>
                    <img src="<%out.println(aServ.cautaPoza(id));%>.jpg" >
                    <%
                }

        }
        else if(subNrCal!=""){
                int nSubNrCal=Integer.parseInt(subNrCal);
                int nSubNrCalCautat=aServ.cautaSubNrCalorii(nSubNrCal);
                out.println(aServ.afiseazaAlimentDupaNrCaloriiSub(nSubNrCalCautat));
                int id=aServ.cautaIdAlimentDupaNrSub(nSubNrCalCautat);
                if(id!=0){
                    %>
                    <img src="<%out.println(aServ.cautaPoza(id));%>.jpg" >
                    <%
                }
        }
        else if(pesteNrCal!=""){
            int nPesteNrCal=Integer.parseInt(pesteNrCal);
            int nPesteNrCalCautat=aServ.cautaPesteNrCalorii(nPesteNrCal);
            out.println(aServ.afiseazaAlimentDupaNrCaloriiPeste(nPesteNrCalCautat));
            int id=aServ.cautaIdAlimentDupaNrPeste(nPesteNrCalCautat);
            if(id!=0){
                %>
                <img src="<%out.println(aServ.cautaPoza(id));%>.jpg" >
                <%
            }

       }

//        else if(limitaCal!=""){
//            int nLimitaCal=Integer.parseInt(limitaCal);
//            UtilizatorService ut=new UtilizatorService();
//            ut.setLimitaCalorii(nume,limitaCal);
//            }
        else{
            out.println("completati criteriu");
        }

    }

%>


</center>
</body>
</html>
