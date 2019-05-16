<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%> 

<!DOCTYPE html>
<html>
<head>
 <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
 <title>Customer List</title>
 <link href="../../webjars/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" />
 <script src="../../webjars/bootstrap/4.0.0/js/bootstrap.min.js"></script>
 <script src="../../webjars/jquery/3.0.0/js/jquery.min.js"></script>
</head>
<body>
 <div class="container">
  <h2>Customer List</h2>
  <table class="table table-striped">
   <thead>
    <th scope="row">#ID</th>
    <th scope="row">Name</th>
    <th scope="row">Address</th>
    <th scope="row">Work</th>
    <th scope="row">Delete</th>
   </thead>
   <tbody>
    <c:forEach items="${customerList }" var="customer" >
     <tr>
      <td>${customer.id }</td>
      <td>${customer.name }</td>
      <td>${customer.address }</td>
      <td>${customer.works }</td>
      <td>
       <spring:url value="/deleteCustomer/${customer.id }" var="deleteURL" />
       <a class="btn btn-primary" href="${deleteURL }" role="button" >Delete</a>
      </td>
     </tr>
    </c:forEach>
   </tbody>
  </table>
  <spring:url value="/addCustomer" var="addURL" />
  <a class="btn btn-primary" href="${addURL }" role="button" >Add New Customer</a>
 </div>
</body>
</html>