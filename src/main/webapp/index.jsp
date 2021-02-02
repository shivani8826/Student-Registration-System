<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="./web-resources/style.css">
    <title>User Onboard</title>
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

        /* Overwrite defausubmit button */
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
        .signin {
            background-color: #f1f1f1;
            text-align: center;
            height: 6%;
        }
    </style>
</head>
<body>


<%--  ----------- User Onboard ----------- --%>
<div class="container">
    <h1 style="text-align: center;">Student OnBoard Registration<br><br></h1>

    <form action="/user/onboard" method="post">
        <%--<form th:action="/user/onboard" th:object="${user}"
              method="post" style="max-width: 600px; margin: 0 auto;">
            <div class="m-3">
                <div class="form-group row">
                    <label class="col-4 col-form-label">E-mail: </label>
                    <div class="col-8">
                        <input type="email" th:field="*{email}" class="form-control" required />
                    </div>
                </div>

                <div class="form-group row">
                    <label class="col-4 col-form-label">Password: </label>
                    <div class="col-8">
                        <input type="password" th:field="*{password}" class="form-control"
                               required minlength="6" maxlength="10"/>
                    </div>
                </div>

                <div class="form-group row">
                    <label class="col-4 col-form-label">First Name: </label>
                    <div class="col-8">
                        <input type="text" th:field="*{firstName}" class="form-control"
                               required minlength="2" maxlength="20"/>
                    </div>
                </div>

                <div class="form-group row">
                    <label class="col-4 col-form-label">Last Name: </label>
                    <div class="col-8">
                        <input type="text" th:field="*{lastName}" class="form-control"
                               required minlength="2" maxlength="20" />
                    </div>
                </div>

                <div>
                    <button type="submit" class="btn btn-primary">Sign Up</button>
               </div>
            </div>

        </form>
--%>
        <div class="input-group">
        <div class="form-group row">
           <%-- <label for="email"><b>Email</b><b></b></label>
            <input type="email" placeholder="Enter Email" id="email" class="input-type" name="email" required minlength="5" maxlength="20" />
--%>
            <label for="first"><b>First Name</b></label>
            <input type="text" placeholder="Enter First Name" id="first" class="input-type" name="first" required minlength="5" maxlength="20" />
       </div>

        <div class="form-group row">

            <label for="last"><b>Last Name</b></label>
            <input type="text" placeholder="Enter Last Name" id="last" class="input-type" name="last" required minlength="2" maxlength="20" />

       </div>

        <div class="form-group row">
            <label for="psswd"><b>Password</b></label>
            <input type="password" placeholder="Enter Password" id="psswd" class="input-type" name="password" required minlength="5" maxlength="20" />

        </div>
            <button type="submit" class="registerbtn">REGISTER</button>
            <div class="signin">
                <p>Already have an account? <a href="login.jsp">Sign in</a>.</p>
            </div>

        </div>

    </form>




</div>

</body>
</html>
