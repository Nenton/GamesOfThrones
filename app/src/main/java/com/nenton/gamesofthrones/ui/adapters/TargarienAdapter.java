package com.nenton.gamesofthrones.ui.adapters;

import android.content.Context;
import android.support.design.widget.TextInputLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;

import com.nenton.gamesofthrones.R;
import com.nenton.gamesofthrones.data.storage.Persons;
import com.nenton.gamesofthrones.data.storage.Titles;

import java.util.List;

public class TargarienAdapter extends RecyclerView.Adapter<TargarienAdapter.NamesViewHolder> {

    private Context mContext;
    List<Persons> personsesTargarien;
    private CustomClickListener mCustomClickListener;

    public TargarienAdapter(List<Persons> personsesStark, CustomClickListener customClickListener) {
        this.personsesTargarien = personsesStark;
        mCustomClickListener = customClickListener;
    }
    @Override
    public TargarienAdapter.NamesViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        mContext = parent.getContext();
        View convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_name, parent, false);
        return new TargarienAdapter.NamesViewHolder(convertView, mCustomClickListener);
    }

    @Override
    public void onBindViewHolder(TargarienAdapter.NamesViewHolder holder, int position) {
//        StringBuilder stringBuilder = new StringBuilder();
//        for (Titles title: personsesTargarien.get(position).getTitles()) {
//            stringBuilder.append(title.getTitle());
//        }
        holder.mEditText.setText("Fire and Blood");
        holder.mTextInputLayout.setHint(personsesTargarien.get(position).getName());
        holder.mImageView.setVisibility(View.GONE);
    }

    @Override
    public int getItemCount() {
        return personsesTargarien.size();
    }

    public class NamesViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        protected ImageView mImageView;
        protected EditText mEditText;
        protected LinearLayout mLinearLayout;
        protected TextInputLayout mTextInputLayout;

        private CustomClickListener mClickListener;

        public NamesViewHolder(View itemView, CustomClickListener customClickListener) {
            super(itemView);
            mImageView = (ImageView) itemView.findViewById(R.id.imageHouse);
            mEditText = (EditText) itemView.findViewById(R.id.name_property);
            mLinearLayout = (LinearLayout)itemView.findViewById(R.id.lineName);
            mTextInputLayout = (TextInputLayout)itemView.findViewById(R.id.til);
            mClickListener = customClickListener;
            mLinearLayout.setOnClickListener(this);
            mImageView.setOnClickListener(this);
            mEditText.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            if (mClickListener != null){
                mClickListener.onUserItemClickListener(getAdapterPosition());
            }

        }
    }

}
