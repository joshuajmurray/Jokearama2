package com.jmurray.android.jokearama2;
//generate jokes here

import java.util.ArrayList;
import java.util.List;

/**
 * Created by joshua on 12/2/2017.
 */

public class JokeFactory {
    private List<Jokes> mJokes;

    public JokeFactory() {
        mJokes = new ArrayList<>();
        for(int i = 0; i < 50; i++) {
            Jokes joke = new Jokes("Joke " + i);
            mJokes.add(joke);
        }
    }

    public List<Jokes> getJokes() {
        return mJokes;
    }

}
