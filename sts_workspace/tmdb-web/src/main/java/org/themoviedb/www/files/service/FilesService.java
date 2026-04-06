package org.themoviedb.www.files.service;

import org.themoviedb.www.files.vo.response.DownloadVO;

public interface FilesService {

	DownloadVO findAttachFile(String fileGroupId);

}
