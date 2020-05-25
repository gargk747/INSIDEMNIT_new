package com.example.insidemnit;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.gms.maps.model.LatLng;

import java.util.ArrayList;
import java.util.List;

public class SearchAdapter extends RecyclerView.Adapter<SearchAdapter.SearchViewHolder> implements Filterable {

    private Context mContext;
    private ArrayList<SearchClass> searchClasses;
    private ArrayList<SearchClass> filterSearchClass;
    private ValueFilter valueFilter;

    public SearchAdapter(SearchRecyclerView searchRecyclerView, ArrayList<SearchClass> searchClasses){
        this.mContext=searchRecyclerView;
        this.searchClasses=searchClasses;
        this.filterSearchClass=searchClasses;
    }

    @NonNull
    @Override
    public SearchAdapter.SearchViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.search_items,parent,false);
        return new SearchViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SearchAdapter.SearchViewHolder holder, int position) {
        holder.locationName.setText(searchClasses.get(position).getLocation1());
        holder.latLn= new LatLng(searchClasses.get(position).getLatLng().latitude,searchClasses.get(position).getLatLng().longitude);
    }

    @Override
    public int getItemCount() {
        return searchClasses.size();
    }

    @Override
    public Filter getFilter() {
        if(valueFilter==null){
            valueFilter= new ValueFilter();
        }
        return valueFilter;
    }


    public class SearchViewHolder extends RecyclerView.ViewHolder {
        TextView locationName;
        LatLng latLn;


        public SearchViewHolder(@NonNull View itemView) {
            super(itemView);
            locationName=itemView.findViewById(R.id.locationName);
        }
    }

    private class ValueFilter extends Filter {

        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            FilterResults results=new FilterResults();

            if(constraint!=null && constraint.length()>0){
                List<SearchClass> filterList = new ArrayList<>();
                for(int i=0;i<filterSearchClass.size();i++){
                    if((filterSearchClass.get(i).getLocation1().toUpperCase()).contains(constraint.toString().toUpperCase())){
                        filterList.add(filterSearchClass.get(i));
                    }
                }
                results.count= filterList.size();
                results.values= filterList;
            }else{
                results.count=filterSearchClass.size();
                results.values=filterSearchClass;
            }
            return results;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            searchClasses= (ArrayList<SearchClass>) results.values;
            notifyDataSetChanged();
        }
    }
}
