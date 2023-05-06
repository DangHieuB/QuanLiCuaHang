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
<h1>Update Khách Hàng</h1><br/>
<form action="/khach-hang/update?id=${khDetail.id}" method="post">
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
    <button type="submit" class="btn btn-success">Update</button>
</form>
</body>
</html>
