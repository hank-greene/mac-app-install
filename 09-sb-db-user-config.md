

https://tableplus.com/blog/2019/09/access-denied-for-user-root-localhost-mysql.html

https://kinsta.com/blog/mysql-error-1045/

https://stackoverflow.com/questions/11922323/java-sql-sqlexception-access-denied-for-user-rootlocalhost-using-password

-- Source - https://stackoverflow.com/a
-- Posted by Sadhvik Chirunomula
-- Retrieved 2026-01-03, License - CC BY-SA 4.0

CREATE USER 'admin'@'localhost' IDENTIFIED BY 'password';
GRANT ALL PRIVILEGES ON *.* TO 'admin'@'localhost'
WITH GRANT OPTION;

CREATE USER 'admin'@'%' IDENTIFIED BY 'password';
GRANT ALL PRIVILEGES ON *.* TO 'admin'@'%'
WITH GRANT OPTION;

---- executed commands
CREATE USER 'sblrndb'@'localhost' IDENTIFIED BY 'reacher-landman-calvin';
GRANT ALL PRIVILEGES ON *.* TO 'sblrndb'@'localhost'
WITH GRANT OPTION;

CREATE USER 'sblrndb'@'%' IDENTIFIED BY 'reacher-landman-calvin';
GRANT ALL PRIVILEGES ON *.* TO 'sblrndb'@'%'
WITH GRANT OPTION;
