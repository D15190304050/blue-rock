package bluerock.dao;

import bluerock.domain.FileMetadata;
import bluerock.params.CanUploadFileParam;
import bluerock.params.RenameParam;
import bluerock.params.ShowDirectoryAndFileParam;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FileMetadataMapper
{
    List<FileMetadata> showFilesByConditions(ShowDirectoryAndFileParam showFileParam);
    int countFileByCondition(CanUploadFileParam canUploadFileParam);
    FileMetadata getFileMetadataByIdAndUserId(long userId, long id);
    int insertNew(FileMetadata fileMetadata);
    List<FileMetadata> getFilesInDirectories(@Param("userId") long userId, @Param("directoryIds") List<Long> directoryIds);
    int deleteFilesByIds(@Param("userId") long userId, @Param("fileIds") List<Long> fileIds);
    int countFileByIdAndUserId(@Param("id") long id, @Param("userId") long userId);
    int updateNameById(RenameParam renameParam);
    List<Long> getFileIdsNotBelongToUser(@Param("userId") long userId, @Param("fileIds") List<Long> fileIds);
}