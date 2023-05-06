<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <title>UPDATE</title>
</head>
<body class="container">
<center><h1>Update Nhân Viên</h1></center>
<form action="/nhan-vien/update?id=${Detail.id}" method="post" onsubmit="return validate();" name="formAdd">
    Mã: <input type="text" id="ma" name="ma" value="${Detail.ma}"/>
    Tên: <input type="text" id="ten" name="ten" value="${Detail.ten}"/>
    Tên Đệm: <input type="text" id="tenDem" name="tenDem" value="${Detail.tenDem}"/>
    Họ: <input type="text" id="ho" name="ho" value="${Detail.ho}"/>
    Ngày Sinh:<input type="date" id="ngaySinh" name="ngaySinh" value="${ngaySinh}"/>
    <br/><br/>
    SDT: <input type="text" id="sdt" name="sdt" value="${Detail.sdt}"/>
    Địa chỉ: <input type="text" id="diaChi" name="diaChi" value="${Detail.diaChi}"/>
    Mật khẩu: <input type="text" id="matKhau" name="matKhau" value="${Detail.matKhau}"/>
    Giới tính: <input type="radio" name="gioiTinh" value="true" ${Detail.gioiTinh == true?"checked":""}/>Nam
    <input type="radio" name="gioiTinh" value="false" ${Detail.gioiTinh == false?"checked":""}/>Nữ
    <br/><br/>
    Cửa hàng:
    <select name="cuaHang">
        <c:forEach items="${listCH}" var="ch">
            <option value="${ch.idCH}" ${ch.tenCH==Detail.cuaHang.tenCH?"selected":""}>${ch.tenCH}</option>
        </c:forEach>
    </select>
    Chức vụ:
    <select name="chucVu">
        <c:forEach items="${listCV}" var="cv">
            <option value="${cv.id}" ${cv.tenCV==Detail.chucVu.tenCV?"selected":""}>${cv.tenCV}</option>
        </c:forEach>
    </select>
    Trạng thái: <input type="radio" name="trangThai" value="true" ${Detail.trangThai == true?"checked":""} checked/>Đang làm
    <input type="radio" name="trangThai" value="false" ${Detail.trangThai == false?"checked":""}/>Nghỉ việc<br/>
    <br/><br/>
    <button type="submit" class="btn-success">Update</button>
</form>
</body>
</html>
