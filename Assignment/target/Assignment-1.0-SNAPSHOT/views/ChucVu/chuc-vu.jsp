<%--
  Created by IntelliJ IDEA.
  User: DANG HIEU
  Date: 3/18/2023
  Time: 6:12 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <title>Title</title>
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
</head>
<body class="container">
<table>
    <h2>Trang chủ</h2>
    <br/>
    <form action="/chuc-vu/add" method="post" onsubmit="return validate();" name="formAdd">
        Mã: <input type="text" id="ma" name="ma" value="${cvDetail.maCV}"/>
        Tên: <input type="text" id="ten" name="ten" value="${cvDetail.tenCV}"/>
        <br/><br/>
        <button type="submit" class="btn btn-success">Add</button>
    </form>
    <br/><br/>
    <table class="table table-bordered">
        <tr>
            <th>STT</th>
            <th>Mã</th>
            <th>Tên</th>
            <th colspan="2">Action</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${listCV}" var="cv" varStatus="viTri">
            <tr>
                <td>${viTri.index}</td>
                <td>${cv.maCV}</td>
                <td>${cv.tenCV}</td>
                <td>
                    <a href="/chuc-vu/remove?id=${cv.id}" class="btn btn-danger" onclick="return confirm('Ban co muon xoa khong?')">Remove</a>
                    <a href="/chuc-vu/view-update?id=${cv.id}" class="btn btn-success">Edit</a>
                    <a href="/chuc-vu/detail?id=${cv.id}" class="btn btn-primary">Detail</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>

</table>

</body>
</html>
