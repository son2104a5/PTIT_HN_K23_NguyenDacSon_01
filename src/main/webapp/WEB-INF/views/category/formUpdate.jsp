<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Form chỉnh sửa danh mục</title>
</head>
<body>
<h2>Sửa danh mục</h2>
<form:form action="/update/${category.id}" method="post" modelAttribute="category">
    <form:hidden path="id" />
    <div>
        <label for="name">Tên danh mục:</label>
        <form:input value="${category.name}" path="name" id="name"/>
        <br>
        <form:errors path="name" cssStyle="color: red"/>
    </div>
    <div>
        <label for="description">Mô tả:</label>
        <form:textarea value="${category.description}" path="description" id="description"></form:textarea>
        <form:errors path="description" cssStyle="color: red"/>
    </div>
    <div>
        <label for="status">Trạng thái:</label>
        <form:select value="${category.status}" path="status" id="status">
            <form:option value="true">ACTIVE</form:option>
            <form:option value="false">INACTIVE</form:option>
        </form:select>
    </div>
    <div>
        <button type="submit">Sửa</button>
    </div>
</form:form>
</body>
</html>
