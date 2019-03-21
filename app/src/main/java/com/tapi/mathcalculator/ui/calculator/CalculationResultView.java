package com.tapi.mathcalculator.ui.calculator;

import android.content.Context;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.text.Editable;
import android.text.InputType;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.tapi.mathcalculator.R;
import com.tapi.mathcalculator.ui.keyboard.IKeyBoard;
import com.tapi.mathcalculator.utils.Utils;

import static android.content.Context.INPUT_METHOD_SERVICE;

public class CalculationResultView extends ConstraintLayout {
    private TextView mOutText;
    private EditText mInText;
    private OnInTextChangeLister onInTextChangeLister;

    public CalculationResultView(Context context) {
        super(context);
    }

    public CalculationResultView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public CalculationResultView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public void setOnInTextChangeLister(OnInTextChangeLister onInTextChangeLister) {
        this.onInTextChangeLister = onInTextChangeLister;
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        mOutText = findViewById(R.id.calculation_out_text);
        mInText = findViewById(R.id.calculation_in_text);
        mOutText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (mOutText.getText().toString().length() > 14) {
                    mOutText.setTextSize(TypedValue.COMPLEX_UNIT_SP, 38);
                } else if (mOutText.getText().toString().length() > 13) {
                    mOutText.setTextSize(TypedValue.COMPLEX_UNIT_SP, 40);
                } else if (mOutText.getText().toString().length() > 12) {
                    mOutText.setTextSize(TypedValue.COMPLEX_UNIT_SP, 44);
                } else if (mOutText.getText().toString().length() > 11) {
                    mOutText.setTextSize(TypedValue.COMPLEX_UNIT_SP, 48);
                } else if (mOutText.getText().toString().length() > 10) {
                    mOutText.setTextSize(TypedValue.COMPLEX_UNIT_SP, 52);
                } else if (mOutText.getText().toString().length() > 9) {
                    mOutText.setTextSize(TypedValue.COMPLEX_UNIT_SP, 58);
                } else if (mOutText.getText().toString().length() > 8) {
                    mOutText.setTextSize(TypedValue.COMPLEX_UNIT_SP, 64);
                } else if (mOutText.getText().toString().length() > 7) {
                    mOutText.setTextSize(TypedValue.COMPLEX_UNIT_SP, 71);
                } else if (mOutText.getText().toString().length() > 6) {
                    mOutText.setTextSize(TypedValue.COMPLEX_UNIT_SP, 76);
                } else if (mOutText.getText().toString().length() < 7) {
                    mOutText.setTextSize(TypedValue.COMPLEX_UNIT_SP, 80);
                }
            }
        });
        mInText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                onInTextChangeLister.onBeforeInTextChangeListner(s, start, count, after);
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                onInTextChangeLister.onInTextChangeListner(s, start, before, count);
            }

            @Override
            public void afterTextChanged(Editable s) {
                onInTextChangeLister.onAfterInTextChangeListner(s);
            }
        });
        mInText.setOnLongClickListener(new OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                try {
                    mInText.setSelection(mInText.getSelectionStart(), mInText.getSelectionStart() + 1);
                } catch (Exception e) {

                }
                return true;
            }
        });
    }

    public void addKey(IKeyBoard.Key key) {
        int selectionEnd = mInText.getSelectionEnd();
        int selectionStart = mInText.getSelectionStart();
        String outText = key.outText;
        switch (key) {
            case point:
                // them so 0 khi them dau .
                if (selectionStart == 0) {
                    insertIntext("0" + outText, selectionStart, selectionEnd);
                } else if (selectionStart > 0 && selectionStart < mInText.length()) {
                    if (!checkIsNumber(mInText.getText().charAt(selectionEnd - 1))) {
                        insertIntext("0" + outText, selectionStart, selectionEnd);
                    } else {
                        insertIntext(outText, selectionStart, selectionEnd);
                    }
                } else {
                    insertIntext(outText, selectionStart, selectionEnd);
                }
                break;
            case x_1:
                insertIntext("⁻¹", selectionStart, selectionEnd);
                break;
            case x2:
                insertIntext("²", selectionStart, selectionEnd);
                break;
            case x3:
                insertIntext("³", selectionStart, selectionEnd);
                break;
            case xn:
                insertIntext("^", selectionStart, selectionEnd);
                break;
            case sin:
                insertIntext(outText + "(", selectionStart, selectionEnd);
                break;
            case cos:
                insertIntext(outText + "(", selectionStart, selectionEnd);
                break;
            case tan:
                insertIntext(outText + "(", selectionStart, selectionEnd);
                break;
            case asin:
                insertIntext(outText + "(", selectionStart, selectionEnd);
                break;
            case acos:
                insertIntext(outText + "(", selectionStart, selectionEnd);
                break;
            case atan:
                insertIntext(outText + "(", selectionStart, selectionEnd);
                break;
            case log:
                insertIntext(outText + "(", selectionStart, selectionEnd);
                break;
            case lg:
                insertIntext(outText + "(", selectionStart, selectionEnd);
                break;
            case ln:
                insertIntext(outText + "(", selectionStart, selectionEnd);
                break;
            case un:
                insertIntext("!", selectionStart, selectionEnd);
                break;
            case division:
                insertOperator(outText, selectionStart, selectionEnd);
                break;
            case multiply:
                insertOperator(outText, selectionStart, selectionEnd);
                break;
            case minus:
                insertOperator(outText, selectionStart, selectionEnd);
                break;
            case plus:
                insertOperator(outText, selectionStart, selectionEnd);
                break;
            default:
                insertIntext(outText, selectionStart, selectionEnd);
                break;

        }
    }

    private void insertOperator(String outText, int selectionStart, int selectionEnd) {
        //selector == 0 thi insert no
        //selector == 1 thi kiem tra
        // Phia truoc no neu la toan tu thi thay the no
        // neu no ko phai thi insert no
        //selector > 1 thi kiem tra
        // neu phia truoc no ko phai toan tu thi insert
        // neu phia truoc la toan tu thi kiem tra
        // neu ky tu nhap vao la dau -
        // neu la dau - thi kiem tra tiep phia truoc dau -
        //neu la toan tu thi thay the ca 2  = 1 dau khac
        //neu khong phai la toan tu thi thay the dau -

        if (mInText.length() > 0) {
            if (selectionStart == selectionEnd) {
                if (selectionStart == 0) {
                    insertIntext(outText, selectionStart, selectionEnd);
                } else if (selectionStart == 1) {
                    char c = mInText.getText().charAt(selectionStart - 1);
                    if (outText.equals("-")) {
                        if (checkIsOperator(c)) {
                            if (c == ((char) 247) || c == ((char) 215)) {
                                insertIntext(outText, selectionStart, selectionEnd);
                            } else {
                                replaceInText(outText, selectionStart, selectionEnd);
                            }
                        } else {
                            insertIntext(outText, selectionStart, selectionEnd);
                        }
                    } else {
                        if (checkIsOperator(c)) {
                            replaceInText(outText, selectionStart, selectionEnd);
                        } else {
                            insertIntext(outText, selectionStart, selectionEnd);
                        }
                    }
                } else {
                    char c = mInText.getText().charAt(selectionStart - 1);
                    char d = mInText.getText().charAt(selectionStart - 2);
                    if (checkIsOperator(c)) {
                        if (c == '-') {
                            if (checkIsOperator(d)) {
                                if (!outText.equals("-")) {
                                    replaceInTextTwoChar(outText, selectionStart, selectionEnd);
                                }
                            } else {
                                replaceInText(outText, selectionStart, selectionEnd);
                            }
                        } else {
                            if (outText.equals("-")) {
                                if (checkIsOperator(c)) {
                                    if (c == ((char) 247) || c == ((char) 215)) {
                                        insertIntext(outText, selectionStart, selectionEnd);
                                    } else {
                                        replaceInText(outText, selectionStart, selectionEnd);
                                    }
                                } else {
                                    insertIntext(outText, selectionStart, selectionEnd);
                                }
                            } else {
                                if (checkIsOperator(c)) {
                                    replaceInText(outText, selectionStart, selectionEnd);
                                } else {
                                    insertIntext(outText, selectionStart, selectionEnd);
                                }
                            }
                        }
                    } else {
                        insertIntext(outText, selectionStart, selectionEnd);
                    }
                }
            } else {
                insertIntext(outText, selectionStart, selectionEnd);
            }
        } else {
            insertIntext(outText, selectionStart, selectionEnd);
        }
    }

    private void replaceInTextTwoChar(String outText, int selectionStart, int selectionEnd) {
        StringBuffer buffer = new StringBuffer(mInText.getText());
        buffer.replace(selectionStart - 2, selectionStart, outText);
        mInText.setText(buffer.toString());
        mInText.setSelection(selectionStart - 1);
    }

    private void replaceInText(String outText, int selectionStart, int selectionEnd) {
        StringBuffer buffer = new StringBuffer(mInText.getText());
        buffer.replace(selectionStart - 1, selectionStart, outText);
        mInText.setText(buffer.toString());
        mInText.setSelection(selectionStart);
    }

    private boolean checkIsOperator(char charAt) {
        if (mInText.length() > 0) {
            if (charAt == ((char) 247) || charAt == '+' || charAt == '-' || charAt == ((char) 215)) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    private boolean checkIsNumber(char charAt) {
        if (charAt == '0' || charAt == '1' || charAt == '2' || charAt == '3' || charAt == '4' || charAt == '5' || charAt == '6' || charAt == '7' || charAt == '8' || charAt == '9') {
            return true;
        } else {
            return false;
        }
    }

    private void insertIntext(String outText, int selectionStart, int selectionEnd) {
        if (outText.length() > 0) {
            StringBuffer buffer = new StringBuffer(mInText.getText());
            if (checkIsNumber(outText.charAt(0)) || outText.charAt(0) == '.'
                    || outText.contains(IKeyBoard.Key.sin.outText) || outText.contains(IKeyBoard.Key.cos.outText)
                    || outText.contains(IKeyBoard.Key.tan.outText) || outText.contains(IKeyBoard.Key.pi.outText)
                    || outText.contains(IKeyBoard.Key.log.outText) || outText.contains(IKeyBoard.Key.lg.outText)
                    || outText.contains(IKeyBoard.Key.ln.outText) || outText.contains(IKeyBoard.Key.e.outText)
                    || outText.contains(IKeyBoard.Key.gen.outText)) {
                if (selectionStart > 0) {
                    final char c = mInText.getText().charAt(selectionStart - 1);
                    if (c == '¹' || c == '²' || c == '³') {
                        if (outText.charAt(0) == '.') {
                            outText = (String.valueOf(IKeyBoard.Key.multiply.outText) + String.valueOf(IKeyBoard.Key.num_0.outText) + outText);
                        } else {
                            outText = (String.valueOf(IKeyBoard.Key.multiply.outText) + outText);
                        }
                    }
                }
            } else if ( outText.contains("²") ||  outText.contains("³")
                    || outText.contains("¹") ||  outText.contains("^")
                    || outText.contains(IKeyBoard.Key.gen3.outText)
                    || outText.contains("!")) {
                if (selectionStart > 0) {
                    final char c = mInText.getText().charAt(selectionStart - 1);
                    if (c == '¹' || c == '²' || c == '³') {
                        outText = (String.valueOf(IKeyBoard.Key.brackets_r.outText) + outText);
                    }
                }
            }
            if (selectionEnd == selectionStart) {
                buffer.insert(selectionStart, outText);
                mInText.setText(buffer.toString());
                mInText.setSelection(selectionStart + outText.length());
            } else {
                buffer.replace(selectionStart, selectionEnd, outText);
                mInText.setText(buffer.toString());
                mInText.setSelection(selectionStart + outText.length());
            }
        }
    }

    public void setmOutText(String outText) {
        mOutText.setText(outText + "");
    }

    public void removeOneKeyClick() {
        int selectionStart = mInText.getSelectionStart();
        int selectionEnd = mInText.getSelectionEnd();
        if (selectionStart == selectionEnd) {
            if (selectionStart > 0) {
                try {
                    String substring = mInText.getText().toString().substring(selectionStart - 5, selectionStart);
                    if (substring.equals("asin(") || substring.equals("acos(") || substring.equals("atan(")) {
                        mInText.setText((Spanned) mInText.getText().delete(selectionStart - 5, selectionStart));
                        mInText.setSelection(selectionStart - 5);
                    } else {
                        String substring1 = mInText.getText().toString().substring(selectionStart - 4, selectionStart);
                        if (substring1.equals("sin(") || substring1.equals("cos(") || substring1.equals("tan(")) {
                            mInText.setText((Spanned) mInText.getText().delete(selectionStart - 4, selectionStart));
                            mInText.setSelection(selectionStart - 4);
                        } else {
                            String substring2 = mInText.getText().toString().substring(selectionStart - 3, selectionStart);
                            if (substring2.equals("lg(") || substring2.equals("ln(")) {
                                mInText.setText((Spanned) mInText.getText().delete(selectionStart - 3, selectionStart));
                                mInText.setSelection(selectionStart - 3);
                            } else {
                                String substring3 = mInText.getText().toString().substring(selectionStart - 2, selectionStart);
                                if (substring3.equals("⁻¹")) {
                                    mInText.setText((Spanned) mInText.getText().delete(selectionStart - 2, selectionStart));
                                    mInText.setSelection(selectionStart - 2);
                                } else {
                                    mInText.setText((Spanned) mInText.getText().delete(selectionStart - 1, selectionStart));
                                    mInText.setSelection(selectionStart - 1);
                                }
                            }
                        }
                    }
                } catch (Exception e) {
                    try {
                        String substring1 = mInText.getText().toString().substring(selectionStart - 4, selectionStart);
                        if (substring1.equals("sin(") || substring1.equals("cos(") || substring1.equals("tan(") || substring1.equals("log(")) {
                            mInText.setText((Spanned) mInText.getText().delete(selectionStart - 4, selectionStart));
                            mInText.setSelection(selectionStart - 4);
                        } else {
                            String substring2 = mInText.getText().toString().substring(selectionStart - 3, selectionStart);
                            if (substring2.equals("lg(") || substring2.equals("ln(")) {
                                mInText.setText((Spanned) mInText.getText().delete(selectionStart - 3, selectionStart));
                                mInText.setSelection(selectionStart - 3);
                            } else {
                                mInText.setText((Spanned) mInText.getText().delete(selectionStart - 1, selectionStart));
                                mInText.setSelection(selectionStart - 1);
                            }
                        }
                    } catch (Exception e1) {
                        try {
                            String substring2 = mInText.getText().toString().substring(selectionStart - 3, selectionStart);
                            if (substring2.equals("lg(") || substring2.equals("ln(")) {
                                mInText.setText((Spanned) mInText.getText().delete(selectionStart - 3, selectionStart));
                                mInText.setSelection(selectionStart - 3);
                            } else {
                                String substring3 = mInText.getText().toString().substring(selectionStart - 2, selectionStart);
                                if (substring3.equals("⁻¹") || substring3.equals("³√")) {
                                    mInText.setText((Spanned) mInText.getText().delete(selectionStart - 2, selectionStart));
                                    mInText.setSelection(selectionStart - 2);
                                } else {
                                    mInText.setText((Spanned) mInText.getText().delete(selectionStart - 1, selectionStart));
                                    mInText.setSelection(selectionStart - 1);
                                }
                            }
                        } catch (Exception e2) {
                            try {
                                String substring3 = mInText.getText().toString().substring(selectionStart - 2, selectionStart);
                                if (substring3.equals("⁻¹") || substring3.equals("³√")) {
                                    mInText.setText((Spanned) mInText.getText().delete(selectionStart - 2, selectionStart));
                                    mInText.setSelection(selectionStart - 2);
                                } else {
                                    mInText.setText((Spanned) mInText.getText().delete(selectionStart - 1, selectionStart));
                                    mInText.setSelection(selectionStart - 1);
                                }
                            } catch (Exception e3) {
                                try {
                                    mInText.setText((Spanned) mInText.getText().delete(selectionStart - 1, selectionStart));
                                    mInText.setSelection(selectionStart - 1);
                                } catch (Exception e4) {

                                }
                            }
                        }
                    }
                }
            }
        } else {
            mInText.setText((Spanned) mInText.getText().delete(selectionStart - 1, selectionStart));
            mInText.setSelection(selectionStart - 1);
        }
    }

    public void removeAllKey() {
        mInText.setText("");
    }

    public interface OnInTextChangeLister {
        void onAfterInTextChangeListner(Editable s);

        void onInTextChangeListner(CharSequence s, int start, int before, int count);

        void onBeforeInTextChangeListner(CharSequence s, int start, int count, int after);
    }

    public void animationResultTxtWhenClickEqual() {
        //Load animation
        final Animation slide_out = AnimationUtils.loadAnimation(getContext(),
                R.anim.slide_out_top);
        final Animation slide_up = AnimationUtils.loadAnimation(getContext(),
                R.anim.slide_in_bottom);
        slide_out.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                mOutText.startAnimation(slide_up);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

// Start animation
        mOutText.startAnimation(slide_out);
    }

}
