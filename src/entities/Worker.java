package entities;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import entities.enums.WorkerLevel;

public class Worker {
	private String name;
	private WorkerLevel level;
	private double baseSalary;
	
	//Composição "tem um", entra no construtor
	private Department department;
	
	//Composição "tem vários", não entra lista no construtor, somente inicia a lista
	private List <HourContract> contracts = new ArrayList<>();
	
	public Worker () {
		
	}

	public Worker(String name, WorkerLevel level, double baseSalary, Department department) {
		this.name = name;
		this.level = level;
		this.baseSalary = baseSalary;
		this.department = department;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public WorkerLevel getLevel() {
		return level;
	}

	public void setLevel(WorkerLevel level) {
		this.level = level;
	}

	public double getBaseSalary() {
		return baseSalary;
	}

	public void setBaseSalary(double baseSalary) {
		this.baseSalary = baseSalary;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public List<HourContract> getContracts() {
		return contracts;
	}

	//Adiciona um contrato ao trabalhador
	public void addContract(HourContract contract) {
		contracts.add(contract);
	}
	//Remove um contrato do trabalhador
	public void removeContract(HourContract contract) {
		contracts.remove(contract);
	}
	//Função para verificar o valor recebido dado um mês e ano
	public double income(int year, int month) {
		double sum = baseSalary;
		
		//Instanciando um objeto calendar para verificar o mês e ano
		Calendar cal = Calendar.getInstance();
		
		//Passando a lista de contratos 
		for (HourContract c: contracts ) {
			
			//Chamando o objeto calendar
			cal.setTime(c.getDate());
			int c_year = cal.get(Calendar.YEAR);
			int c_month =  1 + cal.get(Calendar.MONTH);
			
			//Verificar o ano e mês na lista iguais ao passado como parâmetro
			if(year == c_year && month == c_month) {
				sum += c.totalValue();
			}
		}
		return sum;
	}
}
