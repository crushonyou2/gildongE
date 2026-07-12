package com.gildong.gildongE;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(properties = {
		"spring.data.mongodb.uri=mongodb://localhost:27017/gildong-test",
		"kakao.client-id=test-client-id"
})
class GildongEApplicationTests {

	@Test
	void contextLoads() {
	}

}
