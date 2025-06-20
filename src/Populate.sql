-- Disable foreign key checks temporarily to allow insertions in any order,
-- though it's best practice to insert in dependency order.
SET FOREIGN_KEY_CHECKS = 0;

-- --- Populate 'passenger' table ---
INSERT INTO passenger (created_at, updated_at, name, email, password, phone_number) VALUES
                                                                                        (NOW(), NOW(), 'Alice Smith', 'alice.s@example.com', 'hashedpass1', '9876543210'),
                                                                                        (NOW(), NOW(), 'Bob Johnson', 'bob.j@example.com', 'hashedpass2', '9876543211'),
                                                                                        (NOW(), NOW(), 'Charlie Brown', 'charlie.b@example.com', 'hashedpass3', '9876543212'),
                                                                                        (NOW(), NOW(), 'Diana Prince', 'diana.p@example.com', 'hashedpass4', '9876543213'),
                                                                                        (NOW(), NOW(), 'Eve Adams', 'eve.a@example.com', 'hashedpass5', '9876543214'),
                                                                                        (NOW(), NOW(), 'Frank White', 'frank.w@example.com', 'hashedpass6', '9876543215'),
                                                                                        (NOW(), NOW(), 'Grace Hopper', 'grace.h@example.com', 'hashedpass7', '9876543216'),
                                                                                        (NOW(), NOW(), 'Harry Potter', 'harry.p@example.com', 'hashedpass8', '9876543217'),
                                                                                        (NOW(), NOW(), 'Ivy League', 'ivy.l@example.com', 'hashedpass9', '9876543218'),
                                                                                        (NOW(), NOW(), 'Jack Daniels', 'jack.d@example.com', 'hashedpass10', '9876543219'),
                                                                                        (NOW(), NOW(), 'Karen Miller', 'karen.m@example.com', 'hashedpass11', '9876543220');


-- --- Populate 'driver' table ---
INSERT INTO driver (created_at, updated_at, name, licence_number, phone_number) VALUES
                                                                                    (NOW(), NOW(), 'Driver A', 'DL1234567890', '9911223300'),
                                                                                    (NOW(), NOW(), 'Driver B', 'DL0987654321', '9922334411'),
                                                                                    (NOW(), NOW(), 'Driver C', 'DL1122334455', '9933445522'),
                                                                                    (NOW(), NOW(), 'Driver D', 'DL5544332211', '9944556633'),
                                                                                    (NOW(), NOW(), 'Driver E', 'DL9876123450', '9955667744'),
                                                                                    (NOW(), NOW(), 'Driver F', 'DL1230987654', '9966778855'),
                                                                                    (NOW(), NOW(), 'Driver G', 'DL6789012345', '9977889966'),
                                                                                    (NOW(), NOW(), 'Driver H', 'DL5432109876', '9988990077'),
                                                                                    (NOW(), NOW(), 'Driver I', 'DL0011223344', '9900112288'),
                                                                                    (NOW(), NOW(), 'Driver J', 'DL4433221100', '9911220099');

-- --- Populate 'booking' table ---
-- Assuming passenger IDs are 1-11 and driver IDs are 1-10 from above insertions
INSERT INTO booking (created_at, updated_at, starting_time, ending_time, total_distance, driver_id, passenger_id, booking_status) VALUES
                                                                                                                                      (NOW(), NOW(), '2025-06-20 10:00:00', '2025-06-20 10:30:00', 10, 1, 1, 'COMPLETED'),
                                                                                                                                      (NOW(), NOW(), '2025-06-20 11:00:00', '2025-06-20 11:45:00', 15, 2, 2, 'SCHEDULED'),
                                                                                                                                      (NOW(), NOW(), '2025-06-20 12:00:00', '2025-06-20 12:15:00', 5, 3, 3, 'COMPLETED'),
                                                                                                                                      (NOW(), NOW(), '2025-06-20 13:00:00', NULL, 0, 4, 4, 'SCHEDULED'), -- Current booking
                                                                                                                                      (NOW(), NOW(), '2025-06-20 14:00:00', '2025-06-20 14:20:00', 8, 5, 5, 'CANCELLED'),
                                                                                                                                      (NOW(), NOW(), '2025-06-20 15:00:00', '2025-06-20 15:40:00', 12, 1, 6, 'COMPLETED'),
                                                                                                                                      (NOW(), NOW(), '2025-06-20 16:00:00', '2025-06-20 16:10:00', 3, 2, 7, 'SCHEDULED'),
                                                                                                                                      (NOW(), NOW(), '2025-06-20 17:00:00', '2025-06-20 17:50:00', 20, 3, 8, 'COMPLETED'),
                                                                                                                                      (NOW(), NOW(), '2025-06-20 18:00:00', NULL, 0, 4, 9, 'CAB_ARRIVED'),
                                                                                                                                      (NOW(), NOW(), '2025-06-20 19:00:00', '2025-06-20 19:35:00', 11, 5, 10, 'COMPLETED'),
                                                                                                                                      (NOW(), NOW(), '2025-06-20 20:00:00', NULL, 0, 6, 11, 'CAB_ARRIVED');


