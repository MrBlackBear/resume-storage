package exception

class NotExistStorageException(uuid: String) : StorageException("Resume $uuid not exist", uuid)
