create index IX_BF99622B on esquare_Employees (employeeDesignation[$COLUMN_LENGTH:75$]);
create index IX_29C23562 on esquare_Employees (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_5FBCAC64 on esquare_Employees (uuid_[$COLUMN_LENGTH:75$], groupId);