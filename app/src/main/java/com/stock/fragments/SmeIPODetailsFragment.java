package com.stock.fragments;

import android.annotation.SuppressLint;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.stock.R;
import com.stock.databinding.FragmentSmeIpoDetailsBinding;
import com.stock.interfaces.OnSetActinBarTitle;
import com.stock.retrofit.model.HomeData;
import com.stock.retrofit.model.SmeIPOData;

import butterknife.ButterKnife;



public class SmeIPODetailsFragment extends Fragment {
    private FragmentSmeIpoDetailsBinding mBinding;
    private SmeIPOData ipoData;
    private HomeData homeData;
    private OnSetActinBarTitle onSetActinBarTitle;

    public SmeIPODetailsFragment() {
    }

    @SuppressLint("ValidFragment")
    public SmeIPODetailsFragment(SmeIPOData smeIPOData) {
        this.ipoData = smeIPOData;
    }

    @SuppressLint("ValidFragment")
    public SmeIPODetailsFragment(HomeData homeData) {
        this.homeData = homeData;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_sme_ipo_details, container, false);
        ButterKnife.bind(this, mBinding.getRoot());
        onSetActinBarTitle = (OnSetActinBarTitle) getActivity();
        onSetActinBarTitle.onSetActionBarTitle("SME IPO");
        return mBinding.getRoot();
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if (homeData == null) {
            mBinding.frgIpoName.setText(ipoData.getSmeIpoName());
            mBinding.frgIpoPrice.setText(ipoData.getPrice());
            mBinding.frgIpoRating.setText(ipoData.getRating());
            mBinding.frgIpoSubscription.setText(ipoData.getSubscription());
            mBinding.frgIpoLotSize.setText(ipoData.getLotSize());
            mBinding.frgIpoIssueSize.setText(ipoData.getIssueSize());
            mBinding.frgIpoFaceValue.setText(ipoData.getFaceValue());
            mBinding.frgIpoTargetDate.setText(ipoData.getIpoDate());
            mBinding.frgIpoAlloatmentDate.setText(ipoData.getAllotmentDate());
            mBinding.frgIpoListingDate.setText(ipoData.getListingDate());
        }else{
            mBinding.frgIpoName.setText(homeData.getSmeIpoName());
            mBinding.frgIpoPrice.setText(homeData.getPrice());
            mBinding.frgIpoRating.setText(homeData.getRating());
            mBinding.frgIpoSubscription.setText(homeData.getSubscription());
            mBinding.frgIpoLotSize.setText(homeData.getLotSize());
            mBinding.frgIpoIssueSize.setText(homeData.getIssueSize());
            mBinding.frgIpoFaceValue.setText(homeData.getFaceValue());
            mBinding.frgIpoTargetDate.setText(homeData.getIpoDate());
            mBinding.frgIpoAlloatmentDate.setText(homeData.getAllotmentDate());
            mBinding.frgIpoListingDate.setText(homeData.getListingDate());
        }
    }
    @Override
    public void onDestroy() {
        super.onDestroy();
        if (homeData != null){
            onSetActinBarTitle.onSetActionBarTitle("My Money Place");
        }
    }
}
