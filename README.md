# PSK_PROJECT

Database setup: https://www3.ntu.edu.sg/home/ehchua/programming/sql/MySQL_HowTo.html

When you change from your temporary password, set the new password to 'password' for the spring boot application to work.

When you launch the mysql database server, you can access it via MySql Workbench app client.
For the Spring Boot code to work, you need to create a database inside the root user with the name 'eshop'.
  - To do this, just run the script: 'CREATE DATABSE eshop'

If you are launching the application for the first time, navigate to 'application.properties' file and set the property spring.jpa.hibernate.ddl-auto = create-drop.
This will initialize the database tables. Right after that, shut down the application, set the spring.jpa.hibernate.ddl-auto = update and launch the application again. After this, leave this value 'update' untouched when you start developing the application. That way all your changes and records, inserted in the database will remain there.
  
 This repo was made according to this video: https://www.youtube.com/watch?v=O_XL9oQ1_To&t=1402s&ab_channel=CodeWithArjun
