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
            var tenDem = document.getElementById("tenDem");
            var ho = document.getElementById("ho");
            var ngaySinh = document.getElementById("ngaySinh");
            var diaChi = document.getElementById("diaChi");
            var sdt = document.getElementById("sdt");
            var thanhPho = document.getElementById("thanhPho");
            var quocGia = document.getElementById("quocGia");
            var matKhau = document.getElementById("matKhau");
            var valid = true;
            if (ma.value.length <= 0 || ten.value.length <= 0 || diaChi.value.length <= 0 || ngaySinh.value.length <= 0 || sdt.value.length <= 0 || tenDem.value.length <= 0 || ho.value.length <= 0 || thanhPho.value.length <= 0 || quocGia.value.length <= 0 || matKhau.value.length <= 0) {
                alert("không được để trống!");
                valid = false;
            }
            return valid;
        };
    </script>
</head>
<body class="container">
<table>
    <center><h2>Trang chủ</h2></center>
    <form action="/khach-hang/search">
        Mã: <input name="maSearch"/>
        <button type="submit" class="btn btn-secondary">Search</button>
        <br/>
    </form>
    <br/>
    <form action="/khach-hang/add" method="post" onsubmit="return validate();" name="formAdd">
        Mã: <input type="text" id="ma" name="ma" value="${khDetail.ma}"/>
        Tên: <input type="text" id="ten" name="ten" value="${khDetail.ten}"/>
        Tên Đệm: <input type="text" id="tenDem" name="tenDem" value="${khDetail.tenDem}"/>
        Họ: <input type="text" id="ho" name="ho" value="${khDetail.ho}"/>
        Ngày Sinh:<input type="date" id="ngaySinh" name="ngaySinh" value="${ngaySinh}"/>
        <br/><br/>
        SDT: <input type="text" id="sdt" name="sdt" value="${khDetail.sdt}"/>
        Địa chỉ: <input type="text" id="diaChi" name="diaChi" value="${khDetail.diaChi}"/>
        Thành phố: <input type="text" id="thanhPho" name="thanhPho" value="${khDetail.thanhPho}"/>
        Quốc gia: <input type="text" id="quocGia" name="quocGia" value="${khDetail.quocGia}"/>
        Mật khẩu: <input type="text" id="matKhau" name="matKhau" value="${khDetail.matKhau}"/>
        <br/><br/>
        <button type="submit" class="btn btn-success">Add</button>
    </form>
    <br/><br/>
    <table class="table table-bordered">
        <tr>
            <th>STT</th>
            <th>Mã</th>
            <th>Họ và tên</th>
            <th>Ngày sinh</th>
            <th>SDT</th>
            <th>Địa chỉ</th>
            <th>Thành phố</th>
            <th>Quốc gia</th>
            <th>Mật khẩu</th>
            <th colspan="2">Action</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${listKH}" var="kh" varStatus="viTri">
            <tr>
                <td>${viTri.index}</td>
                <td>${kh.ma}</td>
                <td>${kh.ten} ${kh.ho} ${kh.tenDem}</td>
                <td>${kh.ngaySinh}</td>
                <td>${kh.sdt}</td>
                <td>${kh.diaChi}</td>
                <td>${kh.thanhPho}</td>
                <td>${kh.quocGia}</td>
                <td>${kh.matKhau}</td>
                <td>
                    <a href="/khach-hang/remove?id=${kh.id}" class="btn btn-danger">Remove</a>
                    <a href="/khach-hang/view-update?id=${kh.id}" class="btn btn-success">Edit</a>
                    <a href="/khach-hang/detail?id=${kh.id}" class="btn btn-primary">Detail</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</table>
</body>
</html>
