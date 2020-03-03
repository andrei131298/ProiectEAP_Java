<%@ page import="pachet.CategorieService"%>
<%@ page import="pachet.AlimentService" %>
<%@ page import="pachet.Aliment" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body>
<center>
    <form action="insertAliment.jsp" method="post"/>
    <table border="0">
    <tbody>
<tr>
    <td>Categorie de aliment:</td>
    <td><input type="text" name="denumire2" value="" size="30" /></td>
</tr>
<tr>
    <td>Nume aliment:</td>
    <td><input type="text" name="numeAl" value="" size="30" /></td>
</tr>
<tr>
    <td>Descriere aliment:</td>
    <td><input type="text" name="desc" value="" size="30" /></td>
</tr>
<tr>
    <td>Numarul de calorii al alimentului:</td>
    <td><input type="text" name="nrcal" value="" size="30" /></td>
</tr>
</tbody>
</table>
    <input type="submit" value="Insereaza aliment" name="insert2">

<%
    if(request.getParameter("insert2")!=null){
        int nNrCalorii=0;
        CategorieService cs=new CategorieService();
        AlimentService as=new AlimentService();

        String denumireCateg = request.getParameter("denumire2");

        String numeAlim=request.getParameter("numeAl");
        if (numeAlim == "") {
            out.println("Completati numele alimentului");
            return;
        }

        String descriere=request.getParameter("desc");
        if (descriere == "") {
            out.println("Completati descrierea");
            return;
        }

        String nrCalorii=request.getParameter("nrcal");
        if (nrCalorii == "") {
            out.println("Completati numarul de calorii");
            return;
        }
        nNrCalorii = Integer.parseInt(nrCalorii);

        int IdCateg= cs.cautaIdCategorie(denumireCateg);

        String numeAlimCautat=as.cautaNumeAliment(numeAlim);
        if(numeAlimCautat==null){
            Aliment alim=new Aliment(1,numeAlim,descriere, nNrCalorii,IdCateg);
            as.insertAliment(alim);
        }
        else {
            out.println("Alimentul deja exista");
            return;
        }
        out.println("Inserare cu succes");
    }
%>
</center>
</body>
</html>
