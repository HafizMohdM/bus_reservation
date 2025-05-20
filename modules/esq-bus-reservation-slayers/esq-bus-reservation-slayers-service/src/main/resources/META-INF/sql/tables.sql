create table BOOKRESERVATION_AdminSetting (
	settingId LONG not null primary key,
	key_ VARCHAR(75) null,
	value VARCHAR(75) null
);

create table BOOKRESERVATION_AuditLog (
	auditId LONG not null primary key,
	entityName VARCHAR(75) null,
	entityId LONG,
	action VARCHAR(75) null,
	userId LONG,
	actionDate DATE null
);

create table BOOKRESERVATION_Booking (
	bookingId LONG not null primary key,
	scheduleId LONG,
	passengerId LONG,
	numberOfSeats INTEGER,
	fareAmount DOUBLE,
	totalAmount DOUBLE,
	dateOfBooking DATE null,
	bookingStatus INTEGER,
	userId LONG
);

create table BOOKRESERVATION_Bus (
	busId LONG not null primary key,
	busNumber VARCHAR(75) null,
	busPlateNumber VARCHAR(75) null,
	busType INTEGER,
	capacity INTEGER,
	userId LONG,
	image1 VARCHAR(75) null,
	image2 VARCHAR(75) null,
	image3 VARCHAR(75) null,
	image4 VARCHAR(75) null,
	image5 VARCHAR(75) null
);

create table BOOKRESERVATION_BusUser (
	userId LONG not null primary key,
	fullName VARCHAR(75) null,
	contactNo VARCHAR(75) null,
	emailAddress VARCHAR(75) null,
	username VARCHAR(75) null,
	userpassword VARCHAR(75) null,
	accountCategory INTEGER,
	accountStatus INTEGER
);

create table BOOKRESERVATION_Discount (
	discountId LONG not null primary key,
	code_ VARCHAR(75) null,
	percentage DOUBLE,
	validFrom DATE null,
	validTo DATE null
);

create table BOOKRESERVATION_Driver (
	driverId LONG not null primary key,
	driverName VARCHAR(75) null,
	driverContact VARCHAR(75) null,
	userId LONG
);

create table BOOKRESERVATION_DriverLog (
	logId LONG not null primary key,
	driverId LONG,
	tripDate DATE null,
	scheduleId LONG
);

create table BOOKRESERVATION_Feedback (
	feedbackId LONG not null primary key,
	passengerId LONG,
	bookingId LONG,
	rating INTEGER,
	comment_ VARCHAR(75) null
);

create table BOOKRESERVATION_Location (
	locationId LONG not null primary key,
	city VARCHAR(75) null,
	station VARCHAR(75) null
);

create table BOOKRESERVATION_Notification (
	notificationId LONG not null primary key,
	userId LONG,
	message VARCHAR(75) null,
	type_ VARCHAR(75) null,
	sentDate DATE null
);

create table BOOKRESERVATION_Passenger (
	passengerId LONG not null primary key,
	passengerName VARCHAR(75) null,
	passengerContact VARCHAR(75) null,
	passengerEmail VARCHAR(75) null,
	username VARCHAR(75) null,
	password_ VARCHAR(75) null,
	accountStatus INTEGER,
	userId LONG
);

create table BOOKRESERVATION_Payment (
	paymentId LONG not null primary key,
	bookingId LONG,
	amountPaid DOUBLE,
	paymentDate DATE null,
	userId LONG
);

create table BOOKRESERVATION_RefundRequest (
	requestId LONG not null primary key,
	bookingId LONG,
	reason VARCHAR(75) null,
	status VARCHAR(75) null,
	requestDate DATE null
);

create table BOOKRESERVATION_Route (
	routeId LONG not null primary key,
	startLocationId LONG,
	endLocationId LONG,
	distanceKm DOUBLE
);

create table BOOKRESERVATION_Seat (
	seatId LONG not null primary key,
	scheduleId LONG,
	seatNumber VARCHAR(75) null,
	isBooked BOOLEAN
);

create table BOOKRESERVATION_SupportTicket (
	supportTicketId LONG not null primary key,
	userId LONG,
	subject VARCHAR(75) null,
	message VARCHAR(75) null,
	status VARCHAR(75) null,
	createdDate DATE null
);

create table BOOKRESERVATION_Ticket (
	ticketId LONG not null primary key,
	bookingId LONG,
	qrCode VARCHAR(75) null,
	issuedDate DATE null
);

create table BOOKRESERVATION_TransactionLog (
	logId LONG not null primary key,
	action VARCHAR(75) null,
	timestamp DATE null,
	userId LONG,
	bookingId LONG
);

create table BOOKRESERVATION_TravelSchedule (
	scheduleId LONG not null primary key,
	busId LONG,
	driverId LONG,
	startingPoint VARCHAR(75) null,
	destination VARCHAR(75) null,
	scheduleDate DATE null,
	departureTime DATE null,
	estimatedArrivalTime DATE null,
	fareAmount DOUBLE,
	remarks VARCHAR(75) null,
	userId LONG
);

create table BOOKRESERVATION_User (
	userId LONG not null primary key,
	fullName VARCHAR(75) null,
	contactNo VARCHAR(75) null,
	emailAddress VARCHAR(75) null,
	username VARCHAR(75) null,
	userpassword VARCHAR(75) null,
	accountCategory INTEGER,
	accountStatus INTEGER
);

create table BOOKRESERVATION_UserRole (
	userRoleId LONG not null primary key,
	userId LONG,
	roleName VARCHAR(75) null
);