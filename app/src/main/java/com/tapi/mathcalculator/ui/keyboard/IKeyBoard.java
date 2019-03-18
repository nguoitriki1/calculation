package com.tapi.mathcalculator.ui.keyboard;

import android.view.View;

import com.tapi.mathcalculator.R;
import com.tapi.mathcalculator.utils.Utils;

public interface IKeyBoard extends View.OnClickListener, View.OnLongClickListener {
    public enum Event {
        click,
        longClick;

        public boolean isClick() {
            return this == click;
        }

        public boolean isLongClick() {
            return this == longClick;
        }
    }

    public enum Key {
        percent(Utils.charsToString('%')),
        brackets_l(Utils.charsToString('(')),
        brackets_r(Utils.charsToString(')')),
        division(Utils.charsToString((char) 247)),
        minus(Utils.charsToString('-')),
        multiply(Utils.charsToString((char) 215)),
        plus(Utils.charsToString('+')),
        equal(Utils.charsToString('=')),
        point(Utils.charsToString('.')),
        back(R.drawable.ic_ico_keyboard_eliminate),
        clr("CLR"),
        num_0("0"),
        num_1("1"),
        num_2("2"),
        num_3("3"),
        num_4("4"),
        num_5("5"),
        num_6("6"),
        num_7("7"),
        num_8("8"),
        num_9("9"),
        log("log"),
        x2("X²"),
        xn("x^"),
        gen(Utils.charsToString((char) 8730)),
        un("n!"),
        rad("RAD"),
        deg("DEG"),
        sin("sin"),
        cos("cos"),
        tan("tan"),
        open(R.drawable.ic_ico_keyboard_upglide_down),
        asin("asin"),
        acos("acos"),
        atan("atan"),
        ln("ln"),
        lg("lg"),
        x3("X³"),
        x_1("X⁻¹"),
        gen3("³√"),
        pi(Utils.charsToString((char) 960)),
        e(Utils.charsToString('e')),
        x(Utils.charsToString('x')),
        y(Utils.charsToString('y'));

        public int drawableId;
        public String keyText;
        public String outText;

        private Key(String str, String str2) {
            this.keyText = str;
            this.outText = str2;
        }

        private Key(String str) {
            this.keyText = str;
            this.outText = str;
        }

        Key(int drawableId) {
            this.drawableId = drawableId;
        }

        boolean hasDrawableRes() {
            return this.drawableId != 0;
        }
    }

    public interface OnKeyboardOnClickListener {
        void onKeyEvent(View view, Event event, IKeyBoard.Key key);
    }

}
