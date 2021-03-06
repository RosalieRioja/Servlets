<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<script type="text/javascript" src="http://code.jquery.com/jquery-1.7.1.min.js"></script>

<script>

function deletePerson(id) {
    if(confirm("Are you sure you want to delete this record?")) {
        window.location.assign("/Person/delete?DeleteId=" + id);
    }
}

</script>
<!-- LIST PERSON JSP -->
<html>
    <style type="text/css">
    body {
        background-image:
            url('http://cdn.crunchify.com/wp-content/uploads/2013/03/Crunchify.bg_.300.png');
    }
    </style>
 
    <head>
        <title>Mini Registration System</title>
    </head>

    <body>
     
    <div align="center">
        <a href="#" onclick="window.location.assign('/Menu');">Back</a>
    </div>
    <br>
    <div align="center">
        <a href="#" onclick="window.location.assign('/Person/add');">Register Person</a>
    </div>
    <br>
    <div align="center">
        List of Persons
    </div>
    <br>
    <div align="center">
        <table>
            <thead>
                <tr>
                    <td></td><td></td><td></td>
                    <td>First name</td>
                    <td>Middle name</td>
                    <td>Last name</td>
                    <td>Suffix</td>
                    <td>Title</td>
                    <td>Birthday</td>
                    <td>GWA</td>
                    <td>Employed</td>
                    <td>Date Hired</td>
                    <td>Gender</td>
                    <td>Street number</td>
                    <td>Barangay</td>
                    <td>City</td>
                    <td>Zip code</td>
                    <td>Contact</td>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${people}" var="person">
                    <tr>
                        <td>
                            <a href="/Person/edit?EditId=${person.id}">Edit</a>
                        </td>
                        <td></td>
                        <td>
                            <form action="/Person/delete?DeleteId=${person.id}" method="post" onsubmit="return confirm('Are you sure you want to delete this record?');">
                                <!--<a href="#" onclick="deletePerson(${person.id});">Delete</a>-->
                                <input type="submit" value="Delete"/>
                            </form>
                        </td>
                        <td>${person.name.firstName}</td>
                        <td>${person.name.middleName}</td>
                        <td>${person.name.lastName}</td>
                        <td>${person.name.suffix}</td>
                        <td>${person.name.title}</td>
                        <td>${person.birthday}</td>
                        <td>${person.GWA}</td>
                        <td>${person.currentlyEmployed}</td>
                        <td>${person.dateHired}</td>
                        <td>${person.gender}</td>
                        <td>${person.address.streetNumber}</td>
                        <td>${person.address.barangay}</td>
                        <td>${person.address.city}</td>
                        <td>${person.address.zipCode}</td>
                        <td><a href="/Contact/list?PersonId=${person.id}">View Contact/s</a></td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>
    </body>
</html>