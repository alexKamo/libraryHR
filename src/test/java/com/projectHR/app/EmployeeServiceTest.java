package com.projectHR.app;

import com.projectHR.app.dao.EmployeeDAO;
import com.projectHR.app.entity.Employee;
import com.projectHR.app.service.EmployeeServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class EmployeeServiceTest {

    @Mock
    private EmployeeDAO employeeDAO;

    //  EmployeeServiceImpl employeeService = new EmployeeServiceImpl(employeeDAO);
    @InjectMocks
    private EmployeeServiceImpl employeeService;

    @BeforeEach
    void setUp(){
        MockitoAnnotations.openMocks(this);
    }


    // TEST findAll();
    // TEST findById();
    // TEST findById when exception throw
    // TEST save employee;
    // TEST delete employee;


}
