INSERT INTO analytics (id, timestamp, user_id, status, error_message, request, response)
VALUES
(1, '2023-12-06T00:00:00', 'John Smith', 'Success', null, 'Initial request', 'Initial response'),
(2, '2023-12-06T00:15:00', 'Emma Johnson', 'Success', 'Error occurred 1', 'Request 1', 'Response 1'),
(3, '2023-12-06T00:30:00', 'Michael Williams', 'Success', null, 'Test request 1', 'Test response 1'),
(4, '2023-12-06T00:45:00', 'Sophia Brown', 'Success', 'Error occurred 2', 'Request 2', 'Response 2'),
(5, '2023-12-06T01:00:00', 'Liam Jones', 'Success', null, 'Another request', 'Another response'),
(6, '2023-12-06T01:15:00', 'Olivia Davis', 'Success', 'Error occurred 3', 'Request 3', 'Response 3'),
(7, '2023-12-06T01:30:00', 'William Wilson', 'Success', null, 'Yet another request', 'Yet another response'),
(8, '2023-12-06T01:45:00', 'Ella Sanchez', 'Success', 'Error occurred 4', 'Request 4', 'Response 4'),
(9, '2023-12-06T02:00:00', 'Alexander Jackson', 'Success', null, 'New test request', 'New test response'),
(10, '2023-12-06T02:15:00', 'Chloe Reed', 'Success', 'Error occurred 5', 'Request 5', 'Response 5'),
(11, '2023-12-06T02:30:00', 'Jacob Scott', 'Success', null, 'Request A', 'Response A'),
(12, '2023-12-06T02:45:00', 'Grace Morales', 'Success', 'Error occurred 6', 'Request B', 'Response B'),
(13, '2023-12-06T03:00:00', 'Aiden Hill', 'Success', null, 'Request C', 'Response C'),
(14, '2023-12-06T03:15:00', 'Avery Sullivan', 'Success', 'Error occurred 7', 'Request D', 'Response D'),
(15, '2023-12-06T03:30:00', 'Scarlett Clark', 'Success', null, 'Request E', 'Response E'),
(16, '2023-12-06T03:45:00', 'Luke Mitchell', 'Success', 'Error occurred 8', 'Request F', 'Response F'),
(17, '2023-12-06T04:00:00', 'Lily Adams', 'Success', null, 'Request G', 'Response G'),
(18, '2023-12-06T04:15:00', 'John Smith', 'Success', 'Error occurred 9', 'Request H', 'Response H'),
(19, '2023-12-06T04:30:00', 'Emma Johnson', 'Success', null, 'Request I', 'Response I'),
(20, '2023-12-06T04:45:00', 'Michael Williams', 'Success', 'Error occurred 10', 'Request J', 'Response J'),
(21, '2023-12-06T05:00:00', 'Sophia Brown', 'Success', null, 'Request K', 'Response K'),
(22, '2023-12-06T05:15:00', 'Liam Jones', 'Success', 'Error occurred 11', 'Request L', 'Response L'),
(23, '2023-12-06T05:30:00', 'Olivia Davis', 'Success', null, 'Request M', 'Response M'),
(24, '2023-12-06T05:45:00', 'William Wilson', 'Success', 'Error occurred 12', 'Request N', 'Response N'),
(25, '2023-12-06T06:00:00', 'Ella Sanchez', 'Success', null, 'Request O', 'Response O'),
(26, '2023-12-06T06:15:00', 'Alexander Jackson', 'Success', 'Error occurred 13', 'Request P', 'Response P'),
(27, '2023-12-06T06:30:00', 'Chloe Reed', 'Success', null, 'Request Q', 'Response Q'),
(28, '2023-12-06T06:45:00', 'Jacob Scott', 'Success', 'Error occurred 14', 'Request R', 'Response R'),
(29, '2023-12-06T07:00:00', 'Grace Morales', 'Success', null, 'Request S', 'Response S'),
(30, '2023-12-06T07:15:00', 'Aiden Hill', 'Success', 'Error occurred 15', 'Request T', 'Response T'),
(31, '2023-12-06T07:30:00', 'Avery Sullivan', 'Success', null, 'Request U', 'Response U'),
(32, '2023-12-06T07:45:00', 'Scarlett Clark', 'Failure', 'Error occurred 16', 'Request V', 'Response V'),
(33, '2023-12-06T08:00:00', 'Luke Mitchell', 'Success', null, 'Request W', 'Response W'),
(34, '2023-12-06T08:15:00', 'Lily Adams', 'Failure', 'Error occurred 17', 'Request X', 'Response X'),
(35, '2023-12-06T08:30:00', 'John Smith', 'Success', null, 'Request Y', 'Response Y'),
(36, '2023-12-06T08:45:00', 'Emma Johnson', 'Failure', 'Error occurred 18', 'Request Z', 'Response Z'),
(37, '2023-12-06T09:00:00', 'Michael Williams', 'Success', null, 'Request AA', 'Response AA'),
(38, '2023-12-06T09:15:00', 'Sophia Brown', 'Failure', 'Error occurred 19', 'Request AB', 'Response AB'),
(39, '2023-12-06T09:30:00', 'Liam Jones', 'Success', null, 'Request AC', 'Response AC'),
(40, '2023-12-06T09:45:00', 'Olivia Davis', 'Failure', 'Error occurred 20', 'Request AD', 'Response AD'),
(41, '2023-12-06T10:00:00', 'William Wilson', 'Success', null, 'Request AE', 'Response AE'),
(42, '2023-12-06T10:15:00', 'Ella Sanchez', 'Failure', 'Error occurred 21', 'Request AF', 'Response AF'),
(43, '2023-12-06T10:30:00', 'Alexander Jackson', 'Success', null, 'Request AG', 'Response AG'),
(44, '2023-12-06T10:45:00', 'Chloe Reed', 'Failure', 'Error occurred 22', 'Request AH', 'Response AH'),
(45, '2023-12-06T11:00:00', 'Jacob Scott', 'Success', null, 'Request AI', 'Response AI'),
(46, '2023-12-06T11:15:00', 'Grace Morales', 'Failure', 'Error occurred 23', 'Request AJ', 'Response AJ'),
(47, '2023-12-06T11:30:00', 'Aiden Hill', 'Success', null, 'Request AK', 'Response AK'),
(48, '2023-12-06T11:45:00', 'Avery Sullivan', 'Failure', 'Error occurred 24', 'Request AL', 'Response AL'),
(49, '2023-12-06T12:00:00', 'Scarlett Clark', 'Success', null, 'Request AM', 'Response AM'),
(50, '2023-12-06T12:15:00', 'Luke Mitchell', 'Failure', 'Error occurred 25', 'Request AN', 'Response AN'),
(51, '2023-12-06T12:30:00', 'Lily Adams', 'Success', null, 'Request AO', 'Response AO'),
(52, '2023-12-06T12:45:00', 'John Smith', 'Failure', 'Error occurred 26', 'Request AP', 'Response AP'),
(53, '2023-12-06T13:00:00', 'Emma Johnson', 'Success', null, 'Request AQ', 'Response AQ'),
(54, '2023-12-06T13:15:00', 'Michael Williams', 'Failure', 'Error occurred 27', 'Request AR', 'Response AR'),
(55, '2023-12-06T13:30:00', 'Sophia Brown', 'Success', null, 'Request AS', 'Response AS'),
(56, '2023-12-06T13:45:00', 'Liam Jones', 'Failure', 'Error occurred 28', 'Request AT', 'Response AT'),
(57, '2023-12-06T14:00:00', 'Olivia Davis', 'Success', null, 'Request AU', 'Response AU'),
(58, '2023-12-06T14:15:00', 'William Wilson', 'Failure', 'Error occurred 29', 'Request AV', 'Response AV'),
(59, '2023-12-06T14:30:00', 'Ella Sanchez', 'Success', null, 'Request AW', 'Response AW'),
(60, '2023-12-06T14:45:00', 'Alexander Jackson', 'Failure', 'Error occurred 30', 'Request AX', 'Response AX'),
(61, '2023-12-06T15:00:00', 'Chloe Reed', 'Success', null, 'Request AY', 'Response AY'),
(62, '2023-12-06T15:15:00', 'Jacob Scott', 'Failure', 'Error occurred 31', 'Request AZ', 'Response AZ'),
(63, '2023-12-06T15:30:00', 'Grace Morales', 'Success', null, 'Request BA', 'Response BA'),
(64, '2023-12-06T15:45:00', 'Aiden Hill', 'Failure', 'Error occurred 32', 'Request BB', 'Response BB'),
(65, '2023-12-06T16:00:00', 'Avery Sullivan', 'Success', null, 'Request BC', 'Response BC'),
(66, '2023-12-06T16:15:00', 'Scarlett Clark', 'Failure', 'Error occurred 33', 'Request BD', 'Response BD'),
(67, '2023-12-06T16:30:00', 'Luke Mitchell', 'Success', null, 'Request BE', 'Response BE'),
(68, '2023-12-06T16:45:00', 'Lily Adams', 'Failure', 'Error occurred 34', 'Request BF', 'Response BF'),
(69, '2023-12-06T17:00:00', 'John Smith', 'Success', null, 'Request BG', 'Response BG'),
(70, '2023-12-06T17:15:00', 'Emma Johnson', 'Failure', 'Error occurred 35', 'Request BH', 'Response BH'),
(71, '2023-12-06T17:30:00', 'Michael Williams', 'Success', null, 'Request BI', 'Response BI'),
(72, '2023-12-06T17:45:00', 'Sophia Brown', 'Failure', 'Error occurred 36', 'Request BJ', 'Response BJ'),
(73, '2023-12-06T18:00:00', 'Liam Jones', 'Success', null, 'Request BK', 'Response BK'),
(74, '2023-12-06T18:15:00', 'Olivia Davis', 'Failure', 'Error occurred 37', 'Request BL', 'Response BL'),
(75, '2023-12-06T18:30:00', 'William Wilson', 'Success', null, 'Request BM', 'Response BM'),
(76, '2023-12-06T18:45:00', 'Ella Sanchez', 'Failure', 'Error occurred 38', 'Request BN', 'Response BN'),
(77, '2023-12-06T19:00:00', 'Alexander Jackson', 'Success', null, 'Request BO', 'Response BO'),
(78, '2023-12-06T19:15:00', 'Chloe Reed', 'Failure', 'Error occurred 39', 'Request BP', 'Response BP'),
(79, '2023-12-06T19:30:00', 'Jacob Scott', 'Success', null, 'Request BQ', 'Response BQ'),
(80, '2023-12-06T19:45:00', 'Grace Morales', 'Failure', 'Error occurred 40', 'Request BR', 'Response BR'),
(81, '2023-12-06T20:00:00', 'Aiden Hill', 'Success', null, 'Request BS', 'Response BS'),
(82, '2023-12-06T20:15:00', 'Avery Sullivan', 'Failure', 'Error occurred 41', 'Request BT', 'Response BT'),
(83, '2023-12-06T20:30:00', 'Scarlett Clark', 'Success', null, 'Request BU', 'Response BU'),
(84, '2023-12-06T20:45:00', 'Luke Mitchell', 'Failure', 'Error occurred 42', 'Request BV', 'Response BV'),
(85, '2023-12-06T21:00:00', 'Lily Adams', 'Success', null, 'Request BW', 'Response BW'),
(86, '2023-12-06T21:15:00', 'John Smith', 'Failure', 'Error occurred 43', 'Request BX', 'Response BX'),
(87, '2023-12-06T21:30:00', 'Emma Johnson', 'Success', null, 'Request BY', 'Response BY'),
(88, '2023-12-06T21:45:00', 'Michael Williams', 'Failure', 'Error occurred 44', 'Request BZ', 'Response BZ'),
(89, '2023-12-06T22:00:00', 'Sophia Brown', 'Success', null, 'Request CA', 'Response CA'),
(90, '2023-12-06T22:15:00', 'Liam Jones', 'Failure', 'Error occurred 45', 'Request CB', 'Response CB'),
(91, '2023-12-06T22:30:00', 'Olivia Davis', 'Success', null, 'Request CC', 'Response CC'),
(92, '2023-12-06T22:45:00', 'William Wilson', 'Success', 'Error occurred 46', 'Request CD', 'Response CD'),
(93, '2023-12-06T23:00:00', 'Ella Sanchez', 'Success', null, 'Request CE', 'Response CE'),
(94, '2023-12-06T23:15:00', 'Alexander Jackson', 'Success', 'Error occurred 47', 'Request CF', 'Response CF'),
(95, '2023-12-06T23:30:00', 'Chloe Reed', 'Success', null, 'Request CG', 'Response CG'),
(96, '2023-12-06T23:45:00', 'Jacob Scott', 'Success', 'Error occurred 48', 'Request CH', 'Response CH'),
(97, '2023-12-07T00:00:00', 'Grace Morales', 'Success', null, 'Request CI', 'Response CI'),
(98, '2023-12-07T00:15:00', 'Aiden Hill', 'Success', 'Error occurred 49', 'Request CJ', 'Response CJ'),
(99, '2023-12-07T00:30:00', 'Avery Sullivan', 'Success', null, 'Request CK', 'Response CK'),
(100, '2023-12-07T00:45:00', 'Scarlett Clark', 'Success', 'Error occurred 50', 'Request CL', 'Response CL');