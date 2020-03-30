# [小游戏] Escapist_Chess

## 一、我该如何启动它?

这个可爱的游戏需要一点时间才能启动，它是一个maven项目，并且mysql数据库是必要的

#### 1 导入游戏用到的数据

很遗憾没有采用云存储数据库内容

还请您务必将项目根目录下的 escapistchess.sql 导入数据库中

#### 2 修改数据库相关代码

必须在src/main/java/Mysql/MyJdbc.java这个文件中配置数据库

你需要修改如下四个静态属性，直到它们与你的mysql环境相符

##### (1)  JDBC驱动版本

com.mysql.jdbc.Driver为旧版mysql的驱动

com.mysql.cj.jdbc.Driver为新版mysql的驱动

> private static String jdbcDriver = "com.mysql.cj.jdbc.Driver";

##### (2)  连接数据库的URL

​	数据库的名字叫做EscapistChess

> private static String connectUrl = "jdbc:mysql://localhost:3306/EscapistChess?useSSL=false&serverTimezone=GMT%2B8&amp";

##### (3)  数据库的用户名

> private static String userName = "root";

##### (4)  数据库的密码

> private static String passWord = "1234";

#### 3 编译项目吧

编译这个maven项目并且运行它

如果编译成功且在运行过程中没有错误提示的话就那真是太好了

如果运行后有数据库相关的异常，请检查是否在数据库的配置上出现了差错

## 二、游戏的操作方法

点开始游戏按钮

上下左右键 移动人物

遇到可爱的怪物与其战斗

拿到稀有的宝物变得更强

击败boss逃出迷宫吧

如果无法继续前进的话，请重置游戏！

每一次都是全新的体验!!!



-- 2020.3.30