<html>
<head>
    <title>欢迎  ${user.username}!</title>
</head>
<body>

<h2>freemarker展示String类型数据</h2>
    ${stringShow}
<h2>freemarker展示对象数据</h2>
    欢迎 ${user.username}!
    年龄: ${user.age}
    ${user.record.id}：${user.record.name}

<h2>freemarker以字符串展示boolean类型数据</h2>
${boolTest?string('yes', 'no')}

<h2>freemarker展示java.util.Date</h2>
${utildate?string("yyyy/MM/dd HH:mm:ss")}

<h2>freemarker展示null</h2>
${nullVar!'默认输出'}
<br/>

${missingVar!}
<br/>

<h2>freemarker展示list集合</h2>
<#list numList as item>
    ${item}
    <br/>
</#list>
<br/>


<h2>freemarker展示map集合</h2>
    ${map.obj.username}

<h2>freemarker测试if判断</h2>
<#if ("小明"==map.obj.username) >
    这是小明
<#else>
    这不是小明
</#if>

</body>
</html>