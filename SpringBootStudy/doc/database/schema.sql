/******************************/
/* 스프링 스터디 2018-07-21 */
/******************************/

/* 
 * 1. 데이터베이스, 유저 생성
 */

	CREATE DATABASE SPRINGBOOT;
	GRANT ALL PRIVILEGES ON SPRINGBOOT.* To 'SPRINGBOOT'@'%' IDENTIFIED BY 'SPRINGBOOT';

	USE SPRINGBOOT;

/*
 * 2. 스키마
 */

	/* 게시판 테이블 */
	DROP TABLE IF EXISTS board;
	CREATE TABLE IF NOT EXISTS board (
		id				INT(10)			NOT NULL	AUTO_INCREMENT,
		title			VARCHAR(100)	NOT NULL,
		content			VARCHAR(5000) 	NOT NULL,
		hit				INT(10)			NOT NULL	DEFAULT 0,
		auth			VARCHAR(100)	NOT NULL,
		created_at 		TIMESTAMP		NOT NULL 	DEFAULT CURRENT_TIMESTAMP,
		updated_at		TIMESTAMP 		NULL,
	  	PRIMARY KEY (id),
	  	INDEX idx_id (id)
	) ENGINE=MyISAM AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;