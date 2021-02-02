<%--
  Created by IntelliJ IDEA.
  User: shivani
  Date: 02/01/21
  Time: 4:37 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
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

         .registerbtn {
             background-color: #4CAF50;
             color: white;
             width: 100%;
             height: 8%;
         }
         hr {
             border: 1px solid #f1f1f1;
             margin-bottom: 25px;
         }


         /* Add a blue text color to links */
         a {
             color: dodgerblue;
         }

     </style>
</head>
<body>

<form action="/user/login" method="post">
    <div class="container">
        <h1 style="text-align: center;">Student Login</h1>

        <br><br>
        <label for="Id"><b>Student ID</b></label>
        <input type="text" placeholder="Enter Student ID" id="Id" class="input-type" name="id" required>

        <label for="psswd"><b>Password</b></label>
        <input type="password" placeholder="Enter Password" id="psswd" class="input-type" name="password"required>

        <button type="Login" class="registerbtn">LOGIN</button>
    </div>
</form>

</body>
</html>
