package com.wiredbrain.friends.services;

import com.wiredbrain.friends.model.Friend;
import com.wiredbrain.friends.service.FriendService;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class ServicesTests {

    @Autowired
    FriendService friendService;

    @Test
    public void testCreateReadDelete(){
        Friend friend = new Friend("Pranav","Shukla");

        friendService.save(friend);

        Iterable<Friend> friends = friendService.findAll();
        Assertions.assertThat(friends).extracting(Friend::getFirstName).containsOnly("Pranav");

        friendService.deleteAll();
        Assertions.assertThat(friendService.findAll()).isEmpty();

    }
}
