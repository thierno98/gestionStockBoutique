-- phpMyAdmin SQL Dump
-- version 4.9.1
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1
-- Généré le :  lun. 15 mars 2021 à 23:34
-- Version du serveur :  10.4.8-MariaDB
-- Version de PHP :  7.3.11

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `dbvente`
--

-- --------------------------------------------------------

--
-- Structure de la table `approvisionnement`
--

CREATE TABLE `approvisionnement` (
  `id` bigint(20) NOT NULL,
  `DateReception` date DEFAULT NULL,
  `QteProduitEncours` int(11) NOT NULL,
  `QteProduitInitial` int(11) NOT NULL,
  `produit_id` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `approvisionnement`
--

INSERT INTO `approvisionnement` (`id`, `DateReception`, `QteProduitEncours`, `QteProduitInitial`, `produit_id`) VALUES
(1, '0015-03-13', 60, 50, 1),
(2, '0015-03-13', 80, 70, 7);

-- --------------------------------------------------------

--
-- Structure de la table `client`
--

CREATE TABLE `client` (
  `id` bigint(20) NOT NULL,
  `matricule` varchar(60) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `client`
--

INSERT INTO `client` (`id`, `matricule`) VALUES
(1, 'SENDK-INFORMATIQUE02020-09-09'),
(2, 'SENDK-INFORMATIQUE12020-09-09'),
(3, 'SENDK-INFORMATIQUE22020-09-09'),
(4, 'SENDK-INFORMATIQUE32020-09-09'),
(5, 'SENDK-INFORMATIQUE42020-09-09'),
(6, 'SENDK-INFORMATIQUE52020-09-09');

-- --------------------------------------------------------

--
-- Structure de la table `commande`
--

CREATE TABLE `commande` (
  `id` bigint(20) NOT NULL,
  `annule` bit(1) NOT NULL,
  `dateCommande` date DEFAULT NULL,
  `numero` varchar(60) DEFAULT NULL,
  `client_id` bigint(20) DEFAULT NULL,
  `facture_id` bigint(20) DEFAULT NULL,
  `user_id` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `commande`
--

INSERT INTO `commande` (`id`, `annule`, `dateCommande`, `numero`, `client_id`, `facture_id`, `user_id`) VALUES
(1, b'0', '2020-09-09', 'COM_00_0', 6, 2, 3),
(2, b'0', '2020-09-09', 'COM_00_1', 6, 3, 3),
(4, b'0', '2020-09-09', 'COM_00_2', 4, 5, 3),
(5, b'0', '2020-09-09', 'COM_00_2', 4, 6, 3),
(6, b'0', '2020-09-09', 'COM_00_2', 4, 7, 3),
(7, b'1', '2020-09-09', 'COM_00_5', 6, 8, 3);

-- --------------------------------------------------------

--
-- Structure de la table `detail`
--

CREATE TABLE `detail` (
  `id` bigint(20) NOT NULL,
  `numeroProduit` varchar(60) DEFAULT NULL,
  `quantite` int(11) NOT NULL,
  `commande_id` bigint(20) DEFAULT NULL,
  `produit_id` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `detail`
--

INSERT INTO `detail` (`id`, `numeroProduit`, `quantite`, `commande_id`, `produit_id`) VALUES
(1, 'LDLC Saturne TB67-16-S4H20', 10, 1, 4),
(2, 'LG 19\" LED - 19M38A-B', 5, 1, 10),
(3, 'HP ProBook 430 G7 (9VZ24EA)', 10, 2, 9),
(4, 'HP ProBook 430 G7 (9VZ24EA)', 5, 4, 9),
(5, 'LG 24\" LED 24MP88HV-S', 1, 4, 11),
(6, 'LDLC Saturne TB67-16-S4H20', 10, 7, 4),
(7, 'AORUS 15G XB-8FR2130MH', 10, 7, 6),
(8, 'LG 19\" LED - 19M38A-B', 40, 7, 10);

-- --------------------------------------------------------

--
-- Structure de la table `entreprise`
--

CREATE TABLE `entreprise` (
  `id` bigint(20) NOT NULL,
  `adresse` varchar(50) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `nom` varchar(60) DEFAULT NULL,
  `tel` varchar(50) DEFAULT NULL,
  `client_id` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `entreprise`
--

INSERT INTO `entreprise` (`id`, `adresse`, `email`, `nom`, `tel`, `client_id`) VALUES
(1, 'Bargny', 'sococim@gmail.com', 'SOCOCIM', '338854422', 1),
(2, 'Dakar', 'sedimasn@gmail.com', 'SEDIMA', '332225544', 2);

-- --------------------------------------------------------

--
-- Structure de la table `facture`
--

CREATE TABLE `facture` (
  `id` bigint(20) NOT NULL,
  `dateFacture` date DEFAULT NULL,
  `montantAPayer` int(11) NOT NULL,
  `numeroFacture` varchar(60) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `facture`
--

INSERT INTO `facture` (`id`, `dateFacture`, `montantAPayer`, `numeroFacture`) VALUES
(1, '2020-09-09', 7198000, 'SENDK-INFO-FACT12020-09-09'),
(2, '2020-09-09', 7434000, 'SENDK-INFO-FACT22020-09-09'),
(3, '2020-09-09', 4720000, 'SENDK-INFO-FACT32020-09-09'),
(4, '2020-09-09', 5180200, 'SENDK-INFO-FACT42020-09-09'),
(5, '2020-09-09', 2501600, 'SENDK-INFO-FACT52020-09-09'),
(6, '2020-09-09', 0, 'SENDK-INFO-FACT62020-09-09'),
(7, '2020-09-09', 0, 'SENDK-INFO-FACT72020-09-09'),
(8, '2020-09-09', 18644000, 'SENDK-INFO-FACT82020-09-09');

-- --------------------------------------------------------

--
-- Structure de la table `paiement`
--

CREATE TABLE `paiement` (
  `id` bigint(20) NOT NULL,
  `dateFacture` date DEFAULT NULL,
  `montantVerse` int(11) NOT NULL,
  `numeroPaiement` varchar(60) DEFAULT NULL,
  `facture_id` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `paiement`
--

INSERT INTO `paiement` (`id`, `dateFacture`, `montantVerse`, `numeroPaiement`, `facture_id`) VALUES
(1, '2020-09-09', 5600000, 'SENDK-INFO-PMT12020-09-09', 3),
(2, '2020-09-09', 480000, 'SENDK-INFO-PMT22020-09-09', 4),
(3, '2020-09-09', 1120000, 'SENDK-INFO-PMT32020-09-09', 4),
(4, '2020-09-09', 1200000, 'SENDK-INFO-PMT42020-09-09', 8),
(5, '2020-09-09', 2800000, 'SENDK-INFO-PMT52020-09-09', 8);

-- --------------------------------------------------------

--
-- Structure de la table `personne`
--

CREATE TABLE `personne` (
  `id` bigint(20) NOT NULL,
  `adresse` varchar(50) DEFAULT NULL,
  `datenaissance` date DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `nom` varchar(30) DEFAULT NULL,
  `prenom` varchar(30) DEFAULT NULL,
  `tel` varchar(50) DEFAULT NULL,
  `client_id` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `personne`
--

INSERT INTO `personne` (`id`, `adresse`, `datenaissance`, `email`, `nom`, `prenom`, `tel`, `client_id`) VALUES
(1, 'Parcel', '1998-09-15', 'mouhamed@gmail.com', 'Ndiaye', 'Mouhamadou Moustapha', '775584433', 3),
(2, 'Rufisque', '1998-02-15', 'mordiagne@gmail.com', 'Diagne', 'Mor', '774445588', 4),
(3, 'Rufisque', '1998-02-15', 'thiamhabib@gmail.com', 'Thiam', 'Habiboulaye', '774451177', 5),
(4, 'Rufisque', '1998-02-01', 'mouhamed@gmail.com', 'Sarr', 'Mouhamed', '775546688', 6);

-- --------------------------------------------------------

--
-- Structure de la table `produit`
--

CREATE TABLE `produit` (
  `id` bigint(20) NOT NULL,
  `libelle` varchar(60) DEFAULT NULL,
  `prixMinimal` int(11) NOT NULL,
  `prixNormale` int(11) NOT NULL,
  `qteMinimale` int(11) NOT NULL,
  `qteStock` int(11) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `produit`
--

INSERT INTO `produit` (`id`, `libelle`, `prixMinimal`, `prixNormale`, `qteMinimale`, `qteStock`) VALUES
(1, 'Apple MacBook Air (2020) 13\" avec écran Retina', 30000, 350000, 10, 60),
(2, 'Apple MacBook Pro 16\" avec Touch Bar Gris', 250000, 300000, 10, 50),
(3, 'LDLC Aurore NJ3L-8-S4', 300000, 400000, 5, 30),
(4, 'LDLC Saturne TB67-16-S4H20', 200000, 580000, 10, 40),
(5, 'Acer Predator Helios 300 PH315-52-55QR', 50000, 650000, 10, 5),
(6, 'AORUS 15G XB-8FR2130MH', 550000, 600000, 3, 5),
(7, 'HP EliteBook 830 G6 (6XD24EA)', 450000, 500000, 10, 77),
(8, 'HP OMEN 15-dh0069nf', 400000, 450000, 5, 30),
(9, 'HP ProBook 430 G7 (9VZ24EA)', 350000, 400000, 10, 75),
(10, 'LG 19\" LED - 19M38A-B', 90000, 100000, 5, 55),
(11, 'LG 24\" LED 24MP88HV-S', 100000, 120000, 5, 46),
(12, 'HP LaserJet Pro M102w', 100000, 140000, 10, 55),
(13, 'LDLC SSD Externe USB 3.0 120 Go', 45000, 50000, 10, 77),
(14, 'Seagate Portable Expansion 4 To', 75000, 80000, 10, 14),
(15, 'Ordinateur', 80000, 90000, 10, 100);

-- --------------------------------------------------------

--
-- Structure de la table `profil`
--

CREATE TABLE `profil` (
  `id` bigint(20) NOT NULL,
  `libelle` varchar(60) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `profil`
--

INSERT INTO `profil` (`id`, `libelle`) VALUES
(1, 'admin'),
(2, 'caissier'),
(3, 'Gestionnaire Des Ventes ');

-- --------------------------------------------------------

--
-- Structure de la table `user`
--

CREATE TABLE `user` (
  `id` bigint(20) NOT NULL,
  `adresse` varchar(60) DEFAULT NULL,
  `dateNaissance` date DEFAULT NULL,
  `login` varchar(60) DEFAULT NULL,
  `nom` varchar(60) DEFAULT NULL,
  `password` varchar(60) DEFAULT NULL,
  `prenom` varchar(60) DEFAULT NULL,
  `telephone` varchar(60) DEFAULT NULL,
  `profil_id` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `user`
--

INSERT INTO `user` (`id`, `adresse`, `dateNaissance`, `login`, `nom`, `password`, `prenom`, `telephone`, `profil_id`) VALUES
(1, 'Rufisque', '1998-03-02', 'admin', 'Ndiaye', 'passer', 'Thierno', '775554433', 1),
(2, 'Parcel', '1998-08-12', 'diouf98', 'Diouf', 'passer', 'Moussa', '772253366', 2),
(3, 'Rufisque', '1997-09-09', 'mouha98', 'Diallo', 'passer', 'Mouhamed', '775556644', 3);

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `approvisionnement`
--
ALTER TABLE `approvisionnement`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKb0yss8nk5wrvyp90td7jiiaha` (`produit_id`);

--
-- Index pour la table `client`
--
ALTER TABLE `client`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `commande`
--
ALTER TABLE `commande`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKvulim1yo1bvjsxck8kblj7mu` (`client_id`),
  ADD KEY `FKo3wo0qca2k8sd5btf1k8awita` (`facture_id`),
  ADD KEY `FKqpl4bbvvi7bd14i34d9dimads` (`user_id`);

--
-- Index pour la table `detail`
--
ALTER TABLE `detail`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKoae2t0dft0lsef267adxmb48e` (`commande_id`),
  ADD KEY `FKrw4tselqdemdesc61u1t9bq95` (`produit_id`);

--
-- Index pour la table `entreprise`
--
ALTER TABLE `entreprise`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK46dvdwli410fk8brewiqou3je` (`client_id`);

--
-- Index pour la table `facture`
--
ALTER TABLE `facture`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `paiement`
--
ALTER TABLE `paiement`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKh4bfwkcblaoe5xsvyalao486x` (`facture_id`);

--
-- Index pour la table `personne`
--
ALTER TABLE `personne`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKp7u3u86ina5hrlfkbx22h3y9c` (`client_id`);

--
-- Index pour la table `produit`
--
ALTER TABLE `produit`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `profil`
--
ALTER TABLE `profil`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK88l1ekjabd3nyw7m79hfdqqvv` (`profil_id`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `approvisionnement`
--
ALTER TABLE `approvisionnement`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT pour la table `client`
--
ALTER TABLE `client`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT pour la table `commande`
--
ALTER TABLE `commande`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT pour la table `detail`
--
ALTER TABLE `detail`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT pour la table `entreprise`
--
ALTER TABLE `entreprise`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT pour la table `facture`
--
ALTER TABLE `facture`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT pour la table `paiement`
--
ALTER TABLE `paiement`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT pour la table `personne`
--
ALTER TABLE `personne`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT pour la table `produit`
--
ALTER TABLE `produit`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;

--
-- AUTO_INCREMENT pour la table `profil`
--
ALTER TABLE `profil`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT pour la table `user`
--
ALTER TABLE `user`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
