
--
-- Table structure for table `User`
--

CREATE TABLE IF NOT EXISTS `User` (
  `userId` int(25) NOT NULL AUTO_INCREMENT,
  `userName` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  `firstName` varchar(50) NOT NULL,
  `lastName` varchar(50) NOT NULL,
  `city` varchar(20) NOT NULL,
  `state` varchar(20) NOT NULL,
  `gender` varchar(10) NOT NULL,
  PRIMARY KEY (`userId`)
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 AUTO_INCREMENT=9 ;

--
-- Dumping data for table `User`
--

INSERT INTO `User` (`userId`, `userName`, `password`, `firstName`, `lastName`, `city`, `state`, `gender`) VALUES
(1, 'nag', '9fdc8b3f3027472d64e26a8e88fa2727', 'Nagarjuna', 'Bikkasani', 'Culver City', 'CA', 'M'),
(2, 'nag2', 'e3db8994fb67b9a5b58b97c27bd25b50', 'Nag', 'Bikk', 'Reno', 'NV', 'F'),
(3, 'chand', 'aeda6d66c337fa09f185719baa2334f9', 'Chandu', 'Channu', 'Reno', 'NV', 'F'),
(4, 'neymar', '70080aa08b4fe2b66aae3baea7e4a99f', 'Neymar', 'Da Silva Santos', 'Reno', 'NV', 'M'),
(5, 'messi', '1463ccd2104eeb36769180b8a0c86bb6', 'Messi', 'Lionel', 'Reno', 'NV', 'M'),
(6, 'marshawn', 'ac70e3f7022966dd5fc1ff5c3b394b87', 'Marshawn', 'Lynch', 'Seattle', 'WA', 'M'),
(7, 'tom', '34b7da764b21d298ef307d04d8152dc5', 'Tom', 'Brady', 'Seattle', 'WA', 'M'),
(8, 'nujitha', '2d4e356c0923bd9d786bd783057bff5b', 'Nujitha', 'Bikkasani', 'Seattle', 'WA', 'F');

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
