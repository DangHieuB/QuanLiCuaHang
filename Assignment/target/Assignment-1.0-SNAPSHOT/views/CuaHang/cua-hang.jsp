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
            var thanhPho = document.getElementById("thanhPho");
            var quocGia = document.getElementById("quocGia");
            var diaChi = document.getElementById("diaChi");
            var valid = true;
            if (ma.value.length <= 0 || ten.value.length <= 0 || thanhPho.value.length <= 0 || quocGia.value.length <= 0 || diaChi.value.length <= 0 ) {
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
    <form action="/cua-hang/add" method="post" onsubmit="return validate();" name="formAdd">
        Mã: <input type="text" id="ma" name="maCH" value="${Detail.maCH}"/>
        Tên: <input type="text" id="ten" name="tenCH" value="${Detail.tenCH}"/>
        <br/><br/>
        Địa chỉ: <input type="text" id="diaChi" name="diaChi" value="${Detail.diaChi}"/>
        Thành phố: <input type="text" id="thanhPho" name="thanhPho" value="${Detail.thanhPho}"/>
        Quốc gia: <input type="text" id="quocGia" name="quocGia" value="${Detail.quocGia}"/>
        <br/><br/>
        <button type="submit" class="btn btn-success">Add</button>
    </form>
    <br/><br/>
    <table class="table table-bordered">
        <tr>
            <th>STT</th>
            <th>Mã</th>
            <th>Tên</th>
            <th>Địa chỉ</th>
            <th>Thành phố</th>
            <th>Quốc gia</th>
            <th colspan="2">Action</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${listCH}" var="ch" varStatus="viTri">
            <tr>
                <td>${viTri.index}</td>
                <td>${ch.maCH}</td>
                <td>${ch.tenCH}</td>
                <td>${ch.diaChi}</td>
                <td>${ch.thanhPho}</td>
                <td>${ch.quocGia}</td>
                <td>
                    <a href="/cua-hang/remove?id=${ch.idCH}" class="btn btn-danger" onclick="return confirm('Ban co muon xoa khong?')">Remove</a>
                    <a href="/cua-hang/view-update?id=${ch.idCH}" class="btn btn-success">Edit</a>
                    <a href="/cua-hang/detail?id=${ch.idCH}" class="btn btn-primary">Detail</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>

</table>

</body>
</html>
