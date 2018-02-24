<!DOCTYPE html>
<html>
<head>

    <title>列表展示</title>
</head>

<body>
<table border="1">
    <tr>

        <th>状态变量：even</th>
        <th>状态变量：odd</th>
        <th>状态变量：first</th>
        <th>状态变量：last</th>
        <th>状态变量：first</th>
        <th>状态变量：last</th>
    </tr>
    <#list allbooklist as item>
    <tr>

        <th>${item.id}</th>
        <th>${item.title}</th>
        <th>${item.price}</th>
        <th>${item.unit}</th>
        <th>${item.typeName}</th>
        <th>${item.typeId}</th>
    </tr>
    </#list>
</table>
</body>
</html>