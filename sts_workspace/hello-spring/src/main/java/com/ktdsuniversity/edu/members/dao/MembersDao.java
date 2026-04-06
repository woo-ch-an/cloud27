package com.ktdsuniversity.edu.members.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ktdsuniversity.edu.members.vo.MemberVO;
import com.ktdsuniversity.edu.members.vo.request.LoginVO;

@Mapper
public interface MembersDao {

	int insertNewMember(MemberVO memberVO);

	List<MemberVO> selectMemebers();

	int selectMembersCount();

	MemberVO selectMemeber(String memberName);

	int updateMemberByMemberEmail(MemberVO memberVO);

	int deleteMemberbyEmail(String email);

	MemberVO selectMemeberbyEmail(String memberEmail);

	int updateIncreaseLoginFailCount(String email);

	int updateBlock(String email);

	int updateSuccessLogin(LoginVO loginVO);

}
