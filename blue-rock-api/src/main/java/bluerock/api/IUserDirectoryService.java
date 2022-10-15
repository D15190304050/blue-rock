package bluerock.api;

import bluerock.domain.UserDirectory;
import bluerock.model.StorageObject;
import bluerock.params.DeleteParam;
import bluerock.params.CreateDirectoryParam;
import bluerock.params.RenameParam;
import bluerock.params.ShowDirectoryAndFileParam;
import dataworks.web.commons.ServiceResponse;
import org.springframework.validation.annotation.Validated;

import java.util.List;

public interface IUserDirectoryService
{
    ServiceResponse<List<UserDirectory>> showDirectories(ShowDirectoryAndFileParam showDirectoryParam);
    ServiceResponse<List<StorageObject>> showContentsInDirectory(ShowDirectoryAndFileParam showParam);
    ServiceResponse<Boolean> createDirectory(CreateDirectoryParam createParam);
    ServiceResponse<Boolean> renameDirectory(@Validated RenameParam renameParam);
    String getDirectoryPathById(Long id);
    ServiceResponse<Boolean> canDelete(DeleteParam deleteParam);
    List<Long> getAllChildrenIds(long id);
    ServiceResponse<Boolean> deleteDirectory(DeleteParam deleteParam);
}
