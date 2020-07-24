To run this program, you need to execute following steps:
1. package the code for the login and the action into two separate
   JAR files:
   javac auth/*.java
   jar cvf login.jar auth/AuthTest.class
   jar cvf action.jar auth/SysPropAction.class

2. Then run the command:
    java -classpath login.jar;action.jar
    -Djava.security.policy=auth/AuthTest.policy
    -Djava.security.auth.login.config=auth/jaas.config
    auth.AuthTest

Tips:
    1) you need to update the user "harry" in AuthTest.policy to your username,
        otherwise you will get a security exception.The printing of LoginContext.getSubject
        will display your NTUserPrincipal.
        (grant principal com.sun.security.auth.NTUserPrincipal "harry", change "harry" to you username);
    2) Since i test the program in windows, so i use NTUserPrincipal, NTLoginModule.
    if your in a unix os, you need to use UNIXUserPrincipal, UNIXLoginModule.
    3) Besides, unix separates the jar with colon (:), and windows separates the
    jar with semicolon (;).