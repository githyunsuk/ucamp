--1.
select department_name 학과이름, category 계열, capacity 정원수
from tb_department
where capacity between 35 and 40
order by capacity desc;

--2.
select class_name 과목이름
from tb_class
where class_type = '전공선택' and preattending_class_no is not null
order by class_name;

--3.
select professor_no 교수번호, professor_name 교수이름, salary 연봉
from tb_professor
where salary between 85000000 and 100000000
order by professor_no;

--4.
select c.class_no 과목번호
from tb_class_professor c
join tb_professor p on c.professor_no = p.professor_no
where c.professor_no in ('P095','P102')
order by c.class_no desc;

--5. ??
select student_no 학생번호, student_name 학생이름
from tb_student
where coach_professor_no is null and absence_yn = 'N'
order by student_no desc;

--6.
select student_no 학생번호, point 성적
from tb_grade
where class_no = 'C4711500';

--7.
select distinct category as "학과계열"
from tb_department
order by category desc;

--8.
select student_no 학생번호, student_name 학생이름
from tb_student
where student_name like '정%'
order by student_no;

--9.
select class_no 과목번호, class_name 과목이름
from tb_class
where department_no = 'D008' and class_time not in (4,6)
order by class_no desc;

--10.
select class_no 과목번호, student_no 학생번호, point 성적
from tb_grade
where class_no in ('C0134700', 'C0108600') and point != 0
order by class_no desc;

--11.
select '학과번호 : ' || department_no 번호
from tb_department
where department_name = '물리학과';

--12.
select student_name || '의 주소는 ' || student_address || '입니다.' 주소
from tb_student
where substr(student_birth,4,1) = '3' and department_no='D008'
order by student_name desc;

--13.
select student_no 학생번호, student_name 학생이름
from tb_student
where student_name like '_기_' and department_no not in ('D045', 'D008')
order by student_no desc;

--14.
select department_name 학과이름, capacity + 30 as "증원된 정원"
from tb_department
where category = '인문사회';

--15.
select professor_no 교수번호, professor_name 교수이름, '월급 700만원 초과' as 월급
from tb_professor
where salary / 12 > 7000000
order by professor_no desc;

--16.
select class_name || '의 과목학점은 ' || class_grd || '입니다.' 과목학점
from tb_class
where preattending_class_no is not null and class_grd = 2;

--17.
select student_no 학생번호, student_name 학생이름
from tb_student
where coach_professor_no is null and substr(student_no, 1, 1) = 'W' and absence_yn = 'N';

--18.
select class_name 과목이름
from tb_class
where class_grd is null and class_time < 5 and class_type = '전공선택' and class_name like '%경영%'
order by class_name;

--19.
select student_no 학생번호, student_name 학생이름
from tb_student
where coach_professor_no is not null and absence_yn='Y' and student_name not like '김%'
order by student_name desc;

--20.
select distinct s.coach_professor_no "지도교수 번호"
from tb_department d
join tb_student s using(department_no)
where department_no='D045' and s.coach_professor_no is not null
order by s.coach_professor_no;

--21.
select sum(capacity) "전체 학과 정원"
from tb_department;

--22.
select round(avg(point),1) 평균성적
from tb_grade
where student_no='M253795' and point != 0;

--23.
select department_no 학과번호, sum(salary) 연봉합계
from tb_professor
group by department_no
having department_no is not null
order by department_no desc;

--24.
select professor_name 교수이름, salary 연봉
from tb_professor
where to_char(sysdate, 'YY') = to_char(hire_date, 'YY');

--25.
select student_name 학생이름, substr(student_birth,3,2) || '월' 생일
from tb_student
where substr(student_address, 1, 2)='부산';

--26.
select student_no 학생번호, sum(point) 성적합계
from tb_grade
group by student_no
having student_no in ('M377899', 'M330559')
order by student_no;

--27.
select count(*) 과목수
from tb_class
where class_type='전공선택' and class_grd between 3 and 5;

--28.
select student_name 학생이름, decode(coach_professor_no, null, '지도교수 없음', '지도교수 있음') "지도교수 여부"
from tb_student
where absence_yn = 'Y'
order by student_name desc;

--29.

--30.
select student_no 학생번호, avg(g.point) 평균학점
from tb_student s
join tb_grade g using(student_no)
group by student_no
having avg(g.point) >= 3
order by student_no;

--31.
select category, count(department_no) 학과수, sum(capacity) 정원
from tb_department
group by category
order by category desc;

--32.
select '최고 연봉은' || max(salary) || '원 입니다.' 연봉
from tb_professor;

--33.
select round(avg(salary), -3) || '원' 평균연봉
from tb_professor
where department_no not in ('D047', 'D055');

--34.
select count(*) "휴학인원 수"
from tb_student
where absence_yn = 'Y';

--35.
select student_no 학생번호, student_name 학생이름, decode(substr(student_no,1,1), 'M', 'Male', 'Female') 성별
from tb_student
where student_name like '김%' and absence_yn = 'N'
order by student_no desc;
