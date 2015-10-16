package paxos.dynamic;

import org.junit.Test;
import org.mockito.Matchers;
import org.mockito.Mockito;
import paxos.CommLayer;
import paxos.Member;
import paxos.Receiver;

import java.util.Collections;

import static org.junit.Assert.*;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class DynamicGroupTest {
    @Test
    public void testStartingASingleMember() throws Exception {
        CommLayer commLayer = mock(CommLayer.class);
        Receiver receiver = mock(Receiver.class);
        DynamicGroup group = new DynamicGroup(commLayer, receiver, 2440, Collections.<Member>emptyList());

        verify(commLayer).setListener(Matchers.<CommLayer.MessageListener>any());
    }

    @Test
    public void testSendingMessageToSingleMember() throws Exception {
        CommLayer commLayer = mock(CommLayer.class);
        Receiver receiver = mock(Receiver.class);



        DynamicGroup group = new DynamicGroup(commLayer, receiver, 2440, Collections.<Member>emptyList());
        group.broadcast("Hello");

        verify(commLayer).setListener(Matchers.<CommLayer.MessageListener>any());

        verify(commLayer).sendTo((Member) any(), (byte[]) any());

//        verify(receiver).receive("Hello");
    }
}