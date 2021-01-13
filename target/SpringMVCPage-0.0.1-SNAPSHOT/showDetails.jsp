<%--
  Created by IntelliJ IDEA.
  User: shivani
  Date: 05/01/21
  Time: 3:08 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>Student Details</title>
    <style>
        body {
            font-family: Arial, Helvetica, sans-serif;
        }

        * {
            box-sizing: border-box;
        }

        /* Add padding to containers */
        .container {
            margin: 0;
            padding: 0;
            width: 610px;
            height: 600px;
            position: relative;
            margin: 6% auto;
            background: violet;
            padding: 5px;
        }


        /* Full-width input fields */
        input[type=text], input[type=password] {
            width: 100%;
            padding: 15px;
            margin: 5px 0 22px 0;
            display: inline-block;
            border: none;
            background: #f1f1f1;
        }

        input[type=text]:focus, input[type=password]:focus {
            background-color: #ddd;
            outline: none;
        }

        hr {
            border: 1px solid #f1f1f1;
            margin-bottom: 25px;
        }
        .buttons{
            background-color: #4CAF50;
            color: white;
            width: 100%;
            height: 8%;
            padding: 25px 25px 25px 25px;
            margin-top: 20px;
            margin-bottom: 20px;
            align-content: center;
        }


        /* Add a blue text color to links */
        a {
            color: dodgerblue;
        }

    </style>
</head>
<body>
<div class="container">
    <h2>Successfully registered.....</h2>
    <b>1.  </b>    Your Generated Student ID is :   <b> ${id} </b><br>
    <b>2.  </b>    Your Email Id :    <b> ${email} </b><br>
    <b>3.  </b>    Your First Name :    <b> ${first} </b><br>
    <b>4.  </b>    Your Last Name :    <b> ${last} </b><br><br><br>

    <h3>YOU CAN NOW LOGIN WITH ABOVE DETAILS !<br><br></h3>
    <a href="/login.jsp" class="buttons">Login  </a><br><br><br><br><br>
    <a href="/index.jsp" class="buttons">Register</a>


    </p>

</div>
</body>
</html>
