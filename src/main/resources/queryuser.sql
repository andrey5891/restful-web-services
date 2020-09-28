insert into user values (10001, sysdate(), 'Adam');
insert into user values (10002, sysdate(), 'Bob');
insert into user values (10003, sysdate(), 'Frank');

insert into post values (11001, 'Some post1', 10001);
insert into post values (11002, 'Some post2', 10001);

insert into post values (11004, 'Some post3', 10002);
insert into post values (11005, 'Some post4', 10002);
insert into post values (11006, 'Some post5', 10002);