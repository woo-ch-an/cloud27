package org.themoviedb.www.files.dao;

import org.apache.ibatis.annotations.Mapper;
import org.themoviedb.www.files.vo.request.UploadVO;
import org.themoviedb.www.files.vo.response.DownloadVO;

@Mapper
public interface FilesDao {

	int insertAttachFile(UploadVO uploadVO);

	DownloadVO selectFilesByFileGroupAndFileNum(String fileGroupId);

}
