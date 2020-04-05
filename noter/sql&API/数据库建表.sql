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
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8;

INSERT INTO `note`(`id`, `title`, `content`, `category`, `time`, `uid`, `nbid`) VALUES (1, 'English Note', 'something just like this', '学习', '2020-02-15 08:46:57', 1, 1);
INSERT INTO `note`(`id`, `title`, `content`, `category`, `time`, `uid`, `nbid`) VALUES (2, '厨师长农国栋', '蛋炒饭', '生活', '2020-02-15 08:46:57', 1, 2);
INSERT INTO `note`(`id`, `title`, `content`, `category`, `time`, `uid`, `nbid`) VALUES (3, '日本', '旅行计划', '生活', '2020-02-15 08:46:57', 1, 3);
INSERT INTO `note`(`id`, `title`, `content`, `category`, `time`, `uid`, `nbid`) VALUES (5, '刺激战场', '我有98K', '娱乐', '2020-02-15 08:46:57', 2, 4);
INSERT INTO `note`(`id`, `title`, `content`, `category`, `time`, `uid`, `nbid`) VALUES (6, '华农兄弟', '烤竹鼠', '美食', '2020-02-15 08:47:05', 2, 4);
INSERT INTO `note`(`id`, `title`, `content`, `category`, `time`, `uid`, `nbid`) VALUES (15, '单词背诵', '<p>re</p>', '学习', '2020-04-06 04:06:31', 1, 1);
INSERT INTO `note`(`id`, `title`, `content`, `category`, `time`, `uid`, `nbid`) VALUES (16, '六级听力', '<p>fqereqrfe</p>', '学习', '2020-04-06 04:06:36', 1, 1);
INSERT INTO `note`(`id`, `title`, `content`, `category`, `time`, `uid`, `nbid`) VALUES (17, '六级词汇', '<p>dwe</p>', '学习', '2020-04-06 04:06:40', 1, 1);
INSERT INTO `note`(`id`, `title`, `content`, `category`, `time`, `uid`, `nbid`) VALUES (18, '六级写作', '<p>反而丰富</p>', '学习', '2020-04-06 04:06:45', 1, 1);
INSERT INTO `note`(`id`, `title`, `content`, `category`, `time`, `uid`, `nbid`) VALUES (19, '六级口语', '<p><b>ef</b>q<i>eqegr</i>q4<u>grqergko</u>rn<strike>ognergnoernge</strike></p>', '学习', '2020-04-06 04:06:51', 1, 1);
INSERT INTO `note`(`id`, `title`, `content`, `category`, `time`, `uid`, `nbid`) VALUES (20, '雅思写作', '<blockquote><p>成功保存把！</p></blockquote>', '学习', '2020-04-06 04:06:57', 1, 1);
INSERT INTO `note`(`id`, `title`, `content`, `category`, `time`, `uid`, `nbid`) VALUES (21, '雅思听力', '<p>dqwdw</p>', '学习', '2020-04-06 04:07:01', 1, 1);
INSERT INTO `note`(`id`, `title`, `content`, `category`, `time`, `uid`, `nbid`) VALUES (22, '雅思词汇', '<p>dwdwdewde</p>', '学习', '2020-04-06 04:07:05', 1, 1);
INSERT INTO `note`(`id`, `title`, `content`, `category`, `time`, `uid`, `nbid`) VALUES (23, '雅思口语', '<p>wd22d</p>', '学习', '2020-04-06 04:07:08', 1, 1);
INSERT INTO `note`(`id`, `title`, `content`, `category`, `time`, `uid`, `nbid`) VALUES (24, '网课资料', '<p>fqe</p>', '学习', '2020-04-06 04:07:26', 1, 1);

