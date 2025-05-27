<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Form tạo mới danh mục</title>
</head>
<body>
    <h2>Tạo danh mục</h2>
    <form:form action="add" method="post" modelAttribute="category">
        <div>
            <label for="name">Tên danh mục:</label>
            <form:input path="name" id="name" />
            <br>
            <form:errors path="name" cssStyle="color: red"/>
        </div>
        <div>
            <label for="description">Mô tả:</label>
            <form:textarea path="description" id="description"></form:textarea>
            <form:errors path="description" cssStyle="color: red"/>
        </div>
        <div>
            <label for="status">Trạng thái:</label>
            <form:select path="status" id="status">
                <form:option value="true">ACTIVE</form:option>
                <form:option value="false">INACTIVE</form:option>
            </form:select>
        </div>
        <div>
            <button type="submit">Lưu</button>
        </div>
    </form:form>
</body>
</html>
