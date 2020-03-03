<%@ page import="pachet.Utilizator,pachet.UtilizatorService"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<body>

<form action="index.jsp" method="post">
<center>
  <table border="0">
    <tbody>
    <tr>
      <td>Nume:</td>
      <td><input type="text" name="nume" value="" size="30" /></td>
    </tr>
    <tr>
      <td>Prenume:</td>
      <td><input type="text" name="prenume" value="" size="30" /></td>
    </tr>
    <tr>
      <td>Varsta:</td>
      <td><input type="text" name="varsta" value="" size="30" /></td>
    </tr>
    <tr>
      <td>Sex:</td>
      <td><input type="text" name="sex" value="" size="30" /></td>
    </tr>
    <tr>
      <td>Inaltime:</td>
      <td><input type="text" name="inaltime" value="" size="30" /></td>
    </tr>
    <tr>
      <td>Greutate:</td>
      <td><input type="text" name="greutate" value="" size="30" /></td>
    </tr>
    <tr>
      <td>Email:</td>
      <td><input type="text" name="email" value="" size="30" /></td>
    </tr>
    <tr>
      <td>Parola:</td>
      <td><input type="password" name="parola" value="" size="30" /></td>
    </tr>
    </tbody>
  </table>
  <input type="submit" value="Inregistrare" name="buton">
  <%
    if(request.getParameter("buton")!=null) {
      int nInaltime = 0;
      int nVarsta=0;
      int nGreutate=0;

      String nume = request.getParameter("nume");
//      String curent = (String) session.getAttribute("nume");
//      out.println(curent);
      if (nume == "") {
        out.println("Completati numele");
        return;
      }

      String prenume = request.getParameter("prenume");
      if (prenume == "") {
        out.println("Completati prenumele");
        return;
      }

      String varsta = request.getParameter("varsta");
      if (varsta == "") {
        out.println("Completati varsta");
        return;
      }
      nVarsta = Integer.parseInt(varsta);

      String sex = request.getParameter("sex");
      if (sex == "") {
        out.println("Completati sexul");
        return;
      }

      String inaltime = request.getParameter("inaltime");
      if (inaltime == "") {
        out.println("Completati inaltimea");
        return;
      }
      nInaltime = Integer.parseInt(inaltime);

      String greutate = request.getParameter("greutate");
      if (greutate == "") {
        out.println("Completati greutatea");
        return;
      }
      nGreutate = Integer.parseInt(greutate);

      String email = request.getParameter("email");
      if (email == "") {
        out.println("Completati emailul");
        return;
      }

      String parola = request.getParameter("parola");
      if (parola == "") {
        out.println("Completati parola");
        return;
      }

      UtilizatorService ut=new UtilizatorService();
      if(ut.cautaNumeUtilizator(nume).equals(nume) && ut.cautaPrenume(prenume).equals(prenume) && ut.cautaParola(parola).equals(parola)){
        out.println("Utilizatorul deja exista");
        return;
      }

      Utilizator u=new Utilizator(1,"user",nume,prenume,sex,nInaltime, nGreutate, parola, 0,nVarsta,email);
      ut.insertUtilizator(u);
      out.println("Inregistrare cu succes");



%>
  </form>
  <form action="OptiuniUser.jsp" method="post">
  <input type="submit" value="Pagina user" name="optuser1">
<%
  }
%>
</form>
<form action="Login.jsp" method="post">
<input type="submit" value="Vrei sa te loghezi?" name="logare">

</center>
  </form>
</body>
</html>