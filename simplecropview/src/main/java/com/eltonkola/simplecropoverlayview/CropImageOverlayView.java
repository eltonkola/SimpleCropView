package com.eltonkola.simplecropoverlayview;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;

import com.isseiaoki.simplecropview.CropImageView;
/**
 * Created by Elton on 02/10/2015.
 */
public class CropImageOverlayView extends CropImageView{

    private Bitmap mOverlay;
    private int mOverlayAlpha = 80;

    public void setOverlayImage(Bitmap overlay){
        mOverlay = overlay;
    }

    public void setOverlayAlpha(int alpha){
        mOverlayAlpha = alpha;
    }

    public CropImageOverlayView(Context context) {
        super(context);
    }

    public CropImageOverlayView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public CropImageOverlayView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    @Override
    public void drawEditFrame(Canvas canvas) {
        super.drawEditFrame(canvas);

        if(mOverlay!=null) {
            Paint paint = new Paint();
            paint.setAlpha(mOverlayAlpha);
            int fixedSize = (int) (getFrameRect().right - getFrameRect().left);
            Bitmap alteredBitmapFinal = Bitmap.createScaledBitmap(mOverlay, fixedSize, fixedSize, false);
            canvas.drawBitmap(alteredBitmapFinal, getFrameRect().left, getFrameRect().top, paint);
        }

    }
}
