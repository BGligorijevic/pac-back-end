package com.prodyna.voting.vote;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.powermock.modules.junit4.PowerMockRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertTrue;
import static org.powermock.api.mockito.PowerMockito.when;

@RunWith(PowerMockRunner.class)
public class VotingRestApiTest {

    @InjectMocks
    private VotingRestApi votingRestApi;

    @Mock
    private VotingService votingService;

    /**
     * Test for {@link VotingRestApi#getAllVotes()}.
     */
    @Test
    public void gets_all_votes() {
        List<Vote> votes = new ArrayList<>();
        Vote vote1 = new Vote();
        vote1.setTitle("vote1 title");
        vote1.setDescription("vote1 description");
        votes.add(vote1);

        when(votingService.getAllVotes()).thenReturn(votes);
        List<Vote> allVotes = votingRestApi.getAllVotes();
        assertTrue(allVotes != null);
        assertTrue(allVotes.size() == 1);
        assertTrue(allVotes.get(0).getTitle().equals("vote1 title"));
        assertTrue(allVotes.get(0).getDescription().equals("vote1 description"));
        assertTrue(allVotes.get(0).getCreated() == null);
    }
}