<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="./web-resources/style.css">
    <script type="text/javascript" src="./validate.js"></script>
    <title>Course Register</title>
    <style>
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
        .registerbtn {
            background-color: #4CAF50;
            color: white;
            padding: 10px 50px 10px 50px;
        }
    </style>

</head>
<body>

<div class="container">
    <h1>Courses choice available</h1>
   <form action="/user/registered">

       <input type="checkbox" class="checks" value="English"> English<br>
       <input type="checkbox" class="checks" value="Physics"> Physics<br>
       <input type="checkbox" class="checks" value="Chemistry"> Chemistry<br>
       <input type="checkbox" class="checks" value="Maths"> Maths<br>
       <input type="checkbox" class="checks" value="Electronics"> Electronics<br>
       <input type="checkbox" class="checks" value="Computer Science"> Computer Science<br>
       <input type="checkbox" class="checks" value="Operating System"> Operating System<br>
       <input type="checkbox" class="checks" value="Database Management"> Database Management<br>
       <input type="checkbox" class="checks" value="Data Structure"> Data Structure<br>
       <input type="checkbox" class="checks" value="Web Development"> Web Development<br>
       <br><br>
       <a href="#" onclick="getValue();return false;">Submit</a>

    </form>
</div>
<script>
    function getValue() {
        var checks = document.getElementsByClassName('checks');
        var str = [];
        var k=0;
        var len=0;

        for ( i = 0; i < 10; i++) {
            if ( checks[i].checked == true ) {
                str[k++]=checks[i].value;
                len++;
            }
        }

        if(len==0)
            alert("No Options choosen !!");
        else if(len>5)
            alert("You can only Choose Five Courses !!");
        else if(len<5)
            alert("You have to choose Five Courses !!");
        else
        alert("Choosen Courses are :  "+str);
    }
</script>
</body>
</html>