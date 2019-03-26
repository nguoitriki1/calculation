package com.tapi.mathcalculator.ui.equation;

import android.content.Context;
import android.support.constraint.ConstraintLayout;
import android.text.Spanned;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import com.tapi.mathcalculator.R;
import com.tapi.mathcalculator.ui.keyboard.IKeyBoard;
import com.tapi.mathcalculator.utils.Utils;

public class EquationResultView extends ConstraintLayout {
    private ImageView imgBracket;
    private EditText edtResult1, edtResult2;
    private EditText edtCurentForcus;

    public EquationResultView(Context context) {
        super(context);
    }

    public EquationResultView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        edtResult1 = findViewById(R.id.equation_edt_result_1);
        edtResult2 = findViewById(R.id.equation_edt_result_2);
        imgBracket = findViewById(R.id.equation_img_bracket);
        edtCurentForcus = edtResult1;
        edtResult1.setOnTouchListener(new OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                edtCurentForcus = edtResult1;
                return false;
            }
        });
        edtResult2.setOnTouchListener(new OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                edtCurentForcus = edtResult2;
                return false;
            }
        });
    }

    public EditText getEdtResult1() {
        return edtResult1;
    }

    public void setEdtResult1(EditText edtResult1) {
        this.edtResult1 = edtResult1;
    }

    public EditText getEdtResult2() {
        return edtResult2;
    }

    public void setEdtResult2(EditText edtResult2) {
        this.edtResult2 = edtResult2;
    }

    public void addKey(IKeyBoard.Key key) {
        int selectionEnd = edtCurentForcus.getSelectionEnd();
        int selectionStart = edtCurentForcus.getSelectionStart();
        String outText = key.outText;
        switch (key) {
            case point:
               insertPoint(outText,selectionStart,selectionEnd);
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

    private void insertPoint(String outText, int selectionStart, int selectionEnd) {
        // them so 0 khi them dau .
        if (selectionStart == 0) {
            insertIntext("0" + outText, selectionStart, selectionEnd);
        } else {
            if (edtCurentForcus.getText().toString().substring(0, selectionStart).contains(".")) {
                int i1 = edtCurentForcus.getText().toString().lastIndexOf(".");
                if (i1 != 0) {
                    if (edtCurentForcus.getText().toString().substring(i1, selectionStart).contains("+") ||
                            edtCurentForcus.getText().toString().substring(i1, selectionStart).contains("-") ||
                            edtCurentForcus.getText().toString().substring(i1, selectionStart).contains(Utils.charsToString((char) 215)) ||
                            edtCurentForcus.getText().toString().substring(i1, selectionStart).contains(")") ||
                            edtCurentForcus.getText().toString().substring(i1, selectionStart).contains("(") ||
                            edtCurentForcus.getText().toString().substring(i1, selectionStart).contains(Utils.charsToString((char) 960)) ||
                            edtCurentForcus.getText().toString().substring(i1, selectionStart).contains("⁰") ||
                            edtCurentForcus.getText().toString().substring(i1, selectionStart).contains("¹") ||
                            edtCurentForcus.getText().toString().substring(i1, selectionStart).contains("²") ||
                            edtCurentForcus.getText().toString().substring(i1, selectionStart).contains("³") ||
                            edtCurentForcus.getText().toString().substring(i1, selectionStart).contains("⁴") ||
                            edtCurentForcus.getText().toString().substring(i1, selectionStart).contains("⁵") ||
                            edtCurentForcus.getText().toString().substring(i1, selectionStart).contains("⁶") ||
                            edtCurentForcus.getText().toString().substring(i1, selectionStart).contains("⁷") ||
                            edtCurentForcus.getText().toString().substring(i1, selectionStart).contains("⁸") ||
                            edtCurentForcus.getText().toString().substring(i1, selectionStart).contains("⁹") ||
                            edtCurentForcus.getText().toString().substring(i1, selectionStart).contains("x") ||
                            edtCurentForcus.getText().toString().substring(i1, selectionStart).contains("y")) {
                        if (Utils.checkIsNumber(edtCurentForcus.getText().charAt(selectionStart - 1))) {
                            insertIntext(outText, selectionStart, selectionEnd);
                        } else {
                            insertIntext("0" + outText, selectionStart, selectionEnd);
                        }
                    }
                } else {
                    if (!Utils.checkIsNumber(edtCurentForcus.getText().charAt(selectionEnd - 1))) {
                        insertIntext("0" + outText, selectionStart, selectionEnd);
                    } else {
                        insertIntext(outText, selectionStart, selectionEnd);
                    }
                }
            } else {
                if (!Utils.checkIsNumber(edtCurentForcus.getText().charAt(selectionEnd - 1))) {
                    insertIntext("0" + outText, selectionStart, selectionEnd);
                } else {
                    insertIntext(outText, selectionStart, selectionEnd);
                }
            }
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

        if (edtCurentForcus.length() > 0) {
            if (selectionStart == selectionEnd) {
                if (selectionStart == 0) {
                    insertIntext(outText, selectionStart, selectionEnd);
                } else if (selectionStart == 1) {
                    char c = edtCurentForcus.getText().charAt(selectionStart - 1);
                    if (outText.equals("-")) {
                        if (Utils.checkIsOperator(edtCurentForcus.length(), c)) {
                            if (c == ((char) 247) || c == ((char) 215)) {
                                insertIntext(outText, selectionStart, selectionEnd);
                            } else {
                                replaceInText(outText, selectionStart, selectionEnd);
                            }
                        } else {
                            insertIntext(outText, selectionStart, selectionEnd);
                        }
                    } else {
                        if (Utils.checkIsOperator(edtCurentForcus.length(), c)) {
                            replaceInText(outText, selectionStart, selectionEnd);
                        } else {
                            insertIntext(outText, selectionStart, selectionEnd);
                        }
                    }
                } else {
                    char c = edtCurentForcus.getText().charAt(selectionStart - 1);
                    char d = edtCurentForcus.getText().charAt(selectionStart - 2);
                    if (Utils.checkIsOperator(edtCurentForcus.length(), c)) {
                        if (c == '-') {
                            if (Utils.checkIsOperator(edtCurentForcus.length(), d)) {
                                if (!outText.equals("-")) {
                                    replaceInTextTwoChar(outText, selectionStart, selectionEnd);
                                }
                            } else {
                                replaceInText(outText, selectionStart, selectionEnd);
                            }
                        } else {
                            if (outText.equals("-")) {
                                if (Utils.checkIsOperator(edtCurentForcus.length(), c)) {
                                    if (c == ((char) 247) || c == ((char) 215)) {
                                        insertIntext(outText, selectionStart, selectionEnd);
                                    } else {
                                        replaceInText(outText, selectionStart, selectionEnd);
                                    }
                                } else {
                                    insertIntext(outText, selectionStart, selectionEnd);
                                }
                            } else {
                                if (Utils.checkIsOperator(edtCurentForcus.length(), c)) {
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
        StringBuilder buffer = new StringBuilder(edtCurentForcus.getText());
        buffer.replace(selectionStart - 2, selectionStart, outText);
        edtCurentForcus.setText(buffer.toString());
        edtCurentForcus.setSelection(selectionStart - 1);
    }

    private void replaceInText(String outText, int selectionStart, int selectionEnd) {
        StringBuilder buffer = new StringBuilder(edtCurentForcus.getText());
        buffer.replace(selectionStart - 1, selectionStart, outText);
        edtCurentForcus.setText(buffer.toString());
        edtCurentForcus.setSelection(selectionStart);
    }

    private void insertIntext(String outText, int selectionStart, int selectionEnd) {
        if (outText.length() > 0) {
            StringBuilder buffer = new StringBuilder(edtCurentForcus.getText());
            if (Utils.checkIsNumber(outText.charAt(0)) || outText.charAt(0) == '.') {
                if (selectionStart > 0) {
                    final char c = edtCurentForcus.getText().charAt(selectionStart - 1);
                    if (c == '⁰' || c == '¹' || c == '²' || c == '³'
                            || c == '⁴' || c == '⁵' || c == '⁶'
                            || c == '⁷' || c == '⁸' || c == '⁹' ) {
                        if (outText.charAt(0) == '.') {
                            outText = (String.valueOf(IKeyBoard.Key.multiply.outText) + String.valueOf(IKeyBoard.Key.num_0.outText) + outText);
                        } else {
                            outText = (String.valueOf(IKeyBoard.Key.multiply.outText) + outText);
                        }
                    }else if (c == 'x' || c == 'y' ){
                        if (outText.charAt(0) == '.') {
                            outText = (String.valueOf(IKeyBoard.Key.num_0.outText) + outText);
                        } else {
                            outText = (String.valueOf(IKeyBoard.Key.multiply.outText) + outText);
                        }
                    }
                }
            }
            if (selectionEnd == selectionStart) {
                buffer.insert(selectionStart, outText);
                edtCurentForcus.setText(buffer.toString());
                edtCurentForcus.setSelection(selectionStart + outText.length());
            } else {
                buffer.replace(selectionStart, selectionEnd, outText);
                edtCurentForcus.setText(buffer.toString());
                edtCurentForcus.setSelection(selectionStart + outText.length());
            }
        }
    }

    public void showBacketAndLineNext() {
        imgBracket.setVisibility(VISIBLE);
        edtResult2.setVisibility(VISIBLE);
        edtResult2.requestFocus();
        edtCurentForcus = edtResult2;
    }

    public void removeAllKey() {
        if (edtCurentForcus.length() > 0) {
            edtCurentForcus.setText("");
        } else {
            imgBracket.setVisibility(GONE);
            edtResult2.setVisibility(INVISIBLE);
            edtResult1.requestFocus();
            edtCurentForcus = edtResult1;
        }
    }

    public void removeOneKeyClick() {
        if (edtCurentForcus.length() > 0) {
            int selectionStart = edtCurentForcus.getSelectionStart();
            edtCurentForcus.setText((Spanned) edtCurentForcus.getText().delete(selectionStart - 1, selectionStart));
            edtCurentForcus.setSelection(selectionStart - 1);
        } else {
            imgBracket.setVisibility(GONE);
            edtResult2.setVisibility(INVISIBLE);
            edtResult1.requestFocus();
            edtCurentForcus = edtResult1;
        }
    }

    public String equationResult() {
        String resultEquation = "null";
        //calculator here
        return resultEquation;
    }
}
