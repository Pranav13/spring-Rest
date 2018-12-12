package com.wiredbrain.friends.controller;


import com.wiredbrain.friends.controller.FriendController;
import com.wiredbrain.friends.model.Friend;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.xml.bind.ValidationException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class IntegrationTests {

    @Autowired
   FriendController friendController;

    @Test
    public void testCreateReadDelete(){
        Friend friend = new Friend("Pranav", "Shukla");

        Friend friendResult = friendController.create(friend);

        Iterable<Friend> friends = friendController.read();
        Assertions.assertThat(friends).first().hasFieldOrPropertyWithValue("firstName","Pranav");

        friendController.delete(friendResult.getId());
        Assertions.assertThat(friendController.read()).isEmpty();
    }

    @Test(expected = ValidationException.class)
    public void errorHandlingValidationExceptionThrown() throws ValidationException {
        friendController.someThingIsWrong();
    }
}
