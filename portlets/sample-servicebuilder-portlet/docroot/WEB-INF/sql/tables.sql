create table Sample_Degree (
	degreeId LONG not null primary key,
	degreeName VARCHAR(75) null
);

create table Sample_Education (
	educationId LONG not null primary key,
	userId LONG,
	schoolName VARCHAR(75) null,
	degreeId LONG,
	majorId LONG,
	graduateYear VARCHAR(75) null
);

create table Sample_Honour (
	honourId LONG not null primary key,
	honoraryName VARCHAR(75) null,
	recommender VARCHAR(75) null,
	introduction VARCHAR(75) null,
	userId LONG
);

create table Sample_Major (
	majorId LONG not null primary key,
	majorName VARCHAR(75) null
);

create table Sample_Property (
	propertyId LONG not null primary key,
	propertyName VARCHAR(75) null,
	userId LONG
);

create table Sample_Thesis (
	thesisId LONG not null primary key,
	thesisName VARCHAR(75) null,
	userId LONG
);