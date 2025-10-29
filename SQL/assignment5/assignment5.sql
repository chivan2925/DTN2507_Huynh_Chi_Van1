-- danh sach nhan vien phong sale
CREATE VIEW NhanVienPhongSale AS
SELECT * FROM account a
JOIN department d ON a.DepartmentID = d.DepartmentID
WHERE d.DepartmentName = 'Sale';

SELECT * FROM NhanVienPhongSale;



-- Tạo view có chứa thông tin các account tham gia vào nhiều group nhất
CREATE VIEW AthamGiaNhieuGr AS
SELECT * FROM account a
JOIN groupaccount ga ON a.AccountID = ga.AccountID
GROUP BY a.AccountID
HAVING COUNT(ga.GroupID) = (
    SELECT MAX(group_count)
    FROM (
        SELECT COUNT(GroupID) AS group_count
        FROM GroupAccount
        GROUP BY AccountID
    ) AS temp
);
SELECT * FROM AthamGiaNhieuGr;


--Tạo view có chứa danh sách các phòng ban có nhiều nhân viên nhất
CREATE OR REPLACE VIEW DNhieuNhanVienNhat AS
SELECT d.DepartmentID,d.DepartmentName,COUNT(a.AccountID) AS employee_count FROM department d
LEFT JOIN account a ON a.DepartmentID = d.DepartmentID
GROUP BY d.DepartmentID, d.DepartmentName
HAVING COUNT(a.AccountID) = (
    SELECT MAX(cnt)
    FROM (
        SELECT COUNT(a2.AccountID) AS cnt
        FROM Department d2
        LEFT JOIN Account a2 ON a2.DepartmentID = d2.DepartmentID
        GROUP BY d2.DepartmentID
    ) AS t
);
SELECT * FROM DNhieuNhanVienNhat;