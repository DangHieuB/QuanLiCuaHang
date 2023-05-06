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
<body  class="container">
<table>
    <h2>Trang chủ</h2>
    <br/>
    <form action="/nha-san-xuat/add" method="post" onsubmit="return validate();" name="formAdd">
        Mã: <input type="text" id="ma" name="maNSX" value="${Detail.maNSX}"/>
        Tên: <input type="text" id="ten" name="tenNSX" value="${Detail.tenNSX}"/>
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
        <c:forEach items="${listNSX}" var="nhaSanXuat" varStatus="viTri">
            <tr>
                <td>${viTri.index}</td>
                <td>${nhaSanXuat.maNSX}</td>
                <td>${nhaSanXuat.tenNSX}</td>
                <td>
                    <a href="/nha-san-xuat/remove?id=${nhaSanXuat.idNSX}" class="btn btn-danger">Remove</a>
                    <a href="/nha-san-xuat/view-update?id=${nhaSanXuat.idNSX}" class="btn btn-success">Edit</a>
                    <a href="/nha-san-xuat/detail?id=${nhaSanXuat.idNSX}" class="btn btn-primary">Detail</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>

</table>

</body>
</html>
