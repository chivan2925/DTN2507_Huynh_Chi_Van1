

--Viết lệnh để lấy ra danh sách câu hỏi được sử dụng trong đề thi nhiều nhất
SELECT q.QuestionID, q.Content, COUNT(eq.ExamID) AS used_in_exams
FROM Question q
JOIN ExamQuestion eq ON eq.QuestionID = q.QuestionID
GROUP BY q.QuestionID, q.Content
HAVING COUNT(eq.ExamID) = (
  SELECT MAX(cnt)
  FROM (
    SELECT COUNT(*) AS cnt
    FROM ExamQuestion
    GROUP BY QuestionID
  ) t
);

CREATE OR REPLACE VIEW vw_MaxQuestionUsingExam AS (
	WITH cte_maxCount as(
	SELECT count(*) AS SL FROM examquestion ex
	GROUP BY ex.QuestionID
	)
	SELECT ex.QuestionID, q.Content, count(1) COUNT FROM examquestion ex
	INNER JOIN question q ON ex.QuestionID = q.QuestionID
	GROUP BY ex.QuestionID
	HAVING count(1) = (SELECT max(SL) FROM cte_maxCount)
);

--Thông kê mỗi Question được sử dụng trong bao nhiêu Exam
SELECT q.QuestionID, q.Content, COUNT(eq.ExamID) AS exam_count
FROM Question q
LEFT JOIN ExamQuestion eq ON eq.QuestionID = q.QuestionID
GROUP BY q.QuestionID, q.Content
ORDER BY exam_count DESC, q.QuestionID;
--Lấy ra Question có nhiều câu trả lời nhất
SELECT q.QuestionID, q.Content, COUNT(a.AnswerID) AS answer_count
FROM Question q
JOIN Answer a ON a.QuestionID = q.QuestionID
GROUP BY q.QuestionID, q.Content
HAVING COUNT(a.AnswerID) = (
  SELECT MAX(cnt)
  FROM (
    SELECT COUNT(*) AS cnt
    FROM Answer
    GROUP BY QuestionID
  ) t
);
--Thống kê số lượng account trong mỗi group
SELECT g.GroupID, g.GroupName, COUNT(ga.AccountID) AS member_count
FROM group g
LEFT JOIN GroupAccount ga ON ga.GroupID = g.GroupID
GROUP BY g.GroupID, g.GroupName;

 --
 SELECT p.PositionID, p.PositionName, COUNT(a.AccountID) AS headcount
FROM Position p
LEFT JOIN Account a ON a.PositionID = p.PositionID
GROUP BY p.PositionID, p.PositionName
HAVING COUNT(a.AccountID) = (
  SELECT MIN(cn) FROM (
    SELECT COUNT(a2.AccountID) AS cn
    FROM Position p2
    LEFT JOIN Account a2 ON a2.PositionID = p2.PositionID
    GROUP BY p2.PositionID
  ) x
);


