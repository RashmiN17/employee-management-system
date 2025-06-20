package com.example.employee_management_system.daoImpl;

import java.util.List;

import javax.management.RuntimeErrorException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.employee_management_system.dao.EmployeeDao;
import com.example.employee_management_system.entity.DepartmentEntity;
import com.example.employee_management_system.entity.DesignationEntity;
import com.example.employee_management_system.entity.EmployeeEntity;
import com.example.employee_management_system.pojo.CommonGetPayloadPojo;
import com.example.employee_management_system.pojo.EmployeePojo;
import com.example.employee_management_system.pojo.ResponsePojo;
import com.example.employee_management_system.repo.DepartmentRepo;
import com.example.employee_management_system.repo.DesignationRepo;
import com.example.employee_management_system.repo.EmployeeRepo;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;

@Service
public class EmployeeDaoImpl implements EmployeeDao {
	
	@Autowired
	EmployeeRepo repo;
	
	@Autowired
	DesignationRepo desingationRepo;
	
	@Autowired
	DepartmentRepo departmentRepo;
	
	@PersistenceContext
	EntityManager entityManager;

	@Override
	public ResponsePojo getAllEmployees(CommonGetPayloadPojo pojo) {
		ResponsePojo result=new ResponsePojo();
		CriteriaBuilder cb=entityManager.getCriteriaBuilder();
		
		
		
		try {
			CriteriaQuery<EmployeeEntity>cq=cb.createQuery(EmployeeEntity.class);
			Root<EmployeeEntity>root=cq.from(EmployeeEntity.class);
			

			
			Predicate searchPredicate=cb.or(cb.like(root.get("empName"), "%"+pojo.getSearch()+"%"),
					cb.like(root.get("designation").get("name"),"%"+pojo.getSearch()+"%"));
			
			if (pojo.getSearch()!="") {
				pojo.setSearch("%"+pojo.getSearch().toLowerCase()+"%");
				
				
				cq.where(searchPredicate);
			}
			
			if (pojo.getDepartmentFilter() != null && !pojo.getDepartmentFilter().isEmpty()) {
				Predicate departmentIdPredicate=root.get("department").get("id").in(pojo.getDepartmentFilter());
				cq.where(departmentIdPredicate);
				
			}
			TypedQuery<EmployeeEntity> typedQuery=entityManager.createQuery(cq);
			
			if (pojo.getNoOfRecords() != 0) {
				typedQuery=entityManager.createQuery(cq).setFirstResult(pojo.getNoOfRecords()*pojo.getPageNo()).setMaxResults(pojo.getNoOfRecords());
			}
			
			
			List<EmployeeEntity> list=typedQuery.getResultList();
			
			CriteriaQuery<Long>countQuery=cb.createQuery(Long.class);
			Root<EmployeeEntity>countRoot=countQuery.from(EmployeeEntity.class);
			 Predicate countPredicate = cb.conjunction();

		        // Reuse same search logic
		        if (pojo.getSearch() != null && !pojo.getSearch().trim().isEmpty()) {
		            String search = "%" + pojo.getSearch().toLowerCase() + "%";
		            countPredicate = cb.and(countPredicate, cb.or(
		                cb.like(cb.lower(countRoot.get("empName")), search),
		                cb.like(cb.lower(countRoot.get("designation").get("name")), search)
		            ));
		        }

		        // Reuse department filter
		        if (pojo.getDepartmentFilter() != null && !pojo.getDepartmentFilter().isEmpty()) {
		            countPredicate = cb.and(countPredicate,
		                countRoot.get("department").get("id").in(pojo.getDepartmentFilter())
		            );
		        }

		        countQuery.select(cb.count(countRoot)).where(countPredicate);
		        Long totalNoOfRecords = entityManager.createQuery(countQuery).getSingleResult();
			
//			List<EmployeeEntity> employees=repo.findAll();
			result.setData(list);
			result.setStatus(true);
			result.setTotalRecords(totalNoOfRecords.intValue());
			result.setMessage("Employee List Fetched Successfully");
		} catch (Exception e) {
			result.setStatus(false);
			result.setMessage("Exception while fetching the data");
			e.printStackTrace();
		}
		
		return result;
	}

