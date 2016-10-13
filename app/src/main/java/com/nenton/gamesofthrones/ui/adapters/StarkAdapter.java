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

public class StarkAdapter extends RecyclerView.Adapter<StarkAdapter.NamesViewHolder> {

    private Context mContext;
    List<Persons> personsesStark;
    private CustomClickListener mCustomClickListener;

    public StarkAdapter(List<Persons> personsesStark, CustomClickListener customClickListener) {
        this.personsesStark = personsesStark;
        mCustomClickListener = customClickListener;

    }
    @Override

    public StarkAdapter.NamesViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        mContext = parent.getContext();
        View convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_name, parent, false);
        return new StarkAdapter.NamesViewHolder(convertView, mCustomClickListener);
    }

    @Override
    public void onBindViewHolder(StarkAdapter.NamesViewHolder holder, int position) {
//        StringBuilder stringBuilder = new StringBuilder();
//        for (Titles title:personsesStark.get(position).getTitles()) {
//            stringBuilder.append(title.getTitle());
//        }
        holder.mEditText.setText("Winter is Coming");
        holder.mTextInputLayout.setHint(personsesStark.get(position).getName());
        holder.mImageView.setImageDrawable(mContext.getResources().getDrawable(R.drawable.stark_icon));
    }

    @Override
    public int getItemCount() {
        return personsesStark.size();
    }

    public class NamesViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        protected ImageView mImageView;
        protected EditText mEditText;
        protected LinearLayout mLinearLayout;
        protected TextInputLayout mTextInputLayout;

        private CustomClickListener mClickListener;

        public NamesViewHolder(View itemView,CustomClickListener customClickListener) {
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
