<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link href="css/jquery-ui.css" rel="stylesheet">
  <script src="js/jquery-1.11.2.js"></script>
  <script src="js/jquery-ui.js"></script>
  <script>
  $(function() {
  
   $('#tags').keypress(function () {   
    $.ajax({
     url:"Auto",
     type:"post",
     data:'',
     success:function(data){
      $( "#tags" ).autocomplete({   
          source: data   
        });
     
     },error:  function(data, status, er){
              console.log(data+"_"+status+"_"+er);
          },
           
    });
    
    });
 
  });
  </script>
</head>
<body>

</body>
</html>