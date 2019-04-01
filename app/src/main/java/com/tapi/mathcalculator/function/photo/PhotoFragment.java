package com.tapi.mathcalculator.function.photo;

import android.Manifest;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.tapi.mathcalculator.R;
import com.tapi.mathcalculator.function.dialog.PhotoDialogResult;
import com.tapi.mathcalculator.function.dialog.PremissionCameraDialog;
import com.tapi.mathcalculator.utils.CheckInternetConection;
import com.tapi.mathcalculator.utils.UtilsString;
import com.vincent.mathpix.lib.MathpixCameraView;
import com.vincent.mathpix.lib.OnMathpixCameraViewListener;


public class PhotoFragment extends Fragment implements View.OnClickListener, CheckInternetConection.Consumer {
    private MathpixCameraView mMathpixView;
    private TextView mTxtDenyPermission, mTxtCaptureFailure;
    private PremissionCameraDialog mPremissionCameraDialog;
    private ConstraintLayout mPhotoPermissionButton, mBtnOk;
    private ImageView mPhotoDenyPermissionWarnning, mBtnCapture, mBtnRefesh, mBtnNotInternet;
    private ProgressBar mProgessCapture;
    private OnStartMathpixCameraView onStartMathpixCameraView;
    private Animation animFadeOut, animFadeIn;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.photo_fragment, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        funFindViewById(view);
        initView();
    }

    public void setOnStartMathpixCameraView(OnStartMathpixCameraView onStartMathpixCameraView) {
        this.onStartMathpixCameraView = onStartMathpixCameraView;
    }

    private void funFindViewById(View view) {
        animFadeOut = AnimationUtils.loadAnimation(getActivity(), R.anim.common_animation_fadeout);
        animFadeIn = AnimationUtils.loadAnimation(getActivity(), R.anim.common_animation_fadein);
        mMathpixView = view.findViewById(R.id.photo_camera_view);
        mBtnCapture = view.findViewById(R.id.photo_capture_button);
        view.findViewById(R.id.photo_permission_button).setOnClickListener(this);
        mTxtDenyPermission = view.findViewById(R.id.photo_deny_permission_warnning_txt);
        mPhotoPermissionButton = view.findViewById(R.id.photo_permission_button);
        mPhotoDenyPermissionWarnning = view.findViewById(R.id.photo_deny_permission_warnning_img);
        mProgessCapture = view.findViewById(R.id.photo_capture_progess);
        mTxtCaptureFailure = view.findViewById(R.id.photo_capture_failure);
        mProgessCapture.getIndeterminateDrawable().setColorFilter(Color.RED, android.graphics.PorterDuff.Mode.MULTIPLY);
        mBtnRefesh = view.findViewById(R.id.photo_capture_button_refesh);
        mBtnOk = view.findViewById(R.id.photo_capture_button_ok);
        mBtnNotInternet = view.findViewById(R.id.photo_capture_not_internet);
//        mathView = view.findViewById(R.id.photo_permission_button);

        mBtnCapture.setOnClickListener(this);
        mBtnRefesh.setOnClickListener(this);
        mBtnNotInternet.setOnClickListener(this);
    }

    private void initView() {
        mMathpixView.setCameraViewListener(new OnMathpixCameraViewListener() {
            @Override
            public void onCameraError() {
                //image not found . progess infinite and show message error
                mTxtCaptureFailure.setVisibility(View.VISIBLE);
                mBtnOk.setVisibility(View.INVISIBLE);
            }

            @Override
            public void onRecognized(String latex) {
                //stop camera
                mMathpixView.stop();
                onStartMathpixCameraView.onStartMathpixCameraView(false);
                if (!TextUtils.isEmpty(latex)) {
                    //fade in check button , hide progess button , show dialog result when 0.5s
                    mBtnOk.setAnimation(animFadeIn);
                    animFadeIn.setAnimationListener(new Animation.AnimationListener() {
                        @Override
                        public void onAnimationStart(Animation animation) {

                        }

                        @Override
                        public void onAnimationEnd(Animation animation) {
                            mProgessCapture.setVisibility(View.INVISIBLE);
                            mTxtCaptureFailure.setVisibility(View.INVISIBLE);
                            mBtnOk.setVisibility(View.VISIBLE);
                            //show dialog result , crop image camera set background dialog
                            //hien nut tich sau nua giay show dialog ( trong dialog chup lại tấm ảnh làm mờ làm bg va nut photo duoi goc để hide dialog di)
                            new Handler().postDelayed(new Runnable() {
                                @Override
                                public void run() {
                                    showDialogResult(latex);
                                }
                            }, 1000);
                        }

                        @Override
                        public void onAnimationRepeat(Animation animation) {

                        }
                    });
                } else {
                    //stop camera
                    mMathpixView.stop();
                    onStartMathpixCameraView.onStartMathpixCameraView(false);
                    //if result error show message and show button refesh
                    mProgessCapture.setVisibility(View.INVISIBLE);
                    mTxtCaptureFailure.setVisibility(View.VISIBLE);
                    mProgessCapture.setVisibility(View.INVISIBLE);
                    //hide progess button and fade in refesh button
                    animFadeIn.setAnimationListener(new Animation.AnimationListener() {
                        @Override
                        public void onAnimationStart(Animation animation) {

                        }

                        @Override
                        public void onAnimationEnd(Animation animation) {
                            mBtnRefesh.setVisibility(View.VISIBLE);
                            mProgessCapture.setVisibility(View.INVISIBLE);
                        }

                        @Override
                        public void onAnimationRepeat(Animation animation) {

                        }
                    });
                    mBtnRefesh.startAnimation(animFadeIn);
                }
            }
        });
    }

    private void showDialogResult(String latex) {
        PhotoDialogResult photoDialogResult = new PhotoDialogResult();
        Bundle bundle = new Bundle();
        bundle.putString(UtilsString.PHOTO_RESULT_KEY, latex);
        photoDialogResult.setArguments(bundle);
        if (getActivity() != null)
            photoDialogResult.show(getActivity().getSupportFragmentManager(), UtilsString.TAG_RESULT_PHOTO_DIALOG);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.photo_capture_button:
                if (getActivity() != null)
                    if (ContextCompat.checkSelfPermission(getActivity(), Manifest.permission.CAMERA)
                            != PackageManager.PERMISSION_GRANTED) {
                        // Permission is not granted
                        boolean showRationale = shouldShowRequestPermissionRationale(Manifest.permission.CAMERA);
                        if (showRationale) {
                            ActivityCompat.requestPermissions(getActivity(),
                                    new String[]{Manifest.permission.CAMERA},
                                    UtilsString.MY_PERMISSIONS_REQUEST_CAMERA);
                        } else {
                            showDialogSetingPermission();
                        }
                    } else {
                        mBtnCapture.setAnimation(animFadeOut);
                        animFadeOut.setAnimationListener(new Animation.AnimationListener() {
                            @Override
                            public void onAnimationStart(Animation animation) {
                                mProgessCapture.setVisibility(View.VISIBLE);
                            }

                            @Override
                            public void onAnimationEnd(Animation animation) {
                                mBtnCapture.setVisibility(View.INVISIBLE);
                                mMathpixView.capture();
                            }

                            @Override
                            public void onAnimationRepeat(Animation animation) {

                            }
                        });
                        mBtnCapture.startAnimation(animFadeOut);
                    }
                break;
            case R.id.photo_permission_button:
                showDialogSetingPermission();
                break;
            case R.id.photo_capture_button_refesh:
                //show button capture hide button refesh start again view camera
                mBtnRefesh.setVisibility(View.INVISIBLE);
                mBtnCapture.setVisibility(View.VISIBLE);
                mMathpixView.start();
                break;
            case R.id.photo_capture_not_internet:
                new CheckInternetConection(new CheckInternetConection.Consumer() {
                    @Override
                    public void accept(Boolean internet) {
                        if (internet) {
                            setViewHaveInternet();
                            mBtnCapture.performClick();
                        } else {
                            setViewNoInternet();
                        }
                    }
                });
                break;
        }
    }

    private void showDialogSetingPermission() {
        if (getActivity() != null) {
            mPremissionCameraDialog = new PremissionCameraDialog();
            mPremissionCameraDialog.setCancelable(false);
            mPremissionCameraDialog.show(getActivity().getSupportFragmentManager(), UtilsString.TAG_EXIT_DIALOG);
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        mMathpixView.start();
    }

    @Override
    public void onPause() {
        super.onPause();
        mMathpixView.stop();
    }

    public void checkPermission() {
        if (getActivity() != null && ContextCompat.checkSelfPermission(getActivity(), Manifest.permission.CAMERA)
                != PackageManager.PERMISSION_GRANTED) {
            // Permission is not granted
            ActivityCompat.requestPermissions(getActivity(),
                    new String[]{Manifest.permission.CAMERA},
                    UtilsString.MY_PERMISSIONS_REQUEST_CAMERA);
        } else {
            hideViewPermission();
        }
    }

    public void hideViewPermission() {
        if (mTxtDenyPermission != null) {
            mTxtDenyPermission.setVisibility(View.GONE);
        }
        if (mPhotoPermissionButton != null) {
            mPhotoPermissionButton.setVisibility(View.GONE);
        }
        if (mPremissionCameraDialog != null) {
            mPremissionCameraDialog.dismiss();
        }
        if (mPhotoDenyPermissionWarnning != null) {
            mPhotoDenyPermissionWarnning.setVisibility(View.GONE);
        }
    }

    public void setViewDefault(boolean isStart) {
        new CheckInternetConection(this);
        mBtnCapture.setVisibility(View.VISIBLE);
        mBtnOk.setVisibility(View.INVISIBLE);
        mBtnRefesh.setVisibility(View.INVISIBLE);
        mTxtCaptureFailure.setVisibility(View.INVISIBLE);
        mProgessCapture.setVisibility(View.INVISIBLE);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if (!isStart) {
                    mMathpixView.start();
                    onStartMathpixCameraView.onStartMathpixCameraView(true);
                }
                mMathpixView.setVisibility(View.VISIBLE);
            }
        }, 150);
    }

    @Override
    public void accept(Boolean internet) {
        if (internet) {
            setViewHaveInternet();
        } else {
            setViewNoInternet();
        }
    }

    private void setViewNoInternet() {
        mBtnNotInternet.setVisibility(View.VISIBLE);
        mBtnCapture.setClickable(false);
        mBtnOk.setClickable(false);
        mBtnRefesh.setClickable(false);
        mTxtCaptureFailure.setClickable(false);
        mProgessCapture.setClickable(false);
    }

    private void setViewHaveInternet() {
        mBtnNotInternet.setVisibility(View.INVISIBLE);
        mBtnCapture.setClickable(true);
        mBtnOk.setClickable(true);
        mBtnRefesh.setClickable(true);
        mTxtCaptureFailure.setClickable(true);
        mProgessCapture.setClickable(true);
    }

    public interface OnStartMathpixCameraView {
        void onStartMathpixCameraView(Boolean isStart);
    }
}
