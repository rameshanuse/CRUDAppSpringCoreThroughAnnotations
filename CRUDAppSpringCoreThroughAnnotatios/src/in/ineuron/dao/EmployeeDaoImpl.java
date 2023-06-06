package in.ineuron.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import in.ineuron.bo.EmployeeBO;
import in.ineuron.dto.EmployeeDTO;

@Repository
public class EmployeeDaoImpl implements IEmployeeDao {
 
	@Autowired
	private DataSource dataSource;
	
	private static final String EMPLOYEE_DELETE_QUERY = "delete from employee where eid = ?";
	private static final String EMPLOYEE_INSERT_QUERY = "insert into employee(`ename`,`eage`,`eaddress`)values(?,?,?)";
	private static final String EMPLOYEE_SEARCH_QUERY = "select eid, ename, eage, eaddress from employee where eid = ?";
	private static final String EMPLOYEE_UPDATE_QUERY = "update employee set ename = ?, eage = ?, eaddress = ? where eid = ?";

	public EmployeeDaoImpl(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	@Override
	public int save(EmployeeBO bo) throws Exception {
		int count = 0;
		try (Connection connection = dataSource.getConnection();
				PreparedStatement pstmt = connection.prepareStatement(EMPLOYEE_INSERT_QUERY)) {

			pstmt.setString(1, bo.getEname());
			pstmt.setInt(2, bo.getEage());
			pstmt.setString(3, bo.getEaddr());

			count = pstmt.executeUpdate();

		} catch (SQLException se) {
			se.printStackTrace();
			throw se;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}

		return count;
	}

	@Override
	public EmployeeBO findById(EmployeeBO bo) throws Exception {
		EmployeeBO employeeBO = null;
		ResultSet resultSet = null;
		try (Connection connection = dataSource.getConnection();
				PreparedStatement pstmt = connection.prepareStatement(EMPLOYEE_SEARCH_QUERY)) {

			pstmt.setInt(1, bo.getEid());
			resultSet = pstmt.executeQuery();
			if (resultSet != null) {
				if (resultSet.next()) {
					employeeBO = new EmployeeBO();
					employeeBO.setEid(resultSet.getInt(1));
					employeeBO.setEname(resultSet.getString(2));
					employeeBO.setEage(resultSet.getInt(3));
					employeeBO.setEaddr(resultSet.getString(4));

				}
			}

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return employeeBO;
	}

	@Override
	public int updateById(EmployeeBO bo) throws Exception {
		int count = 0;
		try(Connection connection = dataSource.getConnection();
				PreparedStatement pstmt = connection.prepareStatement(EMPLOYEE_UPDATE_QUERY)){
			pstmt.setString(1, bo.getEname());
			pstmt.setInt(2, bo.getEage());
			pstmt.setString(3, bo.getEaddr());
			pstmt.setInt(4, bo.getEid());
			
			count = pstmt.executeUpdate();
		}
		return count;
	}

	@Override
	public int deleteById(EmployeeBO bo) throws Exception {
		int count = 0;
		try (Connection connection = dataSource.getConnection();
				PreparedStatement pstmt = connection.prepareStatement(EMPLOYEE_DELETE_QUERY)) {

			pstmt.setInt(1, bo.getEid());
			count = pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return count;
	}

}
