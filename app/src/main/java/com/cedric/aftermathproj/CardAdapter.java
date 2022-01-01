package com.cedric.aftermathproj;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import java.util.ArrayList;

public class CardAdapter extends PagerAdapter {
    private Context context;
    private ArrayList<CardModel> cardModelArrayList;
    LayoutInflater layoutInflater;

    // Card Constructor
    public CardAdapter(Context context, ArrayList<CardModel> cardModelArrayList) {
        this.context = context;
        this.cardModelArrayList = cardModelArrayList;
    }

    @Override
    public int getCount() {
        return cardModelArrayList.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view.equals(object);
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        // Inflate Layout card_item
        layoutInflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.card_item, container, false);

        // Hooks
        ImageView firstTeamImg = view.findViewById(R.id.first_team_img);
        ImageView secondTeamImg = view.findViewById(R.id.second_team_img);
        TextView firstTeam = view.findViewById(R.id.first_team_txt);
        TextView secondTeam = view.findViewById(R.id.second_team_txt);
        TextView firstTeamScore = view.findViewById(R.id.first_team_score);
        TextView secondTeamScore = view.findViewById(R.id.second_team_score);

        // Get Data
        CardModel model = cardModelArrayList.get(position);
        int modelFirstTeamImg = model.getFirstTeamImg();
        int modelSecondTeamImg = model.getSecondTeamImg();
        String modelFirstTeam = model.getFirstTeam();
        String modelSecondTeam = model.getSecondTeam();
        String modelFirstTeamScore = model.getFirsTeamScore();
        String modelSecondTeamScore = model.getSecondTeamScore();

        // Set Data
        firstTeamImg.setImageResource(modelFirstTeamImg);
        secondTeamImg.setImageResource(modelSecondTeamImg);
        firstTeam.setText(modelFirstTeam);
        secondTeam.setText(modelSecondTeam);
        firstTeamScore.setText(modelFirstTeamScore);
        secondTeamScore.setText(modelSecondTeamScore);

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, modelFirstTeam + " vs " + modelSecondTeam, Toast.LENGTH_SHORT).show();
            }
        });

        // Adding View to Container
        container.addView(view, position);
        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View)object);
    }
}
