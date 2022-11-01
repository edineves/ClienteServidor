

--
-- Database: `db_estoque`
--
-- --------------------------------------------------------

--
-- Table structure for table `tb_produto`
--

DROP TABLE IF EXISTS `tb_produto`;
CREATE TABLE IF NOT EXISTS `tb_produto` (
  `codigo` int(11) NOT NULL,
  `nome` varchar(150) NOT NULL,
  `descricao` varchar(150) NOT NULL,
  `quantidade` int(11) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=armscii8;
COMMIT;