	@Override
	public ResponsePojo getDesignationList() {
		ResponsePojo result=new ResponsePojo();
		
		try {
			List<DesignationEntity>designationList=desingationRepo.findAll();
			result.setData(designationList);
			result.setMessage("Designation List Fetched Sucessfully");
			result.setStatus(true);
		} catch (Exception e) {
			result.setStatus(false);
			result.setMessage("Exception while fetching data");
			e.printStackTrace();
		}
		
		
		return result;
	}

	@Override
	public ResponsePojo addEmployee(EmployeePojo pojo) {
		ResponsePojo result=new ResponsePojo();
		System.err.println(pojo);
		try {
			 DesignationEntity designation = desingationRepo.findById(pojo.getDesignationId())
				        .orElseThrow(() -> new RuntimeException("Designation not found"));
			 DepartmentEntity department = departmentRepo.findById(pojo.getDepartmentId())
				        .orElseThrow(() -> new RuntimeException("Department not found"));
			 
			EmployeeEntity entity=new EmployeeEntity();
			entity.setEmpName(pojo.getEmpName());
			entity.setSalary(pojo.getSalary());
			entity.setDesignation(designation);
			entity.setDepartment(department);
			
			repo.save(entity);
			result.setStatus(true);
			result.setMessage("Employee Added Successfully");
		} catch (Exception e) {
			result.setStatus(false);
			result.setMessage("Exception while saving employee");
			e.printStackTrace();
		}
		
		return result;
	}

	@Override
	public ResponsePojo updateEmployee(Integer empId,EmployeePojo pojo) {
		ResponsePojo result=new ResponsePojo();
		try {
			DesignationEntity designation = desingationRepo.findById(pojo.getDesignationId())
			        .orElseThrow(() -> new RuntimeException("Designation not found"));
			
			DepartmentEntity department=departmentRepo.findById(pojo.getDepartmentId()).orElseThrow(()-> new RuntimeException("Department not found"));
			EmployeeEntity entity=repo.findById(empId).orElseThrow(()-> new RuntimeException("Employee Not Found"));
			
			
			entity.setEmpName(pojo.getEmpName());
			entity.setSalary(pojo.getSalary());
			entity.setDesignation(designation);
			entity.setDepartment(department);
			repo.save(entity);
			result.setStatus(true);
			result.setMessage("Employee Updated Successfully");
		} catch (Exception e) {
			result.setMessage("Exception while updating employee");
			result.setStatus(false);
			e.printStackTrace();
		}
		
		return result;
	}

	@Override
	public ResponsePojo deleteEmployee(Integer empId) {
		ResponsePojo result=new ResponsePojo();
		try {
			EmployeeEntity entity=repo.findById(empId).orElseThrow(()-> new RuntimeException("Employee Not Found"));
			repo.delete(entity);
			
			result.setStatus(true);
			result.setMessage("Employee Deleted Successfully");
			
		} catch (Exception e) {
			result.setMessage("Exception while deleting employee");
			result.setStatus(false);
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public ResponsePojo getEmployeeById(Integer empId) {
		ResponsePojo result=new ResponsePojo();
		try {
			EmployeeEntity entity=repo.findById(empId).orElseThrow(()-> new RuntimeException("Employee Not Found"));
			result.setData(entity);
			result.setStatus(true);
			result.setMessage("Employee Fetched By Id Successfully");
		} catch (Exception e) {
			result.setMessage("Exception while fetching employee");
			result.setStatus(false);
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public ResponsePojo getDepartmentList() {
		ResponsePojo result=new ResponsePojo();
		try {
			List<DepartmentEntity> list=departmentRepo.findAll();
			
			result.setData(list);
			result.setStatus(true);
			result.setMessage("Designation List Fetched Successfully");
		} catch (Exception e) {
			result.setStatus(false);
			result.setMessage("Exception while fetching the list");
			e.printStackTrace();
		}
		
		return result;
	}

}
