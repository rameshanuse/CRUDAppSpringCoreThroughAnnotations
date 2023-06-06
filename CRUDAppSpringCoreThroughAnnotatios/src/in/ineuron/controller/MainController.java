package in.ineuron.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import in.ineuron.dto.EmployeeDTO;
import in.ineuron.service.IEmployeeService;
import in.ineuron.vo.EmployeeVO;

@Component
public class MainController {
	
	@Autowired
	private IEmployeeService service;

	public String saveEmployee(EmployeeVO vo) throws Exception {
		System.out.println("MainController.saveEmployee()");
		EmployeeDTO dto = new EmployeeDTO();
		dto.setEname(vo.getEname());
		dto.setEage(Integer.parseInt(vo.getEage()));
		dto.setEaddr(vo.getEaddr());
		return service.save(dto);
	}
	
	public String deleteEmployee(EmployeeVO vo) throws Exception {
		EmployeeDTO dto = new EmployeeDTO();
		dto.setEid(Integer.parseInt(vo.getEid())); 
		return service.deleteById(dto);
	}
	
	public EmployeeVO searchEmployee(EmployeeVO employeeVO) throws Exception {
		EmployeeDTO dto = new EmployeeDTO();
		dto.setEid(Integer.parseInt(employeeVO.getEid())); 
		
		EmployeeDTO empDTO = service.findById(dto);
		EmployeeVO empVO = new EmployeeVO();
		empVO.setEid(empDTO.getEid().toString());
		empVO.setEname(empDTO.getEname());
		empVO.setEage(empDTO.getEage().toString());
		empVO.setEaddr(empDTO.getEaddr());
		
		return empVO;
	}
	
	public String updateEmployee(EmployeeVO vo) throws Exception {
		EmployeeDTO dto = new EmployeeDTO();
		dto.setEid(Integer.parseInt(vo.getEid())); 
		dto.setEname(vo.getEname());
		dto.setEage(Integer.parseInt(vo.getEage()));
		dto.setEaddr(vo.getEaddr());
		
		return service.updateById(dto); 
	}
	
}
