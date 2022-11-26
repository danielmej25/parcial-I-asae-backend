package co.edu.unicauca.parcial;

import co.edu.unicauca.parcial.controller.DataController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class ParcialIApplicationTests {

	@Autowired
	DataController dataController;

	@Test
	void health() {
		assertEquals( "HEALTH CHECK OK!", dataController.healthCheck());
	}

	@Test
	void version() {
		assertEquals( "The actual version is 1.0.0", dataController.version());
	}

}


