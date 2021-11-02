package resources;

import com.pojo.TestObject;

public class TestDataBuild {

	public TestObject addObjectPayLoad(String name, String description, int id) {

		TestObject obj = new TestObject(name, description, id);

		obj.setName(name);
		obj.setDescription(description);
		obj.setId(id);
		return obj;
	}

}
