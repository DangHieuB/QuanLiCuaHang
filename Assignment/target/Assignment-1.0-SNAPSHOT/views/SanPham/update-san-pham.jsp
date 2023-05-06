<%--
  Created by IntelliJ IDEA.
  User: DANG HIEU
  Date: 3/30/2023
  Time: 4:30 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <title>UPDATE</title>
</head>
<body class="container">
<script>
    function validate() {
        var ma = document.getElementById("ma");
        var ten = document.getElementById("ten");

        var valid = true;
        if (ma.value.length <= 0 || ten.value.length <= 0 ) {
            alert("không được để trống!");
            valid = false;
        }
        return valid;
    };
</script>
<h1>Update Sản Phẩm</h1><br/>
<form action="/san-pham/update?id=${Detail.idSanPham}" method="post" onsubmit="return validate();" name="formAdd">
    Mã: <input type="text" id="ma" name="maSP" value="${Detail.maSP}"/>
    Tên: <input type="text" id="ten" name="tenSP" value="${Detail.tenSP}"/>
    <br/><br/>
    <button type="submit" class="btn-success">Update</button>
</form>
</body>
</html>
