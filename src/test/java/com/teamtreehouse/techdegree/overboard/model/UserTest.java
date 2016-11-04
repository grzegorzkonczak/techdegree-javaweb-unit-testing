package com.teamtreehouse.techdegree.overboard.model;

import com.teamtreehouse.techdegree.overboard.exc.AnswerAcceptanceException;
import com.teamtreehouse.techdegree.overboard.exc.VotingException;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.*;

/**
 * Created by Grzegorz Kończak on 04.11.2016.
 */
public class UserTest {

    private static Board board;
    private User user;
    private User user2;

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @BeforeClass
    public static void initialize(){
        board = new Board("Java");
    }

    @Before
    public void setUp() throws Exception {
        user = new User(board, "testUser");
        user2 = new User(board, "testUser2");
    }

    @Test
    public void afterQuestionUpvotedReputationOfQuestioneerUpBy5() throws Exception {
        Question question = user.askQuestion("Question");

        user2.upVote(question);

        assertEquals(5, user.getReputation());
    }

    @Test
    public void afterQuestionDownvotedReputationOfQuestioneerWithoutChange() throws Exception {
        Question question = user.askQuestion("Question");

        user2.downVote(question);

        assertEquals(0, user.getReputation());
    }

    @Test
    public void afterAnswerUpvotedReputationOfAnswererUpBy10() throws Exception {
        Question question = user.askQuestion("Question");
        Answer answer = user2.answerQuestion(question, "Answer");

        user.upVote(answer);

        assertEquals(10, user2.getReputation());
    }

    @Test
    public void afterAnswerDownvotedReputationOfAnswererDownBy1() throws Exception {
        Question question = user.askQuestion("Question");
        Answer answer = user2.answerQuestion(question, "Answer");

        user.downVote(answer);

        assertEquals(-1, user2.getReputation());
    }

    @Test
    public void afterAnswerAcceptedReputationOfAnswererUpBy15() throws Exception {
        Question question = user.askQuestion("Question");
        Answer answer = user2.answerQuestion(question, "Answer");

        user.acceptAnswer(answer);

        assertEquals(15, user2.getReputation());
    }

    @Test(expected = VotingException.class)
    public void upvotingAnswerByOriginalAuthorNotAllowed() throws Exception {
        Question question = user.askQuestion("Question");
        Answer answer = user.answerQuestion(question, "Answer");
        
        user.upVote(answer);
    }

    @Test(expected = VotingException.class)
    public void upvotingQuestionByOriginalAuthorNotAllowed() throws Exception {
        Question question = user.askQuestion("Question");
        
        user.upVote(question);
    }

    @Test(expected = VotingException.class)
    public void downvotingQuestionByOriginalAuthorNotAllowed() throws Exception {
        Question question = user.askQuestion("Question");

        user.downVote(question);
    }

    @Test(expected = VotingException.class)
    public void downvotingAnswerByOriginalAuthorNotAllowed() throws Exception {
        Question question = user.askQuestion("Question");
        Answer answer = user.answerQuestion(question, "Answer");

        user.downVote(answer);
    }

    @Test
    public void acceptingAnswerNotByOriginalAuthorNotAllowed() throws Exception {
        thrown.expect(AnswerAcceptanceException.class);
        thrown.expectMessage("Only testUser can accept this answer as it is their question");
        Question question = user.askQuestion("Question");
        Answer answer = user2.answerQuestion(question, "Answer");

        user2.acceptAnswer(answer);
    }
}