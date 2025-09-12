--Q1.
select professor_no 교수번호, professor_name 교수이름, round(salary / 12, -3) 월급여
from tb_professor
where salary = (select max(salary) from tb_professor);

--Q2.
select student_no 학생번호, student_name 학생이름
from tb_student
where department_no in (select department_no from tb_department where department_name in ('경영학과', '물리학과'))
and absence_yn = 'N'
and coach_professor_no is null
order by student_no desc;

--Q3
select sum(salary) 연봉합계
from tb_professor
where department_no in (select department_no from tb_department where capacity between 25 and 30);

--Q4
select
    (select max(g.point)
     from tb_grade g
     where g.student_no = 'M253795') "M253795 최고성적",
    (select min(g.point)
     from tb_grade g
     where g.student_no = 'M330559') "M330559 최저성적"
from dual; 


--Q5
select d.department_name 학과이름, d.category 학과계열
from tb_department d
join tb_student s using(department_no)
group by d.department_name, d.category
having count(*) = (
    select min(cnt)
    from (select count(*) cnt from tb_student group by department_no))
order by d.department_name desc;

--Q6
select d.department_name 학과이름, c.class_name 과목이름
from tb_class c
join tb_department d using(department_no)
where c.class_name in (
    select class_name
    from tb_class
    group by class_name
    having count(distinct department_no) > 1)
order by d.department_name;

select d.department_name 학과이름, c1.class_name 과목이름
from tb_class c1
join tb_class c2 on c1.class_name = c2.class_name and c1.department_no != c2.department_no
join tb_department d on c1.department_no = d.department_no
order by d.department_name;

--Q7
select c.class_no 과목번호,
case when c.class_grd >= 4 or c.class_time >= 5 then '중요과목'
     else '일반과목'
     end 구분
from tb_class c
join tb_department d using(department_no)
where c.class_type = '전공필수'
and d.department_name = '법학과'
order by c.class_no;

--Q8
select d.department_name 학과이름, avg(p.salary) 평균연봉
from tb_professor p
join tb_department d using(department_no)
group by d.department_name
having d.department_name in ('물리학과', '경영학과')
order by d.department_name desc;

--Q9
select '전체 교수의 수는' || count(*) || '명이고 평균 연봉은 ' || round(avg(salary),-3) || '원 이다.' 정보
from tb_professor;

--Q10
select s.student_name 학생이름, s.student_address 학생주소
from tb_student s
join tb_department d on s.department_no = d.department_no
where d.department_name = '무역학과'
and s.absence_yn = 'N'
and s.entrance_date = (
    select max(entrance_date)
    from tb_student s2
    join tb_department d2 on s2.department_no = d2.department_no
    where d2.department_name = '무역학과'
    and s2.absence_yn = 'N'
);

select s.student_name 학생이름, s.student_address 학생주소
from tb_student s
join tb_department d using(department_no)
where d.department_name = '무역학과'
and s.absence_yn = 'N'
order by s.entrance_date desc
fetch next 1 rows only;











