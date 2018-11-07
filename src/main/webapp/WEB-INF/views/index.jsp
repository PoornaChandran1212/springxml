<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
    <title>Spring Model</title>
    <link href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
    <script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
    <script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.4.0/css/font-awesome.min.css" rel='stylesheet'
        type='text/css'>
    <link rel="stylesheet" href="style.css">
    <style>
        #myHeader {
            background-color: black;
            color: white;
            padding: 10px;
            text-align: center;
        }

        table th {
            background-color: green;
            color: white;
        }
    </style>
</head>

<body>
    <div class="container">
        <div class="col-md-10 col-md-offset-1">
            <center>
                <h1 id="myHeader">Employee List</h1>
            </center>

            <div class="row">

            </div>
        </div>
        <table class="table table-striped table-bordered table-list">
            <thead>
                <tr>
                    <th>UserId</th>
                    <th>UserName</th>
                    <th>E-mail</th>
                    <th>Phone</th>

                </tr>
            </thead>
            <tbody>
                <c:forEach items="${list}" var="user">
                    <tr>
                        <td>
                            <c:out value="${user.userid}" />
                        </td>

                        <td>
                            <c:out value="${user.username}" />
                        </td>
                        <td>
                            <c:out value="${user.email}" />
                        </td>
                        <td>
                            <c:out value="${user.phone}" />
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>

    </div>

    </div>
</body>

</html>