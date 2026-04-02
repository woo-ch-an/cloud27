package org.themoviedb.www.files.dao;

import org.apache.ibatis.annotations.Mapper;
import org.themoviedb.www.files.vo.request.UploadVO;

@Mapper
public interface FilesDao {

	int insertAttachFile(UploadVO uploadVO);

}
