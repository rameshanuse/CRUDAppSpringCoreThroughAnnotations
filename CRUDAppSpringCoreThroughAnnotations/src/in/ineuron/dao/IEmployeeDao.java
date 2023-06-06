package in.ineuron.dao;

import in.ineuron.bo.EmployeeBO;
import in.ineuron.dto.EmployeeDTO;
import in.ineuron.vo.EmployeeVO;

public interface IEmployeeDao {
	public int save(EmployeeBO bo) throws Exception;

	public EmployeeBO findById(EmployeeBO bo)throws Exception;

	public int updateById(EmployeeBO bo)throws Exception;

	public int deleteById(EmployeeBO bo)throws Exception;
}