-- --- Populate 'review' table ---
-- Assuming booking IDs are 1-11
INSERT INTO review (created_at, updated_at, content, rating, booking_id) VALUES
                                                                             (NOW(), NOW(), 'Great ride, very comfortable!', 4.5, 1),
                                                                             (NOW(), NOW(), 'Driver was friendly and punctual.', 5.0, 2),
                                                                             (NOW(), NOW(), 'Smooth journey, but a bit slow.', 3.5, 3),
-- Booking ID 4 is CONFIRMED, no review yet.
                                                                             (NOW(), NOW(), 'Cancelled the ride, no review applicable.', NULL, 5), -- Rating can be NULL as per schema
                                                                             (NOW(), NOW(), 'Quick and efficient service.', 4.0, 6),
                                                                             (NOW(), NOW(), 'Short ride, got to destination quickly.', 4.8, 7),
                                                                             (NOW(), NOW(), 'Long ride, driver was professional.', 4.9, 8),
-- Booking ID 9 is PENDING, no review yet.
                                                                             (NOW(), NOW(), 'Enjoyed the ride, good conversation.', 4.2, 10);
-- Booking ID 11 is CONFIRMED, no review yet.

-- --- Populate 'driver_review' table ---
-- Note: 'driver_review' table has no direct foreign key to 'booking' or 'driver' based on your `DESC` output.
-- It appears to be a standalone review content table. If it's meant to be linked, you'd need a FK.
-- I'll just insert content.
INSERT INTO driver_review (created_at, updated_at, driver_review_content) VALUES
                                                                              (NOW(), NOW(), 'Excellent driving skills.'),
                                                                              (NOW(), NOW(), 'Driver was very polite and helpful.'),
                                                                              (NOW(), NOW(), 'Clean car and smooth ride.'),
                                                                              (NOW(), NOW(), 'Knowledgeable about the route.'),
                                                                              (NOW(), NOW(), 'A bit quiet, but professional.'),
                                                                              (NOW(), NOW(), 'Fast and efficient.'),
                                                                              (NOW(), NOW(), 'Good communication.'),
                                                                              (NOW(), NOW(), 'Very careful driver.'),
                                                                              (NOW(), NOW(), 'Pleasant journey.'),
                                                                              (NOW(), NOW(), 'Highly recommended driver.');


-- --- Populate 'passenger_review' table ---
-- Note: Similar to driver_review, 'passenger_review' table has no direct foreign key to 'booking' or 'passenger'.
-- It only has content and rating. If it's meant to be linked, you'd need a FK.
INSERT INTO passenger_review (created_at, updated_at, passenger_review_content, passenger_review_rating) VALUES
                                                                                                             (NOW(), NOW(), 'Passenger was on time and polite.', '5'), -- Assuming rating is stored as varchar
                                                                                                             (NOW(), NOW(), 'Easy to communicate with.', '4.5'),
                                                                                                             (NOW(), NOW(), 'A bit messy, but otherwise fine.', '3'),
                                                                                                             (NOW(), NOW(), 'Very friendly passenger.', '5'),
                                                                                                             (NOW(), NOW(), 'No issues, standard trip.', '4'),
                                                                                                             (NOW(), NOW(), 'Left no trash, good experience.', '4.8'),
                                                                                                             (NOW(), NOW(), 'Quiet but respectful.', '4'),
                                                                                                             (NOW(), NOW(), 'Pleasant conversation.', '5'),
                                                                                                             (NOW(), NOW(), 'Long wait time at pickup.', '2.5'),
                                                                                                             (NOW(), NOW(), 'Smooth drop-off.', '4.7');


-- Re-enable foreign key checks
SET FOREIGN_KEY_CHECKS = 1;

-- Optional: Verify data
-- SELECT * FROM passenger;
-- SELECT * FROM driver;
-- SELECT * FROM booking;
-- SELECT * FROM review;
-- SELECT * FROM driver_review;
-- SELECT * FROM passenger_review;