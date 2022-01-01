package com.cedric.aftermathproj;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

import java.util.ArrayList;

public class LeagueActivity extends AppCompatActivity {
    Button userBtn;
    BottomNavigationView bottomNav;
    ViewPager viewPager;
    RecyclerView recyclerView;
    LinearLayoutManager layoutManager;
    ArrayList<CardModel> cardModelArrayList;
    CardModel cardModel;
    CardAdapter cardAdapter;
    ArrayList<NewsModel> newsModelArrayList;
    NewsModel newsModel;
    NewsAdapter newsAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_league);
        // Hooks
        userBtn = (Button) findViewById(R.id.user_btn);
        bottomNav = findViewById(R.id.bottom_nav);

        // User Icon
        userBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent userActivity = new Intent(LeagueActivity.this, ProfileActivity.class);
                startActivity(userActivity);
            }
        });

        // Matches Slider
        // UI Views
        viewPager = findViewById(R.id.lol_matches_viewpager);
        recyclerView = findViewById(R.id.lol_news_recyclerview);

        loadCards();
        loadNews();

        // Bottom Navigation
        // Selecting Item
        bottomNav.setSelectedItemId(R.id.botnav_league);
        // Nav Cases
        bottomNav.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();
                switch (id) {
                    case R.id.botnav_valorant:
                        Intent valorantIntent = new Intent(LeagueActivity.this, ValorantActivity.class);
                        startActivity(valorantIntent);
                        break;

                    case R.id.botnav_home:
                        Intent homeIntent = new Intent(LeagueActivity.this, MainActivity.class);
                        startActivity(homeIntent);
                        break;
                }
                return true;
            }
        });
    }

    private void loadCards() {
        // Initialize List
        cardModelArrayList = new ArrayList<>();

        // Add Card Items
        cardModelArrayList.add(new CardModel(
                "Royal Never Give Up",
                "EDward Gaming",
                "2",
                "3",
                R.drawable.royal_never_give_up,
                R.drawable.edward_gaming));

        cardModelArrayList.add(new CardModel(
                "Gen.G Esports",
                "Cloud9",
                "3",
                "0",
                R.drawable.geng_esports,
                R.drawable.cloud9_blue));

        cardModelArrayList.add(new CardModel(
                "T1",
                "Hanwha Life Esports",
                "3",
                "0",
                R.drawable.t1,
                R.drawable.hanwha_life_esports));

        cardModelArrayList.add(new CardModel(
                "DAMWON Gaming",
                "MAD Lions",
                "3",
                "0",
                R.drawable.damwon_gaming,
                R.drawable.mad_lions));

        // Setup Adapter
        cardAdapter = new CardAdapter(this, cardModelArrayList);
        // Setup Adapter to View Pager
        viewPager.setAdapter(cardAdapter);
        // Set Default Padding
        viewPager.setPadding(0, 0, 250, 0);
    }

    private void loadNews() {
        // Initialize List
        newsModelArrayList = new ArrayList<>();

        // Add News Data
        newsModelArrayList.add(new NewsModel("League of Legends",
                "Hanwha Life Esports brings on three new members to complete its roster",
                "Hanwha Life Esports introduces three new members to the team, finalising their roster ahead of the 2022 season. \n\nHanwha Life Esports has finalised its roster for the upcoming 2022 season, introducing three new members into the squad with the likes of Kim \"OnFleek\" Jang-gyeom, Kim \"Karis\" Hong-jo, and Lee \"SamD\" Jae-hoon. They will join the surviving members of the team like Kim \"Willer\" Jeong-hyeon, Oh \"Vsta\" Hyo-seong, and Lee \"DuDu\" Dong-ju. This comes after a tumultuous few weeks when the likes of Jeong \"Chovy\" Ji-hoon and Kim \"Deft\" Hyuk-kyu went into free agency after their contract expired while Park \"Morgan\" Gi-tae also had his expired on a mutual consensus.",
                "With Chovy confirmed in Gen.G's line-up, HLE had a hard time finding a replacement. In comes Karis, the former mid-laner for Gen.G Esports who is now headed in the opposite direction. While he was demoted to Gen.G Challengers during the middle of the season, he is hoping to bounce back and prove his former employers wrong. \n\nAs for OnFleek, he will assume his usual jungler role alongside Willer. Whether or not HLE decides to keep two junglers for the rest of the season remains to be seen. His performances for SANDBOX Gaming were decent at best but hopefully being in a new team and environment will bring more out of his gameplay. SamD is the last piece of the puzzle, who has spent the majority of his time in the LPL. While his career doesn't boast much as of yet, the upper management of HLE must see something in him that some do not. \n\nThe team has had a rollercoaster season, finishing third during the Spring Split before crashing out in eighth in the Summer Split. Thankfully, the team pulled together to get the very last slot to Worlds 2021. From there, HLE took the play-in stage by storm, finishing second in the group and eliminating Beyond Gaming to secure their spot in the main event.  Being placed in the same group as the Mid-Season Invitational 2021 winners, HLE held their own and managed to finish in second to make it through to the knockout phase. \n\nUnfortunately, their run ended in the quarterfinals, losing three straight games to T1. For a team that many didn't expect to go that far, HLE certainly proved all their doubters wrong.",
                "GravityWillFall",
                "12/9/2021",
                R.drawable.lol_news_first_img));

        newsModelArrayList.add(new NewsModel("League of Legends",
                "G2 Esports secures their 2022 roster ahead of the new season",
                "G2 Esports finalise their League of Legends roster ahead of the 2022 season. \n\nEuropean titans G2 Esports have confirmed their brand new five-man roster ahead of the 2022 League of Legends European Championship (LEC). After an underwhelming season, their star mid-laner, Martin \"Rekkles\" Larsson left the team for the LFL's Karmine Corp after only a year with the team. Soon after, G2 lost both Martin \"Wunder\" Nordahl Hansen and Kristoffer \"P1noy\" Albao Lund Pedersen in the coming days after Rekkles' departure, leaving the team with only two members left in the form of Marcin \"Jankos\" Jankowski and Rasmus \"Caps\" Borregaard Winther.",
                "The German/Turkish veteran top laner has been around the scene for some time now and will provide some much-needed balance to the squad. The new season is one to look forward to from the European giants as they have also strayed away from their usual strategy of signing big-name players. Instead, the org has opted to sign two up-and-coming stars in the scene in the form of Flakked and Targamas. \n\nFlakked joins after leaving MAD Lions Madrid, where he has been the standout performer in the Spanish Superliga even if the team has been underperforming over the past few years. The rookie will join the squad as a fresh face, hoping to bring some renewed youthful energy into the mix. As for Targamas, the Belgian support player has been on the radar for some time now, being one of the most promising young talents to rise through the amateur ranks. He was also part of the Karmine Corp squad that won back-to-back EU Masters titles this year. \n\nWith their new line-up, G2 is hoping to get back to winning ways once more after missing out on Worlds 2021 earlier this year. The likes of Jankos and Caps will be leading the charge and hopefully, they can bring G2 back to its glory days of being a top contender on the world stage. While the team has yet to lift the Summoner's Cup, they did come close two years ago and will be hoping to make it to the grand finals once more.",
                "GravityWillFall",
                "12/06/2021",
                R.drawable.lol_news_second_img));

        newsModelArrayList.add(new NewsModel("League of Legends",
                "DWG.KIA finalise their 2022 roster with ShowMaker and Canyon returning",
                "A change was necessary for DWG.KIA and they have finalised their roster ahead of the 2022 season in the LCK. \n\nDWG.KIA is back for the 2022 season with their brand new roster, featuring the likes of Heo \"ShowMaker\" Su and Kim \"Canyon\" Geon-bu making their return to the organisation. Having been with the team for quite some time now, it was pretty clear that DWG were trying to re-sign their star mid-laner and jungler. Making up the rest of the squad is Noh \"Burdol\" Tae-yoon, formerly of Gen.G Esports taking over the top lane while both Seo \"deokdam\" Dae-gil and Kim \"Kellin\" Hyeong-gyu from Nongshim RedForce join the squad as the ADC and the support respectively.",
                "Just a few weeks after three-fifths of their squad entered free agency, DWG opted to re-sign two of their Worlds 2020 winning squad, which meant that Ghost would move over to Nongshim. There were speculations that DWG was planning to re-sign Nuguri after a horrible season with FunPlus Phoenix but instead, they decided to sign up rookie talent, Burdol. Their decision to sign Nongshim's bot-lane duo also looks to be an interesting choice as deokdam was listed in the All-LCK first team while Kellin was in the All-LCK second team. \n\nDWG had a great 2021 season, winning both LCK splits in dominating fashion. While their second-place finish at the Mid-Season Invitational 2021 was commendable given how well Royal Never Give Up played, it was their second-place finish at Worlds 2021 that ended the season on a low note. Having been one of the major favourites heading into the tournament, DWG was unbeaten during the group stages and made it look easy heading into the grand finals. \n\nUnfortunately, it just didn't work out for them in the grand finals against EDward Gaming. As they weren't able to lift their second Summoner's Cup in a row, this leaves T1 as the most-decorated LCK team to date. With that being said, DWG will be heading into the new season with renewed optimism about the team's chances next year. Having re-signed Canyon and ShowMaker, the team will be looking at both of them to lead the charge.",
                "GravityWillFall",
                "12/02/2021",
                R.drawable.lol_news_third_img));

        newsModelArrayList.add(new NewsModel("League of Legends",
                "Gen.G Esports is the latest team to bring about changes",
                "One of the LCK's top teams, Gen.G Esports has already started rebuilding its squad ahead of the 2022 season. \n\nThe transfer window is now in full swing and Gen.G Esports is the latest organisation from the LCK to release almost their entire roster over the past couple of days. Kim \"Rascal\" Kwang-hee was the first to exit the team, followed by Kim \"Clid\" Tae-min just a few days later. Kim \"Life\" Jeong-min is the latest player to leave the squad, who will be joining KT Rolster for the upcoming season alongside Rascal. However, they did manage to snag Choi \"Doran\" Hyeon-joon, formerly of KT, to add to their squad.",
                "There's also Gwak \"Bdd\" Bo-seong who will be heading to Nongshim RedForce and in return, Gen.G will have Han \"Peanut\" Wang-ho back in their ranks. Having left the team back in 2019, he is now back to prove that he will be a worthy investment to the squad. Lastly, Gen.G has just recently picked up Son \"Lehends\" Si-woo of Afreeca Freecs to their roster. The only player who still keeps his slot is their ADC, Park \"Ruler\" Jae-hyuk. With that said, all there's left now is for the team to find a new mid-laner to balance out the team. \n\nWith many top mid-laners now in the free agency market in the LCK, it wouldn't be all that surprising to see Gen.G try to pick up a top-tier player to bring them to the next level. The likes of Heo \"ShowMaker\" Su and Jeong \"Chovy\" Ji-hoon are still up for grabs, could we see Gen.G make a swoop for one of them? Only time will tell. \n\nAs a whole, their 2021 season has been a relative success, even if there aren't any titles to go with it. They finished third and second respectively during the Spring and Summer splits while still managing to top their group at Worlds 2021. \n\nGen.G then went one step further, knocking out Cloud9 in the quarterfinals of the playoffs with a comfortable three-nil sweep. Unfortunately, their run ended in the semifinals where they managed to put EDward Gaming to the test, going to all five games. That result was their best performance at Worlds to date. Their last two appearances on the world stage ended in the group stages back in 2018 and in the quarterfinals of the playoffs in 2020.",
                "GravityWillFall",
                "11/25/2021",
                R.drawable.lol_news_fourth_img));

        newsModelArrayList.add(new NewsModel("League of Legends",
                "Team Liquid makes three changes to its starting lineup",
                "Team Liquid raids both the LCS and LEC to finalise its starting roster for the 2022 season. \n\nAfter an underwhelming season, Team Liquid has had a busy few days in the transfer market and they may have found the missing piece of the puzzle in the form of TSM's former head coach, Søren \"Bjergsen\" Bjerg. Having retired from professional play since last year, he took up the mantle of head coach for TSM, but it didn't work out well for them. Bjergsen has been TSM's most decorated as well as the longest-serving member of the team, leading the team to six LCS Split titles in the span of his eight-year spell.",
                "He will be joined by both Gabriël \"Bwipo\" Rau and Steven \"Hans sama\" Liv as both players have also joined Team Liquid in the past few days. Bwipo was a mainstay in the Fnatic squad, having been with them for the past three years but they could never truly go the distance. As for Hans Sama, he will be looking to forge a new history for himself and Team Liquid. The former Rogue ADC was in spectacular form during the 2021 season as well as during Worlds. Sadly, the same cannot be said about his former squad. \n\nOf course, with these new additions, we bid farewell to the likes of Edward \"Tactical\" Ra and Barney \"Alphari\" Morris with the former swapping sides to TSM. As a whole, Team Liquid had a disappointing season. Although they won the LCS Lock-In earlier this year, they never managed to secure the top spot at any respective splits, condemned with finishing second on both occasions. This was further fueled by their inability to get out of the group stage once again in their fourth consecutive Worlds appearance. \n\nWith these new additions, Team Liquid will be looking to kick on in the LCS once more and hopefully, bring home some silverware this time around. Having the likes of Bjergsen leading the squad with his years of experience will be a plus for the LCS team alongside their up-and-coming additions like Hans sama, who has been one of the better ADCs to come out of the LEC. Bwipo is another great addition, being one of Fnatic's most consistent players. \n\nRounding out the rest of the squad will be Jo \"CoreJJ\" Yong-in on the support alongside Lucas Tao \"Santorin\" Kilmer Larsen in the jungle. Nicolaj \"Jensen\" Jensen will still be a part of the team in the middle lane, which he will share with Berjsen. As he and CoreJJ have been with Team Liquid for the better part of three years, they will be using all of their experience to guide the team to hopefully, another world championship appearance next year.",
                "GravityWillFall",
                "11/22/2021",
                R.drawable.lol_news_fifth_img));

        newsModelArrayList.add(new NewsModel("League of Legends",
                "Doinb is the latest to leave FunPlus Phoenix",
                "FunPlus Phoenix has lost three key members of their squad with only two of the longest-serving members remaining. \n\nAfter one of their most underwhelming seasons, it seems like a change of scenery is needed for FunPlus Phoenix as three of their top stars have left the squad. The likes of Kim \"Doinb\" Tae-sang, Gao \"Tian\" Tian-Liang, and Jang \"Nuguri\" Ha-gwon will be parting ways with the organisation. All there's left of the FPX we now know is just Liu \"Crisp\" Qing-Song and Lin \"Lwx\" Wei-Xiang, both of whom have been with the team from the very beginning.",
                "Nuguri was the first to leave the organisation after only a year with the team. While he did help the team to two top-two finishes in the Spring and Summer Splits, it still was not enough. Tian was the second one to leave soon after with many claiming for personal reasons. While he was part of the roster that took Worlds 2019 by storm and put the LPL on the world map, he has been fairly inconsistent over the past year. \n\nDoinb is the latest to leave with FPX losing their in-game leader as well as one of the top mid-laners right now. Having led FPX from being a mediocre mid-table team to lifting the Summoner's Cup the following year, it appears that it's now time for him to explore new options. One of those could very well be LNG Esports, who came so close to making it Worlds this year. It has been revealed in a recent stream that he will be signing for a fellow LPL organisation, which will be revealed in the following days. \n\nWith their middle, top, and jungler roles now vacant, it just leaves the support and ADC position of Crisp and Lwx. While they may be FPX's longest-serving members, they have also underperformed in 2021, much like the rest of the now-departed squad. After two strong top-two finishes in the Spring and Summer Split, FPX came into Worlds 2021 as one of the favourites to emerge from the group stage. Unfortunately, it didn't quite pan out the way they would've wanted to as they ended their group dead last. \n\nThe transfer season is well and truly underway now and FPX will have a lot left to do if they're hoping to challenge for the Summoner's Cup once more. However, they are the only top LPL team that has made any changes so far with many others willing to stick with the current roster they have right now.",
                "GravityWillFall",
                "11/21/2021",
                R.drawable.lol_news_sixth_img));

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