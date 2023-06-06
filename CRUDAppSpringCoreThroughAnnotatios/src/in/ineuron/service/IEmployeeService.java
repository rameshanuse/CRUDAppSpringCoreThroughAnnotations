package in.ineuron.service;

import in.ineuron.dto.EmployeeDTO;

public interface IEmployeeService {
	public String save(EmployeeDTO dto) throws Exception;
	
	public EmployeeDTO findById(EmployeeDTO dto) throws Exception;
	
	public String updateById(EmployeeDTO dto) throws Exception;
	
	public String deleteById(EmployeeDTO dto) throws Exception;

}
