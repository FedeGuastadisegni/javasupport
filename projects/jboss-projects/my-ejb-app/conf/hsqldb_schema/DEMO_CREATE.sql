CREATE TABLE EMPLOYEES (
    EMPLOYEE_ID INTEGER IDENTITY NOT NULL
    , FIRST_NAME VARCHAR(20)
    , LAST_NAME VARCHAR(25) NOT NULL
    , EMAIL VARCHAR(25) NULL
    , PHONE_NUMBER VARCHAR(20)
    , HIRE_DATE DATE NULL
    , SALARY DECIMAL(8,2)
);
