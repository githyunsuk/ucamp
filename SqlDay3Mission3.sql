--Q1.
SELECT s.student_name 학생이름, d.department_name 학과이름
FROM tb_student s, tb_department d
WHERE d.department_no = s.department_no
AND d.category = '자연과학'
ORDER BY d.department_name;

--Q2.
select c.class_name 과목이름, d.department_name 학과이름
from tb_class c
join tb_department d using(department_no)
where d.department_name = '법학과' 
and c.class_time >= 4
order by c.class_name;

--Q3.
select p.professor_name 교수이름, d.department_name 학과이름,
case when p.salary > 85000000 then 'A'
     when p.salary > 80000000 then 'B'
     else 'C'
     end 레벨 
from tb_professor p, tb_department d
where p.department_no = d.department_no
and d.department_name = '컴퓨터공학과'
order by p.professor_name desc;

--Q4.
select round(avg(g.point), 1) 평균성적
from tb_class c
join tb_grade g using(class_no)
where c.class_name = '거시경제론';

--Q5.
select class_no 과목번호, decode(class_type, '전공필수', '3학점', '2학점') 학점
from tb_class
where class_time is not null
and class_grd is null
order by class_no desc;

--Q6
select c1.class_no 과목번호, c1.class_name 과목이름, c2.class_name 선수과목이름
from tb_class c1
join tb_class c2 on c1.preattending_class_no = c2.class_no
order by 1 desc;

--Q7
select professor_name 교수이름, salary 연봉
from tb_professor
where department_no is null;

--Q8
select s.student_no 학생번호, s.student_name 학생이름
from tb_student s, tb_professor p
where s.coach_professor_no = p.professor_no
and p.professor_name = '이양희'
and s.absence_yn = 'N'
order by s.student_no desc;

--Q9.
select d.department_name 학과이름, sum(p.salary) 연봉합계
from tb_professor p, tb_department d
where p.department_no = d.department_no
group by d.department_name
having sum(p.salary) >= 300000000
order by d.department_name desc;

--Q10.
select student_no, student_name
from tb_student
where (absence_yn = 'N' and student_address like '부산%') 
or (absence_yn = 'Y' and student_address like '경상북도%')
order by student_no desc;

--Q11.
select d.department_name 학과이름, s.student_name 학생이름, s.student_no 학생번호
from tb_student s
join tb_department d using(department_no)
where (substr(s.student_birth, 4, 1), d.department_name) in (('7', '경영학과'), ('6', '물리학과'))
order by d.department_name desc, s.student_name desc;

--Q12.
select class_name 과목이름
from tb_class
where length(class_name) > 5
and class_time >= 5
order by class_name desc;

--Q13.
select student_name 학생이름, substr(student_birth, 3, 2) || '월' 생일
from tb_student
where student_name like '박%'
and student_address like '서울%'
and absence_yn = 'N'
order by 2;

--Q14.
select c.class_name 과목이름, p.professor_name 교수이름
from tb_class c
join tb_class_professor cp using(class_no)
join tb_professor p using(professor_no)
where c.class_name = '재무관리'
order by p.professor_name;

--Q15.
select c.class_name 과목이름, p.professor_name 교수이름, g.point 성적
from tb_student s
join tb_grade g using(student_no)
join tb_class c using(class_no)
join tb_professor p using(professor_no)
where s.student_name = '김수광'
order by c.class_name;










