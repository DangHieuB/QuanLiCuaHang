<%--
  Created by IntelliJ IDEA.
  User: DANG HIEU
  Date: 4/4/2023
  Time: 1:25 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <title>Title</title>
</head>
<body class="container">
<form action="/chi-tiet-san-pham/update?id=${Detail.id}" method="post" onsubmit="return validate();" name="formAdd">
    Sản phẩm:
    <select name="sanPham">
        <c:forEach items="${listSP}" var="sp">
            <option value="${sp.idSanPham}" ${sp.tenSP==Detail.sanPham.tenSP?"selected":""}>${sp.tenSP}</option>
        </c:forEach>
    </select>
    Màu sắc:
    <select name="mauSac">
        <c:forEach items="${listMS}" var="ms">
            <option value="${ms.idMS}" ${ms.tenMauSac==Detail.mauSac.tenMauSac?"selected":""}>${ms.tenMauSac}</option>
        </c:forEach>
    </select>
    Giá Bán: <input type="text" id="giaBan" name="giaBan" value="${Detail.giaBan}"/>
    Giá Nhập: <input type="text" id="giaNhap" name="giaNhap" value="${Detail.giaNhap}"/>
    <br/><br/>
    Dòng sản phẩm:
    <select name="DSP">
        <c:forEach items="${listDSP}" var="dsp">
            <option value="${dsp.idDSP}" ${dsp.tenDSP==Detail.dongSP.tenDSP?"selected":""}>${dsp.tenDSP}</option>
        </c:forEach>
    </select>
    NSX:
    <select name="NSX">
        <c:forEach items="${listNSX}" var="nhaSanXuat">
            <option value="${nhaSanXuat.idNSX}" ${nhaSanXuat.tenNSX==Detail.NSX.tenNSX?"selected":""}>${nhaSanXuat.tenNSX}</option>
        </c:forEach>
    </select>
    Mô tả: <input type="text" id="moTa" name="moTa" value="${Detail.moTa}"/>
    Năm BH: <input type="text" id="namBH" name="namBH" value="${Detail.namBH}"/>
    Số lượng tồn: <input type="text" id="soLuongTon" name="soLuongTon" value="${Detail.soLuongTon}"/>
    <br/><br/>
    <button type="submit" class="btn btn-success" onclick="return confirm('Ban co muon sua khong?')">Update</button>
</form>
</body>
</html>
