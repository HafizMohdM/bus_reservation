create table esquare_Employees (
	uuid_ VARCHAR(75) null,
	employeeId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	employeeName VARCHAR(75) null,
	employeeMobileNumber VARCHAR(75) null,
	employeeDesignation VARCHAR(75) null,
	employeephoto VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null
);