
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="springform" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
        <title>Insert Trainer</title>

        <style>
            .error{
                color: red;
            }
        </style>
    </head>

    <body style="background-color: whitesmoke">

        <div class="container " >

            <div class="jumbotron" style="background-color: whitesmoke; ">
                <h2 class="float-left">Add <b>Trainer</b></h2>
                <a href="searchtrainer" class="btn btn-primary float-right btn-sm" >Back</a>
            </div>

            <div class="row d-flex justify-content-center">

                <springform:form action="doinserttrainer" method="post"
                                 modelAttribute="newtrainer" >

                    <springform:hidden path="idTrainer"/>

                    <div cssClass="form-group">
                        <label for="exampleFormControlInput1">Name</label>
                        <springform:input type="text" path="name" cssClass="form-control" required="required"/>
                        <springform:errors path="name" cssClass="error"/>
                    </div>

                    <div cssClass="form-group">
                        <label for="exampleFormControlInput1">Surname</label>
                        <springform:input type="text" path="surname" cssClass="form-control" required="required"/>
                        <springform:errors path="surname" cssClass="error"/>
                    </div>

                    <div cssClass="form-group">
                        <label for="exampleFormControlInput1">Subject</label>
                        <springform:input  type="text" path="subject" cssClass="form-control" required="required"/>
                        <springform:errors path="subject" cssClass="error"/>
                    </div>

                    <div cssClass="form-group">
                        <label for="exampleFormControlInput1">Email</label>
                        <springform:input  type="emai" path="email" cssClass="form-control" required="required"/>
                        <springform:errors path="email" cssClass="error"/>
                    </div>

                    <div cssClass="form-group">
                        <label for="exampleFormControlInput1">Phone Number</label>
                        <springform:input path="phoneNumber" cssClass="form-control" required="required"/>
                        <springform:errors path="phoneNumber" cssClass="error" />
                    </div>

                    <br>
                    <input type="submit" value="Submit" class="btn btn-primary btn-primary">
                </springform:form>
            </div>
        </div>
    </body>
</html>
