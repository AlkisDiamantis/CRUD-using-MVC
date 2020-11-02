
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>

        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
        <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>


        <title>Trainers</title>

    </head>

    <body style="background-color: whitesmoke" >

        <div class="container" >

            <div class="jumbotron" style="background-color: whitesmoke">
                <h2 class="float-left">Manage <b>Trainers</b></h2>
                <a href="preinserttrainer" class="btn  btn-primary   float-right" role="button" aria-pressed="true"><i class="material-icons">&#xE147;</i><span style="float: right; font-size: medium">Add New Trainer</span></a>
            </div>

            <form action="searchFortrainer" class="form-inline" >
                <input type="text"  name="name" class="form-control form-control-sm mr-3 w-30" placeholder="Search" id="searchfromletters" >
                <button type="submit" class="btn btn-default">
                    <span class="glyphicon glyphicon-search"></span> 
                </button>
            </form>

            <table class="table table-hover">
                <thead class="thead-dark">
                    <tr>
                        <th scope="col">First Name</th>
                        <th scope="col">Last Name</th>
                        <th scope="col">Subject</th>
                        <th scope="col">Email</th>
                        <th scope="col">Phone_Number</th>
                        <th scope="col">Actions</th>
                    </tr>
                </thead>
                <tbody >
                    <c:forEach items="${trainerlist}" var="t">
                        <tr>  
                            <td>${t.name}</td>
                            <td>${t.surname}</td>
                            <td>${t.subject}</td>
                            <td>${t.email}</td>
                            <td>${t.phoneNumber}</td>
                            <td>
                                <a href="deletetrainer?idTrainer=${t.idTrainer}" title="Delete"class="btn delette btn-secondary btn-sm"   ><i class="material-icons" >&#xE872;</i></a>
                                <a href="edittrainer?idTrainer=${t.idTrainer}" title="Edit" class="btn btn-secondary btn-sm"><i class="material-icons" >&#xE254;</i></a>
                            </td>
                        </tr> 
                    </c:forEach>
                </tbody>
            </table>
        </div>
        <script>
            $('.delette').click(function (event) {

                var r = confirm("This action will be irreversable are you sure you want to delete this trainer?");
                if (r == false) {
                    event.preventDefault();
                }
            });
        </script>   
    </body>
</html>
