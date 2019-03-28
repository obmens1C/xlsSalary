-- phpMyAdmin SQL Dump
-- version 3.5.1
-- http://www.phpmyadmin.net
--
-- Хост: 127.0.0.1
-- Время создания: Мар 29 2019 г., 00:55
-- Версия сервера: 5.5.25
-- Версия PHP: 5.3.13

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- База данных: `calculatesalary`
--

-- --------------------------------------------------------

--
-- Структура таблицы `customers`
--

CREATE TABLE IF NOT EXISTS `customers` (
  `id` varchar(50) NOT NULL,
  `name` varchar(50) NOT NULL,
  `percent` int(3) NOT NULL,
  `orders` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Структура таблицы `managers`
--

CREATE TABLE IF NOT EXISTS `managers` (
  `id` varchar(50) NOT NULL,
  `name` varchar(50) NOT NULL,
  `salary` int(11) NOT NULL,
  `percent` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Дамп данных таблицы `managers`
--

INSERT INTO `managers` (`id`, `name`, `salary`, `percent`) VALUES
('0530b632-2aa9-11e9-1d85-a4bf011ca70c', 'Дубровин Александр Николаевич', 15500, 6),
('0de6ba70-ab9b-11e8-dc81-a4bf011ca70c', 'Рыбаков Семен Сергеевич', 20000, 6),
('39d0a930-e945-11e6-3883-c860000abaae', 'Залялютдинов Тимур Ренатович', 25000, 6),
('3dab5774-76e4-11e4-ee8f-c860000abaae', 'Шиндяпин Александр Витальевич', 15500, 6),
('473d0992-d368-11e8-2094-a4bf011ca70c', 'Рубцов Роман Дмитриевич', 20000, 6),
('6dbd1c5c-b116-11e8-4897-a4bf011ca70c', 'Залялютдинов Дмитрий Ренатович', 20000, 6),
('92dcf4cc-a81f-11e7-2f88-a4bf011ca70c', 'Орехов Владислав Борисович', 20000, 6),
('93a83782-6dea-11e7-569c-a4bf011ca70c', 'Бравиков Александр Анатольевич', 15500, 6),
('974ef116-d8aa-11e2-c886-c860000abaae', 'Хворов Владимир Владимирович', 25000, 6),
('a3599ee4-8d90-11e7-3491-a4bf011ca70c', 'Белобородова Марина Юрьевна', 0, 6),
('d07b9162-6269-11e8-0686-a4bf011ca70c', 'Дружинин Олег Витальевич', 15500, 6);

-- --------------------------------------------------------

--
-- Структура таблицы `orders`
--

CREATE TABLE IF NOT EXISTS `orders` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `date` date NOT NULL,
  `customer` int(11) NOT NULL,
  `manager` int(11) NOT NULL,
  `sum` int(20) NOT NULL,
  `payments` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Структура таблицы `payments`
--

CREATE TABLE IF NOT EXISTS `payments` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `date` date NOT NULL,
  `order` int(11) NOT NULL,
  `sum` int(11) NOT NULL,
  `customer` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 AUTO_INCREMENT=1 ;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
