USE TestingSystem;
-- cau 4
DROP PROCEDURE IF EXISTS sp_GetTypeQ; 
DELIMITER $$
CREATE PROCEDURE sp_GetTypeQ(OUT v_typeID INT)
BEGIN
	SELECT TypeID INTO v_TypeID FROM Question
	GROUP BY TypeID ORDER BY COUNT(QuestionID) DESC
	LIMIT 1;
END$$

DELIMITER ;
CALL sp_GetTypeQ(@type_id);
SELECT @type_id AS 'id của type question có nhiều câu hỏi nhất';
-- cau 5 Sử dụng store ở question 4 để tìm ra tên của type question
DROP PROCEDURE IF EXISTS sp_GetTypeQName; 
DELIMITER $$
CREATE PROCEDURE sp_GetTypeQName()
BEGIN
    -- bien
	DECLARE temp INT;
    CALL sp_GetTypeQ(temp);
	SELECT t.TypeID,t.TypeName FROM TypeQuestion t WHERE t.TypeID = temp;
END$$

DELIMITER ;
CALL sp_GetTypeQName();
