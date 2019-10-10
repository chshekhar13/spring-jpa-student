create table students(
studentId number(4),
studentName varchar2(10),
studentScore number(5)
)
insert into students values(1000,'ABC',50);
insert into students values(1001,'DEF',60);
insert into students values(1002,'GHI',55);

commit;

create table students1(
student_Id number(4),
student_Name varchar2(10),
student_Score number(5)
)
insert into students1 values(1000,'ABC',50);
insert into students1 values(1001,'DEF',60);
insert into students1 values(1002,'GHI',55);

commit;
