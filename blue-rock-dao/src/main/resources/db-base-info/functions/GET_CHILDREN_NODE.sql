CREATE FUNCTION `GET_CHILDREN_DIRECTORY_IDS`(rootId VARCHAR(100))
    RETURNS VARCHAR(2000)
BEGIN
    DECLARE result VARCHAR(2000);
    DECLARE childrenIds VARCHAR(100);
    SET result = '$';
    SET childrenIds = rootId;
    WHILE childrenIds is not null DO
            SET result = concat(result, ',', childrenIds);
            SELECT group_concat(id) INTO childrenIds FROM ${tableName} where FIND_IN_SET(parent_id, childrenIds);
        END WHILE;
    RETURN SUBSTR(result, 3);
END;

-- NOTE: Column "id", "parent_id" are required.
-- Replacement: ${tableName}