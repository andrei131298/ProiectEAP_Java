<%@ page import="pachet.CategorieService"%>
<%@ page import="pachet.Categorie" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body>
<center>
    <form action="insertCateg.jsp" method="post"/>
        Denumire categorie:<input type="text" name="denumire" value="" size="30" />
        <input type="submit" value="Insereaza categorie" name="insert">
<%
        if(request.getParameter("insert")!=null) {
            String denumire = request.getParameter("denumire");
            if (denumire == "")
            {
                out.println("Completati denumirea categoriei");
                return;
            }

            CategorieService cs=new CategorieService();

            String denumireCautata=cs.cautaCategorie(denumire);
            if(denumireCautata==null)
            {
                Categorie categ=new Categorie(1,denumire);
                cs.insertCategorie(categ);
            }
            else {
                out.println("Categoria deja exista");
                return;
            }
            out.println("Inserare cu succes");
        }
%>
</center>
</body>
</html>
