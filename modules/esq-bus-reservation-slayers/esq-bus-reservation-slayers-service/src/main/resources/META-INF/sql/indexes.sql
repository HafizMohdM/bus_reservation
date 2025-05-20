create index IX_9ADA7FA3 on BOOKRESERVATION_AuditLog (actionDate);

create index IX_3CAC1182 on BOOKRESERVATION_Booking (passengerId);
create index IX_CB51F929 on BOOKRESERVATION_Booking (scheduleId);

create index IX_AE944644 on BOOKRESERVATION_Bus (userId);

create index IX_B27AA321 on BOOKRESERVATION_BusUser (emailAddress[$COLUMN_LENGTH:75$]);
create index IX_722BEF3F on BOOKRESERVATION_BusUser (username[$COLUMN_LENGTH:75$]);

create index IX_3F814F5F on BOOKRESERVATION_Discount (code_[$COLUMN_LENGTH:75$]);

create index IX_757B83E4 on BOOKRESERVATION_Driver (userId);

create index IX_C1F7FCBA on BOOKRESERVATION_Passenger (passengerEmail[$COLUMN_LENGTH:75$]);
create index IX_C16560DE on BOOKRESERVATION_Passenger (userId);

create index IX_5160D7F4 on BOOKRESERVATION_Payment (bookingId);

create index IX_9C267CCD on BOOKRESERVATION_Seat (scheduleId);

create index IX_9A001938 on BOOKRESERVATION_TravelSchedule (busId);

create index IX_17546D79 on BOOKRESERVATION_User (emailAddress[$COLUMN_LENGTH:75$]);
create index IX_5378A597 on BOOKRESERVATION_User (username[$COLUMN_LENGTH:75$]);