package com.jmurray.android.jokearama2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private JokeAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecyclerView = (RecyclerView) findViewById(R.id.joke_view);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));

        JokeFactory jokeFactory = new JokeFactory();
        List<Jokes> jokes = jokeFactory.getJokes();

        mAdapter = new JokeAdapter(jokes);
        mRecyclerView.setAdapter(mAdapter);
    }

    private class JokeHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private TextView mJokeName;
        private Jokes mJoke;

        public JokeHolder(LayoutInflater inflater, ViewGroup parent) {
            super(inflater.inflate(R.layout.joke_view, parent, false));
            itemView.setOnClickListener(this);

            mJokeName = (TextView) itemView.findViewById(R.id.joke_name);
        }

        public void bind(Jokes joke) {
            mJoke = joke;
            mJokeName.setText(mJoke.getJokeName());
        }

        @Override
        public void onClick(View v){
            Intent intent = new Intent(MainActivity.this, JokeActivity.class);
            intent.putExtra("JokeName", mJoke.getJokeName());
            startActivity(intent);
        }
    }

    private class JokeAdapter extends RecyclerView.Adapter<JokeHolder> {

        private List<Jokes> mJokes;

        public JokeAdapter(List<Jokes> jokes) {
            mJokes = jokes;
        }

        @Override
        public JokeHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater layoutInflater = LayoutInflater.from(MainActivity.this);
            return new JokeHolder(layoutInflater, parent);
        }

        @Override
        public void onBindViewHolder(JokeHolder holder, int position) {
            Jokes joke = mJokes.get(position);
            holder.bind(joke);
        }

        @Override
        public int getItemCount() {
            return mJokes.size();
        }
    }
}
