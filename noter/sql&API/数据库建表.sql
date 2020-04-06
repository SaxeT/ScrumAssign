CREATE TABLE `notebook` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '笔记本id',
  `name` varchar(32) NOT NULL DEFAULT '' COMMENT '笔记本name',
  `description` varchar(200) DEFAULT '' COMMENT '笔记本描述',
  `uid` int(11) unsigned NOT NULL COMMENT '用户id',
  PRIMARY KEY (`id`),
  KEY `uid` (`uid`),
  CONSTRAINT `notebook_ibfk_1` FOREIGN KEY (`uid`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8;


INSERT INTO `notebook`(`id`, `name`, `description`, `uid`) VALUES (1, '英语学习', '学习英语 day day up', 1);
INSERT INTO `notebook`(`id`, `name`, `description`, `uid`) VALUES (2, '美食记', '骗吃骗喝', 1);
INSERT INTO `notebook`(`id`, `name`, `description`, `uid`) VALUES (3, '旅行', '沿途人文风景', 1);
INSERT INTO `notebook`(`id`, `name`, `description`, `uid`) VALUES (4, '游戏', '每天都要玩玩玩', 1);
INSERT INTO `notebook`(`id`, `name`, `description`, `uid`) VALUES (5, '追剧', '我剧荒了', 1);
INSERT INTO `notebook`(`id`, `name`, `description`, `uid`) VALUES (6, '推理小说', '凶手就是你', 1);
INSERT INTO `notebook`(`id`, `name`, `description`, `uid`) VALUES (7, '食谱', '开心小厨房 每天炒炒菜 每天都在进步', 1);
INSERT INTO `notebook`(`id`, `name`, `description`, `uid`) VALUES (8, '宠物', '生活的好伙伴', 1);
INSERT INTO `notebook`(`id`, `name`, `description`, `uid`) VALUES (9, '购物清单', '双十一大采购清单准备', 1);
INSERT INTO `notebook`(`id`, `name`, `description`, `uid`) VALUES (10, '读书笔记', '书山有路勤为径，学海无涯苦作舟', 1);
INSERT INTO `notebook`(`id`, `name`, `description`, `uid`) VALUES (11, '歌曲', '不要睡，起来嗨~', 1);
INSERT INTO `notebook`(`id`, `name`, `description`, `uid`) VALUES (12, '都市怪谈', '都市怪谈都是真的！', 1);
INSERT INTO `notebook`(`id`, `name`, `description`, `uid`) VALUES (11, '密码本', '记不住的密码通通放在这里', 1);


DROP TABLE IF EXISTS `note`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `note` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `title` varchar(256) NOT NULL DEFAULT '',
  `content` text NOT NULL,
  `category` varchar(32) DEFAULT 'default',
  `time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `uid` int(11) unsigned NOT NULL,
  `nbid` int(11) unsigned NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_note_user` (`uid`),
  KEY `fk_note_notebook` (`nbid`),
  CONSTRAINT `note_ibfk_1` FOREIGN KEY (`uid`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `note_ibfk_2` FOREIGN KEY (`nbid`) REFERENCES `notebook` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `note`
--

LOCK TABLES `note` WRITE;
/*!40000 ALTER TABLE `note` DISABLE KEYS */;
INSERT INTO `note` VALUES (1,'English Note','something just like this','学习','2020-02-15 08:46:57',1,1),(2,'厨师长农国栋','蛋炒饭','生活','2020-02-15 08:46:57',1,2),(3,'日本','旅行计划','生活','2020-02-15 08:46:57',1,3),(6,'牛客网','<p>哈哈</p>','学习','2020-04-06 15:52:37',1,3),(10,'q3f3f334f3f','<p>fq3rfq3rqfq3f3rqfr</p>','学习','2020-04-06 16:02:27',1,3),(14,'134r13r31','<p>f<strike>qffq</strike>t314t3<b>erfe<i>fqrfqf</i>frq<u>frfq</u>f</b></p><ol><li><b>123</b></li><li><b>2abc</b></li></ol><ul><li><b>nihao</b></li></ul><p><b>python<a href=\"http://baidu\" target=\"_blank\">Baidu</a></b></p><p><img alt=\"boboli\" width=\"54.3906\" height=\"25\"><br></p><ul></ul><ol></ol>','学习','2020-04-06 16:41:47',1,5),(20,'r134r34r','<p>12323r</p>','学习','2020-04-06 16:42:09',1,3),(21,'123','<p>123</p>','学习','2020-04-06 18:06:43',1,5),(22,'21e123','<p>132123</p>','学习','2020-04-06 18:10:21',3,6);
/*!40000 ALTER TABLE `note` ENABLE KEYS */;
UNLOCK TABLES;