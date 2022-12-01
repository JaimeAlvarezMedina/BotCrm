package com.example.Crm;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CrmApplicationTests {

	CrmApi api=new CrmApi();
	
	@Test
	void email() {
		assertTrue(api.comprobarEmail("solera@solera.com"));
		assertFalse(api.comprobarEmail("solerasol.com"));
		assertFalse(api.comprobarEmail("solera@soleracom"));
	}

}
