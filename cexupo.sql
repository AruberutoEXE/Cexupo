-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 03-06-2023 a las 18:37:29
-- Versión del servidor: 10.4.27-MariaDB
-- Versión de PHP: 8.2.0

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `cexupo`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `categoria`
--

CREATE TABLE `categoria` (
  `nombre` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `chat`
--

CREATE TABLE `chat` (
  `idProducto` bigint(20) NOT NULL,
  `idUsuario` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `chat`
--

INSERT INTO `chat` (`idProducto`, `idUsuario`) VALUES
(2, 'miguel');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `direccion`
--

CREATE TABLE `direccion` (
  `id` bigint(20) NOT NULL,
  `direccion` varchar(255) NOT NULL,
  `cp` int(11) NOT NULL,
  `nombre` varchar(255) NOT NULL,
  `idUsuario` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `direccion`
--

INSERT INTO `direccion` (`id`, `direccion`, `cp`, `nombre`, `idUsuario`) VALUES
(1, 'mallorca 20', 41100, 'casa', 'usuario'),
(2, 'urb. narnia', 41907, 'principal', 'miguel');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `empresatransporte`
--

CREATE TABLE `empresatransporte` (
  `id` bigint(20) NOT NULL,
  `nombre` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `mensaje`
--

CREATE TABLE `mensaje` (
  `id` bigint(20) NOT NULL,
  `idUsuario` varchar(255) NOT NULL,
  `idChat` bigint(20) NOT NULL,
  `fecha` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  `contenido` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `metodopago`
--

CREATE TABLE `metodopago` (
  `id` bigint(20) NOT NULL,
  `idUsuario` varchar(255) NOT NULL,
  `nombre` varchar(255) NOT NULL,
  `detalles` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `metodopago`
--

INSERT INTO `metodopago` (`id`, `idUsuario`, `nombre`, `detalles`) VALUES
(1, 'miguel', 'tarjeta', '313215469513213');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `producto`
--

CREATE TABLE `producto` (
  `id` bigint(20) NOT NULL,
  `nombre` varchar(255) NOT NULL,
  `descripcion` varchar(255) NOT NULL,
  `estado` varchar(255) NOT NULL,
  `precio` float NOT NULL,
  `hastag` varchar(255) NOT NULL,
  `id_usuario` varchar(255) NOT NULL,
  `vendido` tinyint(1) NOT NULL DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `producto`
--

INSERT INTO `producto` (`id`, `nombre`, `descripcion`, `estado`, `precio`, `hastag`, `id_usuario`, `vendido`) VALUES
(2, 'Vakama', 'Juguete mega rechulón de la compañía lego', 'publicado', 20, '#LEGO #Bionicle #Toa #ToaMetru', 'usuario', 0),
(4, 'soldado', 'tiene pistola', 'publicado', 30, 'makeAmericaGreatAgain', 'usuario', 0),
(11, 'switch station', 'juega a juegos', 'nuevo', 400, 'consola', 'usuario', 0),
(12, 'el nuevo y mejorado pepe', 'perepe', 'acondicionado', 3, 'un grande', 'usuario', 0);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `puntuacion`
--

CREATE TABLE `puntuacion` (
  `id` int(11) NOT NULL,
  `numero` int(11) NOT NULL,
  `resenya` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tarifaenvio`
--

CREATE TABLE `tarifaenvio` (
  `id` bigint(20) NOT NULL,
  `precioPeso` float NOT NULL,
  `precioVolumen` float NOT NULL,
  `precioSeguro` float NOT NULL,
  `nombreTarifa` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `tarifaenvio`
--

INSERT INTO `tarifaenvio` (`id`, `precioPeso`, `precioVolumen`, `precioSeguro`, `nombreTarifa`) VALUES
(1, 20, 10, 3, 'básica');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuario`
--

CREATE TABLE `usuario` (
  `username` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `email` varchar(225) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `usuario`
--

INSERT INTO `usuario` (`username`, `password`, `email`) VALUES
('miguel', '12345', 'miguelito@gmail.com'),
('usuario', 'usuario', 'albertoblsr@gmail.com');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `venta`
--

CREATE TABLE `venta` (
  `id` bigint(6) NOT NULL,
  `precioTotal` float NOT NULL,
  `idUsuario` varchar(255) NOT NULL,
  `fechaVenta` timestamp(6) NOT NULL DEFAULT current_timestamp(6) ON UPDATE current_timestamp(6),
  `idProducto` bigint(6) NOT NULL,
  `idPuntuacion` bigint(6) NOT NULL,
  `idTarifa` bigint(6) NOT NULL,
  `idDireccion` bigint(20) NOT NULL,
  `idMetodoPago` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `venta`
--

INSERT INTO `venta` (`id`, `precioTotal`, `idUsuario`, `fechaVenta`, `idProducto`, `idPuntuacion`, `idTarifa`, `idDireccion`, `idMetodoPago`) VALUES
(1, 0, 'miguel', '2023-06-02 23:49:09.000000', 2, 0, 1, 2, 1),
(4, 63, 'miguel', '2023-06-03 14:43:52.000000', 4, 0, 1, 2, 1);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `categoria`
--
ALTER TABLE `categoria`
  ADD PRIMARY KEY (`nombre`);

--
-- Indices de la tabla `chat`
--
ALTER TABLE `chat`
  ADD PRIMARY KEY (`idProducto`,`idUsuario`);

--
-- Indices de la tabla `direccion`
--
ALTER TABLE `direccion`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `empresatransporte`
--
ALTER TABLE `empresatransporte`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `mensaje`
--
ALTER TABLE `mensaje`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `metodopago`
--
ALTER TABLE `metodopago`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `producto`
--
ALTER TABLE `producto`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_usuario_producto` (`id_usuario`);

--
-- Indices de la tabla `puntuacion`
--
ALTER TABLE `puntuacion`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `tarifaenvio`
--
ALTER TABLE `tarifaenvio`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `usuario`
--
ALTER TABLE `usuario`
  ADD PRIMARY KEY (`username`);

--
-- Indices de la tabla `venta`
--
ALTER TABLE `venta`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `direccion`
--
ALTER TABLE `direccion`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de la tabla `empresatransporte`
--
ALTER TABLE `empresatransporte`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `mensaje`
--
ALTER TABLE `mensaje`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `metodopago`
--
ALTER TABLE `metodopago`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de la tabla `producto`
--
ALTER TABLE `producto`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- AUTO_INCREMENT de la tabla `puntuacion`
--
ALTER TABLE `puntuacion`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `tarifaenvio`
--
ALTER TABLE `tarifaenvio`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de la tabla `venta`
--
ALTER TABLE `venta`
  MODIFY `id` bigint(6) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `producto`
--
ALTER TABLE `producto`
  ADD CONSTRAINT `id_usuario_producto` FOREIGN KEY (`id_usuario`) REFERENCES `usuario` (`username`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
