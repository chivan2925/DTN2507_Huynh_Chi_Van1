-- lấy ra tất cả các phòng ban
SELECT * FROM department;

--lấy ra id của phòng ban "Sale"
SELECT DepartmentID FROM department WHERE DepartmentName = 'Sales';

-- thông tin account có tên dài nhất
SELECT *
FROM account
WHERE
    CHAR_LENGTH(FullName) = (
        SELECT MAX(CHAR_LENGTH(FullName))
        FROM account
    );

-- thông tin account có tên dài nhất trong phòng ban id là 3
SELECT *
FROM account
WHERE
    DepartmentID = 3
    AND CHAR_LENGTH(FullName) = (
        SELECT MAX(CHAR_LENGTH(FullName))
        FROM account
        WHERE
            DepartmentID = 3
    );

-- Lấy ra tên group đã tham gia trước ngày 20/12/2019
SELECT * FROM group WHERE CreateDate < '2025-10-24';

--Lấy ra 5 group được tạo gần đây nhất
SELECT * FROM group ORDER BY CreateDate DESC LIMIT 5;
-- limit 5: 5 group đầu tiên

--đếm nhân viên có id bằng 2
SELECT count(AccountID) FROM Account WHERE DepartmentID = 2;

-- Lấy ra nhân viên có tên bắt đầu bằng chữ "D" và kết thúc bằng chữ "o"
SELECT * FROM Acount WHERE FULLNAME LIKE 'D%o';

--Xóa tất cả các exam được tạo trước ngày 20/12/2019
DELETE FROM Exam WHERE CreateDate < '2019-12-20';

--Xóa tất cả các question có nội dung bắt đầu bằng từ "câu hỏi"
DELETE FROM Question WHERE Content Like 'câu hỏi%'

--Update thông tin của account có id = 5 thành tên "Nguyễn Bá Lộc" và
-- email thành loc.nguyenba@vti.com.vn
UPDATE Account SET FullName = "Nguyễn Bá Lộc", email = "loc.nguyenba@vti.com.vn" WHERE AccountID = 5;

--cập nhật i
UPDATE GrouppAccount SET GroupID = '4' WHERE AccountID = '5';