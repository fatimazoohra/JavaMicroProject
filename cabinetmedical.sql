-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1
-- Généré le :  Dim 09 fév. 2020 à 23:18
-- Version du serveur :  10.1.39-MariaDB
-- Version de PHP :  7.3.5

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `cabinetmedical`
--

-- --------------------------------------------------------

--
-- Structure de la table `adminlogin`
--

CREATE TABLE `adminlogin` (
  `login` varchar(8) NOT NULL,
  `password` varchar(8) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `adminlogin`
--

INSERT INTO `adminlogin` (`login`, `password`) VALUES
('adminlog', 'admin123');

-- --------------------------------------------------------

--
-- Structure de la table `client`
--

CREATE TABLE `client` (
  `id` bigint(20) NOT NULL,
  `version` int(11) NOT NULL,
  `titre` varchar(5) NOT NULL,
  `nom` varchar(30) NOT NULL,
  `prenom` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `client`
--

INSERT INTO `client` (`id`, `version`, `titre`, `nom`, `prenom`) VALUES
(3, 14, 'him', 'alaou', 'si mohammed'),
(5, 18, 'hio', 'kisbin', 'siham'),
(6, 156, 'kasa', 'karimi', 'salim'),
(7, 145, 'fati', 'bouhnach', 'fatima zohra'),
(8, 123, 'jiji', 'jihani', 'jihan');

-- --------------------------------------------------------

--
-- Structure de la table `creneaux`
--

CREATE TABLE `creneaux` (
  `id` bigint(20) NOT NULL,
  `version` int(11) DEFAULT NULL,
  `hdebut` int(11) DEFAULT NULL,
  `mdebut` int(11) DEFAULT NULL,
  `hfin` int(11) DEFAULT NULL,
  `mfin` int(11) DEFAULT NULL,
  `id_medecin` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `creneaux`
--

INSERT INTO `creneaux` (`id`, `version`, `hdebut`, `mdebut`, `hfin`, `mfin`, `id_medecin`) VALUES
(39, 1, 15, 30, 15, 0, 1),
(40, 1, 8, 20, 9, 0, 1),
(41, 1, 10, 30, 11, 0, 1),
(42, 1, 14, 45, 15, 0, 1),
(43, 1, 14, 45, 15, 0, 1),
(44, 1, 14, 45, 15, 0, 1),
(45, 1, 10, 15, 11, 0, 3);

-- --------------------------------------------------------

--
-- Structure de la table `medecin`
--

CREATE TABLE `medecin` (
  `id` bigint(20) NOT NULL,
  `version` int(11) NOT NULL,
  `titre` varchar(5) NOT NULL,
  `nom` varchar(30) NOT NULL,
  `prenom` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `medecin`
--

INSERT INTO `medecin` (`id`, `version`, `titre`, `nom`, `prenom`) VALUES
(1, 123, 'gilal', 'bombal', 'souhail'),
(3, 114, 'hims', 'ahmadni', 'rafik');

-- --------------------------------------------------------

--
-- Structure de la table `rv`
--

CREATE TABLE `rv` (
  `id` bigint(20) NOT NULL,
  `jour` date DEFAULT NULL,
  `id_client` bigint(20) DEFAULT NULL,
  `id_creneau` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `rv`
--

INSERT INTO `rv` (`id`, `jour`, `id_client`, `id_creneau`) VALUES
(20, '2019-11-11', 3, 39),
(21, '2020-04-01', 3, 40),
(22, '2020-03-06', 3, 41),
(24, '2020-03-03', 5, 43),
(25, '2020-06-05', 6, 44),
(26, '2020-04-03', 7, 45);

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `client`
--
ALTER TABLE `client`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `creneaux`
--
ALTER TABLE `creneaux`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk1` (`id_medecin`);

--
-- Index pour la table `medecin`
--
ALTER TABLE `medecin`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `rv`
--
ALTER TABLE `rv`
  ADD PRIMARY KEY (`id`),
  ADD KEY `rv_fk1` (`id_client`),
  ADD KEY `fk2` (`id_creneau`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `client`
--
ALTER TABLE `client`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT pour la table `creneaux`
--
ALTER TABLE `creneaux`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=46;

--
-- AUTO_INCREMENT pour la table `medecin`
--
ALTER TABLE `medecin`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT pour la table `rv`
--
ALTER TABLE `rv`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=27;

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `creneaux`
--
ALTER TABLE `creneaux`
  ADD CONSTRAINT `fk1` FOREIGN KEY (`id_medecin`) REFERENCES `medecin` (`id`);

--
-- Contraintes pour la table `rv`
--
ALTER TABLE `rv`
  ADD CONSTRAINT `fk2` FOREIGN KEY (`id_creneau`) REFERENCES `creneaux` (`id`),
  ADD CONSTRAINT `rv_fk1` FOREIGN KEY (`id_client`) REFERENCES `client` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
