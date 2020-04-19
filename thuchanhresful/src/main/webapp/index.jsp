<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <meta content="text/html; charset=utf-8">
  <title>Vi du ve AJAX JSON</title>
</head>
<body>

Date: <span id="id"></span><br/>
Time: <span id="customers"></span><br/>

<button type="button" onclick="load()">Load Information</button>
<script type="application/javascript">
  function load() {
    // bạn có thể thay thế bằng các url khác
    var url = "http://localhost:8080/thuchanhresful_main_war_exploded/api/get/1";
    var request;

    if(window.XMLHttpRequest) {
      // đối với Chrome, Mozilla, ...
      request=new XMLHttpRequest();
    } else if(window.ActiveXObject){
      // đối với IE
      request=new ActiveXObject("Microsoft.XMLHTTP");
    }
    request.onreadystatechange  = function(){
      if (request.readyState == 4) {
        var jsonObj = JSON.parse(request.responseText);
        document.getElementById("id").innerHTML =  jsonObj.id;
        document.getElementById("customers").innerHTML = jsonObj.firstName;
      }
    }
    request.open("GET", url, true);
    request.send();
  }
</script>
</body>
</html>
