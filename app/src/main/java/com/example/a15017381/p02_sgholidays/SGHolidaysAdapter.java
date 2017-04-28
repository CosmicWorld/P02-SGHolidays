package com.example.a15017381.p02_sgholidays;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by 15017381 on 28/4/2017.
 */

public class SGHolidaysAdapter extends ArrayAdapter<SGHolidays> {
    private Context context;
    private ArrayList<SGHolidays> holidays;
    private TextView tvName;
    private TextView tvDate;
    private ImageView ivPictures;

    public SGHolidaysAdapter(Context context, int resource, ArrayList<SGHolidays> objects){
        super(context, resource, objects);
        holidays = objects;
        this.context = context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View rowView = inflater.inflate(R.layout.row, parent, false);

        tvName = (TextView) rowView.findViewById(R.id.tvHolidayName);
        tvDate = (TextView) rowView.findViewById(R.id.tvHolidayDate);
        ivPictures = (ImageView) rowView.findViewById(R.id.ivPictures);

        SGHolidays currentHoliday = holidays.get(position);

        tvName.setText(currentHoliday.getName());
        tvDate.setText(currentHoliday.getDate());
        String img = currentHoliday.getPictures();
        int holiday = this.context.getResources().getIdentifier(img, "drawable", context.getPackageName());
        ivPictures.setImageResource(holiday);

        return rowView;
    }
}
