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