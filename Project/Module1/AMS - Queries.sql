CREATE TABLE [Admin] (
	AdminID INT PRIMARY KEY IDENTITY(1,1),
	AdminName VARCHAR(20)
);

select * from MasterAssetType

INSERT INTO [ADMIN] VALUES ('Prathik'), ('Ashwin'); 

CREATE TABLE MasterAssetType (
    AssetTypeID INT PRIMARY KEY IDENTITY(1,1),
    AssetType VARCHAR(50) NOT NULL UNIQUE
);

INSERT INTO MasterAssetType VALUES ('Hardware'), ('Software'),('Operating System'); 


--Assigned
--UnAssignedS
--Stock
--Faulty/Repair
--End of Life

CREATE TABLE MasterAssetStatus (
	AssetStatusID INT PRIMARY KEY IDENTITY(1,1),
	AssetStatus VARCHAR(50)
);

	INSERT INTO MasterAssetStatus VALUES 
	('Assigned'), 
	('UnAssigned'),
	('Stock'),
	('Faulty/Repair'),
	('End of Life'); 


--Active
--InActive

CREATE TABLE MasterAssignedStatus (
	AssignedStatusID INT PRIMARY KEY IDENTITY(1,1),
	AssignedStatus VARCHAR(50)
);

	INSERT INTO MasterAssignedStatus VALUES ('Active'),('InActive');

select * from HardwareAssets

CREATE TABLE HardwareAssets (
    HardwareAssetID INT PRIMARY KEY IDENTITY(1,1),
    AssetName VARCHAR(100) NOT NULL,
    AssetType INT,
    Vendor INT,
    PurchaseDate DATE,
    PurchasePrice DECIMAL(18,2),
    WarrantyPeriod VARCHAR(50),
	WarrantyEndDate DATE,
	[Serial Number] VARCHAR(50),
	PurchaseLocation VARCHAR(50),
    AssetStatus INT,
	ManagedBy INT,
    Comments VARCHAR(MAX),
	FOREIGN KEY (AssetType) REFERENCES MasterAssetType (AssetTypeID),
	FOREIGN KEY (Vendor) REFERENCES Vendors (VendorID),
	FOREIGN KEY (AssetStatus) REFERENCES MasterAssetStatus (AssetStatusID)
);

select * from HardwareAssets

-- Insert additional hardware entries into HardwareAssets

	INSERT INTO HardwareAssets
	VALUES 
	('Dell Laptop', 1, 1, '2023-01-15', 1500.00, '3 years', '2026-01-15', 'SN123456', 'New York', 1, 1, 'In stock'),
	('HP Printer', 1, 2, '2023-02-10', 300.00, '1 year', '2024-02-10', 'SN789012', 'Los Angeles', 2, 2, 'In stock'),
	('Cisco Router', 1, 3, '2023-03-20', 800.00, '2 years', '2025-03-20', 'SN345678', 'Chicago', 3, 1, 'Ready for deployment'),
	('Lenovo Desktop', 1, 4, '2023-05-05', 1200.00, '3 years', '2026-05-05', 'SN901234', 'San Francisco', 1, 2, 'Available'),
	('Samsung Monitor', 1, 5, '2023-06-15', 250.00, '2 years', '2025-06-15', 'SN567890', 'Houston', 2, 1, 'In stock');

CREATE TABLE SoftwareAssets (
    SoftwareAssetID INT PRIMARY KEY IDENTITY(1,1),
    AssetName VARCHAR(100) NOT NULL,
    AssetType INT,
    PurchaseDate DATE,
    PurchasePrice DECIMAL(18,2),
	[Subscription Period] VARCHAR(50),
    ExpiryDate DATE,
    AssetStatus INT,
	ManagedBy INT,
    Comments VARCHAR(MAX),
	FOREIGN KEY (AssetType) REFERENCES MasterAssetType (AssetTypeID),
	FOREIGN KEY (AssetStatus) REFERENCES MasterAssetStatus (AssetStatusID)
);

	INSERT INTO SoftwareAssets 
	VALUES 
	('Adobe Photoshop', 2, '2023-04-05', 400.00, '1 year', '2024-04-05', 1, 1, 'In stock'),
	('Microsoft Office 365', 2, '2023-01-10', 100.00, '1 year', '2024-01-10', 1, 2, 'In stock'),
	('Norton Antivirus', 2, '2023-03-15', 50.00, '1 year', '2024-03-15', 1, 2, 'Ready for deployment'),
	('AutoCAD', 2, '2023-02-20', 1500.00, '1 year', '2024-02-20', 2, 2, 'Licensed software'),
	('Visual Studio', 2, '2023-06-25', 500.00, '1 year', '2024-06-25', 2, 1, 'Developer tool');


