# timing-dome
定时消息-定时发送邮件
除去固定依赖之外引入一下依赖:
 <!--邮件发送-->
 
    <dependency>
      <groupId>org.springframework.boot</groupId>
      <artifactId>spring-boot-starter-mail</artifactId>
    </dependency>
    
    <dependency>
      <groupId>org.springframework</groupId>
      <artifactId>spring-context-support</artifactId>
      <version>4.3.10.RELEASE</version>
     </dependency>
     
     <dependency>
       <groupId>org.apache.velocity</groupId>
       <artifactId>velocity</artifactId>
       <version>1.7</version>
     </dependency>
#除此之外还要在application.yml中设置:
>spring:
>  mail:
>   host: smtp.163.com

>   username: hxyHelloWorld@163.com

>   password: *****

>   properties:

>     mail:

>      smtp:

>         auth: true

>         starttls:

>           enable: true

>           required: true
     
#如果出现505 或者500错误在自己的邮箱中设置“开启SMTP服务,password使用开启SMTP服务后的密码
