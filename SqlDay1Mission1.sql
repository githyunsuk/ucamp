--04장

--Q1
/* SELECT문의 기본 구성인 SELECT절에는 조회할 열 또는 여러 열의 조합, 연산식을
   지정합니다. 그리고 FROM절에는 조회할 데이터가 저장된 테이블 이름을 지정합니다.
   지정할 열 이름이 너무 길다면 별도의 이름을 지정할 수 있으며 이를 별칭(이)라고 합니다. */
   
--Q2
select distinct job from emp;

--Q3
select empno as employee_no, ename as employee_name, mgr as manager, sal as salary,
comm as commission, deptno as department_no
from emp
order by deptno desc, ename;

--05장

--Q1
select * from emp
where ename like '%S';

--Q2
select empno, ename, job, sal, deptno
from emp
where deptno = 30 and job = 'SALESMAN';

--Q3
--집합연산자를 사용하지 않은 방식
select empno, ename, job, sal, deptno
from emp
where deptno in (20,30) and sal > 2000;

--집합연산자를 사용한 방식
select empno, ename, job, sal, deptno
from emp
where deptno = 20 and sal > 2000
union
select empno, ename, job, sal, deptno
from emp
where deptno = 30 and sal > 2000;

--Q4
select * from emp
where sal < 2000 or sal > 3000;

--Q5
select ename, empno, sal, deptno
from emp
where ename like '%E%' and deptno = 30 and sal not between 1000 and 2000;

--Q6
select * from emp
where comm is null and mgr is not null and job in ('MANAGER', 'CLERK') and ename not like '_L%';