CREATE TABLE Vendors (
    VendorID INT PRIMARY KEY IDENTITY(1,1),
    VendorName VARCHAR(100) NOT NULL UNIQUE,
    ContactPerson VARCHAR(100),
    PhoneNumber VARCHAR(20),
    Email VARCHAR(100),
    [Address] VARCHAR(255),
    City NVARCHAR(100),
    [State] NVARCHAR(100),
    Country NVARCHAR(100)
);

INSERT INTO Vendors 
VALUES 
('Tech Supplies Inc.', 'Arun Kumar', '1234567890', 'arun.kumar@techsupplies.com', '1234 Elm St.', 'New York', 'NY', 'USA'),
('Office Essentials Co.', 'Murugesan', '2345678901', 'murugesan@officeessentials.com', '5678 Oak St.', 'Los Angeles', 'CA', 'USA'),
('Hardware Solutions', 'Sundar Raja', '3456789012', 'sundar.raja@hardwaresolutions.com', '9101 Pine St.', 'Chicago', 'IL', 'USA'),
('Software World', 'Lakshmi Narayan', '4567890123', 'lakshmi.narayan@softwareworld.com', '1122 Maple St.', 'San Francisco', 'CA', 'USA'),
('Network Systems', 'Vijay Sharma', '5678901234', 'vijay.sharma@networksystems.com', '3344 Cedar St.', 'Houston', 'TX', 'USA');


CREATE TABLE Employees (
    EmployeeID INT PRIMARY KEY IDENTITY(1,1),
    EmployeeName VARCHAR(100) NOT NULL,
    Email VARCHAR(100) NOT NULL UNIQUE,
    PhoneNumber VARCHAR(20),
    Designation VARCHAR(100)
);

	INSERT INTO Employees VALUES 
	('Prathik' , 'prathik@gmail.com','9876543213','Software Developer'),
	('Sita Ram', 'sita.ram@example.com', '1234567890', 'Project Manager'),
	('Amit Kumar', 'amit.kumar@example.com', '2345678901', 'Business Analyst'),
	('Deepa Menon', 'deepa.menon@example.com', '3456789012', 'UX Designer'),
	('Rajesh Gupta', 'rajesh.gupta@example.com', '4567890123', 'System Administrator'),
	('Anjali Sharma', 'anjali.sharma@example.com', '5678901234', 'QA Engineer');

CREATE TABLE HardwareAssigned (
    HardwareAssignedID INT PRIMARY KEY IDENTITY(1,1),
    HardwareAssetID INT,
    EmployeeID INT,
	AssignedBy INT,
    AssignedDate DATE NOT NULL,
	AssignedStatus INT,
	FOREIGN KEY (EmployeeID) REFERENCES Employees (EmployeeID),
	FOREIGN KEY (AssignedBy) REFERENCES [Admin] (AdminID),
	FOREIGN KEY (AssignedStatus) REFERENCES MasterAssignedStatus (AssignedStatusID),
	FOREIGN KEY (HardwareAssetID) REFERENCES HardwareAssets (HardwareAssetID)
);

		INSERT INTO HardwareAssigned VALUES 
		(2,1,2,GETDATE(),1),
		(3,1,2,GETDATE(),1),
		(2,3,1,GETDATE(),1),
		(2,4,1,GETDATE(),2);

CREATE TABLE SoftwareAssociated (
    SoftwareAssociatedID INT PRIMARY KEY IDENTITY(1,1),
    SoftwareAssetID INT,
	HardWareAssetID INT,
	AssignedBy INT,
    AssignedDate DATE NOT NULL,
	AssignedStatus INT,
	FOREIGN KEY (HardwareAssetID) REFERENCES HardwareAssets (HardwareAssetID),
	FOREIGN KEY (SoftwareAssetID) REFERENCES SoftwareAssets (SoftwareAssetID),
	FOREIGN KEY (AssignedBy) REFERENCES [Admin] (AdminID),
	FOREIGN KEY (AssignedStatus) REFERENCES MasterAssignedStatus (AssignedStatusID)
);

	INSERT INTO SoftwareAssociated VALUES
	(1,2,2,GETDATE(),1),
	(2,2,2,GETDATE(),1),
	(3,5,1,GETDATE(),1),
	(1,5,1,GETDATE(),1);

CREATE TABLE AssetAssignedHistory (
    AssignedHistoryID INT PRIMARY KEY IDENTITY(1,1),
    HardwareAssetID INT,
	AssetName VARCHAR(50),
    AssignedTO INT,
    Comments VARCHAR(MAX),
	FOREIGN KEY (HardwareAssetID) REFERENCES HardwareAssets (HardwareAssetID),
	FOREIGN KEY (AssignedTO) REFERENCES Employees (EmployeeID)
);

	INSERT INTO AssetAssignedHistory VALUES (2,'Dell Laptop',4 ,'Employee Exit');





