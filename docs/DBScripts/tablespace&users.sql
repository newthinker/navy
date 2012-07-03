CREATE TABLESPACE "NAVY"
  LOGGING
  DATAFILE 'D:\app\zuow\oradata\orcl\navy.ora' SIZE 2048M
  AUTOEXTEND 
  ON NEXT 1M MAXSIZE UNLIMITED EXTENT MANAGEMENT LOCAL
  SEGMENT SPACE MANAGEMENT  AUTO ;

CREATE USER PRIVSYS 
    IDENTIFIED BY "privsys" 
    DEFAULT TABLESPACE NAVY
    temporary tablespace TEMP
    profile DEFAULT
    password expire;
alter user PRIVSYS  identified by "privsys";  
grant connect to privsys with admin option;
grant dba to privsys with admin option;

CREATE USER NAVYSYS 
    IDENTIFIED BY "navysys" 
    DEFAULT TABLESPACE NAVY
    temporary tablespace TEMP
    profile DEFAULT
    password expire;
alter user NAVYSYS  identified by "navysys";    
grant connect to NAVYSYS with admin option;
grant dba to NAVYSYS with admin option;

CREATE USER LOGSYS 
    IDENTIFIED BY "logsys" 
    DEFAULT TABLESPACE NAVY
    temporary tablespace TEMP
    profile DEFAULT
    password expire;
alter user LOGSYS  identified by "logsys";    
grant connect to LOGSYS with admin option;
grant dba to LOGSYS with admin option;

CREATE USER DICTSYS 
    IDENTIFIED BY "dictsys" 
    DEFAULT TABLESPACE NAVY 
    temporary tablespace TEMP
    profile DEFAULT
    password expire;
alter user DICTSYS  identified by "dictsys";    
grant connect to DICTSYS with admin option;
grant dba to DICTSYS with admin option;
