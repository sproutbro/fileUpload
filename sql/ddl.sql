-- sq.tbl_file definition

CREATE TABLE `tbl_file` (
                            `no` int(11) DEFAULT NULL,
                            `file_name` varchar(45) DEFAULT NULL,
                            `repository_file_name` varchar(100) DEFAULT NULL,
                            `reg_date` timestamp NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;