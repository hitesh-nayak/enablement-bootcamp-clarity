create table customObjService_StateObject (
	uuid_ VARCHAR(75) null,
	stateId LONG not null primary key,
	stateObjectDefId LONG,
	name VARCHAR(75) null,
	pinCode LONG,
	extRefId VARCHAR(75) null
);