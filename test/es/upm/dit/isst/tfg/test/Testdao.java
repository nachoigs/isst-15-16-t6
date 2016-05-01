package es.upm.dit.isst.tfg.test;

import static org.junit.Assert.*;
import es.upm.dit.isst.tfg.dao.*;
import es.upm.dit.isst.tfg.model.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.google.appengine.tools.development.testing.LocalDatastoreServiceTestConfig;
import com.google.appengine.tools.development.testing.LocalServiceTestHelper;

public class Testdao {
	private TFG tfg;
	private TFG tfg2;
	private TFG tfg3;
	private TFG tfg4;
	private TFGDAO tfgdao;
	private final LocalServiceTestHelper helper = new LocalServiceTestHelper(new LocalDatastoreServiceTestConfig());

	@Before
	public void setUp() throws Exception{
		helper.setUp();
		tfgdao = TFGDAOImpl.getInstance();
		tfg = tfgdao.insertData("autor@gmail.com", "titulo", "resumen", "tutor@gmail.com", "secretario@gmail.com", null, 1);
		tfg2 = tfgdao.getTfg("autor@gmail.com");
		tfg3 = tfgdao.getByEstado(1).get(0);
		tfg4 = tfgdao.getByTutor("tutor@gmail.com").get(0);
	}
	
	@Test
	public void test() {
		
		assertEquals(tfg.getAutor(), "autor@gmail.com");
		assertEquals(tfg.getEstado(), 1);
		assertEquals(tfg.getTitulo(), "titulo");
		assertEquals(tfg.getTutor(), "tutor@gmail.com");
		assertEquals(tfg.getResumen(), "resumen");
		
		assertEquals(tfg2.getAutor(), "autor@gmail.com");
		assertEquals(tfg2.getEstado(), 1);
		assertEquals(tfg2.getTitulo(), "titulo");
		assertEquals(tfg2.getTutor(), "tutor@gmail.com");
		assertEquals(tfg2.getResumen(), "resumen");
		
		assertEquals(tfg3.getAutor(), "autor@gmail.com");
		assertEquals(tfg3.getEstado(), 1);
		assertEquals(tfg3.getTitulo(), "titulo");
		assertEquals(tfg3.getTutor(), "tutor@gmail.com");
		assertEquals(tfg3.getResumen(), "resumen");
		
		assertEquals(tfg4.getAutor(), "autor@gmail.com");
		assertEquals(tfg4.getEstado(), 1);
		assertEquals(tfg4.getTitulo(), "titulo");
		assertEquals(tfg4.getTutor(), "tutor@gmail.com");
		assertEquals(tfg4.getResumen(), "resumen");
		
	}

	@After
	public void tearDown() throws Exception{
		helper.tearDown();
	}
}
