# CAFJE
Code Audit For Java Enterprise

一个代码审计的工具，计划包含以下分析引擎：

1. 语义分析:分析程序中不安全的函数,方法的使用的安全问题
2. 配置分析:分析项目配置文件中的敏感信息和配置缺失的安全问题
3. 数据流分析:跟踪,记录并分析程序中的数据传递过程的安全问题
4. 控制流分析:分析程序特定时间,状态下执行操作指令的安全问题
5. 结构分析:分析程序上下文环境,结构中的安全问题

目前完成：

正则匹配.....=-=，即引擎2（部分），规则还需优化

## 用法

```
java -jar CAFJE.jar config.properties
```

更多：[CAFJE 又一个Java Web代码审计工具](http://eveino.com/216.html)

## Rules

```
SSRF.xml 服务端请求伪造
UserInfoLeak.xml 用户信息泄露
SQLiHibernate.xml
File.xml 操作文件
XXE.xml XXE
PrintStackTrace.xml 
Exec.xml 命令执行
SQLiIbatis.xml
IntranetIPLeak.xml
SQLiJdbc.xml
SQLiMybatis.xml
FilePathManipulation.xml 操作文件路径
XSS.xml XSS
DemoRule.xml 规则Demo
URL-Redirect.xml
ObjectDeserialization.xml 反序列化
FileUpload.xml 文件上传
```

