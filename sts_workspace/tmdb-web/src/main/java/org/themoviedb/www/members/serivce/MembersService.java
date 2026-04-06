package org.themoviedb.www.members.serivce;

import org.themoviedb.www.members.vo.MembersVO;


public interface MembersService {

	MembersVO selectMember(String email);

	boolean createNewMember(MembersVO membersVO);

}
