# Books

#### 仓库提交代码流程
1.  新建 dev-xxx 分支
2.  提交代码
3.  新建 Pull Request
4.  解决冲突
5.  找同组人员进行 Code Review
6.  审核通过后 Merge

#### 提交规范
```bash
fix: bug fix (desc relative update here)
feat: new feature
docs: docs update
style: Markup, white-space, formatting, missing semi-colons...
test: Adding missing tests
```

#### 介绍
四季图书后端

#### 软件架构
Basic Once Http Request Handle Processor:
Request => Parameter Validator Interceptor => Service Handle Data to Persistence => Exception Catcher => Return Json Formatted Data

API docs: http://localhost:8080/swagger-ui.html

```
four_seasons_of_books
├── annotation    --  自定义注解
├── config        --  配置模块(包括配置类, 处理器, 拦截器等)
├── constants     --  常量模块
├── controller    --  控制器模块
├── mapper        --  持久层模块
├── model         --  模型模块
  ├── entity      --  基本数据模型
  ├── dto         --  数据传输模型
  ├── vo          --  数据展示模型
├── exception     --  自定义异常模块
├── service       --  服务模块
├── util          --  工具类模块
```
#### 附带数据库SQL
