package com.example.game10;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;

public class Droid {
    private final Paint PAINT = new Paint();
    private Rect rect;
    private Bitmap bitmap;

    private int moveMaxWidth;
    private int moveHeight;

    public Droid(Bitmap bitmap, int canvasWidth, int canvasHeight) {
        moveMaxWidth = canvasWidth - bitmap.getWidth();
        moveHeight = canvasHeight - bitmap.getHeight();

        // ドロイド君を中央に表示する
        int left = moveMaxWidth / 2;
        int top = moveHeight;

        rect = new Rect(left, top, left + bitmap.getWidth(), top + bitmap.getHeight());
        this.bitmap = bitmap;
    }

    public void draw(Canvas canvas) {
        canvas.drawBitmap(bitmap, rect.left, rect.top, PAINT);
    }

    public void moveLeft() {
        rect.offset(-10, 0);
        if (rect.left < 0) {
            rect.offsetTo(0, moveHeight);
        }
    }

    public void moveRight() {
        rect.offset(10, 0);
        if (rect.left > moveMaxWidth) {
            rect.offsetTo(moveMaxWidth, moveHeight);
        }
    }

    public boolean hit(Missile missile) {
        return Rect.intersects(rect, missile.getRect());
    }
}
