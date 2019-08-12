package com.imgurwrapper.imgurwrapper;

import com.imgurwrapper.imgurwrapper.Dao.entity.UserProfile;
import com.imgurwrapper.imgurwrapper.controller.Controller;
import com.imgurwrapper.imgurwrapper.service.UserProfileServiceInterface;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.test.util.ReflectionTestUtils;

@RunWith(MockitoJUnitRunner.class)
public class ImgurwrapperApplicationTests {

	@Mock
	UserProfileServiceInterface registerServiceMock;
	@InjectMocks
	Controller controllerMock;
	UserProfile user;
	@Before
	public void setUp() {
		createData();
		ReflectionTestUtils.setField(controllerMock, "registerService", registerServiceMock);
		Mockito.when(registerServiceMock.registerUser(Mockito.any())).thenReturn(user);
	}

	@Test
	public void registerUserTest() {

		final UserProfile userSaved=controllerMock.registerUser(user);
		Assert.assertEquals(user,userSaved);

	}

	public void createData(){
		 user=new UserProfile();
		user.setEmail("abcd@email.com");
		user.setFirstName("abcd");
		user.setLastName("efg");
		user.setUserId("abcd@email.com");
	}

}
