package com.mycompany.service;

import static org.junit.Assert.assertNotNull;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.mycompany.model.Patient;
import com.mycompany.model.RoleCopy;
import com.mycompany.model.SysRight;
import com.mycompany.model.SysUser;
import com.mycompany.model.Trainning;

@Transactional(Transactional.TxType.NOT_SUPPORTED)
public class SysRoleManagerTest  extends BaseManagerTestCase {

	 private Log log = LogFactory.getLog(SysRoleManagerTest.class);

	    @Autowired
	    private RoleCopyManager roleManager;
	    @Autowired
	    private SysRoleManager sysManager;
	    @Autowired
	    private SysUserManager userManager;
	    @Autowired
	    private SysRightManager rightManager;
	    @Autowired
	    private PatientManager patientManager;
	    @Test
	    public void testGetUser() throws Exception {
	        List list = roleManager.getAll();
	        RoleCopy rc = roleManager.get(1L);
	        assertNotNull(rc);
	        assertNotNull(list);
//	        assertEquals(1, list.size());
	    }
	    @Test
	    public void testSysRole() throws Exception {
	        List list = sysManager.getAll();
	        
	        assertNotNull(list);
//	        assertEquals(1, list.size());
	    }
	    
	    @Test
	    public void testSysUser() throws Exception {
	        List list = userManager.getAll();
	        SysUser rc = userManager.get(1L);
	        assertNotNull(rc);
	        assertNotNull(list);
//	        assertEquals(1, list.size());
	    }
	    
	    @Test
	    public void testSysRight() throws Exception {
	        List list = rightManager.getAll();
	        SysRight rc = rightManager.get(1L);
	        assertNotNull(rc);
	        assertNotNull(list);
//	        assertEquals(1, list.size());
	    }
	    @Test
	    public void testAddPatient() throws Exception{
	    	Patient p = new Patient();
	    	p.setName("ssss");
	    	p.setNo("NO00001");
	    	p.setGender(1);
	    	p.setAge(8);
	    	Calendar cal = Calendar.getInstance();
	    	cal.set(2000, 1, 1);
	    	p.setBirthday(cal.getTime());
	    	p.setStatus(1);
	    	p.setDepartment("幼儿保健科");
	    	p.setCreateDate(new Date());
	    	p = patientManager.save(p);
	    	assertNotNull(p);
	    }
	    
	    @Test
	    public void testPatient() throws Exception {
	        List list = patientManager.getAll();
	        Patient rc = patientManager.get(1L);
	        assertNotNull(rc);
	        assertNotNull(list);
//	        assertEquals(1, list.size());
	    }
	    
	    @Autowired
	    TrainningManager trainningManager;
	    @Test
	    public void testTrainning() throws Exception {
	    	Trainning t = new Trainning();
	    	t.setContent("ssss");
	    	
	    	t = trainningManager.save(t);
	        assertNotNull(t);

//	        assertEquals(1, list.size());
	    }
}
