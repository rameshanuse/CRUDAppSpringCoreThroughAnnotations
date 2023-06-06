package in.ineuron.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import in.ineuron.controller.MainController;
import in.ineuron.vo.EmployeeVO;

public class TestApp {
	public static void main(String[] args) throws Exception {
		
		System.out.println("WELCOME TO EMPLOYEE DATA MANAGEMENT APP");
		while (true) {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("1. CREATE");
			System.out.println("2. READ");
			System.out.println("3. UPDATE");
			System.out.println("4. DELETE");
			System.out.println("5. EXIT");
			System.out.print("ENTER UR CHOICE, PRESS[1/2/3/4/5]::  ");
			String option = br.readLine();

			switch (option) {
			case "1":
				insertOperation();
				break;
			case "2":
				selectOperation();
				break;
			case "3":
				updateOperation();
				break;
			case "4":
				deleteOperation();
				break;
			case "5":
				System.out.println("******* Thanks for using the application *****");
				System.exit(0);
			default:
				System.out.println("Invalid option plz try agin with valid options....");
				break;
			}

		}
		
	}

	public static void updateOperation() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("Enter the employeeID :: ");
		String eid = br.readLine();

		EmployeeVO employeeVO = new EmployeeVO();
		employeeVO.setEid(eid);

		ClassPathXmlApplicationContext factory = new ClassPathXmlApplicationContext(
				"in/ineuron/cfg/applicationContext.xml");
		System.out.println("***********Container Started**************");
		try {
			MainController controller = factory.getBean(MainController.class);

			EmployeeVO empVO = controller.searchEmployee(employeeVO);

			if (empVO != null) {
				EmployeeVO newEmpVO = new EmployeeVO();

				System.out.print("EmployeeID is :: " + empVO.getEid());
				newEmpVO.setEid(empVO.getEid());

				System.out.println();

				System.out.print("Employee old name is :: " + empVO.getEname() + " Enter newName :: ");
				String newName = br.readLine();
				if (newName.equals("") || newName == "") {
					newEmpVO.setEname(empVO.getEname());
				} else {
					newEmpVO.setEname(newName);
				}

				System.out.print("Employee old age is :: " + empVO.getEage() + " Enter newAge :: ");
				String newAge = br.readLine();
				if (newAge.equals("") || newAge == "") {
					newEmpVO.setEage(empVO.getEage());
				} else {
					newEmpVO.setEage(newAge);
				}

				System.out.print("Employee old address is :: " + empVO.getEaddr() + " Enter newAddress :: ");
				String newAddr = br.readLine();

				if (newAddr.equals("") || newAddr == "") {
					newEmpVO.setEaddr(empVO.getEaddr());
				} else {
					newEmpVO.setEaddr(newAddr);
				}

				System.out.println(newEmpVO);
				String result = controller.updateEmployee(newEmpVO);
				System.out.println(result);
			}
		} catch (Exception e) {
			System.out.println("Internal problem.. Try again..." + e.getMessage());
		}
		System.out.println("**********Container Stopped*****************");
	}

	public static void selectOperation() {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter the employeeID :: ");
		String eid = scanner.next();

		EmployeeVO employeeVO = new EmployeeVO();
		employeeVO.setEid(eid);

		ClassPathXmlApplicationContext factory = new ClassPathXmlApplicationContext(
				"in/ineuron/cfg/applicationContext.xml");
		System.out.println("***********Container Started**************");
		try {
			MainController controller = factory.getBean( MainController.class);
			EmployeeVO empVO = controller.searchEmployee(employeeVO);
			if (empVO != null) {
				System.out.println("EID\tENAME\tEAGE\tEADDRESS");
				System.out.println(
						empVO.getEid() + "\t" + empVO.getEname() + "\t" + empVO.getEage() + "\t" + empVO.getEaddr());
			} else {
				System.out.println("Record not found for employeeID :: " + eid);
			}
		} catch (Exception e) {
			System.out.println("Internal problem.. Try again..." + e.getMessage());
		}
		System.out.println("**********Container Stopped*****************");
	}

	public static void deleteOperation() {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter the employeeID :: ");
		String eid = scanner.next();

		EmployeeVO employeeVO = new EmployeeVO();
		employeeVO.setEid(eid);

		ClassPathXmlApplicationContext factory = new ClassPathXmlApplicationContext(
				"in/ineuron/cfg/applicationContext.xml");
		System.out.println("***********Container Started**************");
		try {
			MainController controller = factory.getBean(MainController.class);
			String result = controller.deleteEmployee(employeeVO);
			System.out.println(result);
		} catch (Exception e) {
			System.out.println("Internal problem.. Try again..." + e.getMessage());
		}
		System.out.println("**********Container Stopped*****************");
	}

	@SuppressWarnings("resource")
	public static void insertOperation() throws IOException {
		// Reading the inputs
		Scanner scanner = new Scanner(System.in);

		System.out.print("Enter the employeeName :: ");
		String employeeName = scanner.next();

		System.out.print("Enter the employeeAge :: ");
		String employeeAge = scanner.next();

		System.out.print("Enter the employeeAddress :: ");
		String employeeAddress = scanner.next();

		EmployeeVO employeeVO = new EmployeeVO();
		employeeVO.setEname(employeeName);
		employeeVO.setEage(employeeAge);
		employeeVO.setEaddr(employeeAddress);

		ClassPathXmlApplicationContext factory = new ClassPathXmlApplicationContext(
				"in/ineuron/cfg/applicationContext.xml");
		System.out.println("***********Container Started**************");
		try {
			MainController controller = factory.getBean(MainController.class);
			String result = controller.saveEmployee(employeeVO);
			System.out.println(result);
		} catch (Exception e) {
			System.out.println("Internal problem.. Try again..." + e.getMessage());
		}
		System.out.println("**********Container Stopped*****************");
	}

}
