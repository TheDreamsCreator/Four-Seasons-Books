/*
Navicat MySQL Data Transfer

Source Server         : test
Source Server Version : 80019
Source Host           : 127.0.0.1:3306
Source Database       : db_book_manager

Target Server Type    : MYSQL
Target Server Version : 80019
File Encoding         : 65001

Date: 2023-03-24 15:53:47
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for authority
-- ----------------------------
DROP TABLE IF EXISTS `authority`;
CREATE TABLE `authority` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT 'id',
  `name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '用户名',
  PRIMARY KEY (`id`) USING BTREE,
  KEY `fk_admin_id` (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC COMMENT='管理员';

-- ----------------------------
-- Records of authority
-- ----------------------------
INSERT INTO `authority` VALUES ('1', '游客');
INSERT INTO `authority` VALUES ('2', '一般用户');
INSERT INTO `authority` VALUES ('3', '管理员');

-- ----------------------------
-- Table structure for book
-- ----------------------------
DROP TABLE IF EXISTS `book`;
CREATE TABLE `book` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `author` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `publisher` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `isbn` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `type` int NOT NULL,
  `description` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `is_borrow` int NOT NULL DEFAULT '0',
  `is_del` int NOT NULL DEFAULT '0',
  `borrow_id` int DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE KEY `fk_book_borrow` (`borrow_id`) USING BTREE,
  CONSTRAINT `fk_book_borrow` FOREIGN KEY (`borrow_id`) REFERENCES `borrow` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=55 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of book
-- ----------------------------
INSERT INTO `book` VALUES ('1', '鲁滨逊漂流记', '丹尼尔•笛福', '人民大学出版社', '978-3-50224-1', '9', null, '1', '0', null);
INSERT INTO `book` VALUES ('2', '红楼梦', '曹雪芹', '人民大学出版社', '978-3-50224-2', '9', null, '0', '0', null);
INSERT INTO `book` VALUES ('3', '西游记', '吴承恩', '人民大学出版社', '978-3-50224-3', '9', null, '0', '0', null);
INSERT INTO `book` VALUES ('4', '三国演义', '罗贯中', '人民大学出版社', '978-3-50224-4', '9', null, '0', '0', null);
INSERT INTO `book` VALUES ('5', '水浒传', '施耐庵', '人民大学出版社', '978-3-50224-5', '22', null, '0', '0', null);
INSERT INTO `book` VALUES ('6', '毛泽东选集', '毛泽东', '人民大学出版社', '978-3-50224-6', '22', null, '0', '0', null);
INSERT INTO `book` VALUES ('7', '资治通鉴', '司马光', '中华书局', '978-3-50224-7', '22', null, '0', '0', null);
INSERT INTO `book` VALUES ('8', '资治通鉴', '司马光', '中华书局', '978-3-50224-8', '22', null, '0', '0', null);
INSERT INTO `book` VALUES ('9', '三体', '刘慈欣', '美国托尔出版社', '978-3-50224-9', '22', null, '0', '0', null);
INSERT INTO `book` VALUES ('10', '斗破苍穹', '天蚕土豆', '长江少儿出版社', '978-3-50225-1', '22', null, '0', '0', null);
INSERT INTO `book` VALUES ('11', '基督山伯爵', '大仲马', '二十一世纪出版社', '978-3-50225-2', '22', null, '0', '0', null);
INSERT INTO `book` VALUES ('19', '红楼梦', '曹雪芹', '人民大学出版社', '978-3-50224-3', '9', null, '0', '0', null);
INSERT INTO `book` VALUES ('20', '水浒传', '施耐庵', '人民大学出版社', '978-3-50224-4', '9', null, '0', '1', null);
INSERT INTO `book` VALUES ('21', '西游记', '吴承恩', '人民大学出版社', '978-3-50224-5', '9', null, '0', '0', null);
INSERT INTO `book` VALUES ('22', '老人与海', '海明威', '清华大学出版社', '978-3-50224-6', '9', null, '0', '0', null);
INSERT INTO `book` VALUES ('23', '呐喊', '鲁迅', '人民大学出版社', '978-3-50224-7', '9', null, '0', '0', null);
INSERT INTO `book` VALUES ('24', '中国古代寓言故事', '邶笪钟', '北京人民文学出版社', '978-3-50224-8', '9', null, '0', '0', null);
INSERT INTO `book` VALUES ('25', '中外神话传说', '田新利', '北京人民文学出版社', '978-3-50224-9', '9', null, '0', '0', null);
INSERT INTO `book` VALUES ('26', '十万个为什么', '卢嘉锡', '少年儿童出版社', '978-3-50224-10', '7', null, '0', '0', null);
INSERT INTO `book` VALUES ('27', '与鸟儿一起飞翔', '郑作新', '湖南少儿出版社', '978-3-50224-11', '8', null, '0', '0', null);
INSERT INTO `book` VALUES ('28', '海底两万里', '(法)儒勒.凡尔纳', '北京教育出版社', '978-3-50224-12', '5', null, '0', '0', null);
INSERT INTO `book` VALUES ('29', '汉字的故事', '梅子涵', '上海科普出版社', '978-3-50224-13', '1', null, '0', '0', null);
INSERT INTO `book` VALUES ('30', '安徒生童话选集', '(丹麦)安徒生、叶君健·译', '林出版社', '978-3-50224-14', '9', null, '0', '0', null);
INSERT INTO `book` VALUES ('31', '克雷洛夫寓言全集', '(俄)克雷洛夫、裴家勤·译', '林出版社', '978-3-50224-15', '5', null, '0', '0', null);
INSERT INTO `book` VALUES ('32', '拉.封丹寓言', '(法)拉.封丹着，倪海曙', '上海译文出版社', '978-3-50224-16', '2', null, '0', '0', null);
INSERT INTO `book` VALUES ('33', '格林童话全集', '（德）雅各布.格林威廉.格林着译', '林出版社', '978-3-50224-17', '7', null, '0', '0', null);
INSERT INTO `book` VALUES ('34', '科学王国里的故事', '王会等', '河北少年儿童出版社', '978-3-50224-18', '6', null, '0', '0', null);
INSERT INTO `book` VALUES ('35', '神奇的符号', '苏步清', '湖南少儿出版社', '978-3-50224-19', '6', null, '0', '0', null);
INSERT INTO `book` VALUES ('36', '诗词中的科学', '唐鲁峰', '江苏人民出版社', '978-3-50224-20', '8', null, '0', '0', null);
INSERT INTO `book` VALUES ('37', '中国古代科幻故事集', '杨鹏、刘道远', '中国少年儿童出版社', '978-3-50224-21', '1', null, '0', '0', null);
INSERT INTO `book` VALUES ('38', '阿凡提的故事', '赵世杰', '中国少年儿童出版社', '978-3-50224-22', '3', null, '0', '0', null);
INSERT INTO `book` VALUES ('39', '123123', '张乐平', '少年儿童出版社', '978-3-50224-23', '8', null, '0', '0', null);
INSERT INTO `book` VALUES ('40', '宝葫芦的秘密', '张天翼', '农村读物出版社', '978-3-50224-24', '4', null, '0', '0', null);
INSERT INTO `book` VALUES ('41', '今年你七岁', '刘健屏', '中国少年儿童出版社', '978-3-50224-25', '6', null, '0', '0', null);
INSERT INTO `book` VALUES ('42', '荒漠奇踪', '严阵', '中国少年儿童出版社', '978-3-50224-26', '9', null, '0', '0', null);
INSERT INTO `book` VALUES ('43', '追寻生命的意义', '维克多·弗兰克', '清华大学出版社', '978-3-50224-27', '6', null, '0', '0', null);
INSERT INTO `book` VALUES ('44', '围城', '钱钟书', '人民文学出版社', '978-3-50224-28', '5', null, '0', '0', null);
INSERT INTO `book` VALUES ('45', '西方美学名著译稿', '宗白华编译', '江苏教育出版社', '978-3-50224-29', '2', null, '0', '0', null);
INSERT INTO `book` VALUES ('46', '儒林外史', '吴敬梓著', '人民文学出版社', '978-3-50224-30', '3', null, '0', '0', null);
INSERT INTO `book` VALUES ('47', '家', '巴金', '人民文学出版社', '978-3-50224-31', '4', null, '0', '0', null);
INSERT INTO `book` VALUES ('48', '马克思恩格斯论文学与艺术', '陆梅林辑注', '人民文学出版社', '978-3-50224-32', '8', null, '0', '0', null);
INSERT INTO `book` VALUES ('49', '伪君子', '（法）莫里哀', '上海译文出版社', '978-3-50224-33', '12', null, '0', '0', null);
INSERT INTO `book` VALUES ('50', '诗学', '亚里斯多德', '人民文学出版社', '978-3-50224-34', '10', null, '0', '0', null);
INSERT INTO `book` VALUES ('51', '卡拉马佐夫兄弟', '（俄）陀思妥耶夫斯基著，耿济之译', '人民文学出版社', '978-3-50224-35', '12', null, '0', '0', null);
INSERT INTO `book` VALUES ('52', '格林童话', '格林兄弟', '儿童文学出版社', '978-3-50224-36', '3', null, '0', '0', null);
INSERT INTO `book` VALUES ('53', '静夜思', '李白', '人民文学出版社', '978-3-50', '8', null, '0', '0', null);
INSERT INTO `book` VALUES ('54', '将进酒', '李白', '人民文学出版社', '978-3-50', '8', null, '0', '0', null);

-- ----------------------------
-- Table structure for borrow
-- ----------------------------
DROP TABLE IF EXISTS `borrow`;
CREATE TABLE `borrow` (
  `id` int NOT NULL AUTO_INCREMENT,
  `user_id` int DEFAULT NULL,
  `book_id` int DEFAULT NULL,
  `borrow_time` datetime DEFAULT NULL,
  `return_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  KEY `fk_borrow_book` (`book_id`) USING BTREE,
  KEY `fk_borrow_user` (`user_id`) USING BTREE,
  CONSTRAINT `fk_borrow_book` FOREIGN KEY (`book_id`) REFERENCES `book` (`id`),
  CONSTRAINT `fk_borrow_user` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of borrow
-- ----------------------------
INSERT INTO `borrow` VALUES ('10', '2', '5', '2022-10-21 10:21:08', null);
INSERT INTO `borrow` VALUES ('11', '1', '8', '2022-10-21 10:21:28', '2022-10-22 12:51:15');
INSERT INTO `borrow` VALUES ('12', '2', '3', '2022-10-21 10:37:31', null);
INSERT INTO `borrow` VALUES ('13', '2', '3', '2022-10-21 10:36:24', null);
INSERT INTO `borrow` VALUES ('14', '1', '2', '2022-10-21 08:37:28', '2022-10-22 12:51:12');
INSERT INTO `borrow` VALUES ('15', '1', '2', '2022-10-21 08:48:58', '2022-10-22 12:51:14');
INSERT INTO `borrow` VALUES ('16', '1', '1', '2022-10-24 06:53:59', '2022-10-24 06:54:13');
INSERT INTO `borrow` VALUES ('17', '1', '2', '2022-10-24 06:54:51', '2023-03-22 12:42:58');
INSERT INTO `borrow` VALUES ('18', '1', '9', '2022-10-24 07:00:13', '2022-10-24 07:00:28');
INSERT INTO `borrow` VALUES ('19', '1', '1', '2022-10-24 07:12:08', '2022-10-24 07:36:39');
INSERT INTO `borrow` VALUES ('20', '1', '9', '2022-10-24 07:37:45', '2022-10-24 15:38:44');
INSERT INTO `borrow` VALUES ('21', '1', '9', '2022-10-24 15:42:32', '2022-10-24 15:42:38');
INSERT INTO `borrow` VALUES ('22', '1', '9', '2022-10-24 15:43:36', '2022-10-24 15:44:26');
INSERT INTO `borrow` VALUES ('23', '1', '9', '2022-10-24 17:44:33', '2023-03-22 12:43:00');
INSERT INTO `borrow` VALUES ('24', '1', '7', '2022-10-24 15:46:29', '2023-03-22 12:43:01');
INSERT INTO `borrow` VALUES ('25', '1', '1', '2023-03-22 12:43:05', null);

-- ----------------------------
-- Table structure for type
-- ----------------------------
DROP TABLE IF EXISTS `type`;
CREATE TABLE `type` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL,
  `stock` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_inv_book` (`name`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of type
-- ----------------------------
INSERT INTO `type` VALUES ('1', '马列主义', null);
INSERT INTO `type` VALUES ('2', '哲学、宗教', null);
INSERT INTO `type` VALUES ('3', '社会科学总论', null);
INSERT INTO `type` VALUES ('4', '政治、法律', null);
INSERT INTO `type` VALUES ('5', '军事', null);
INSERT INTO `type` VALUES ('6', '经济', null);
INSERT INTO `type` VALUES ('7', '文化、科学、教育、体育', null);
INSERT INTO `type` VALUES ('8', '语言、文字', null);
INSERT INTO `type` VALUES ('9', '文学', null);
INSERT INTO `type` VALUES ('10', '艺术', null);
INSERT INTO `type` VALUES ('11', '历史、地理', null);
INSERT INTO `type` VALUES ('12', '自然科学总论', null);
INSERT INTO `type` VALUES ('13', '数理科学和化学', null);
INSERT INTO `type` VALUES ('14', '天文学、地球科学', null);
INSERT INTO `type` VALUES ('15', '生物科学', null);
INSERT INTO `type` VALUES ('16', '医药、卫生', null);
INSERT INTO `type` VALUES ('17', '农业科学', null);
INSERT INTO `type` VALUES ('18', '工业技术', null);
INSERT INTO `type` VALUES ('19', '交通运输', null);
INSERT INTO `type` VALUES ('20', '航空、航天', null);
INSERT INTO `type` VALUES ('21', '环境科学、劳动保护科学', null);
INSERT INTO `type` VALUES ('22', '综合性图书', null);

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT 'id',
  `authority` int NOT NULL,
  `account` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `nickname` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '用户名',
  `pwd` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '密码',
  `age` int DEFAULT NULL COMMENT '年龄',
  `email` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '邮箱',
  `cellphone` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '电话',
  `is_cancel` int DEFAULT '0',
  `borrow_id` int DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  KEY `fk_user_borrow` (`borrow_id`) USING BTREE,
  KEY `fk_user_authority` (`authority`),
  CONSTRAINT `fk_user_authority` FOREIGN KEY (`authority`) REFERENCES `authority` (`id`),
  CONSTRAINT `fk_user_borrow` FOREIGN KEY (`borrow_id`) REFERENCES `borrow` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC COMMENT='管理员';

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', '3', 'a123456789', '张三', 'asd1234.', '18', '12345678@qq.com', '12345', '0', null);
INSERT INTO `user` VALUES ('2', '2', 'b123456789', '小宋', 'zxc1234.', '20', '123456789@qq.com', '123456', '0', null);
INSERT INTO `user` VALUES ('5', '1', 'c123456678', '王五', '123456', '21', '123456@qq.com', '123456', '0', null);
INSERT INTO `user` VALUES ('6', '2', 'd123456789', '赵六', '123456', '22', '123456@qq.com', '123456', '0', null);
