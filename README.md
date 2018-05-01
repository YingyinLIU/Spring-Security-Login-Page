# Spring Security -- Login Page
一个很简易的DEMO，利用Spring Security提供的安全服务对用户进行管理。

---
## 环境
- OS: OSX-10.13.3
- Tool: Intellij IDEA
- JDK: JAVA9
- Port: 8080

## 主要技术内容  
- Spring Boot & Spring Security
- User authentication in Spring Security
- AngularJS httpPost header&body setting (for spring)

## 数据库配置

### 数据库属性
- localhost 
- user: root 
- password: root
- database_name: login_demo


### 生成用户表

hibernate.ddl设置update属性，运行Project就会在数据库中自动帮我们生成三张表，用户表、角色表和两者的关联表。

下面为插入部分用户的sql语句:
```sql
insert  into `sys_role`(`id`,`name`) values (1,'ROLE_ADMIN'),(2,'ROLE_USER');

insert  into `sys_user`(`id`,`password`,`username`) values (1,'root','root'),(2,'sang','sang');

insert  into `sys_user_roles`(`sys_user_id`,`roles_id`) values (1,1),(2,2);
```

## Demo
- 管理员账户登录  
![image.png-45kB][1]
---  

- 登录成功，有额外信息  
![image.png-42kB][2]
---  

- 普通用户登录  
![image.png-42.3kB][3]
---  

- 登录成功，没有额外信息  
![image.png-36.1kB][4]
---  

- 用户验证不成功  
![image.png-56.7kB][5]

## Ref
[SpringSecurity重写详解：springboot 集成 spring security 详细][6]
[GITHUB教程：Spring、SpringMVC、MyBatis、Spring Boot案例][7]
[Spring Security 参考手册][8]


  [1]: http://static.zybuluo.com/yylllyy/nj7lktr7gacjq7fj5g71yl3u/image.png
  [2]: http://static.zybuluo.com/yylllyy/0zdj8314nirdxkte1luktjpj/image.png
  [3]: http://static.zybuluo.com/yylllyy/y1bpxbafrn3d92yklqnzhhhx/image.png
  [4]: http://static.zybuluo.com/yylllyy/fijftcdnrtlpxpbj8d5dftlc/image.png
  [5]: http://static.zybuluo.com/yylllyy/64h9ve6s413ne1mz80o2n9d5/image.png
  [6]: https://blog.csdn.net/qq_29580525/article/details/79317969
  [7]: https://github.com/lenve/JavaEETest
  [8]: https://springcloud.cc/spring-security-zhcn.html#tech-intro-web-authentication
