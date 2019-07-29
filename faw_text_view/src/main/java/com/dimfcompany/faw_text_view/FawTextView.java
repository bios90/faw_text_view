package com.dimfcompany.faw_text_view;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Typeface;
import android.support.annotation.Nullable;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v4.graphics.TypefaceCompat;
import android.support.v7.widget.AppCompatTextView;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.Gravity;

public class FawTextView extends AppCompatTextView
{
    //dummy changes
    private Typeface typeface;

    public FawTextView(Context context)
    {
        super(context);
        init(null);
    }

    public FawTextView(Context context, @Nullable AttributeSet attrs)
    {
        super(context, attrs);
        init(attrs);
    }

    public FawTextView(Context context, @Nullable AttributeSet attrs, int defStyleAttr)
    {
        super(context, attrs, defStyleAttr);
        init(attrs);
    }

    private void init(@Nullable AttributeSet attrs)
    {
        typeface = Typeface.createFromAsset(getContext().getAssets(),"fawsolid.otf");
        this.setTypeface(typeface);
        initAttributes(attrs);
    }

    private void initAttributes(@Nullable AttributeSet attrs)
    {
        if (attrs == null)
        {
            return;
        }

        TypedArray ta = getContext().obtainStyledAttributes(attrs, R.styleable.FawTextView);

        int icon_size = ta.getInt(R.styleable.FawTextView_icon_size, 999);
        int text_size = ta.getDimensionPixelSize(R.styleable.FawTextView_android_textSize, 12);

        switch (icon_size)
        {
            case 0:
                this.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 12);
                break;
            case 1:
                this.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 14);
                break;
            case 2:
                this.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 16);
                break;
            case 3:
                this.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 18);
                break;
            case 4:
                this.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 20);
                break;
            case 5:
                this.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 23);
                break;
            case 6:
                this.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 26);
                break;
            case 999:
                this.setTextSize(TypedValue.COMPLEX_UNIT_DIP, text_size);
        }

        int gravity = ta.getInt(R.styleable.FawTextView_android_gravity, 999);
        if (gravity == 999)
        {
            this.setGravity(Gravity.CENTER);
        }
        else
        {
            this.setGravity(gravity);
        }

        ta.recycle();
    }

    @Override
    protected void onDraw(Canvas canvas)
    {
        super.onDraw(canvas);
    }

    private static int dp2pxInt(float dp)
    {
        return (int) dp2px(dp);
    }

    private static float dp2px(float dp)
    {
        Resources r = Resources.getSystem();
        return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, r.getDisplayMetrics());
    }
}
