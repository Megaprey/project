<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<%--
    Document   : index
    Author     : nbuser
--%>

<sql:setDataSource var="ADataSource"
        url="jdbc:mysql://localhost:3306/test_v.2" driver="com.mysql.jdbc.Driver" user="root" password=""/>

<sql:query var="subjects" dataSource="${ADataSource}">
    SELECT subject_id FROM Subject </sql:query>


    
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
        
<body>
    <link rel="stylesheet" type="text/css" href="style.css">
    <h2>Добро пожаловать на <strong>САЙТ</strong>, разработанный для проверки этого приложения!
    </h2>
       
    
     <table border="0">
         <tbody>
             <tr>
                <td>Для того чтобы получить данные из таблицы введите интересуемых сталбцов таблицы через запятую без пробелов</td>
             </tr>
             <tr>
                 <td>
                     <form action="SelectServlet" method="GET">
    <p>Введите имя таблицы: <input type="text" name="sTable"></p>
    <p>Введите имена столбцов: <input type="text" name="columnname"></p>
    <input type="submit" value="Отправить" />
</form>
                 </td>
             </tr>    
             
         </tbody>
     </table>

    
    
     <table border="0">
         <tbody>
             <tr>
                <td>Для того чтобы добавить данные в таблицу введите данные через запятую без пробелов</td>
             </tr>
             <tr>
                 <td>
                     <form action="SelectServlet" method="GET">
    <p>Введите имена столбцов таблицы: <input type="text" name="InColumnname"></p>
    <p>Введите имена значений: <input type="text" name="valueColumn"></p>
    <input type="submit" value="Отправить" />
</form>
                 </td>
             </tr>    
             
   </body>
   
   <table border="0">
         <tbody>
             <tr>
                <td>Удаление данных из таблицы. Если вы хотите удалить все данне из таблицы, то в условиях удаления ничего не пишите</td>
             </tr>
             <tr>
                 <td>
                     <form action="SelectServlet" method="GET">
    <p>Имя таблицы: <input type="text" name="delTable"></p>
    <p>Условие удаления: <input type="text" name="condition"></p>
    <input type="submit" value="Отправить" />
                    </form>
                 </td>
             </tr>    
             
   </body>
   