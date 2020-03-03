<%@ page import="pachet.UtilizatorService"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body>
<center>
    <form action="Login.jsp" method="post">
    <table border="0">
    <tbody>
    <tr>
        <td>Nume:</td>
        <td><input type="text" name="nume2" value="" size="30" /></td>
    </tr>
    <tr>
        <td>Prenume:</td>
        <td><input type="text" name="prenume2" value="" size="30" /></td>
    </tr>
    <tr>
        <td>Parola:</td>
        <td><input type="password" name="parola2" value="" size="30" /></td>
    </tr>
    </table>
    <input type="submit" value="Login" name="logare2">
    </form>
        <%
        if(request.getParameter("logare2")!=null) {
            String nume = request.getParameter("nume2");
            if (nume == "") {
                out.println("Completati numele");
                return;
            }

            String prenume = request.getParameter("prenume2");
            if (prenume == "") {
                out.println("Completati prenumele");
                return;
            }

            String parola = request.getParameter("parola2");
            if (parola == "") {
                out.println("Completati parola");
                return;
            }

            UtilizatorService ut=new UtilizatorService();

            String numeCautat=ut.cautaNumeUtilizator(nume);
            if(numeCautat==null){
                out.println("Nume gresit");
                return;
            }

            String prenumeCautat=ut.cautaPrenume(prenume);
            if(prenumeCautat==null){
                out.println("Prenume gresit");
                return;
            }

            String parolaCautata=ut.cautaParola(parola);
            if(parolaCautata==null){
                out.println("Parola gresita");
                return;
            }

            if(numeCautat.equals("Popescu") && prenumeCautat.equals("Ion") && parolaCautata.equals("aaa")){
                %>
                <form action="OptiuniAdmin.jsp" method="post">
                    <input type="submit" value="Pagina admin" name="pagina2">
                </form>
                <%
                }

            if(numeCautat.equals(nume) && prenumeCautat.equals(prenume) && parolaCautata.equals(parola)){
                %>
                <form action="OptiuniUser.jsp" method="post">
                <input type="submit" value="Pagina user" name="optuser">
                </form>
                <%
            }

            out.println("Salut, " +prenume+ "!");
        }
%>

</center>
</body>
</html>
