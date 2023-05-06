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
    <h2>Trang chủ</h2>
    <form action="/nhan-vien/search">
        Mã: <input name="maSearch"/>
        <button type="submit" class="btn-secondary">Search</button>
        <br/>
    </form>
    <br/>
    <form action="/nhan-vien/add" method="post" onsubmit="return validate();" name="formAdd">
        Mã: <input type="text" id="ma" name="ma" value="${Detail.ma}"/>
        Tên: <input type="text" id="ten" name="ten" value="${Detail.ten}"/>
        Tên Đệm: <input type="text" id="tenDem" name="tenDem" value="${Detail.tenDem}"/>
        Họ: <input type="text" id="ho" name="ho" value="${Detail.ho}"/>
        Ngày Sinh:<input type="date" id="ngaySinh" name="ngaySinh" value="${ngaySinh}"/>
        <br/><br/>
        SDT: <input type="text" id="sdt" name="sdt" value="${Detail.sdt}"/>
        Địa chỉ: <input type="text" id="diaChi" name="diaChi" value="${Detail.diaChi}"/>
        Mật khẩu: <input type="text" id="matKhau" name="matKhau" value="${Detail.matKhau}"/>
        Giới tính: <input type="radio" name="gioiTinh" value="true" ${Detail.gioiTinh == true?"checked":""} checked/>Nam
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
                <option value="${cv.id}" ${ch.tenCV==Detail.chucVu.tenCV?"selected":""}>${cv.tenCV}</option>
            </c:forEach>
        </select>
        Trạng thái: <input type="radio" name="trangThai" value="true" ${Detail.trangThai == true?"checked":""} checked/>Đang làm
        <input type="radio" name="trangThai" value="false" ${Detail.trangThai == false?"checked":""}/>Nghỉ việc
        <br/><br/>
        <button type="submit" class="btn-success">Add</button>
    </form>
    <br/><br/>
    <table class="table table-bordered">
        <tr>
            <th>STT</th>
            <th>Mã</th>
            <th>Họ và tên</th>
            <th>Ngày sinh</th>
            <th>Giói tính</th>
            <th>SDT</th>
            <th>Địa chỉ</th>
            <th>Cửa hàng</th>
            <th>Chức vụ</th>
            <th>Trạng thái</th>
            <th>Mật khẩu</th>
            <th colspan="2">Action</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${listNV}" var="nv" varStatus="viTri">
            <tr>
                <td>${viTri.index}</td>
                <td>${nv.ma}</td>
                <td>${nv.ten} ${nv.ho} ${nv.tenDem}</td>
                <td>${nv.ngaySinh}</td>
                <td>
                    <c:if test="${nv.gioiTinh == true}">Nam</c:if>
                    <c:if test="${nv.gioiTinh == false}">Nữ</c:if>
                </td>
                <td>${nv.sdt}</td>
                <td>${nv.diaChi}</td>
                <td>${nv.cuaHang.tenCH}</td>
                <td>${nv.chucVu.tenCV}</td>
                <td>
                    <c:if test="${nv.trangThai == true}">Đang làm</c:if>
                    <c:if test="${nv.trangThai == false}">Nghỉ việc</c:if>
                </td>
                <td>${nv.matKhau}</td>
                <td>
                    <a href="/nhan-vien/remove?id=${nv.id}" class="btn btn-danger">Remove</a>
                    <a href="/nhan-vien/view-update?id=${nv.id}" class="btn btn-primary">Edit</a>
                    <a href="/nhan-vien/detail?id=${nv.id}" class="btn btn-success">Detail</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>

</table>

</body>
</html>
