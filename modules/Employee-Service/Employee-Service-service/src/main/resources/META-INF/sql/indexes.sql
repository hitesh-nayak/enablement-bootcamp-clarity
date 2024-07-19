create index IX_5C17BA62 on Company_Employee (companyName[$COLUMN_LENGTH:75$]);
create index IX_8CFB64A3 on Company_Employee (empLastName[$COLUMN_LENGTH:75$]);
create unique index IX_8691BE00 on Company_Employee (groupId, uuid_[$COLUMN_LENGTH:75$]);