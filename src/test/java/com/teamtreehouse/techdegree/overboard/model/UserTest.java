package com.teamtreehouse.techdegree.overboard.model;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Grzegorz Kończak on 04.11.2016.
 */
public class UserTest {

    private Board board;
    private User user;
    private User user2;

    @Before
    public void setUp() throws Exception {
        board = new Board("Java");
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
    public void afterAnswerUpvotedReputationOfAnswererUpBy10() throws Exception {
        Question question = user.askQuestion("Question");
        Answer answer = user2.answerQuestion(question, "Answer");

        user.upVote(answer);

        assertEquals(10, user2.getReputation());
    }
}