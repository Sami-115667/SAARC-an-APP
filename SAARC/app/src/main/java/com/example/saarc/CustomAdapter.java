package com.example.saarc;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CustomAdapter extends BaseAdapter implements Filterable {

    private int[] flags;
    private String[] countryNames;
    private String[] filteredCountryNames;
    private int[] filteredFlags;
    private int[] filteredPositions;
    private LayoutInflater inflater;
    private CountryFilter countryFilter;

    public CustomAdapter(Context context, String[] countryNames, int[] flags) {
        this.countryNames = countryNames;
        this.filteredCountryNames = countryNames;
        this.flags = flags;
        this.filteredFlags = flags;
        this.filteredPositions = new int[countryNames.length];
        for (int i = 0; i < countryNames.length; i++) {
            this.filteredPositions[i] = i;
        }
        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return filteredCountryNames.length;
    }

    @Override
    public Object getItem(int position) {
        return filteredCountryNames[position];
    }

    @Override
    public long getItemId(int position) {
        return filteredPositions[position];
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;

        if (convertView == null) {
            convertView = inflater.inflate(R.layout.customlist, parent, false);
            holder = new ViewHolder();
            holder.imageView = convertView.findViewById(R.id.imageidlogo);
            holder.textView = convertView.findViewById(R.id.countryname);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        holder.imageView.setImageResource(filteredFlags[position]);
        holder.textView.setText(filteredCountryNames[position]);

        return convertView;
    }

    static class ViewHolder {
        ImageView imageView;
        TextView textView;
    }

    @Override
    public Filter getFilter() {
        if (countryFilter == null) {
            countryFilter = new CountryFilter();
        }
        return countryFilter;
    }

    private class CountryFilter extends Filter {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            FilterResults results = new FilterResults();

            if (constraint == null || constraint.length() == 0) {
                // No filter applied, return the original data
                results.count = countryNames.length;
                results.values = countryNames;
            } else {
                String filterPattern = constraint.toString().toLowerCase().trim();

                List<String> filteredList = new ArrayList<>();
                List<Integer> filteredFlagsList = new ArrayList<>();
                List<Integer> filteredPositionsList = new ArrayList<>();
                for (int i = 0; i < countryNames.length; i++) {
                    String countryName = countryNames[i];
                    if (countryName.toLowerCase().contains(filterPattern)) {
                        filteredList.add(countryName);
                        filteredFlagsList.add(flags[i]);
                        filteredPositionsList.add(i);
                    }
                }

                results.count = filteredList.size();
                results.values = filteredList.toArray(new String[0]);
                filteredFlags = new int[filteredFlagsList.size()];
                for (int i = 0; i < filteredFlagsList.size(); i++) {
                    filteredFlags[i] = filteredFlagsList.get(i);
                }
                filteredPositions = new int[filteredPositionsList.size()];
                for (int i = 0; i < filteredPositionsList.size(); i++) {
                    filteredPositions[i] = filteredPositionsList.get(i);
                }
            }

            return results;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            filteredCountryNames = (String[]) results.values;
            notifyDataSetChanged();
        }
    }

}
