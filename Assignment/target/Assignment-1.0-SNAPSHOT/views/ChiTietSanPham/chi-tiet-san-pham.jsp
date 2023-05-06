
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <title>Title</title>
</head>
<body class="container">
<table>
    <center><h2>Chi tiết sản phẩm</h2></center>
    <br/>
    <form action="/chi-tiet-san-pham/add" method="post">
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
        <br/>
        <p style="color: red">${error}</p>
        <br/>
        <button type="submit" class="btn btn-success">Add</button>
    </form>
    <br/><br/>
    <table class="table table-bordered">
        <tr>
            <th>STT</th>
            <th>Tên SP</th>
            <th>Màu sắc</th>
            <th>Giá bán</th>
            <th>Giá nhập</th>
            <th>Dòng SP</th>
            <th>Mô tả</th>
            <th>Năm BH</th>
            <th>Số lượng tồn</th>
            <th>NSX</th>
            <th colspan="2">Action</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${listCTSP}" var="kh" varStatus="viTri">
            <tr>
                <td>${viTri.index}</td>
                <td>${kh.sanPham.tenSP}</td>
                <td>${kh.mauSac.tenMauSac}</td>
                <td>${kh.giaBan}</td>
                <td>${kh.giaNhap}</td>
                <td>${kh.dongSP.tenDSP}</td>
                <td>${kh.moTa}</td>
                <td>${kh.namBH}</td>
                <td>${kh.soLuongTon}</td>
                <td>${kh.NSX.tenNSX}</td>
                <td>
                    <a href="/chi-tiet-san-pham/remove?id=${kh.id}" class="btn btn-danger" onclick="return confirm('Ban co muon xoa khong?')">Remove</a>
                    <a href="/chi-tiet-san-pham/view-update?id=${kh.id}" class="btn btn-success">Edit</a>
                    <a href="/chi-tiet-san-pham/detail?id=${kh.id}" class="btn btn-primary">Detail</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>

</table>
</body>
</html>
