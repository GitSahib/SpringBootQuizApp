-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Oct 27, 2016 at 04:51 PM
-- Server version: 10.1.13-MariaDB
-- PHP Version: 5.6.20

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `mems_db`
--

-- --------------------------------------------------------

--
-- Table structure for table `choice`
--

CREATE TABLE `choice` (
  `id` bigint(20) NOT NULL,
  `updated_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `choice_marks` int(11) NOT NULL,
  `correct` bit(1) NOT NULL,
  `text` varchar(300) NOT NULL,
  `question_id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `choice`
--

INSERT INTO `choice` (`id`, `updated_time`, `choice_marks`, `correct`, `text`, `question_id`) VALUES
(3, '2016-10-27 03:21:11', 3, b'1', 'Run advice after a method execution only if method exits by throwing an exception.', 14),
(4, '2016-10-27 03:21:11', 0, b'0', 'Run advice after a class loads only if class throws exception during load time.', 14),
(5, '2016-10-27 03:21:11', 0, b'0', 'Run advice after http response is returned with error status.', 14),
(6, '2016-10-27 03:21:21', 3, b'1', 'The functions that span multiple points of an application are called cross cutting concerns.', 15),
(7, '2016-10-27 03:21:21', 0, b'0', 'Cross-cutting concerns are conceptually separate from the application''s business logic.', 15),
(8, '2016-10-27 03:21:21', 0, b'0', 'Logging is one of the examples of cross cutting concerns.', 15),
(13, '2016-10-27 03:21:21', 0, b'0', 'All of the above.', 15),
(14, '2016-10-27 03:21:31', 3, b'1', 'XmlBeanFactory', 16),
(15, '2016-10-27 03:21:31', 0, b'0', 'ClassPathBeanFactory', 16),
(16, '2016-10-27 03:21:31', 0, b'0', 'FileSystemBeanFactory', 16),
(17, '2016-10-27 03:21:31', 0, b'0', 'AdvancedBeanFactory', 16),
(18, '2016-10-27 03:21:40', 0, b'0', 'This helps in wiring a list of values, allowing duplicates.', 17),
(19, '2016-10-27 03:21:40', 0, b'0', 'This helps in wiring a list of values but without any duplicates.', 17),
(20, '2016-10-27 03:21:41', 3, b'1', 'This can be used to inject a collection of name-value pairs where name and value can be of any type.', 17),
(21, '2016-10-27 03:21:41', 0, b'0', 'This tag is not supported.', 17),
(22, '2016-10-27 03:21:50', 0, b'0', 'This annotation indicates that bean property must be populated by the user.', 18),
(23, '2016-10-27 03:21:50', 0, b'0', 'This annotation indicates that bean property is required while saving the bean data to database.', 18),
(24, '2016-10-27 03:21:50', 3, b'1', 'This annotation simply indicates that the affected bean property must be populated at configuration time, through an explicit property value in a bean definition or through autowiring.', 18),
(25, '2016-10-27 03:21:50', 0, b'0', 'This annotation indicates that bean property is required while serializing the bean.', 18),
(26, '2016-10-27 03:21:02', 0, b'0', 'This event is published when the Servlet Context is either initialized or refreshed.', 2),
(27, '2016-10-27 03:21:02', 0, b'0', 'This event is published when the HTTP Request is received.', 2),
(28, '2016-10-27 03:21:02', 0, b'0', 'This event is published when the HTTP Response is returned.', 2),
(29, '2016-10-27 03:21:02', 0, b'1', 'This event is published when the ApplicationContext is either initialized or refreshed.', 2),
(30, '2016-10-27 03:21:11', 0, b'0', 'Run advice after http request is processed and an exception occurred.', 14),
(31, '2016-10-27 03:28:43', 2, b'1', 'True', 30),
(32, '2016-10-27 03:28:43', 0, b'0', 'False', 30);

-- --------------------------------------------------------

--
-- Table structure for table `contact`
--

CREATE TABLE `contact` (
  `id` bigint(20) NOT NULL,
  `updatedTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `email` varchar(255) DEFAULT NULL,
  `message` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `subject` varchar(255) DEFAULT NULL,
  `updated_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `question`
--

CREATE TABLE `question` (
  `id` bigint(20) NOT NULL,
  `updated_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `text` varchar(3000) NOT NULL,
  `total_marks` int(11) NOT NULL,
  `type` varchar(255) DEFAULT NULL,
  `quiz_id` bigint(20) DEFAULT NULL,
  `subject_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `question`
--

INSERT INTO `question` (`id`, `updated_time`, `text`, `total_marks`, `type`, `quiz_id`, `subject_id`) VALUES
(2, '2016-10-27 03:21:02', '<p><span style="font-family: Verdana, Geneva, Tahoma, Arial, Helvetica, sans-serif; font-size: 15px; font-weight: bold; text-align: justify;">What is ContextRefreshedEvent event?</span><br></p>', 3, 'MULTIPLE_CHOICE', NULL, 2),
(14, '2016-10-27 03:21:11', '<p><span style="font-family: Verdana, Geneva, Tahoma, Arial, Helvetica, sans-serif; font-size: 15px; font-weight: bold; text-align: justify;">How after-throwing advice works?</span><br></p>', 3, 'MULTIPLE_CHOICE', NULL, 2),
(15, '2016-10-27 03:21:21', '<p><span style="font-family: Verdana, Geneva, Tahoma, Arial, Helvetica, sans-serif; font-size: 15px; font-weight: bold; text-align: justify;">What is true about cross-cutting concerns?</span><br></p>', 3, 'MULTIPLE_CHOICE', NULL, 2),
(16, '2016-10-27 03:21:31', '<p><span style="font-family: Verdana, Geneva, Tahoma, Arial, Helvetica, sans-serif; font-size: 15px; font-weight: bold; text-align: justify;">Which is the correct implementation class of BeanFactory?</span><br></p>', 3, 'MULTIPLE_CHOICE', NULL, 2),
(17, '2016-10-27 03:21:40', '<p><span style="font-family: Verdana, Geneva, Tahoma, Arial, Helvetica, sans-serif; font-size: 15px; font-weight: bold; text-align: justify;">What is true about &lt;map&gt; collection configuration elements?</span><br></p>', 3, 'MULTIPLE_CHOICE', NULL, 2),
(18, '2016-10-27 03:21:50', '<p><span style="font-family: Verdana, Geneva, Tahoma, Arial, Helvetica, sans-serif; font-size: 15px; font-weight: bold; text-align: justify;">What does @Required annotation mean?</span><br></p>', 3, 'MULTIPLE_CHOICE', NULL, 2),
(19, '2016-10-27 03:20:54', '<p><span style="font-family: Verdana, Geneva, Tahoma, Arial, Helvetica, sans-serif; font-size: 15.4px; background-color: rgb(244, 244, 244);">What is Spring?</span><br></p>', 5, 'SHORT_QUESTION', NULL, 2),
(20, '2016-10-27 03:22:27', '<p><span style="font-family: Verdana, Geneva, Tahoma, Arial, Helvetica, sans-serif; font-size: 15.4px; background-color: rgb(244, 244, 244);">What are benefits of using spring?</span><br></p>', 5, 'SHORT_QUESTION', NULL, 2),
(21, '2016-10-27 03:23:22', '<p><span style="font-family: Verdana, Geneva, Tahoma, Arial, Helvetica, sans-serif; font-size: 15.4px; background-color: rgb(244, 244, 244);">What are the different modules in Spring framework?</span><br></p>', 5, 'SHORT_QUESTION', NULL, 2),
(22, '2016-10-27 03:23:12', '<p><span style="font-family: Verdana, Geneva, Tahoma, Arial, Helvetica, sans-serif; font-size: 15.4px; background-color: rgb(244, 244, 244);">What is Spring configuration file?</span><br></p>', 5, 'SHORT_QUESTION', NULL, 2),
(23, '2016-10-27 03:23:40', '<p><span style="font-family: Verdana, Geneva, Tahoma, Arial, Helvetica, sans-serif; font-size: 15.4px; background-color: rgb(244, 244, 244);">What is Dependency Injection?</span><br></p>', 5, 'SHORT_QUESTION', NULL, 2),
(24, '2016-10-27 03:23:57', '<p><span style="font-family: Verdana, Geneva, Tahoma, Arial, Helvetica, sans-serif; font-size: 15.4px; background-color: rgb(244, 244, 244);">What are the different types of IoC (dependency injection)?</span><br></p>', 5, 'SHORT_QUESTION', NULL, 2),
(25, '2016-10-27 03:24:28', '<p><span style="font-family: Verdana, Geneva, Tahoma, Arial, Helvetica, sans-serif; font-size: 15.4px; background-color: rgb(244, 244, 244);">Which DI would you suggest Constructor-based or setter-based DI?</span><br></p>', 5, 'SHORT_QUESTION', NULL, 2),
(26, '2016-10-27 03:25:27', '<p><span style="font-family: Verdana, Geneva, Tahoma, Arial, Helvetica, sans-serif; font-size: 15.4px; background-color: rgb(244, 244, 244);">What are the JSR-250 Annotations? Explain them.</span><br></p>', 10, 'LONG_QUESTION', NULL, 2),
(27, '2016-10-27 03:25:48', '<p><span style="font-family: Verdana, Geneva, Tahoma, Arial, Helvetica, sans-serif; font-size: 15.4px; background-color: rgb(244, 244, 244);">Describe some of the standard Spring events.</span><br></p>', 10, 'LONG_QUESTION', NULL, 2),
(28, '2016-10-27 03:26:24', '<p><span style="font-family: Verdana, Geneva, Tahoma, Arial, Helvetica, sans-serif; font-size: 15.4px; background-color: rgb(244, 244, 244);">What are the advantages of Spring MVC over Struts MVC ?</span><br></p>', 10, 'LONG_QUESTION', NULL, 2),
(29, '2016-10-27 03:26:45', '<p><span style="font-family: Verdana, Geneva, Tahoma, Arial, Helvetica, sans-serif; font-size: 15.4px; background-color: rgb(244, 244, 244);">What are ORM''s Spring supports ?</span><br></p>', 10, 'LONG_QUESTION', NULL, 2),
(30, '2016-10-27 03:28:43', '<p><span style="color: rgb(34, 34, 34); font-family: Roboto, sans-serif; font-size: 14px; background-color: rgb(250, 248, 245);">What meter does "Spring" follow? -&gt; iambic tetrameter</span><br></p>', 2, 'TRUE_FALSE', NULL, 2);

-- --------------------------------------------------------

--
-- Table structure for table `question_choices`
--

CREATE TABLE `question_choices` (
  `question_id` bigint(20) NOT NULL,
  `choices_id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `question_choices`
--

INSERT INTO `question_choices` (`question_id`, `choices_id`) VALUES
(2, 26),
(2, 27),
(2, 28),
(2, 29),
(14, 3),
(14, 4),
(14, 5),
(14, 30),
(15, 6),
(15, 7),
(15, 8),
(15, 13),
(16, 14),
(16, 15),
(16, 16),
(16, 17),
(17, 18),
(17, 19),
(17, 20),
(17, 21),
(18, 22),
(18, 23),
(18, 24),
(18, 25),
(30, 31),
(30, 32);

-- --------------------------------------------------------

--
-- Table structure for table `quiz`
--

CREATE TABLE `quiz` (
  `id` bigint(20) NOT NULL,
  `updated_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `description` varchar(500) NOT NULL,
  `end_time` datetime NOT NULL,
  `start_time` datetime NOT NULL,
  `title` varchar(200) NOT NULL,
  `subject_id` bigint(20) DEFAULT NULL,
  `user_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `quiz`
--

INSERT INTO `quiz` (`id`, `updated_time`, `description`, `end_time`, `start_time`, `title`, `subject_id`, `user_id`) VALUES
(8, '2016-10-27 07:56:00', 'Mid Term Description', '2016-10-28 02:55:00', '2016-10-22 02:55:00', 'Mid Term', 2, 1);

-- --------------------------------------------------------

--
-- Table structure for table `quiz_questions`
--

CREATE TABLE `quiz_questions` (
  `quiz_id` bigint(20) NOT NULL,
  `questions_id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `quiz_questions`
--

INSERT INTO `quiz_questions` (`quiz_id`, `questions_id`) VALUES
(8, 14),
(8, 15),
(8, 17),
(8, 19),
(8, 20),
(8, 21),
(8, 23),
(8, 27),
(8, 28),
(8, 29),
(8, 30);

-- --------------------------------------------------------

--
-- Table structure for table `role`
--

CREATE TABLE `role` (
  `id` bigint(20) NOT NULL,
  `updated_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `name` varchar(255) DEFAULT NULL,
  `updatedTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `role`
--

INSERT INTO `role` (`id`, `updated_time`, `name`, `updatedTime`) VALUES
(1, '2016-10-25 02:18:09', 'Admin', '2016-10-26 20:17:08'),
(2, '2016-10-25 02:18:09', 'Student', '2016-10-26 20:17:08'),
(3, '2016-10-25 02:18:09', 'Teacher', '2016-10-26 20:17:08');

-- --------------------------------------------------------

--
-- Table structure for table `student`
--

CREATE TABLE `student` (
  `id` bigint(20) NOT NULL,
  `updated_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `end_date` date NOT NULL,
  `start_date` date NOT NULL,
  `student_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `student_subject`
--

CREATE TABLE `student_subject` (
  `student_id` bigint(20) NOT NULL,
  `subject_id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `student_teacher`
--

CREATE TABLE `student_teacher` (
  `student_id` bigint(20) NOT NULL,
  `teacher_id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `subject`
--

CREATE TABLE `subject` (
  `id` bigint(20) NOT NULL,
  `updated_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `mission` varchar(255) NOT NULL,
  `name` varchar(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `subject`
--

INSERT INTO `subject` (`id`, `updated_time`, `mission`, `name`) VALUES
(1, '2016-10-27 01:09:40', 'HTML, CSS, JavaScript, Servlet', 'Web Application Programming'),
(2, '2016-10-27 01:09:51', 'Spring MVC, Design Patterns, Best Practices, Spring Security, Spring Web Flow, Sprint Data, Spring Mobile, Tiles, Thymeleaf, Spring Validation', 'Web Application Architechture');

-- --------------------------------------------------------

--
-- Table structure for table `subject_questions`
--

CREATE TABLE `subject_questions` (
  `subject_id` bigint(20) NOT NULL,
  `questions_id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `id` bigint(20) NOT NULL,
  `updated_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `password` varchar(255) DEFAULT NULL,
  `password_confirm` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  `updatedTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `passwordConfirm` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`id`, `updated_time`, `password`, `password_confirm`, `username`, `updatedTime`, `passwordConfirm`) VALUES
(1, '2016-10-25 02:23:57', '$2a$10$mm/gTTEim8FLUhWPcfl32.G8v9FhHKScz869OtC1Zi9z5.c8pKjce', 'genious123', 'sahib.zer@gmail.com', '2016-10-26 20:17:09', NULL),
(2, '2016-10-26 23:42:41', '$2a$10$CqwX6Wu1fKENUQoSNFoyB.D4u62EOsWAgdsV0sqwKnD1XiCc/QkB6', 'genious123', 'meetsahib88@gmail.com', '2016-10-26 23:42:41', NULL),
(3, '2016-10-25 02:23:57', '$2a$10$mm/gTTEim8FLUhWPcfl32.G8v9FhHKScz869OtC1Zi9z5.c8pKjce', 'genious123', 'salem@gmail.com', '2016-10-26 20:17:09', NULL),
(4, '2016-10-26 23:42:41', '$2a$10$CqwX6Wu1fKENUQoSNFoyB.D4u62EOsWAgdsV0sqwKnD1XiCc/QkB6', 'genious123', 'stella@gmail.com', '2016-10-26 23:42:41', NULL),
(5, '2016-10-26 23:42:41', '$2a$10$CqwX6Wu1fKENUQoSNFoyB.D4u62EOsWAgdsV0sqwKnD1XiCc/QkB6', 'genious123', 'mena@gmail.com', '2016-10-26 23:42:41', NULL),
(6, '2016-10-27 14:50:37', '$2a$10$ujbaVCjgF9Jxc3LPxlvbA.Jwg.9j74dd1U.SzS5wGFRCBVUxpmPGm', 'admin1234', 'admin@gmail.com', '2016-10-27 14:50:37', NULL);

-- --------------------------------------------------------

--
-- Table structure for table `user_profile`
--

CREATE TABLE `user_profile` (
  `id` bigint(20) NOT NULL,
  `updatedTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `image` longblob,
  `user_id` bigint(20) DEFAULT NULL,
  `updated_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `first_name` varchar(255) DEFAULT NULL,
  `last_name` varchar(255) DEFAULT NULL,
  `phone_number` varchar(255) DEFAULT NULL,
  `entry` varchar(255) DEFAULT NULL,
  `student_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user_profile`
--

INSERT INTO `user_profile` (`id`, `updatedTime`, `image`, `user_id`, `updated_time`, `first_name`, `last_name`, `phone_number`, `entry`, `student_id`) VALUES
(1, '2016-10-26 23:42:41', NULL, 2, '2016-10-26 23:42:41', 'Sahib Zar', 'Khan', '6414519852', 'April 2016', 985248),
(2, '2016-10-26 23:42:41', NULL, 1, '2016-10-26 23:42:41', 'David', 'Came', '6414519852', 'April 2016', 985214),
(3, '2016-10-26 23:42:41', NULL, 3, '2016-10-26 23:42:41', 'Mahmoud', 'Salem', '6414519852', 'April 2016', 985217),
(4, '2016-10-26 23:42:41', NULL, 4, '2016-10-26 23:42:41', 'Stella', 'ti', '6414519852', 'April 2016', 985236),
(5, '2016-10-26 23:42:41', NULL, 5, '2016-10-26 23:42:41', 'Mena', 'Mena', '6414519852', 'April 2016', 985234),
(6, '2016-10-27 14:50:38', NULL, 6, '2016-10-27 14:50:38', 'Admin', 'Admin', '12345678', NULL, 0);

-- --------------------------------------------------------

--
-- Table structure for table `user_role`
--

CREATE TABLE `user_role` (
  `user_id` bigint(20) NOT NULL,
  `role_id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user_role`
--

INSERT INTO `user_role` (`user_id`, `role_id`) VALUES
(1, 1),
(2, 1),
(6, 1);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `choice`
--
ALTER TABLE `choice`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKcaq6r76cswke5b9fk6fyx3y5w` (`question_id`);

--
-- Indexes for table `contact`
--
ALTER TABLE `contact`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `question`
--
ALTER TABLE `question`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKb0yh0c1qaxfwlcnwo9dms2txf` (`quiz_id`),
  ADD KEY `FKkfvh71q42645g7p9cgxjygbgc` (`subject_id`);

--
-- Indexes for table `question_choices`
--
ALTER TABLE `question_choices`
  ADD UNIQUE KEY `UK_ckut30xnpwau3xasueewsscko` (`choices_id`),
  ADD KEY `FKifc0cyjdk3ijjhtju0fual7a6` (`question_id`);

--
-- Indexes for table `quiz`
--
ALTER TABLE `quiz`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK2bn6jb1u6wox8j2oh77k4vyp4` (`subject_id`),
  ADD KEY `FK1tofsm1qynhakggx7ttqh8ihu` (`user_id`);

--
-- Indexes for table `quiz_questions`
--
ALTER TABLE `quiz_questions`
  ADD UNIQUE KEY `UK_pfk49sobo174wlj8wb6c8082k` (`questions_id`),
  ADD KEY `FKcgp9e1c6ww3t383aui4w8feae` (`quiz_id`);

--
-- Indexes for table `role`
--
ALTER TABLE `role`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `student`
--
ALTER TABLE `student`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKn0tlhb4h26adrdbwpm4ahhq61` (`student_id`);

--
-- Indexes for table `student_subject`
--
ALTER TABLE `student_subject`
  ADD UNIQUE KEY `UK_cl6v8ui7bvpgkxf6rvk8821ip` (`subject_id`),
  ADD KEY `FKnhw926s5os3ei5wqfaq94j0mh` (`student_id`);

--
-- Indexes for table `student_teacher`
--
ALTER TABLE `student_teacher`
  ADD UNIQUE KEY `UK_oic1totapgfxfuwby8v4sun1o` (`teacher_id`),
  ADD KEY `FK3f00dinmqlkrlgtsb7dk4r4m2` (`student_id`);

--
-- Indexes for table `subject`
--
ALTER TABLE `subject`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `subject_questions`
--
ALTER TABLE `subject_questions`
  ADD UNIQUE KEY `UK_4srv83g4qq03gmi0s00w7nj2m` (`questions_id`),
  ADD KEY `FKi6iyayqwrqgr4o4q6q2vmokrt` (`subject_id`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `user_profile`
--
ALTER TABLE `user_profile`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK6kwj5lk78pnhwor4pgosvb51r` (`user_id`);

--
-- Indexes for table `user_role`
--
ALTER TABLE `user_role`
  ADD PRIMARY KEY (`user_id`,`role_id`),
  ADD KEY `FKa68196081fvovjhkek5m97n3y` (`role_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `choice`
--
ALTER TABLE `choice`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=33;
--
-- AUTO_INCREMENT for table `contact`
--
ALTER TABLE `contact`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `question`
--
ALTER TABLE `question`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=31;
--
-- AUTO_INCREMENT for table `quiz`
--
ALTER TABLE `quiz`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;
--
-- AUTO_INCREMENT for table `role`
--
ALTER TABLE `role`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT for table `student`
--
ALTER TABLE `student`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `subject`
--
ALTER TABLE `subject`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;
--
-- AUTO_INCREMENT for table `user_profile`
--
ALTER TABLE `user_profile`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;
--
-- Constraints for dumped tables
--

--
-- Constraints for table `choice`
--
ALTER TABLE `choice`
  ADD CONSTRAINT `FKcaq6r76cswke5b9fk6fyx3y5w` FOREIGN KEY (`question_id`) REFERENCES `question` (`id`);

--
-- Constraints for table `question`
--
ALTER TABLE `question`
  ADD CONSTRAINT `FKb0yh0c1qaxfwlcnwo9dms2txf` FOREIGN KEY (`quiz_id`) REFERENCES `quiz` (`id`),
  ADD CONSTRAINT `FKkfvh71q42645g7p9cgxjygbgc` FOREIGN KEY (`subject_id`) REFERENCES `subject` (`id`);

--
-- Constraints for table `question_choices`
--
ALTER TABLE `question_choices`
  ADD CONSTRAINT `FK4cygmiuxya64qd1mkhrxsbloo` FOREIGN KEY (`choices_id`) REFERENCES `choice` (`id`),
  ADD CONSTRAINT `FKifc0cyjdk3ijjhtju0fual7a6` FOREIGN KEY (`question_id`) REFERENCES `question` (`id`);

--
-- Constraints for table `quiz`
--
ALTER TABLE `quiz`
  ADD CONSTRAINT `FK1tofsm1qynhakggx7ttqh8ihu` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`),
  ADD CONSTRAINT `FK2bn6jb1u6wox8j2oh77k4vyp4` FOREIGN KEY (`subject_id`) REFERENCES `subject` (`id`);

--
-- Constraints for table `quiz_questions`
--
ALTER TABLE `quiz_questions`
  ADD CONSTRAINT `FKcgp9e1c6ww3t383aui4w8feae` FOREIGN KEY (`quiz_id`) REFERENCES `quiz` (`id`),
  ADD CONSTRAINT `FKpmfvwer12y1nrjc0efm04dq16` FOREIGN KEY (`questions_id`) REFERENCES `question` (`id`);

--
-- Constraints for table `student`
--
ALTER TABLE `student`
  ADD CONSTRAINT `FKn0tlhb4h26adrdbwpm4ahhq61` FOREIGN KEY (`student_id`) REFERENCES `student` (`id`);

--
-- Constraints for table `student_subject`
--
ALTER TABLE `student_subject`
  ADD CONSTRAINT `FK5cvx0kd792xhvd99s3bsbygfq` FOREIGN KEY (`subject_id`) REFERENCES `subject` (`id`),
  ADD CONSTRAINT `FKnhw926s5os3ei5wqfaq94j0mh` FOREIGN KEY (`student_id`) REFERENCES `student` (`id`);

--
-- Constraints for table `student_teacher`
--
ALTER TABLE `student_teacher`
  ADD CONSTRAINT `FK3f00dinmqlkrlgtsb7dk4r4m2` FOREIGN KEY (`student_id`) REFERENCES `student` (`id`),
  ADD CONSTRAINT `FKi3v76k6msqtm9yq454vnfvcu2` FOREIGN KEY (`teacher_id`) REFERENCES `user` (`id`);

--
-- Constraints for table `subject_questions`
--
ALTER TABLE `subject_questions`
  ADD CONSTRAINT `FKi6iyayqwrqgr4o4q6q2vmokrt` FOREIGN KEY (`subject_id`) REFERENCES `subject` (`id`),
  ADD CONSTRAINT `FKsac03odjhtoui8f67bwtnm7s8` FOREIGN KEY (`questions_id`) REFERENCES `question` (`id`);

--
-- Constraints for table `user_profile`
--
ALTER TABLE `user_profile`
  ADD CONSTRAINT `FK6kwj5lk78pnhwor4pgosvb51r` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`),
  ADD CONSTRAINT `FK_ebc21hy5j7scdvcjt0jy6xxrv` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`);

--
-- Constraints for table `user_role`
--
ALTER TABLE `user_role`
  ADD CONSTRAINT `FK859n2jvi8ivhui0rl0esws6o` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`),
  ADD CONSTRAINT `FK_apcc8lxk2xnug8377fatvbn04` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`),
  ADD CONSTRAINT `FK_it77eq964jhfqtu54081ebtio` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`),
  ADD CONSTRAINT `FKa68196081fvovjhkek5m97n3y` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
