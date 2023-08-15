-- system run / testwdb 
create user c##testweb IDENTIFIED by testweb;

grant CONNECT, RESOURCE to c##testweb;
GRANT create view to c##testweb;
alter user c##testweb
quota 1024m on users;


