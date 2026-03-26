package com.ktdsuniversity.edu.board.service;

import com.ktdsuniversity.edu.members.vo.SearchResultVO;

/**
 * 상황별
 * 		회원의 등급이 다르다 -> 일반 사용자 고ㅓㄴ리자 슈퍼관리자 운영자 등 
 * 		애플리케이션의 버전이 다르다 
 * 	로알맞는 처리를 위해 인터페이스를 제공 
 * 		상황에 맞추워 클래스를 생성해 사용자ㅔ게 제공
 * 서비스의 목적 -> 트랜잭션 처리 (이체 같은거)
 */
public interface BoardService {

	SearchResultVO findAllBoard();

}
