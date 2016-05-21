<%@ page language="java" contentType="text/html; charset=EUC-KR" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
    <title>JSON 테스트</title>
    <script type="text/javascript">
        var xmlhttp;
        $(document).ready(function () {
            if (window.XMLHttpRequest) {
                xmlhttp = new XMLHttpRequest();
            } else {
                xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
            }
            xmlhttp.onreadystatechange = function () {
                if (xmlhttp.readyState == 4) {
                    document.getElementById('loadedJson').innerHTML = xmlhttp.responseText;
                }
            }
            xmlhttp.open("GET", "json.do", true);
            xmlhttp.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
            xmlhttp.setRequestHeader("Accept", "application/json");
            xmlhttp.send(null);
        });
    </script>
</head>
<body>
<div id="loadedJson"></div>
</body>
</html>
