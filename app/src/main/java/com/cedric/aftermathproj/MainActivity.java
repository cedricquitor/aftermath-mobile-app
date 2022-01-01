package com.cedric.aftermathproj;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    DatabaseHelper myDatabase;
    TextView sessionTxt2;
    Button userBtn;
    BottomNavigationView bottomNav;
    RecyclerView recyclerView;
    LinearLayoutManager layoutManager;
    ArrayList<NewsModel> newsModelArrayList;
    NewsAdapter newsAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Hooks
        userBtn = (Button) findViewById(R.id.user_btn);
        bottomNav = findViewById(R.id.bottom_nav);
        sessionTxt2 = (TextView) findViewById(R.id.session_text);

        // UI Views
        recyclerView = findViewById(R.id.main_news_recyclerview);
        loadNews();

        // User Button Click Listener
        userBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent userActivity = new Intent(MainActivity.this, ProfileActivity.class);
                startActivity(userActivity);
            }
        });

        myDatabase = new DatabaseHelper(this);
        SharedPreferences sp = getApplicationContext().getSharedPreferences("SessionID", Context.MODE_PRIVATE);

        // Retrieve Data
        Cursor cursor = myDatabase.viewData(sp.getString("loginSession", ""));
        StringBuilder retrievedFullName = new StringBuilder();
        while (cursor.moveToNext()) {
            retrievedFullName.append("Welcome back, " + cursor.getString(1) + " " + cursor.getString(2) + "!");
        }

        sessionTxt2.setText(retrievedFullName);

        // Bottom Navigation
        // Selecting Item
        bottomNav.setSelectedItemId(R.id.botnav_home);
        // Nav Cases
        bottomNav.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();
                switch (id) {
                    case R.id.botnav_league:
                        Intent leagueIntent = new Intent(MainActivity.this, LeagueActivity.class);
                        startActivity(leagueIntent);
                        break;

                    case R.id.botnav_valorant:
                        Intent valorantIntent = new Intent(MainActivity.this, ValorantActivity.class);
                        startActivity(valorantIntent);
                        break;
                }
                return true;
            }
        });
    }

    private void loadNews() {
        // Initialize List
        newsModelArrayList = new ArrayList<>();

        // Add News Data
        newsModelArrayList.add(new NewsModel("Riot Games",
                "RiotX Arcane: Until Next Time",
                "That’s a wrap! With the launch of Arcane’s epic finale on Netflix and our Undercity Nights celebration over the weekend, the RiotX Arcane event officially draws to a close. We’ve been so humbled by your enthusiasm and creativity over the last month. Thank you to everyone who has watched and supported Arcane.  \n\nIf you missed any of this weekend's festivities or announcements, here’s a recap of what went down. ",
                "The Riot Gauntlet gave creators the opportunity to stick it to our balance teams for charity. Eight global teams competed for bragging rights and their share of a $100,000 donation pool.  \n\nArcane was the result of years of dedicated work from animators, writers, artists, a talented cast, and many many more passionate creators. We held a Q&A with the people who made Arcane a reality to talk about their favorite moments, funny interactions, and how Arcane came together. \n\nPusha T, Bones UK, Mako, Miyavi, and PVRIS hit the stage for Notes from the Undercity, a live musical performance featuring original songs from the Arcane soundtrack. \n\nIn 2020, the brilliant folks over at Hypixel Studios joined the Riot family. We’ve been huge fans of Hytale since the first trailer released and they dropped by to give an update on their community-powered block game that combines the scope of a creative sandbox with the depth of a roleplaying game. \n\nOver the last few weeks, we’ve been blown away by your passion and support for Arcane. With Arcane now wrapped up, we’ve heard you all loud and clear: You want more Arcane. So do we. \n\nWe’re excited to confirm that a second season of Arcane is already in production, will continue to be made by us, and will NOT take another six years. We’ll have more information for you at a later date. \n\nIf you’re still looking for more, in-game Arcane celebrations haven’t wrapped just yet so make sure to experience the events and collect your rewards while you still can. League players will see a few more stories appearing in the Council Archives, and the World of RiotX Arcane remains open until December 15.  \n\nWe set out to create a moment across Riot’s ecosystem where we could all come together to celebrate a shared love for this world. Thank you for making this an unforgettable moment. We’ve never been more excited about the future.",
                "Riot Games",
                "11/22/2021",
                R.drawable.riot_news_first));

        newsModelArrayList.add(new NewsModel("Riot Games",
                "Project L /dev: Finding our Game",
                "Hey everyone, Tom here from the team working on the League of Legends fighter, codenamed Project L. It’s been a while! How have you been? \n\nOur initial reveal back in 2019 showed a potential direction that we could take the game. But Project L is in R&D: the phase of game development where we’re exploring options and finding the fun. Today, our explorations have borne fruit, and we’ve landed in a spot that we’re all pretty excited about! So now felt like a great moment to bring you up to speed, especially with all the Undercity Nights festivities happening across Riot.",
                "Before we get into the details, a quick clarification: the gameplay clip that we aired at Undercity Nights is still what the gaming industry calls a ‘vertical slice.’ We built this to hammer out the final look of the game, in advance of actually going in and building all of our content like characters and stages. Our vertical slice might give you the sense that the game is ready, but we actually still have a lot of work ahead of us. So, although we’ve made a great deal of progress, we will not be shipping in 2021 or 2022. \n\nOur goal is to build a super high-quality fighting game that the FGC can invest deeply in, playing for years or even decades. That takes time to get right, and we’re not going to rush it.  \n\nWe’re excited to share that Project L will be a tag-team style fighting game, where you’ll build and pilot a team of two different champions. In this preview, you’ll see we’ve updated the game’s art style and included a breakdown of a champion’s kit. You’ll catch a glimpse of how we’re approaching controls with an easy-to-learn but hard-to-master mentality.  \n\nWe also talk a little about one of our top priorities for the game: to build the absolute best in netcode that you can get in a fighter. Of course we’re starting with rollback as a foundation, and we’re adding in existing tech from Riot like RiotDirect, which does a great job at minimizing ping for League of Legends and VALORANT. \n\nSo when will you get to play? Well we’re almost locked in on the stuff that makes a game a game (core gameplay, controls, art direction, etc.) but we still need to do things like build out a full roster of champions, design stages, add menus and UI, create ranking systems, and more. \n\nLast time we talked we said we’d be going dark, but this time around we’re going to commit to AT LEAST two updates next year. You’ll hear from us again sometime early in the second half of 2022. GG until then.",
                "Tom Cannon",
                "11/20/2021",
                R.drawable.riot_news_second));

        newsModelArrayList.add(new NewsModel("Riot Games",
                "Filipino American History Month Recap",
                "Filipino American History Month celebrates the first recorded presence of Filipinos in the continental US when Filipino sailors aboard a Spanish galleon landed at Morro Bay, California on October 18, 1587. Now every October is Filipino American History Month, a celebration of Filipino American achievements, contributions, and influence on America’s history and culture. \n\nRiot’s Filipino employee resource group, Filipinos At Riot (FAR), led festivities for the company and hosted a range of activities around the theme: A Quest for Emergence. This theme was chosen by national leaders to celebrate the 50th anniversary of the first Young Filipino People’s Far West Convention which featured the same theme.",
                "FAR explored incredible Filipino flavors at our NOMs Food Lab, learned from Rioters about growing up Filipino American, and were inspired by Filipino American storyteller Dante Basco. \n\nIn a joint celebration of Latinx Heritage Month & FIlipino American History Month, we fused together a delicious meal showcasing ingredients from our diverse backgrounds. Our employee resource groups Riot Unidos and FAR partnered with our NOMs staff to put on an in-house virtual cooking course. We learned how to make Lechon Paksiw Pupusas, Curtido (El Salvador Slaw), and Mang Tomas Salsa Roja with Brian Bellicourt, Riot’s Executive Sous Chef. \n\nThe FAR community got together to hold an online, interactive Filipino party. We shared a meal together virtually and played classic Filipino party games like “Bring Me!” \n\nWe asked some of our Rioters from FAR to (virtually) sit down and chat about growing up Filipino American. In this lighthearted chat we cover fun Filipino games, traditions, and some of our favorite foods. \n\nLast but not least, we had an intimate conversation with Filipino American actor Dante Basco. The event was moderated by Justin Hulog, Riot’s General Manager of the SEA region. You might know Dante as Prince Zuko in Avatar: The Last Airbender or Rufio in Steven Spielberg’s Hook. \n\nIn addition to his accomplished acting career, Dante has also been a trailblazer in telling Filipino American stories. He starred in the first Filipino American feature film, The Debut, and made his directorial debut this year with The Fabulous Filipino Brothers. Dante discussed his experiences navigating the entertainment industry as a Filipino American and how he’s advocated for greater representation of his culture throughout his career. \n\nAlthough the month of October is over, Riot will continue to support FAR’s mission of empowering, unifying, and celebrating Filipinos at Riot and throughout the worldwide gaming community.",
                "Riot Games",
                "11/19/2021",
                R.drawable.riot_news_third));

        newsModelArrayList.add(new NewsModel("Riot Games",
                "Global Undercity Nights Broadcast Co-Streaming and Rewards",
                "We hope you enjoyed the premiere of our first TV series, Arcane. And with two acts out now, the finale is coming up quicker than a Firelight’s hoverboard. Much like the premiere, we're excited to have our remote content creators and players around the world celebrate the finale of Arcane through the co-streaming of Undercity Nights, a two-day broadcast event on all platforms. \n\nJoin us for two days of competition, talks with the devs, live music, immersive experiences, and more. As a reminder, no episodes of Arcane will be streamed during this broadcast. For more details on what to expect, check out this article. For guidance on co-streaming Undercity Nights off-site, read below!",
                "When: The Undercity Nights broadcast begins on Riot Games' Twitch and YouTube channels starting November 19 at 4:00 PM PT and November 20 at 12:00 PM PT. The entirety of Riot's official broadcast is co-stream safe. \n\nWhere: Your Twitch or YouTube channels (or anywhere else for that matter). VODs/clips of the Undercity Nights broadcast content will be allowed outside of the musical performances. VODs/clips should be disabled from the music portions of the broadcast. Please visit Twitch's help pages on VOD and clips to learn how to enable and disable VODs/clips prior to co-streaming. \n\nHow: Co-stream the live broadcast from Riot Games’ official Twitch or YouTube channels. Use #UCNCostream both in co-stream titles and on social media. For Twitch, make sure you are co-streaming in the Arcane streaming category. For more information on how to co-stream on Twitch, visit their Content Sharing Guidelines. \n\nMonetization: We understand that monetization is important to all of our creators. At this time, co-streams are allowed to maintain normal monetization. Sponsors will need to follow the normal League of Legends sponsorship guidelines. \n\nPlease be responsible and respectful. Riot Games reserves the right to remove access to the co-stream for any creator at any time. As always, follow our Legal Jibber Jabber guidelines.",
                "Riot Games",
                "11/18/2021",
                R.drawable.riot_news_fourth));


        // Layout Manager
        layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(RecyclerView.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);

        // Setup Adapter
        newsAdapter = new NewsAdapter(this, newsModelArrayList);
        // Set Adapter to Recycler View
        recyclerView.setAdapter(newsAdapter);
        newsAdapter.notifyDataSetChanged();

        recyclerView.setPadding(0, 0, 0, 0);
    }
}