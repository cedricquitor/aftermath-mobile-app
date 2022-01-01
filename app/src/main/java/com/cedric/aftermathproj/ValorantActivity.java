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

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

import java.util.ArrayList;

public class ValorantActivity extends AppCompatActivity {
    Button userBtn;
    BottomNavigationView bottomNav;
    ViewPager viewPager;
    RecyclerView recyclerView;
    LinearLayoutManager layoutManager;
    ArrayList<CardModel> cardModelArrayList;
    CardAdapter cardAdapter;
    ArrayList<NewsModel> newsModelArrayList;
    NewsAdapter newsAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_valorant);
        // Hooks
        userBtn = (Button) findViewById(R.id.user_btn);
        bottomNav = findViewById(R.id.bottom_nav);

        // User Icon
        userBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent userActivity = new Intent(ValorantActivity.this, ProfileActivity.class);
                startActivity(userActivity);
            }
        });

        // Matches Slider
        // UI Views
        viewPager = findViewById(R.id.vlr_matches_viewpager);
        recyclerView = findViewById(R.id.vlr_news_recyclerview);
        loadCards();
        loadNews();

        // Bottom Navigation
        // Selecting Item
        bottomNav.setSelectedItemId(R.id.botnav_valorant);
        // Nav Cases
        bottomNav.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();
                switch (id) {
                    case R.id.botnav_league:
                        Intent leagueIntent = new Intent(ValorantActivity.this, LeagueActivity.class);
                        startActivity(leagueIntent);
                        break;

                    case R.id.botnav_home:
                        Intent valorantIntent = new Intent(ValorantActivity.this, MainActivity.class);
                        startActivity(valorantIntent);
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
                "Vision Strikers",
                "Full Sense",
                "2",
                "0",
                R.drawable.vision_strikers,
                R.drawable.full_sense));

        cardModelArrayList.add(new CardModel(
                "Team Vikings",
                "Crazy Raccoon",
                "2",
                "0",
                R.drawable.team_vikings,
                R.drawable.crazy_raccoon));

        cardModelArrayList.add(new CardModel(
                "Fnatic",
                "Cloud9 Blue",
                "2",
                "1",
                R.drawable.fnatic,
                R.drawable.cloud9_blue));

        cardModelArrayList.add(new CardModel(
                "Gambit Esports",
                "Team Secret",
                "2",
                "1",
                R.drawable.gambit_esports,
                R.drawable.team_secret));

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
        newsModelArrayList.add(new NewsModel("VALORANT",
                "100 Thieves transfer steel",
                "100 Thieves have announced the transfer of substitute player Joshua \"steel\" Nissan.",
                "As the 100 Thieves in-game leader after their late-2020 rebuild, steel's leadership brought the team into North America's upper echelon of teams via a podium finish in the JBL Quantum Cup and first place finish in First Strike: North America. Going into 2021, they were one of the favorites to compete at the very top. \n\nIn 2021, 100 Thieves had varied results, despite what their multiple podium finishes throughout the 2021 VCT circuit might suggest. They only attended one international event—Masters: Berlin—and achieved a top-four finish there. 100 Thieves missed out on qualifying for Masters: Reykjavik despite finishing in first place in Stage 2 Challengers 1 and only dropping two maps the entire tournament. \n\nsteel was made a substitute player after 100 Thieves promoted Aaron \"b0i\" Thao—an analyst for the team prior to the announcement—to a starting role on the team. That addition came just a few weeks before the NA LCQ, which 100 Thieves finished third in. \n\nWhere steel will end up as a result of this transfer is currently unconfirmed, but recent reports have hinted that he has been in talks with T1 to join them as their fifth player and new in-game leader.",
                "Hudsen",
                "12/07/2021",
                R.drawable.vlr_news_first_img));

        newsModelArrayList.add(new NewsModel("VALORANT",
                "Fnatic triumph over Cloud9 in Champions opening day",
                "The match of the day, by far, was the NA vs EU showdown between Fnatic and Cloud9. \n\nThe fight kicked off on Icebox, with Cloud9 winning the first two rounds. However, Fnatic would turn the tables, winning the next three. Both teams would eventually round the half out after exchanging bunches of rounds, with Fnatic getting the better of Cloud9 7-5. \n\nAlthough they just lost four consecutive rounds, Cloud9 rebounded in the second half by taking four of their own. However, Fnatic responded with two opening picks by Domagoj \"doma\" Fancev and James \"Mistic\" Orfila, giving the squad momentum for the remainder of the half. Fnatic's superb site executions gave them the first map with a score of 13-11.",
                "“Our mentality was pretty good the entire time, I think maybe we got a little stressed on Icebox because it was our first match on LAN as a team,” said Anthony \"vanity\" Malaspina. Obviously there is going to be a lot of pressure but I think we did a good job of dealing with it.” \n\nDespite the brutal loss on Split, Fnatic rebounded well on the final map, Fracture. This was the first time Cloud9 had played the new map in an official match while Fnatic previously played it once before against FunPlus Phoenix in the Red Bull Home Ground. As a result, Fnatic quickly demonstrated a better understanding of how to control the map than Cloud9. They finished the half up 8-4. Fnatic carried its momentum into the second half by winning the first three rounds. Just as many lost hope for Cloud9, they began to do exactly what they did on the Split. \n\nThree back-to-back multikills by three different players chipped away the gap to 12-9. Cloud9 began to slow their style of attack and take control of the map similarly to how Fnatic played in the first half. In round 23, an insane fake site execution caused Fnatic to burn two game-changing ultimates to give Cloud9 the edge it needed to win the round and close the scoreline to a one round difference. They won the next round with the help of a 3K by Nathan \"leaf\" Orf which forced overtime. \n\nJust as the game looked finished, with all the momentum in Cloud9's favor, Fnatic soared when it mattered most. A couple of opening picks by their star fragger Nikita \"Derke\" Sirmitev gave Fnatic the edge in the first overtime round. Now they were on defense, the side they struggled with the most. However, an immaculate retake allowed Fnatic to close the match out 14-12.",
                "korexicano",
                "12/02/2021",
                R.drawable.vlr_news_second_img));

        newsModelArrayList.add(new NewsModel("VALORANT",
                "X10 CRIT bring new identity and revitalized spirit to Berlin",
                "In the wake of Masters Reykjavik, X10 CRIT garnered themselves quite an international following, despite missing gold at the event. With lessons from international play in hand, the ceiling was endless for the Thai squad. \n\nHowever, at the start of Stage 3, their star player Patiphan \"Patiphan\" Chaiwong announced a break for the entirety of the stage, owing to an aggravated wrist injury. Yuttanagorn \"Zeus\" Kaewkongyai, the team's coach, would play in his stead. Patiphan's impending absence cast doubt on the team's ability to improve, or even maintain, their previous form. \n\nBut those fears were allayed as X10 swept Challengers 1 in dominant fashion, securing themselves a spot in the SEA Challengers Finals.",
                "With a first-seed advantage, X10 was placed in Group C of the SEA Challengers Finals, alongside Team Big BAAM, Galaxy Racer, and BOOM Esports. X10 was expected to advance from groups and edge one step closer to Berlin. But after a controversial ruling and a flurry of draws, X10 ended up missing playoffs by the slimmest of margins: a single round. The impact of Patiphan's absence was apparent. \n\nDespite missing Masters event, X10 were still atop the SEA circuit points standings. If Paper Rex and Bren Esports failed to make it past the group stages, X10 were locked-in for Champions. At worst, they'd be relegated to playing in the LCQ. \n\nBut when Bren were plagued by COVID travel complications and denied a chance to compete in Berlin, X10's place at Champions became guaranteed. In addition, Patiphan was also ready to return to the active roster for Champions. \n\nWhile X10's return to international competition seems destined, the team's expected performance is much less clear. They've made few appearances after Stage 3, their most recent an encounter with FULL SENSE in which they narrowly lost in a 1-2 series. \n\nOne thing we know for sure, though: they'll be bringing their signature jubilance and composure to the most important fight of the year.",
                "TMosura",
                "12/01/2021",
                R.drawable.vlr_news_third_img));

        newsModelArrayList.add(new NewsModel("VALORANT",
                "Sentinels look to cement legacy",
                "When thinking of esports dynasties, a few names instantly come to mind. SKT T1 in League of Legends. mibr in Counter-Strike 1.6. NIP, fnatic, and Astralis in CS:GO. The Five Gods of SSBM. \n\nThe making of these dynasties, and truthfully, of history, often goes unnoticed. \n\nAnd so it is with Sentinels.",
                "Something wasn't right for Sentinels. Nothing significant had changed for the team, but with a target on their back, the extreme pressure certainly didn't help. \n\n“Going into the [Masters: Berlin] tournament when you're the favorite there is a little bit of nerve because people expect you to do it again,” said Tyson \"TenZ\" Ngo in the YouTube series NA/TURALS. \n\nAlthough Envy eventually went on to finish second in the tournament, falling to Gambit Esports, the loss was still a surprise to Sentinels and their supporters. The shock made them consider something they had no need for before: a coach. The team never had a coach, which was a rare situation among all the Valorant organizations. \n\nHowever, that would change just one month prior to Champions, as Shane \"Rawkus\" Flaherty left FaZe Clan following a disappointing loss in the NA LCQ and joined Sentinels as their head coach. Sentinels finally had someone to take the workload off of Shahzeb \"ShahZaM\" Khan, the man who up until this point carried the burden of both coach and IGL. \n\n“Rawkus has been extremely helpful, honestly it's impressed me, [it's] more than I expected originally,” said ShahZaM in the pre-Champions post conference. “Outside of stuff in-game like more set plays, he's been pretty good at recording practice for us and taking notes. So when we watch back we kind of break down [those] things and have more productive discussions as well as hold people accountable. It's eased a lot of the workload off of my shoulders.” \n\nThey were crowned champions of Masters: Reykjavik. And they are here to become the first Valorant champions of the world.",
                "korexicano",
                "12/01/2021",
                R.drawable.vlr_news_fourth_img));

        newsModelArrayList.add(new NewsModel("VALORANT",
                "Acend unfazed by competition at Champions",
                "Heading into Stage 3, no one really knew what to expect of Acend. \n\n“We've had our ups and downs,” Santeri \"BONECOLD\" Sassi said. “Even though we haven't won, other than the online Masters, we have gotten to the biggest tournaments, we've been playing really well.” \n\nAs the second-lowest EMEA seed for Masters Berlin, Acend had the misfortune of being placed into the same group as SuperMassive Blaze, EMEA's second seed, and Vision Strikers, one of the most hyped up squads of the tournament. They were forced to brawl against the former twice in their group, emerging victorious both times and eliminating SuperMassive Blaze from the event. As a result, Acend advanced to the playoffs.",
                "“[Our motivation's] just been on an up course and it's been growing exponentially,” BONECOLD said. “We've been working our asses off, trying to polish everything that we have in our playbook to be 110% ready. I think the whole team, right now, is really relaxed, really comfortable and we're ready to rock it in Champions. \n\nAcend's IGL later said that the team isn't currently scared of any opponent. Be it a good or bad day, BONECOLD still expects Acend to win extremely convincingly against anyone that dares challenge them. \n\n“I feel like we have the same confidence that we had in Masters,” he said. “I feel like, in both these tournaments, we've been very well prepared. The only thing we missed was the actual experience, the travelling, etc, that we didn't have before Masters 3. \n\nAcend's group in Champions is made up of Berlin runners-up Envy, as well as X10 CRIT and Keyd Stars. \n\n“I feel like it's going to be very nice to play against the Brazilians. I know heat is an extremely good Jett player, it's going to be a fun match between cNed and heat,” BONECOLD said. “Everyone's speaking about mwzera being the best player in Brazil, so I think that's going to be quite an exciting match.” \n\nMasters 3 winners Gambit claimed to only be at 60% of peak form after taking the trophy home, but they're obviously aiming for 100%. Gambit are the benchmark right now for any team that expects to become the first Valorant world champions. \n\nAcend are aiming for 120%. \n\n“I mean, we already won against Gambit in the Red Bull Home Ground tournament really convincingly,” BONECOLD said. \"They're really good friends of mine but I really feel like the talent in our players and the coaching staff… I feel like, in this day of Valorant, we can surpass anybody.”",
                "Eutalyx",
                "12/01/2021",
                R.drawable.vlr_news_fifth_img));

        newsModelArrayList.add(new NewsModel("VALORANT",
                "Team Secret thirst for competition at Berlin",
                "Champions would've marked Team Secret's second foray into Berlin. They would've been met with excitement and jubilation as the second seed of the Southeast Asian region, returning to redeem themselves for their beloved fans. But those feelings weren't meant to be for one of the region's best teams. \n\n“To be completely honest, the way we qualified for Champions wasn't the most satisfying one,” Jayvee \"DubsteP\" Paguirigan said. “It had to be either of us and I felt bad celebrating our qualification because another team from SEA would not be able to make it. So we will do our best on behalf of Paper Rex as well. I felt excited that we had another chance to showcase PH Valorant at such a level and we all can't wait for the games to start.” \n\nBut what's done is done, and it was them who gained the second spot. And in the time spent between Masters Berlin and Champions, Secret took their time to refresh themselves by participating in multiple regional tournaments such as the Predator Esports Circuit, KJC eSports Invitational, and Mineski's VxV Invitational. But it was during these tournaments that doubts started to creep into fans as Secret fell short of winning all three, even if they were close to winning VxV.",
                "And now that they're in Berlin, DubsteP feels like it's still a dream come true and is pumped for the tournament. But their first skirmish won't be an easy one. As a matter of fact, their matchup is worthy of representing what Champions is all about. Their first match on an international stage is against the reigning Masters winner, Gambit Esports. \n\nLesser teams might be demoralized to face a team with such talent as Gambit in their first matchup. However, DubsteP wouldn't have it any other way. \n\n“There was no wish other than Gambit. I wanted to have a game with the best because in order to be the best, you have to beat the best. It's quite what we wanted as a team as well,” DubsteP said. “We came here knowing we would eventually play every strong team out there so this has to be a matchup we have been looking forward to.” \n\nAfter that, it's either going to be the Brazilian powerhouse of Team Vikings or the beloved Japanese underdogs in the form of Crazy Raccoon, both of whom possess prior LAN experience. Any other way would mean a long path for Team Secret in order to claim the Champions title. \n\nThe team is no stranger to adversity. From demoralizing defeats to epic comebacks, Secret has gone through thick and thin as the same five-man roster since the start of the year. They've crowned themselves as the Philippines' and Southeast Asia's best then, but they'll have to prove that it was not all for naught come December. \n\nThey've been robbed of an opportunity to prove themselves to the entire world, to prove why they and their region should be regarded as the ones who could take it all. And rest assured, they're not counting their lucky stars and won't waste their second chance.",
                "TMosura",
                "11/30/2021",
                R.drawable.vlr_news_sixth_img));

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