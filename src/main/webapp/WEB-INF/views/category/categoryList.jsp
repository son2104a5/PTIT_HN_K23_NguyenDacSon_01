<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Trang danh mục</title>
</head>
<body style="display: flex; flex-direction: column; align-items: center; width: 100%">
<h2>Danh sách danh mục</h2>
<div style="display: flex; gap: 50px; margin-bottom: 20px;">
    <a href="categories/add" style="text-decoration: none;">Thêm mới</a>
    <div>
        <input type="search" placeholder="Search....">
        <button>Tìm kiếm</button>
    </div>
</div>
<div>
    <table border="1">
        <thead>
            <th>STT</th>
            <th>ID</th>
            <th>Tên danh mục</th>
            <th>Mô tả</th>
            <th>Trạng thái</th>
            <th>Chức năng</th>
        </thead>
        <tbody>
            <c:forEach var="category" items="${categories}" varStatus="loop">
                <tr>
                    <td>${loop.index + 1}</td>
                    <td>${category.id}</td>
                    <td>${category.name}</td>
                    <td>${category.description}</td>
                    <td>${category.status ? "ACTIVE" : "INACTIVE"}</td>
                    <td>
                        <a href="categories/update/${category.id}">Sửa</a>
                        <a href="categories/delete/${category.id}">Xóa</a>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</div>

</body>
</html>
